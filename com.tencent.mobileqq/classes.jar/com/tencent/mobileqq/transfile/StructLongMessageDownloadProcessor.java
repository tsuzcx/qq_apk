package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.service.message.QMessagePBElemDecoder;
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
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Collection;
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
  static ConcurrentHashMap<Long, HttpNetReq> downloadList = new ConcurrentHashMap();
  QQAppInterface app;
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
  
  public StructLongMessageDownloadProcessor() {}
  
  public StructLongMessageDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.app = ((QQAppInterface)this.app);
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    return QMessagePBElemDecoder.b(paramArrayOfByte);
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
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cancel PALongMsg:");
            localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            QLog.d("cancelpic", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  private boolean checkDataValid(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      int i = paramArrayOfByte.length;
      if ((paramArrayOfByte[0] == 40) && (paramArrayOfByte[(i - 1)] == 41)) {
        return true;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected body data, len=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", data=");
      String str = ((StringBuilder)localObject).toString();
      localObject = paramArrayOfByte.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      paramArrayOfByte = (byte[])localObject;
      if (((String)localObject).length() > 20) {
        paramArrayOfByte = ((String)localObject).substring(0, 20);
      }
      localStringBuilder.append(paramArrayOfByte);
      paramArrayOfByte = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseOldLongMsgContent->");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("StructLongMessageDownloadProcessor", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->null bodyData");
    }
    return false;
  }
  
  public static void deleteTask(QQAppInterface paramQQAppInterface, long paramLong)
  {
    synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
    {
      if ((DOWN_LOAD_TRANSFER_REQUESTS != null) && (DOWN_LOAD_TRANSFER_REQUESTS.size() != 0) && (paramQQAppInterface != null))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteAllTask msgid");
          ((StringBuilder)localObject).append(paramLong);
          QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject).toString());
        }
        if ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class) != null)
        {
          localObject = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
          while (((Iterator)localObject).hasNext())
          {
            TransferRequest localTransferRequest = (TransferRequest)((Iterator)localObject).next();
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
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public static void deleteTask(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
    {
      if ((DOWN_LOAD_TRANSFER_REQUESTS != null) && (DOWN_LOAD_TRANSFER_REQUESTS.size() != 0) && (paramString != null) && (paramQQAppInterface != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteAllTask uin");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = new ArrayList();
        if ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class) != null)
        {
          Iterator localIterator = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
          while (localIterator.hasNext())
          {
            TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
            if (paramString.equalsIgnoreCase(localTransferRequest.mPeerUin))
            {
              cancelPALongMsgTask(paramQQAppInterface, localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
              ((ArrayList)localObject).add(localTransferRequest);
              doReportForDelete(true, localTransferRequest.mSelfUin, localTransferRequest.mPeerUin, localTransferRequest.mUniseq, localTransferRequest);
            }
          }
        }
        DOWN_LOAD_TRANSFER_REQUESTS.removeAll((Collection)localObject);
        return;
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  private boolean directDownloadIfCan()
  {
    this.directDownload = true;
    this.directDownloadFlag = 5;
    MessageRecord localMessageRecord = this.mUiRequest.mRec;
    if (localMessageRecord == null) {
      return false;
    }
    Object localObject1 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
    Object localObject2 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
    this.selfUin = localMessageRecord.selfuin;
    this.pUin = localMessageRecord.frienduin;
    if ((localObject1 != null) && (!"".equals(localObject1)) && (localObject2 != null))
    {
      if ("".equals(localObject2)) {
        return false;
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("&rkey=");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = FMTSrvAddrProvider.getInstance().getSrvAddrForPttDownload();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().getIp();
        this.directDownloadFlag = 10;
        this.connectionFlag = FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().getConnectionFlag();
      }
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((String)localObject3);
        localObject1 = ((StringBuilder)localObject2).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("directUrl = ");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append(",url:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject2).toString());
        }
        receiveFile(localMessageRecord.uniseq, (String)localObject1);
        ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
        return true;
      }
      if (FMTSrvAddrProvider.getInstance().getState() != 1)
      {
        this.directDownloadFlag = 7;
        return false;
      }
      this.directDownloadFlag = 6;
    }
    return false;
  }
  
  private void doReportForCancel()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (isOldLongMsg(this.mUiRequest.mRec))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("msgId=uniseq:");
        ((StringBuilder)localObject1).append(this.mUiRequest.mRec.uniseq);
        ((StringBuilder)localObject1).append(", cancle download task!");
        QLog.d("PaOldLongMsg", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (isOldLongMsg(this.mUiRequest.mRec)) {
      localObject1 = "actOldLongMessageDownload";
    } else {
      localObject1 = "actLongMessageDownload";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.selfUin);
    localHashMap.put("param_puin", this.pUin);
    localHashMap.put("param_channel", "0");
    localHashMap.put("param_errcode", String.valueOf(7));
    localHashMap.put("param_url", this.url);
    if (QLog.isColorLevel())
    {
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject2);
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, localStringBuilder.toString());
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject1, false, 0L, 0L, localHashMap, "", true);
  }
  
  private static void doReportForDelete(boolean paramBoolean, String paramString1, String paramString2, long paramLong, TransferRequest paramTransferRequest)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (isOldLongMsg(paramTransferRequest.mRec))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("msgId=uniseq:");
        ((StringBuilder)localObject1).append(paramTransferRequest.mRec.uniseq);
        ((StringBuilder)localObject1).append(", delete download task!");
        QLog.d("PaOldLongMsg", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (isOldLongMsg(paramTransferRequest.mRec)) {
      paramTransferRequest = "actOldLongMessageDownload";
    } else {
      paramTransferRequest = "actLongMessageDownload";
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_uin", paramString1);
    ((HashMap)localObject1).put("param_puin", paramString2);
    ((HashMap)localObject1).put("param_channel", "0");
    if (paramBoolean) {
      ((HashMap)localObject1).put("param_errcode", String.valueOf(11));
    } else {
      ((HashMap)localObject1).put("param_errcode", String.valueOf(10));
    }
    paramString1 = new StringBuilder();
    paramString1.append("");
    paramString1.append(paramLong);
    ((HashMap)localObject1).put("param_resid", paramString1.toString());
    if (QLog.isColorLevel())
    {
      paramString1 = ((HashMap)localObject1).entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject2 = (Map.Entry)paramString1.next();
        paramString2 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append((String)localObject2);
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, localStringBuilder.toString());
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramTransferRequest, false, 0L, 0L, (HashMap)localObject1, "", true);
  }
  
  public static void getStructLongMessage(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    synchronized (DOWN_LOAD_TRANSFER_REQUESTS)
    {
      Object localObject = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TransferRequest)((Iterator)localObject).next()).mUniseq == paramMessageRecord.uniseq) {
          return;
        }
      }
      localObject = new TransferRequest();
      ((TransferRequest)localObject).mIsUp = false;
      ((TransferRequest)localObject).mPeerUin = paramMessageRecord.frienduin;
      ((TransferRequest)localObject).mBusiType = 131079;
      ((TransferRequest)localObject).mFileType = 131079;
      ((TransferRequest)localObject).mUniseq = paramMessageRecord.uniseq;
      ((TransferRequest)localObject).mRec = paramMessageRecord;
      ((TransferRequest)localObject).mSelfUin = paramMessageRecord.selfuin;
      if (((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "")).transferAsync((TransferRequest)localObject)) {
        DOWN_LOAD_TRANSFER_REQUESTS.add(localObject);
      }
      if (QLog.isColorLevel()) {
        if (isOldLongMsg(paramMessageRecord))
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("getStructLongMessage(oldLongMsg) , messageRecord,msgid= ");
          paramAppInterface.append(paramMessageRecord.uniseq);
          QLog.d("StructLongMessageDownloadProcessor", 2, paramAppInterface.toString());
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("msgId=uniseq:");
          paramAppInterface.append(paramMessageRecord.uniseq);
          paramAppInterface.append(", getStructLongMessage");
          QLog.d("PaOldLongMsg", 2, paramAppInterface.toString());
        }
        else
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("getStructLongMessage , messageRecord,msgid= ");
          paramAppInterface.append(paramMessageRecord.uniseq);
          QLog.d("StructLongMessageDownloadProcessor", 2, paramAppInterface.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("LongMessage Download time start: ");
        paramAppInterface.append(System.currentTimeMillis());
        QLog.d("StructLongMessageDownloadProcessor", 2, paramAppInterface.toString());
      }
      return;
    }
    for (;;)
    {
      throw paramAppInterface;
    }
  }
  
  public static boolean isOldLongMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if (!StringUtil.isEmpty(paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg")))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isOldLongMsg , messageRecord,msgid= ");
        localStringBuilder.append(paramMessageRecord.msgId);
        localStringBuilder.append(" uid= ");
        localStringBuilder.append(paramMessageRecord.msgUid);
        localStringBuilder.append(" msgseq= ");
        localStringBuilder.append(paramMessageRecord.msgseq);
        localStringBuilder.append(" uniseq=");
        localStringBuilder.append(paramMessageRecord.uniseq);
        QLog.d("StructLongMessageDownloadProcessor", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public static boolean isPALongMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
    String str1 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
    String str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
    if ((!StringUtil.isEmpty((String)localObject)) && (!StringUtil.isEmpty(str1)) && (!StringUtil.isEmpty(str2)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isPALongMsg , messageRecord,msgid= ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgId);
        ((StringBuilder)localObject).append(" uid= ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgUid);
        ((StringBuilder)localObject).append(" msgseq= ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgseq);
        ((StringBuilder)localObject).append(" uniseq=");
        ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
        QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    return false;
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
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg");
    String str1 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
    String str2 = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
    if ((!StringUtil.isEmpty((String)localObject)) && (!StringUtil.isEmpty(str2)) && (!StringUtil.isEmpty(str1)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("needFetchOldLongMsg , messageRecord,msgid= ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgId);
        ((StringBuilder)localObject).append(" uid= ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgUid);
        ((StringBuilder)localObject).append(" msgseq= ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgseq);
        ((StringBuilder)localObject).append(" uniseq=");
        ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
        QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    return false;
  }
  
  private byte[] parseOldLongMsgContent(byte[] paramArrayOfByte)
  {
    if (!checkDataValid(paramArrayOfByte)) {
      return null;
    }
    int i;
    int j;
    try
    {
      paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
      paramArrayOfByte.readByte();
      i = paramArrayOfByte.readInt();
      j = paramArrayOfByte.readInt();
      if (i <= 0) {
        break label317;
      }
      localObject = new byte[i];
      paramArrayOfByte.read((byte[])localObject);
      im_msg_head.Head localHead = new im_msg_head.Head();
      localHead.mergeFrom((byte[])localObject);
      i = ((im_msg_head.HttpConnHead)localHead.msg_httpconn_head.get()).uint32_error_code.get();
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseOldLongMsgContent- exception");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("StructLongMessageDownloadProcessor", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    localObject = new byte[j];
    paramArrayOfByte.read((byte[])localObject);
    paramArrayOfByte = new Cryptor().decrypt((byte[])localObject, this.mMsgKey);
    localObject = new LongMsg.RspBody();
    ((LongMsg.RspBody)localObject).mergeFrom(paramArrayOfByte);
    paramArrayOfByte = (LongMsg.MsgDownRsp)((LongMsg.RspBody)localObject).rpt_msg_down_rsp.get(0);
    if (paramArrayOfByte.uint32_result.get() != 0)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result != 0");
        return null;
      }
    }
    else
    {
      paramArrayOfByte = paramArrayOfByte.bytes_msg_content.get().toByteArray();
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length > 0) {
          break label332;
        }
      }
      if (!QLog.isColorLevel()) {
        break label334;
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content == null or empty");
      return null;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parseOldLongMsgContent->bodyLen= ");
          paramArrayOfByte.append(j);
          paramArrayOfByte.append(" errCode= ");
          paramArrayOfByte.append(i);
          QLog.d("StructLongMessageDownloadProcessor", 2, paramArrayOfByte.toString());
        }
        return null;
        label317:
        i = 0;
        if (j > 0) {
          if (i == 0) {
            break;
          }
        }
      }
    }
    return null;
    label332:
    return paramArrayOfByte;
    label334:
    return null;
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
  
  private void sendGetUrlReq()
  {
    this.directDownload = false;
    this.connectionFlag = 0;
    Object localObject1 = this.mUiRequest.mRec;
    if (localObject1 == null)
    {
      this.errorCode = 15;
      onError();
      return;
    }
    String str = ((MessageRecord)localObject1).getExtInfoFromExtStr("pub_long_msg_resid");
    if ((str != null) && (!str.equals("")))
    {
      Object localObject2;
      if (isOldLongMsg((MessageRecord)localObject1))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StructLongMessageDownloadProcessor", 2, "sendGetUrlReq->oldLongMsg");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("msgId=uniseq:");
          ((StringBuilder)localObject2).append(((MessageRecord)localObject1).uniseq);
          ((StringBuilder)localObject2).append(", sendGetUrlReq");
          QLog.d("PaOldLongMsg", 2, ((StringBuilder)localObject2).toString());
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
          this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
          this.errorCode = 16;
          onError();
          return;
        }
        if (!canDoNextStep()) {
          return;
        }
        this.mRichProtoReq = ((RichProto.RichProtoReq)localObject1);
        RichProtoProc.procRichProtoReq((RichProto.RichProtoReq)localObject1);
      }
      else
      {
        localObject2 = new RichProto.RichProtoReq();
        ((RichProto.RichProtoReq)localObject2).callback = this;
        ((RichProto.RichProtoReq)localObject2).protoKey = "pa_long_message";
        ((RichProto.RichProtoReq)localObject2).protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
        if (!isAppValid())
        {
          this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
          this.errorCode = 16;
          onError();
          return;
        }
        if (!canDoNextStep()) {
          return;
        }
        this.mRichProtoReq = ((RichProto.RichProtoReq)localObject2);
        RichProto.RichProtoReq.LongStructMessageDownReq localLongStructMessageDownReq = new RichProto.RichProtoReq.LongStructMessageDownReq();
        localLongStructMessageDownReq.strFileid = str;
        localLongStructMessageDownReq.peerUin = ((MessageRecord)localObject1).frienduin;
        ((RichProto.RichProtoReq)localObject2).reqs.add(localLongStructMessageDownReq);
        RichProtoProc.procRichProtoReq((RichProto.RichProtoReq)localObject2);
      }
      this.mSSOStartTime = System.nanoTime();
      return;
    }
    if ((!isPALongMsg((MessageRecord)localObject1)) && (!isOldLongMsg((MessageRecord)localObject1))) {
      return;
    }
    this.errorCode = 13;
    onError();
  }
  
  private void updateMessageDataBaseContent(int paramInt)
  {
    if ((this.mUiRequest.mRec instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)this.mUiRequest.mRec;
      if (localMessageForStructing != null)
      {
        if (paramInt == 2003)
        {
          localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_url");
          localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_download_key");
          localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_resid");
          Object localObject = this.mStructingMsg;
          if ((localObject instanceof StructMsgForGeneralShare))
          {
            localObject = ((StructMsgForGeneralShare)localObject).mWarningTips;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject);
            }
          }
          long l = 0L;
          if (localMessageForStructing.structingMsg != null) {
            l = localMessageForStructing.structingMsg.msgId;
          }
          localMessageForStructing.structingMsg = this.mStructingMsg;
          localMessageForStructing.structingMsg.msgId = l;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("LongMessage data size: ");
            ((StringBuilder)localObject).append(this.mStructingMsg.getBytes().length);
            QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject).toString());
          }
          localMessageForStructing.msgData = this.mStructingMsg.getBytes();
          this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
          this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
          this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
          return;
        }
        if (paramInt == 2005)
        {
          localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(2));
          localMessageForStructing.structingMsg.mMsgBrief = HardCodeUtil.a(2131911901);
          localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
          this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
          this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
          this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
        }
      }
    }
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
      if ((DOWN_LOAD_TRANSFER_REQUESTS != null) && (DOWN_LOAD_TRANSFER_REQUESTS.size() != 0))
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("cancelAllTask msgid");
          ((StringBuilder)localObject1).append(paramLong);
          QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        if ((ITransFileController)this.app.getRuntimeService(ITransFileController.class) != null)
        {
          localObject1 = DOWN_LOAD_TRANSFER_REQUESTS.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            TransferRequest localTransferRequest = (TransferRequest)((Iterator)localObject1).next();
            if (localTransferRequest.mUniseq == paramLong)
            {
              cancelPALongMsgTask(this.app, localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
              DOWN_LOAD_TRANSFER_REQUESTS.remove(localTransferRequest);
            }
          }
        }
        return;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int checkParam()
  {
    return super.checkParam();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", new Object[] { Integer.valueOf(this.errorCode), Integer.valueOf(this.mProcessorReport.mReportedFlag) }));
      ((StringBuilder)localObject1).append(hashCode());
      QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      localObject1 = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      if (paramBoolean) {
        i = 2;
      }
      ((ProcessorReport)localObject1).mReportedFlag = (i | j);
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        localObject1 = "actOldLongMessageDownload";
      } else {
        localObject1 = "actLongMessageDownload";
      }
      this.mProcessorReport.mEndTime = System.currentTimeMillis();
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      this.mProcessorReport.mReportInfo.put("param_uin", this.mUiRequest.mRec.selfuin);
      this.mProcessorReport.mReportInfo.put("param_puin", this.mUiRequest.mRec.senderuin);
      this.mProcessorReport.mReportInfo.put("param_resid", this.mUiRequest.mRec.getExtInfoFromExtStr("pub_long_msg_resid"));
      Object localObject2 = this.mProcessorReport.mReportInfo;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.directDownloadFlag);
      ((HashMap)localObject2).put("param_ip_source", ((StringBuilder)localObject3).toString());
      this.mProcessorReport.mReportInfo.put("param_channel", "0");
      this.mProcessorReport.mReportInfo.put("param_errcode", String.valueOf(this.errorCode));
      this.mProcessorReport.mReportInfo.put("param_url", this.url);
      this.mProcessorReport.mReportInfo.put("param_http_error_code", String.valueOf(this.httpErrorCode));
      this.mProcessorReport.mReportInfo.put("param_android_error_code", String.valueOf(this.mProcessorReport.errCode));
      if (QLog.isColorLevel())
      {
        localObject2 = this.mProcessorReport.mReportInfo.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append((String)localObject4);
          QLog.d("StructLongMessageDownloadProcessorForReport", 2, localStringBuilder.toString());
        }
      }
      if (paramBoolean) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject1, true, l, this.mTotolLen, this.mProcessorReport.mReportInfo, "", true);
      } else {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject1, false, l, 0L, this.mProcessorReport.mReportInfo, "", true);
      }
      setReportFlag();
    }
  }
  
  public void doReportForExpired(int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Expired");
      if (isOldLongMsg(this.mUiRequest.mRec))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("msgId=uniseq:");
        ((StringBuilder)localObject1).append(this.mUiRequest.mRec.uniseq);
        ((StringBuilder)localObject1).append(", resource expired!");
        QLog.d("PaOldLongMsg", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (isOldLongMsg(this.mUiRequest.mRec)) {
      localObject1 = "actOldLongMessageDownload";
    } else {
      localObject1 = "actLongMessageDownload";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramMessageRecord.selfuin);
    localHashMap.put("param_puin", paramMessageRecord.frienduin);
    localHashMap.put("param_resid", paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
    localHashMap.put("param_channel", "0");
    localHashMap.put("param_errcode", String.valueOf(paramInt));
    localHashMap.put("param_url", this.url);
    if (QLog.isColorLevel())
    {
      paramMessageRecord = localHashMap.entrySet().iterator();
      while (paramMessageRecord.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMessageRecord.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject2);
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, localStringBuilder.toString());
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject1, false, 0L, 0L, localHashMap, "", true);
  }
  
  void handleReq(NetResp paramNetResp)
  {
    if ((paramNetResp.mReq instanceof HttpNetReq))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("result:");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      ((StringBuilder)localObject).append(" errCode:");
      ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject).append(" errDesc:");
      ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
      logRichMediaEvent("onResp", ((StringBuilder)localObject).toString());
      this.httpErrorCode = paramNetResp.mHttpCode;
      paramNetResp = (HttpNetReq)paramNetResp.mReq;
      if (paramNetResp.mReqUrl != null)
      {
        localObject = downloadList.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (paramNetResp.mReqUrl.equals(((HttpNetReq)localEntry.getValue()).mReqUrl)) {
            downloadList.remove(localEntry.getKey());
          }
        }
      }
    }
  }
  
  void handleRespError(NetResp paramNetResp)
  {
    String str = this.url;
    if ((str != null) && (!"".equals(str))) {
      FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
    }
    int j = 0;
    int i = j;
    if ((this.mUiRequest.mRec instanceof MessageForStructing))
    {
      i = j;
      if (isResourceIDOutofDate(this.mUiRequest.mRec))
      {
        int k = this.httpErrorCode;
        i = j;
        if (399 < k)
        {
          i = j;
          if (k < 500) {
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      notifyResourceExpired(this.mUiRequest.mRec);
      return;
    }
    if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
    {
      this.mNetworkChgRetryCount += 1;
      if (QLog.isColorLevel())
      {
        paramNetResp = new StringBuilder();
        paramNetResp.append("LongMessage Download Fail. Net Changed. Retry ");
        paramNetResp.append(this.mNetworkChgRetryCount);
        QLog.d("StructLongMessageDownloadProcessor", 2, paramNetResp.toString());
      }
      clearReprotInfo();
      this.directDownloadFlag = 15;
      sendGetUrlReq();
      return;
    }
    if (this.directDownload)
    {
      if (this.directDownloadFlag == 5) {
        i = 8;
      } else {
        i = 11;
      }
      this.directDownloadFlag = i;
      requestUrlWhileDirectFailed();
      return;
    }
    this.errorCode = 14;
    onError();
  }
  
  void handleRespSucess(NetResp paramNetResp)
  {
    paramNetResp = paramNetResp.mRespData;
    this.mTotolLen = paramNetResp.length;
    handleStructMsg(paramNetResp);
    if (this.mStructingMsg != null)
    {
      this.errorCode = 0;
      onSuccess();
      if (isOldLongMsg(this.mUiRequest.mRec))
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOldLongMessageTimeDownload", true, (System.nanoTime() - this.mDownloadStartTime) / 1000000L, 0L, null, "", true);
        return;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLongMessageTimeDownload", true, (System.nanoTime() - this.mDownloadStartTime) / 1000000L, 0L, null, "", true);
      return;
    }
    paramNetResp = this.url;
    if ((paramNetResp != null) && (!"".equals(paramNetResp))) {
      FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
    }
    boolean bool = this.directDownload;
    int i = 12;
    if (bool)
    {
      if (this.directDownloadFlag == 5) {
        i = 9;
      }
      this.directDownloadFlag = i;
      requestUrlWhileDirectFailed();
      return;
    }
    this.errorCode = 12;
    onError();
  }
  
  protected void handleStructMsg(byte[] paramArrayOfByte)
  {
    if ((this.mUiRequest.mRec instanceof MessageForStructing))
    {
      if (isOldLongMsg(this.mUiRequest.mRec)) {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "onResp->oldLongMsg");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("msgId=uniseq:");
            localStringBuilder.append(this.mUiRequest.mRec.uniseq);
            localStringBuilder.append(", onResp->getStructMsgFromXmlBuff");
            QLog.d("PaOldLongMsg", 2, localStringBuilder.toString());
          }
          this.mStructingMsg = StructMsgFactory.a(parseOldLongMsgContent(paramArrayOfByte), -1);
        }
        catch (Exception paramArrayOfByte)
        {
          QLog.d("StructLongMessageDownloadProcessor", 1, paramArrayOfByte, new Object[0]);
        }
      } else {
        this.mStructingMsg = StructMsgFactory.a(paramArrayOfByte, -1);
      }
      if (this.mUiRequest.mRec.istroop == 1008)
      {
        paramArrayOfByte = this.mStructingMsg;
        if ((paramArrayOfByte != null) && ((TextUtils.isEmpty(paramArrayOfByte.mMsgBrief)) || (this.mStructingMsg.mEmptyMsgBriefModified))) {
          this.mStructingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
        }
      }
    }
  }
  
  public boolean isResourceIDOutofDate(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    long l = NetConnInfoCenter.getServerTime();
    return paramMessageRecord.time < l - 604800L;
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
      localMessageForStructing.structingMsg.mMsgBrief = HardCodeUtil.a(2131911900);
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
      RichProto.RichProtoResp.MultiMsgDownResp localMultiMsgDownResp = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.resps.get(0);
      if (QLog.isColorLevel())
      {
        paramRichProtoReq = new StringBuilder();
        paramRichProtoReq.append("onBusiProtoResp->oldLongMsg procUrl:");
        paramRichProtoReq.append(localMultiMsgDownResp.toString());
        QLog.d("StructLongMessageDownloadProcessor", 2, paramRichProtoReq.toString());
        paramRichProtoReq = new StringBuilder();
        paramRichProtoReq.append("msgId=uniseq:");
        paramRichProtoReq.append(this.mUiRequest.mRec.uniseq);
        paramRichProtoReq.append(", onBusiProtoResp->oldLongMsg procUrl:");
        paramRichProtoReq.append(localMultiMsgDownResp.toString());
        QLog.d("PaOldLongMsg", 2, paramRichProtoReq.toString());
      }
      if (localMultiMsgDownResp.result == 0)
      {
        int i = localMultiMsgDownResp.mChannelType;
        paramRichProtoResp = "http://";
        paramRichProtoReq = paramRichProtoResp;
        if (i != 0) {
          if (i != 2) {
            paramRichProtoReq = paramRichProtoResp;
          } else {
            paramRichProtoReq = "https://";
          }
        }
        ServerAddr localServerAddr = (ServerAddr)localMultiMsgDownResp.ipList.get(0);
        paramRichProtoResp = new StringBuilder();
        paramRichProtoResp.append(paramRichProtoReq);
        paramRichProtoResp.append(localServerAddr.mIp);
        paramRichProtoResp = paramRichProtoResp.toString();
        paramRichProtoReq = paramRichProtoResp;
        if (localServerAddr.port != 80)
        {
          paramRichProtoReq = new StringBuilder();
          paramRichProtoReq.append(paramRichProtoResp);
          paramRichProtoReq.append(":");
          paramRichProtoReq.append(localServerAddr.port);
          paramRichProtoReq = paramRichProtoReq.toString();
        }
        paramRichProtoResp = new StringBuilder();
        paramRichProtoResp.append(paramRichProtoReq);
        paramRichProtoResp.append(localMultiMsgDownResp.urlParam);
        paramRichProtoReq = paramRichProtoResp.toString();
        this.mMsgKey = localMultiMsgDownResp.msgkey;
        receiveFile(this.mUiRequest.mRec.uniseq, paramRichProtoReq);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOldLongMessageTimeSSO", true, (System.nanoTime() - this.mSSOStartTime) / 1000000L, 0L, null, "", true);
        return;
      }
      this.errorCode = 1;
      onError();
      return;
    }
    this.errorCode = 1;
    onError();
  }
  
  public void onError()
  {
    super.onError();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId=");
      localStringBuilder.append(this.mUiRequest.mRec.uniseq);
      localStringBuilder.append(", receiveError");
      QLog.d("StructLongMessageDownloadProcessor", 2, localStringBuilder.toString());
      if (isOldLongMsg(this.mUiRequest.mRec))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("msgId=uniseq:");
        localStringBuilder.append(this.mUiRequest.mRec.uniseq);
        localStringBuilder.append(", receiveError");
        QLog.d("PaOldLongMsg", 2, localStringBuilder.toString());
      }
    }
    updateMessageDataBaseContent(2005);
    sendMessageToUpdate(2005);
    removeMessage();
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.directDownload) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (paramNetResp == null) {
      return;
    }
    super.onResp(paramNetResp);
    this.mProcessorReport.errCode = paramNetResp.mErrCode;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LongMessage Download time end: ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("StructLongMessageDownloadProcessor", 2, localStringBuilder.toString());
    }
    handleReq(paramNetResp);
    if (this.mNetReq != null) {
      this.mNetReq.mCallback = null;
    }
    this.mNetReq = null;
    if ((paramNetResp.mResult == 0) && (paramNetResp.mRespData != null) && (paramNetResp.mRespData.length > 0))
    {
      handleRespSucess(paramNetResp);
      return;
    }
    handleRespError(paramNetResp);
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId=");
      localStringBuilder.append(this.mUiRequest.mRec.uniseq);
      localStringBuilder.append(", receiveSuccess");
      QLog.d("StructLongMessageDownloadProcessor", 2, localStringBuilder.toString());
      if (isOldLongMsg(this.mUiRequest.mRec))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("msgId=uniseq:");
        localStringBuilder.append(this.mUiRequest.mRec.uniseq);
        localStringBuilder.append(", receiveSuccess");
        QLog.d("PaOldLongMsg", 2, localStringBuilder.toString());
      }
    }
    updateMessageDataBaseContent(2003);
    sendMessageToUpdate(2003);
    removeMessage();
  }
  
  protected void receiveFile(long paramLong, String paramString)
  {
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = this;
    ((HttpNetReq)localObject).mReqUrl = paramString;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mServerList = this.mIpList;
    this.mNetEngine.sendReq((NetReq)localObject);
    downloadList.put(Long.valueOf(paramLong), localObject);
    this.mNetReq = ((NetReq)localObject);
    FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().saveIp(TransFileUtil.getIpAndPortFromUrl(paramString));
    this.url = paramString;
    this.mDownloadStartTime = System.nanoTime();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receiveFile->msgid:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("StructLongMessageDownloadProcessor", 2, ((StringBuilder)localObject).toString());
      if (isOldLongMsg(this.mUiRequest.mRec))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msgId=uniseq:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", receiveFile->url:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PaOldLongMsg", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  void requestUrlWhileDirectFailed()
  {
    sendGetUrlReq();
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
    int i;
    if (this.directDownloadFlag == 5) {
      i = 13;
    } else {
      i = 14;
    }
    this.directDownloadFlag = i;
    String str = this.url;
    if ((str != null) && (!"".equals(str))) {
      FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
    }
    sendGetUrlReq();
  }
  
  public void start()
  {
    super.start();
    if (!directDownloadIfCan()) {
      sendGetUrlReq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */