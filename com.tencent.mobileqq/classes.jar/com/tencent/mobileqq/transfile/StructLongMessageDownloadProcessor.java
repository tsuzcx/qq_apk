package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.LongStructMessageDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.LongStructMessageDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.im.longconn.longmsg.LongMsg.MsgDownRsp;
import tencent.im.longconn.longmsg.LongMsg.RspBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

public class StructLongMessageDownloadProcessor
  extends BaseDownloadProcessor
  implements Runnable
{
  private static final ArrayList<TransferRequest> DOWN_LOAD_TRANSFER_REQUESTS = new ArrayList();
  private static final int IP_SOURCE_DIRECT = 5;
  private static final int IP_SOURCE_REUSE = 10;
  private static final int IP_SOURCE_SSO_DIRECT_INVALID = 7;
  private static final int IP_SOURCE_SSO_DIRECT_NO_DATA = 6;
  private static final int IP_SOURCE_SSO_DIRECT_PARSE_ERROR = 9;
  private static final int IP_SOURCE_SSO_DIRECT_RETRY = 8;
  private static final int IP_SOURCE_SSO_DIRECT_TIMEOUT = 13;
  private static final int IP_SOURCE_SSO_NETCHANGE = 15;
  private static final int IP_SOURCE_SSO_REUSE_PARSE_ERROR = 12;
  private static final int IP_SOURCE_SSO_REUSE_RETRY = 11;
  private static final int IP_SOURCE_SSO_REUSE_TIMEOUT = 14;
  public static final int LONG_MESSAGE_ERROR_CODE_CANCEL = 2;
  public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_ACCOUNT_CHANGE = 7;
  public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_BACKGROUND = 9;
  public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_CRASH = 6;
  public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_FORCE_OFFLINE = 8;
  public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_TERMINATE = 5;
  public static final int LONG_MESSAGE_ERROR_CODE_DATA_PARSE_ERROR = 12;
  public static final int LONG_MESSAGE_ERROR_CODE_DOWNLOAD_ERROR_NO_TIMEOUT_ERROR = 14;
  public static final int LONG_MESSAGE_ERROR_CODE_EXPIRED = 3;
  public static final int LONG_MESSAGE_ERROR_CODE_ILLEGAL_APP = 16;
  public static final int LONG_MESSAGE_ERROR_CODE_OTHER = 4;
  public static final int LONG_MESSAGE_ERROR_CODE_RESID_ERROR = 13;
  public static final int LONG_MESSAGE_ERROR_CODE_SSO_FAIL = 1;
  public static final int LONG_MESSAGE_ERROR_CODE_STOP_DELETE_MSG = 10;
  public static final int LONG_MESSAGE_ERROR_CODE_STOP_UNFOLLOW = 11;
  public static final int LONG_MESSAGE_ERROR_CODE_STRUCTMESSAGE_NULL = 15;
  public static final int LONG_MESSAGE_ERROR_CODE_SUCCESS = 0;
  public static final int LONG_MSG_STATE_FAILED = 2;
  public static final int LONG_MSG_STATE_LOADING = 1;
  public static final int LONG_MSG_STATE_TIMEOUT = 3;
  public static final int LONG_MSG_STATE_UNKNOWN = 0;
  public static final String PA_OLD_LONG_MSG_TAG = "PaOldLongMsg";
  public static final String REPORTTAG = "StructLongMessageDownloadProcessorForReport";
  public static final String TAG = "StructLongMessageDownloadProcessor";
  private static ConcurrentHashMap<Long, HttpNetReq> downloadList = new ConcurrentHashMap();
  private int connectionFlag = 0;
  boolean directDownload = true;
  private int directDownloadFlag = 5;
  int errorCode = 4;
  int httpErrorCode = 200;
  private long mDownloadStartTime;
  private byte[] mMsgKey;
  private long mSSOStartTime;
  AbsStructMsg mStructingMsg;
  String pUin = "";
  String selfUin = "";
  String url = "";
  
  public StructLongMessageDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void cancelPALongMsgTask(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
    while (paramQQAppInterface.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)paramQQAppInterface.next()).getValue();
      if (isPALongMsg((IHttpCommunicatorListener)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (BaseTransProcessor)localObject;
        if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
        {
          ((BaseTransProcessor)localObject).cancel();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
          }
        }
      }
    }
  }
  
  public static void deleteTask(QQAppInterface paramQQAppInterface, long paramLong)
  {
    synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
    {
      if ((DOWN_LOAD_TRANSFER_REQUESTS == null) || (DOWN_LOAD_TRANSFER_REQUESTS.size() == 0) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask msgid" + paramLong);
      }
      if ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class) != null)
      {
        Iterator localIterator = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.mUniseq == paramLong)
          {
            cancelPALongMsgTask(paramQQAppInterface, localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
            DOWN_LOAD_TRANSFER_REQUESTS.remove(localTransferRequest);
            doReportForDelete(false, localTransferRequest.mSelfUin, localTransferRequest.mPeerUin, localTransferRequest.mUniseq, localTransferRequest);
          }
        }
      }
      return;
    }
  }
  
  public static void deleteTask(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList2;
    synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
    {
      if ((DOWN_LOAD_TRANSFER_REQUESTS == null) || (DOWN_LOAD_TRANSFER_REQUESTS.size() == 0) || (paramString == null) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask uin" + paramString);
      }
      localArrayList2 = new ArrayList();
      if ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class) != null)
      {
        Iterator localIterator = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (paramString.equalsIgnoreCase(localTransferRequest.mPeerUin))
          {
            cancelPALongMsgTask(paramQQAppInterface, localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
            localArrayList2.add(localTransferRequest);
            doReportForDelete(true, localTransferRequest.mSelfUin, localTransferRequest.mPeerUin, localTransferRequest.mUniseq, localTransferRequest);
          }
        }
      }
    }
    DOWN_LOAD_TRANSFER_REQUESTS.removeAll(localArrayList2);
  }
  
  private boolean directDownloadIfCan()
  {
    this.directDownload = true;
    this.directDownloadFlag = 5;
    MessageRecord localMessageRecord = this.mUiRequest.mRec;
    if (localMessageRecord == null) {}
    do
    {
      return false;
      localObject = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str1 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      this.selfUin = localMessageRecord.selfuin;
      this.pUin = localMessageRecord.frienduin;
    } while ((localObject == null) || ("".equals(localObject)) || (str1 == null) || ("".equals(str1)));
    String str2 = (String)localObject + "&rkey=" + str1;
    String str1 = FMTSrvAddrProvider.getInstance().getSrvAddrForPttDownload();
    Object localObject = str1;
    if (str1 == null)
    {
      localObject = FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().getIp();
      this.directDownloadFlag = 10;
      this.connectionFlag = FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().getConnectionFlag();
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      switch (FMTSrvAddrProvider.getInstance().getState())
      {
      default: 
        this.directDownloadFlag = 7;
        return false;
      }
      this.directDownloadFlag = 6;
      return false;
    }
    localObject = (String)localObject + str2;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "directUrl = " + str2 + ",url:" + (String)localObject);
    }
    receiveFile(localMessageRecord.uniseq, (String)localObject);
    ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
    return true;
  }
  
  private void doReportForCancel()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", cancle download task!");
      }
    }
    if (isOldLongMsg(this.mUiRequest.mRec)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", this.selfUin);
      localHashMap.put("param_puin", this.pUin);
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(7));
      localHashMap.put("param_url", this.url);
      if (!QLog.isColorLevel()) {
        break;
      }
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  private static void doReportForDelete(boolean paramBoolean, String paramString1, String paramString2, long paramLong, TransferRequest paramTransferRequest)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (isOldLongMsg(paramTransferRequest.mRec)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + paramTransferRequest.mRec.uniseq + ", delete download task!");
      }
    }
    HashMap localHashMap;
    if (isOldLongMsg(paramTransferRequest.mRec))
    {
      paramTransferRequest = "actOldLongMessageDownload";
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramString1);
      localHashMap.put("param_puin", paramString2);
      localHashMap.put("param_channel", "0");
      if (!paramBoolean) {
        break label264;
      }
      localHashMap.put("param_errcode", String.valueOf(11));
    }
    for (;;)
    {
      localHashMap.put("param_resid", "" + paramLong);
      if (!QLog.isColorLevel()) {
        break label281;
      }
      paramString1 = localHashMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        paramString2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, paramString2 + (String)localObject);
      }
      paramTransferRequest = "actLongMessageDownload";
      break;
      label264:
      localHashMap.put("param_errcode", String.valueOf(10));
    }
    label281:
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramTransferRequest, false, 0L, 0L, localHashMap, "", true);
  }
  
  public static void getStructLongMessage(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
      {
        Object localObject = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((TransferRequest)((Iterator)localObject).next()).mUniseq != paramMessageRecord.uniseq) {
            continue;
          }
          return;
        }
        localObject = new TransferRequest();
        ((TransferRequest)localObject).mIsUp = false;
        ((TransferRequest)localObject).mPeerUin = paramMessageRecord.frienduin;
        ((TransferRequest)localObject).mBusiType = 131079;
        ((TransferRequest)localObject).mFileType = 131079;
        ((TransferRequest)localObject).mUniseq = paramMessageRecord.uniseq;
        ((TransferRequest)localObject).mRec = paramMessageRecord;
        ((TransferRequest)localObject).mSelfUin = paramMessageRecord.selfuin;
        if (((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject)) {
          DOWN_LOAD_TRANSFER_REQUESTS.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          if (isOldLongMsg(paramMessageRecord))
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage(oldLongMsg) , messageRecord,msgid= " + paramMessageRecord.uniseq);
            QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + paramMessageRecord.uniseq + ", getStructLongMessage");
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time start: " + System.currentTimeMillis());
          return;
        }
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage , messageRecord,msgid= " + paramMessageRecord.uniseq);
    }
  }
  
  public static boolean isOldLongMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (StringUtil.a(paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isOldLongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  public static boolean isPALongMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      str3 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
    } while ((StringUtil.a(str1)) || (StringUtil.a(str2)) || (StringUtil.a(str3)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isPALongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  private static boolean isPALongMsg(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null)
    {
      bool1 = bool2;
      if ((paramIHttpCommunicatorListener instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean needFetchOldLongMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
      str3 = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
    } while ((StringUtil.a(str1)) || (StringUtil.a(str3)) || (StringUtil.a(str2)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "needFetchOldLongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  private byte[] parseOldLongMsgContent(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->null bodyData");
      }
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    int i = paramArrayOfByte.length;
    Object localObject2;
    Object localObject1;
    if ((paramArrayOfByte[0] != 40) || (paramArrayOfByte[(i - 1)] != 41))
    {
      localObject2 = "unexpected body data, len=" + i + ", data=";
      localObject1 = paramArrayOfByte.toString();
      localObject2 = new StringBuilder().append((String)localObject2);
      paramArrayOfByte = (byte[])localObject1;
      if (((String)localObject1).length() > 20) {
        paramArrayOfByte = ((String)localObject1).substring(0, 20);
      }
      paramArrayOfByte = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->" + paramArrayOfByte);
      }
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
        paramArrayOfByte.readByte();
        int k = paramArrayOfByte.readInt();
        j = paramArrayOfByte.readInt();
        if ((k > i) || (j > i))
        {
          if (!QLog.isColorLevel()) {
            break label599;
          }
          QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->unexpected length, headLen=" + k + ", bodyLen=" + j);
          break label599;
        }
        if (k <= 0) {
          break label594;
        }
        localObject1 = new byte[k];
        paramArrayOfByte.read((byte[])localObject1);
        localObject2 = new im_msg_head.Head();
        ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
        i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      if (!QLog.isColorLevel()) {
        break label612;
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bodyLen= " + j + " errCode= " + i);
      break label612;
      localObject1 = new byte[j];
      paramArrayOfByte.read((byte[])localObject1);
      paramArrayOfByte = new Cryptor().decrypt((byte[])localObject1, this.mMsgKey);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        if (!QLog.isColorLevel()) {
          break label614;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->after decrypt: dBodyBytes==null ||dBodyBytes.length<=0");
        break label614;
      }
      localObject1 = new LongMsg.RspBody();
      ((LongMsg.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (LongMsg.MsgDownRsp)((LongMsg.RspBody)localObject1).rpt_msg_down_rsp.get(0);
      if (paramArrayOfByte == null)
      {
        if (!QLog.isColorLevel()) {
          break label616;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->rspBody.rpt_msg_down_rsp == null");
        break label616;
      }
      if (!paramArrayOfByte.uint32_result.has())
      {
        if (!QLog.isColorLevel()) {
          break label618;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result NOT exists");
        break label618;
      }
      if (paramArrayOfByte.uint32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label620;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result != 0");
        break label620;
      }
      if (!paramArrayOfByte.bytes_msg_content.has())
      {
        if (!QLog.isColorLevel()) {
          break label622;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content NOT exists");
        break label622;
      }
      localObject1 = paramArrayOfByte.bytes_msg_content.get().toByteArray();
      if (localObject1 != null)
      {
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1.length > 0) {
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content == null or empty");
      }
      return null;
      label594:
      i = 0;
      break label601;
      label599:
      return null;
      label601:
      if (j > 0) {
        if (i == 0) {}
      }
    }
    label612:
    return null;
    label614:
    return null;
    label616:
    return null;
    label618:
    return null;
    label620:
    return null;
    label622:
    return null;
  }
  
  private void receiveFile(long paramLong, String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mServerList = this.mIpList;
    this.mNetEngine.sendReq(localHttpNetReq);
    downloadList.put(Long.valueOf(paramLong), localHttpNetReq);
    this.mNetReq = localHttpNetReq;
    FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().saveIp(TransFileUtil.getIpAndPortFromUrl(paramString));
    this.url = paramString;
    this.mDownloadStartTime = System.nanoTime();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "receiveFile->msgid:" + paramLong + ", url:" + paramString);
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + paramLong + ", receiveFile->url:" + paramString);
      }
    }
  }
  
  private void removeMessage()
  {
    if ((this.mUiRequest.mRec instanceof MessageForStructing)) {
      synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
      {
        Iterator localIterator = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.mUniseq == this.mUiRequest.mRec.uniseq) {
            DOWN_LOAD_TRANSFER_REQUESTS.remove(localTransferRequest);
          }
        }
        return;
      }
    }
  }
  
  private void requestUrlWhileDirectFailed()
  {
    sendGetUrlReq();
  }
  
  private void sendGetUrlReq()
  {
    this.directDownload = false;
    this.connectionFlag = 0;
    Object localObject1 = this.mUiRequest.mRec;
    if (localObject1 == null)
    {
      this.errorCode = 15;
      onError();
    }
    String str;
    Object localObject2;
    do
    {
      do
      {
        return;
        str = ((MessageRecord)localObject1).getExtInfoFromExtStr("pub_long_msg_resid");
        if ((str != null) && (!str.equals(""))) {
          break;
        }
      } while ((!isPALongMsg((MessageRecord)localObject1)) && (!isOldLongMsg((MessageRecord)localObject1)));
      this.errorCode = 13;
      onError();
      return;
      if (!isOldLongMsg((MessageRecord)localObject1)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "sendGetUrlReq->oldLongMsg");
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + ((MessageRecord)localObject1).uniseq + ", sendGetUrlReq");
      }
      localObject2 = new RichProto.RichProtoReq.MultiMsgDownReq();
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).selfUin = ((MessageRecord)localObject1).selfuin;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).peerUin = ((MessageRecord)localObject1).frienduin;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).secondUin = ((MessageRecord)localObject1).frienduin;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).uinType = ((MessageRecord)localObject1).istroop;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).msgResId = str.getBytes();
      localObject1 = new RichProto.RichProtoReq();
      ((RichProto.RichProtoReq)localObject1).callback = this;
      ((RichProto.RichProtoReq)localObject1).protoKey = "multi_msg_dw";
      ((RichProto.RichProtoReq)localObject1).reqs.add(localObject2);
      ((RichProto.RichProtoReq)localObject1).protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepUrl);
        this.errorCode = 16;
        onError();
        return;
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = ((RichProto.RichProtoReq)localObject1);
    RichProtoProc.procRichProtoReq((RichProto.RichProtoReq)localObject1);
    for (;;)
    {
      this.mSSOStartTime = System.nanoTime();
      return;
      localObject2 = new RichProto.RichProtoReq();
      ((RichProto.RichProtoReq)localObject2).callback = this;
      ((RichProto.RichProtoReq)localObject2).protoKey = "pa_long_message";
      ((RichProto.RichProtoReq)localObject2).protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepUrl);
        this.errorCode = 16;
        onError();
        return;
      }
      if (!canDoNextStep()) {
        break;
      }
      this.mRichProtoReq = ((RichProto.RichProtoReq)localObject2);
      RichProto.RichProtoReq.LongStructMessageDownReq localLongStructMessageDownReq = new RichProto.RichProtoReq.LongStructMessageDownReq();
      localLongStructMessageDownReq.strFileid = str;
      localLongStructMessageDownReq.peerUin = ((MessageRecord)localObject1).frienduin;
      ((RichProto.RichProtoReq)localObject2).reqs.add(localLongStructMessageDownReq);
      RichProtoProc.procRichProtoReq((RichProto.RichProtoReq)localObject2);
    }
  }
  
  private void updateMessageDataBaseContent(int paramInt)
  {
    MessageForStructing localMessageForStructing;
    if ((this.mUiRequest.mRec instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)this.mUiRequest.mRec;
      if (localMessageForStructing != null)
      {
        if (paramInt != 2003) {
          break label282;
        }
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_url");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_download_key");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_resid");
        if ((this.mStructingMsg instanceof StructMsgForGeneralShare))
        {
          str = ((StructMsgForGeneralShare)this.mStructingMsg).mWarningTips;
          if (!TextUtils.isEmpty(str)) {
            localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", str);
          }
        }
        l = 0L;
        if (localMessageForStructing.structingMsg != null) {
          l = localMessageForStructing.structingMsg.msgId;
        }
        localMessageForStructing.structingMsg = this.mStructingMsg;
        localMessageForStructing.structingMsg.msgId = l;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage data size: " + this.mStructingMsg.getBytes().length);
        }
        localMessageForStructing.msgData = this.mStructingMsg.getBytes();
        this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
        this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
        this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
      }
    }
    label282:
    while (paramInt != 2005)
    {
      String str;
      long l;
      return;
    }
    localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(2));
    localMessageForStructing.structingMsg.mMsgBrief = HardCodeUtil.a(2131714468);
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
    this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
    this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
  }
  
  public void accountChanged()
  {
    cancelTask(this.mUiRequest.mUniseq);
    this.errorCode = 7;
    notifyCancelTask();
  }
  
  public void cancelTask(long paramLong)
  {
    synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
    {
      if ((DOWN_LOAD_TRANSFER_REQUESTS == null) || (DOWN_LOAD_TRANSFER_REQUESTS.size() == 0)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "cancelAllTask msgid" + paramLong);
      }
      if ((ITransFileController)this.app.getRuntimeService(ITransFileController.class) != null)
      {
        Iterator localIterator = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.mUniseq == paramLong)
          {
            cancelPALongMsgTask(this.app, localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
            DOWN_LOAD_TRANSFER_REQUESTS.remove(localTransferRequest);
          }
        }
      }
      return;
    }
  }
  
  public int checkParam()
  {
    return super.checkParam();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", new Object[] { Integer.valueOf(this.errorCode), Integer.valueOf(this.mReportedFlag) }) + hashCode());
    }
    if ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      if (!isOldLongMsg(this.mUiRequest.mRec)) {
        break label435;
      }
    }
    long l;
    label435:
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      this.mReportInfo.put("param_uin", this.mUiRequest.mRec.selfuin);
      this.mReportInfo.put("param_puin", this.mUiRequest.mRec.senderuin);
      this.mReportInfo.put("param_resid", this.mUiRequest.mRec.getExtInfoFromExtStr("pub_long_msg_resid"));
      this.mReportInfo.put("param_ip_source", "" + this.directDownloadFlag);
      this.mReportInfo.put("param_channel", "0");
      this.mReportInfo.put("param_errcode", String.valueOf(this.errorCode));
      this.mReportInfo.put("param_url", this.url);
      this.mReportInfo.put("param_http_error_code", String.valueOf(this.httpErrorCode));
      this.mReportInfo.put("param_android_error_code", String.valueOf(this.errCode));
      if (!QLog.isColorLevel()) {
        break label443;
      }
      Iterator localIterator = this.mReportInfo.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
      i = 1;
      break;
    }
    label443:
    if (paramBoolean) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, true, l, this.mTotolLen, this.mReportInfo, "", true);
    }
    for (;;)
    {
      setReportFlag();
      return;
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, false, l, 0L, this.mReportInfo, "", true);
    }
  }
  
  public void doReportForExpired(int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Expired");
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", resource expired!");
      }
    }
    if (isOldLongMsg(this.mUiRequest.mRec)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramMessageRecord.selfuin);
      localHashMap.put("param_puin", paramMessageRecord.frienduin);
      localHashMap.put("param_resid", paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(paramInt));
      localHashMap.put("param_url", this.url);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramMessageRecord = localHashMap.entrySet().iterator();
      while (paramMessageRecord.hasNext())
      {
        Object localObject = (Map.Entry)paramMessageRecord.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public boolean isResourceIDOutofDate(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    long l;
    do
    {
      return false;
      l = NetConnInfoCenter.getServerTime();
    } while (paramMessageRecord.time >= l - 604800L);
    return true;
  }
  
  public void notifyCancelTask()
  {
    doReportForCancel();
  }
  
  public void notifyResourceExpired(MessageRecord paramMessageRecord)
  {
    this.errorCode = 3;
    paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(3));
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      localMessageForStructing.structingMsg.mMsgBrief = HardCodeUtil.a(2131714467);
      localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
      this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
    }
    removeMessage();
    doReportForExpired(this.errorCode, paramMessageRecord);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if ((paramRichProtoResp != null) && (paramRichProtoResp.resps != null) && (paramRichProtoResp.resps.size() > 0) && ((paramRichProtoResp.resps.get(0) instanceof RichProto.RichProtoResp.LongStructMessageDownResp)))
    {
      paramRichProtoReq = (RichProto.RichProtoResp.LongStructMessageDownResp)paramRichProtoResp.resps.get(0);
      if ((paramRichProtoReq.retInfo != null) && (paramRichProtoReq.retInfo.ret_code.get() == 0))
      {
        receiveFile(this.mUiRequest.mRec.uniseq, paramRichProtoReq.strUrl);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLongMessageTimeSSO", true, (System.nanoTime() - this.mSSOStartTime) / 1000000L, 0L, null, "", true);
        return;
      }
      this.errorCode = 1;
      onError();
      return;
    }
    if ((paramRichProtoResp != null) && (paramRichProtoResp.resps != null) && (paramRichProtoResp.resps.size() > 0) && ((paramRichProtoResp.resps.get(0) instanceof RichProto.RichProtoResp.MultiMsgDownResp)))
    {
      paramRichProtoResp = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.resps.get(0);
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "onBusiProtoResp->oldLongMsg procUrl:" + paramRichProtoResp.toString());
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", onBusiProtoResp->oldLongMsg procUrl:" + paramRichProtoResp.toString());
      }
      if (paramRichProtoResp.result == 0) {
        switch (paramRichProtoResp.mChannelType)
        {
        case 1: 
        default: 
          paramRichProtoReq = "http://";
          ServerAddr localServerAddr = (ServerAddr)paramRichProtoResp.ipList.get(0);
          paramRichProtoReq = paramRichProtoReq + localServerAddr.mIp;
          if (localServerAddr.port != 80) {
            paramRichProtoReq = paramRichProtoReq + ":" + localServerAddr.port;
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramRichProtoReq = paramRichProtoReq + paramRichProtoResp.urlParam;
      this.mMsgKey = paramRichProtoResp.msgkey;
      receiveFile(this.mUiRequest.mRec.uniseq, paramRichProtoReq);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOldLongMessageTimeSSO", true, (System.nanoTime() - this.mSSOStartTime) / 1000000L, 0L, null, "", true);
      return;
      paramRichProtoReq = "http://";
      break;
      paramRichProtoReq = "https://";
      break;
      this.errorCode = 1;
      onError();
      return;
      this.errorCode = 1;
      onError();
      return;
    }
  }
  
  public void onError()
  {
    super.onError();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.mUiRequest.mRec.uniseq + ", receiveError");
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", receiveError");
      }
    }
    updateMessageDataBaseContent(2005);
    sendMessageToUpdate(2005);
    removeMessage();
  }
  
  public void onResp(NetResp paramNetResp)
  {
    i = 1;
    if (this.directDownload) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (paramNetResp == null) {
      return;
    }
    super.onResp(paramNetResp);
    this.errCode = paramNetResp.mErrCode;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time end: " + System.currentTimeMillis());
    }
    if ((paramNetResp.mReq instanceof HttpNetReq))
    {
      logRichMediaEvent("onResp", "result:" + paramNetResp.mResult + " errCode:" + paramNetResp.mHttpCode + " errDesc:" + paramNetResp.mErrDesc);
      this.httpErrorCode = paramNetResp.mHttpCode;
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
      if (localHttpNetReq.mReqUrl != null)
      {
        Iterator localIterator = downloadList.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localHttpNetReq.mReqUrl.equals(((HttpNetReq)localEntry.getValue()).mReqUrl)) {
            downloadList.remove(localEntry.getKey());
          }
        }
      }
    }
    if (this.mNetReq != null) {
      this.mNetReq.mCallback = null;
    }
    this.mNetReq = null;
    if ((paramNetResp.mResult == 0) && (paramNetResp.mRespData != null) && (paramNetResp.mRespData.length > 0))
    {
      paramNetResp = paramNetResp.mRespData;
      this.mTotolLen = paramNetResp.length;
      if ((!(this.mUiRequest.mRec instanceof MessageForStructing)) || (isOldLongMsg(this.mUiRequest.mRec))) {}
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "onResp->oldLongMsg");
            QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", onResp->getStructMsgFromXmlBuff");
          }
          this.mStructingMsg = StructMsgFactory.a(parseOldLongMsgContent(paramNetResp), -1);
        }
        catch (Exception paramNetResp)
        {
          continue;
          i = 0;
          continue;
        }
        if ((this.mUiRequest.mRec.istroop == 1008) && (this.mStructingMsg != null) && ((TextUtils.isEmpty(this.mStructingMsg.mMsgBrief)) || (this.mStructingMsg.mEmptyMsgBriefModified))) {
          this.mStructingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
        }
        if (this.mStructingMsg == null) {
          continue;
        }
        this.errorCode = 0;
        onSuccess();
        if (!isOldLongMsg(this.mUiRequest.mRec)) {
          continue;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOldLongMessageTimeDownload", true, (System.nanoTime() - this.mDownloadStartTime) / 1000000L, 0L, null, "", true);
        return;
        this.mStructingMsg = StructMsgFactory.a(paramNetResp, -1);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLongMessageTimeDownload", true, (System.nanoTime() - this.mDownloadStartTime) / 1000000L, 0L, null, "", true);
      return;
      if ((this.url != null) && (!"".equals(this.url))) {
        FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
      }
      if (this.directDownload)
      {
        if (this.directDownloadFlag == 5) {}
        for (i = 9;; i = 12)
        {
          this.directDownloadFlag = i;
          requestUrlWhileDirectFailed();
          return;
        }
      }
      this.errorCode = 12;
      onError();
      return;
    }
    if ((this.url != null) && (!"".equals(this.url))) {
      FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
    }
    if (((this.mUiRequest.mRec instanceof MessageForStructing)) && (isResourceIDOutofDate(this.mUiRequest.mRec)) && (399 < this.httpErrorCode) && (this.httpErrorCode < 500))
    {
      if (i != 0)
      {
        notifyResourceExpired(this.mUiRequest.mRec);
        return;
      }
      if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
      {
        this.mNetworkChgRetryCount += 1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Fail. Net Changed. Retry " + this.mNetworkChgRetryCount);
        }
        clearReprotInfo();
        this.directDownloadFlag = 15;
        sendGetUrlReq();
        return;
      }
      if (this.directDownload)
      {
        if (this.directDownloadFlag == 5) {}
        for (i = 8;; i = 11)
        {
          this.directDownloadFlag = i;
          requestUrlWhileDirectFailed();
          return;
        }
      }
      this.errorCode = 14;
      onError();
      return;
    }
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.mUiRequest.mRec.uniseq + ", receiveSuccess");
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", receiveSuccess");
      }
    }
    updateMessageDataBaseContent(2003);
    sendMessageToUpdate(2003);
    removeMessage();
  }
  
  public void run()
  {
    if (this.mNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructLongMessageDownloadProcessor", 2, "Direct download failed timeout");
      }
      this.mNetEngine.cancelReq(this.mNetReq);
      this.mNetReq = null;
    }
    if (this.directDownloadFlag == 5) {}
    for (int i = 13;; i = 14)
    {
      this.directDownloadFlag = i;
      if ((this.url != null) && (!"".equals(this.url))) {
        FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
      }
      sendGetUrlReq();
      return;
    }
  }
  
  public void start()
  {
    super.start();
    if (!directDownloadIfCan()) {
      sendGetUrlReq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */