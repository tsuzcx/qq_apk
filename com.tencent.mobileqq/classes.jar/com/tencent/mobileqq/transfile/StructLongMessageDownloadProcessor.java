package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.LongStructMessageDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.LongStructMessageDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.StringUtil;
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
  private static ConcurrentHashMap b = new ConcurrentHashMap();
  private static final ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = 4;
  private long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = true;
  private long d;
  String f = "";
  String g = "";
  String l;
  int o = 200;
  private int p = 5;
  private int q;
  
  public StructLongMessageDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_l_of_type_JavaLangString = "";
  }
  
  public static String a(byte[] paramArrayOfByte)
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
  
  private void a(long paramLong, String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    b.put(Long.valueOf(paramLong), localHttpNetReq);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    FMTSrvAddrProvider.a().a().b(RichMediaUtil.a(paramString));
    this.f = paramString;
    this.d = System.nanoTime();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "receiveFile->msgid:" + paramLong + ", url:" + paramString);
      if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + paramLong + ", receiveFile->url:" + paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask msgid" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.jdField_a_of_type_Long == paramLong)
          {
            paramQQAppInterface.c(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
            jdField_c_of_type_JavaUtilArrayList.remove(localTransferRequest);
            a(false, localTransferRequest.jdField_b_of_type_JavaLangString, localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long, localTransferRequest);
          }
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      synchronized (jdField_c_of_type_JavaUtilArrayList)
      {
        Object localObject = jdField_c_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((TransferRequest)((Iterator)localObject).next()).jdField_a_of_type_Long != paramMessageRecord.uniseq) {
            continue;
          }
          return;
        }
        localObject = new TransferRequest();
        ((TransferRequest)localObject).jdField_a_of_type_Boolean = false;
        ((TransferRequest)localObject).c = paramMessageRecord.frienduin;
        ((TransferRequest)localObject).e = 131079;
        ((TransferRequest)localObject).jdField_b_of_type_Int = 131079;
        ((TransferRequest)localObject).jdField_a_of_type_Long = paramMessageRecord.uniseq;
        ((TransferRequest)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        ((TransferRequest)localObject).jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
        if (paramQQAppInterface.a().a((TransferRequest)localObject)) {
          jdField_c_of_type_JavaUtilArrayList.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          if (c(paramMessageRecord))
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage(oldLongMsg) , messageRecord,msgid= " + paramMessageRecord.uniseq);
            QLog.d("PaOldLongMsg", 2, "msgId=" + paramMessageRecord.uniseq + ", getStructLongMessage");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList2;
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0) || (paramString == null) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask uin" + paramString);
      }
      localArrayList2 = new ArrayList();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (paramString.equalsIgnoreCase(localTransferRequest.c))
          {
            paramQQAppInterface.c(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
            localArrayList2.add(localTransferRequest);
            a(true, localTransferRequest.jdField_b_of_type_JavaLangString, localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long, localTransferRequest);
          }
        }
      }
    }
    jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList2);
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, TransferRequest paramTransferRequest)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (c(paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", delete download task!");
      }
    }
    HashMap localHashMap;
    if (c(paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
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
    StatisticCollector.a(BaseApplication.getContext()).a(null, paramTransferRequest, false, 0L, 0L, localHashMap, "", true);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
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
      paramArrayOfByte = new Cryptor().decrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
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
  
  public static boolean b(MessageRecord paramMessageRecord)
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
  
  public static boolean c(MessageRecord paramMessageRecord)
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
  
  public static boolean d(MessageRecord paramMessageRecord)
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
  
  private boolean e()
  {
    this.jdField_c_of_type_Boolean = true;
    this.p = 5;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageRecord == null) {}
    do
    {
      return false;
      localObject = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str1 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      this.g = localMessageRecord.selfuin;
      this.jdField_l_of_type_JavaLangString = localMessageRecord.frienduin;
    } while ((localObject == null) || ("".equals(localObject)) || (str1 == null) || ("".equals(str1)));
    String str2 = (String)localObject + "&rkey=" + str1;
    String str1 = FMTSrvAddrProvider.a().a();
    Object localObject = str1;
    if (str1 == null)
    {
      localObject = FMTSrvAddrProvider.a().a().a();
      this.p = 10;
      this.q = FMTSrvAddrProvider.a().a().a();
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      switch (FMTSrvAddrProvider.a().a())
      {
      default: 
        this.p = 7;
        return false;
      }
      this.p = 6;
      return false;
    }
    localObject = (String)localObject + str2;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "directUrl = " + str2 + ",url:" + (String)localObject);
    }
    a(localMessageRecord.uniseq, (String)localObject);
    ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
    return true;
  }
  
  private void f(int paramInt)
  {
    MessageForStructing localMessageForStructing;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageForStructing != null)
      {
        if (paramInt != 2003) {
          break label282;
        }
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_url");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_download_key");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_resid");
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          str = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mWarningTips;
          if (!TextUtils.isEmpty(str)) {
            localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", str);
          }
        }
        l1 = 0L;
        if (localMessageForStructing.structingMsg != null) {
          l1 = localMessageForStructing.structingMsg.msgId;
        }
        localMessageForStructing.structingMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localMessageForStructing.structingMsg.msgId = l1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage data size: " + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getBytes().length);
        }
        localMessageForStructing.msgData = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getBytes();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.msgData);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
      }
    }
    label282:
    while (paramInt != 2005)
    {
      String str;
      long l1;
      return;
    }
    localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(2));
    localMessageForStructing.structingMsg.mMsgBrief = "消息下载失败";
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.msgData);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) {
      synchronized (jdField_c_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) {
            jdField_c_of_type_JavaUtilArrayList.remove(localTransferRequest);
          }
        }
        return;
      }
    }
  }
  
  private void p()
  {
    this.jdField_c_of_type_Boolean = false;
    this.q = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject1 == null)
    {
      this.jdField_c_of_type_Int = 15;
      d();
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
      } while ((!b((MessageRecord)localObject1)) && (!c((MessageRecord)localObject1)));
      this.jdField_c_of_type_Int = 13;
      d();
      return;
      if (!c((MessageRecord)localObject1)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "sendGetUrlReq->oldLongMsg");
        QLog.d("PaOldLongMsg", 2, "msgId=" + ((MessageRecord)localObject1).uniseq + ", sendGetUrlReq");
      }
      localObject2 = new RichProto.RichProtoReq.MultiMsgDownReq();
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).c = ((MessageRecord)localObject1).selfuin;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).d = ((MessageRecord)localObject1).frienduin;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).e = ((MessageRecord)localObject1).frienduin;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).f = ((MessageRecord)localObject1).istroop;
      ((RichProto.RichProtoReq.MultiMsgDownReq)localObject2).jdField_a_of_type_ArrayOfByte = str.getBytes();
      localObject1 = new RichProto.RichProtoReq();
      ((RichProto.RichProtoReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      ((RichProto.RichProtoReq)localObject1).jdField_a_of_type_JavaLangString = "multi_msg_dw";
      ((RichProto.RichProtoReq)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((RichProto.RichProtoReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!c())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        this.jdField_c_of_type_Int = 16;
        d();
        return;
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = ((RichProto.RichProtoReq)localObject1);
    RichProtoProc.a((RichProto.RichProtoReq)localObject1);
    for (;;)
    {
      this.jdField_c_of_type_Long = System.nanoTime();
      return;
      localObject2 = new RichProto.RichProtoReq();
      ((RichProto.RichProtoReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      ((RichProto.RichProtoReq)localObject2).jdField_a_of_type_JavaLangString = "pa_long_message";
      ((RichProto.RichProtoReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!c())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        this.jdField_c_of_type_Int = 16;
        d();
        return;
      }
      if (!d()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = ((RichProto.RichProtoReq)localObject2);
      RichProto.RichProtoReq.LongStructMessageDownReq localLongStructMessageDownReq = new RichProto.RichProtoReq.LongStructMessageDownReq();
      localLongStructMessageDownReq.jdField_a_of_type_JavaLangString = str;
      localLongStructMessageDownReq.d = ((MessageRecord)localObject1).frienduin;
      ((RichProto.RichProtoReq)localObject2).jdField_a_of_type_JavaUtilList.add(localLongStructMessageDownReq);
      RichProtoProc.a((RichProto.RichProtoReq)localObject2);
    }
  }
  
  private void q()
  {
    p();
  }
  
  private void r()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", cancle download task!");
      }
    }
    if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", this.g);
      localHashMap.put("param_puin", this.jdField_l_of_type_JavaLangString);
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(7));
      localHashMap.put("param_url", this.f);
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
    StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Expired");
      if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", resource expired!");
      }
    }
    if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramMessageRecord.selfuin);
      localHashMap.put("param_puin", paramMessageRecord.frienduin);
      localHashMap.put("param_resid", paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(paramInt));
      localHashMap.put("param_url", this.f);
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
    StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.jdField_c_of_type_Int = 3;
    paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(3));
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      localMessageForStructing.structingMsg.mMsgBrief = "消息下载失败";
      localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.msgData);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
    }
    o();
    a(this.jdField_c_of_type_Int, paramMessageRecord);
  }
  
  public void a(NetResp paramNetResp)
  {
    i = 1;
    if (this.jdField_c_of_type_Boolean) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (paramNetResp == null) {
      return;
    }
    super.a(paramNetResp);
    this.j = paramNetResp.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time end: " + System.currentTimeMillis());
    }
    if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      b("onResp", "result:" + paramNetResp.jdField_a_of_type_Int + " errCode:" + paramNetResp.jdField_c_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      this.o = paramNetResp.jdField_c_of_type_Int;
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      if (localHttpNetReq.jdField_a_of_type_JavaLangString != null)
      {
        Iterator localIterator = b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localHttpNetReq.jdField_a_of_type_JavaLangString.equals(((HttpNetReq)localEntry.getValue()).jdField_a_of_type_JavaLangString)) {
            b.remove(localEntry.getKey());
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    if ((paramNetResp.jdField_a_of_type_Int == 0) && (paramNetResp.jdField_a_of_type_ArrayOfByte != null) && (paramNetResp.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      paramNetResp = paramNetResp.jdField_a_of_type_ArrayOfByte;
      this.jdField_a_of_type_Long = paramNetResp.length;
      if ((!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) || (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {}
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "onResp->oldLongMsg");
            QLog.d("PaOldLongMsg", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", onResp->getStructMsgFromXmlBuff");
          }
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(a(paramNetResp), -1);
        }
        catch (Exception paramNetResp)
        {
          continue;
          i = 0;
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1008) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgBrief)) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mEmptyMsgBriefModified))) {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgBrief = "你有新消息";
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
          continue;
        }
        this.jdField_c_of_type_Int = 0;
        e();
        if (!c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          continue;
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actOldLongMessageTimeDownload", true, (System.nanoTime() - this.d) / 1000000L, 0L, null, "", true);
        return;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(paramNetResp, -1);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageTimeDownload", true, (System.nanoTime() - this.d) / 1000000L, 0L, null, "", true);
      return;
      if ((this.f != null) && (!"".equals(this.f))) {
        FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(this.f));
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.p == 5) {}
        for (i = 9;; i = 12)
        {
          this.p = i;
          q();
          return;
        }
      }
      this.jdField_c_of_type_Int = 12;
      d();
      return;
    }
    if ((this.f != null) && (!"".equals(this.f))) {
      FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(this.f));
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) && (a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) && (399 < this.o) && (this.o < 500))
    {
      if (i != 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      }
      if ((paramNetResp.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
      {
        this.jdField_l_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Fail. Net Changed. Retry " + this.jdField_l_of_type_Int);
        }
        m();
        this.p = 15;
        p();
        return;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.p == 5) {}
        for (i = 8;; i = 11)
        {
          this.p = i;
          q();
          return;
        }
      }
      this.jdField_c_of_type_Int = 14;
      d();
      return;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if ((paramRichProtoResp != null) && (paramRichProtoResp.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoResp.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(0) instanceof RichProto.RichProtoResp.LongStructMessageDownResp)))
    {
      paramRichProtoReq = (RichProto.RichProtoResp.LongStructMessageDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
      if ((paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo.ret_code.get() == 0))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, paramRichProtoReq.jdField_a_of_type_JavaLangString);
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageTimeSSO", true, (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L, 0L, null, "", true);
        return;
      }
      this.jdField_c_of_type_Int = 1;
      d();
      return;
    }
    if ((paramRichProtoResp != null) && (paramRichProtoResp.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoResp.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(0) instanceof RichProto.RichProtoResp.MultiMsgDownResp)))
    {
      paramRichProtoResp = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "onBusiProtoResp->oldLongMsg procUrl:" + paramRichProtoResp.toString());
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", onBusiProtoResp->oldLongMsg procUrl:" + paramRichProtoResp.toString());
      }
      if (paramRichProtoResp.jdField_c_of_type_Int == 0)
      {
        ServerAddr localServerAddr = (ServerAddr)paramRichProtoResp.jdField_a_of_type_JavaUtilArrayList.get(0);
        paramRichProtoReq = "http://" + localServerAddr.jdField_a_of_type_JavaLangString;
        if (localServerAddr.jdField_a_of_type_Int == 80) {
          break label445;
        }
        paramRichProtoReq = paramRichProtoReq + ":" + localServerAddr.jdField_a_of_type_Int;
      }
    }
    label445:
    for (;;)
    {
      paramRichProtoReq = paramRichProtoReq + paramRichProtoResp.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ArrayOfByte = paramRichProtoResp.b;
      a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, paramRichProtoReq);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actOldLongMessageTimeSSO", true, (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L, 0L, null, "", true);
      return;
      this.jdField_c_of_type_Int = 1;
      d();
      return;
      this.jdField_c_of_type_Int = 1;
      d();
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.m) }) + hashCode());
    }
    if ((this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      if (!c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label436;
      }
    }
    long l1;
    label436:
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.k) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_resid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_ip_source", "" + this.p);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_channel", "0");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errcode", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", this.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_http_error_code", String.valueOf(this.o));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_android_error_code", String.valueOf(this.j));
      if (!QLog.isColorLevel()) {
        break label444;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
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
    label444:
    if (paramBoolean) {
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
    }
    for (;;)
    {
      l();
      return;
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", true);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    long l1;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
    } while (paramMessageRecord.time >= l1 - 604800L);
    return true;
  }
  
  public void ap_()
  {
    super.ap_();
    if (!e()) {
      p();
    }
  }
  
  public void b()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    this.jdField_c_of_type_Int = 7;
    f();
  }
  
  public void b(long paramLong)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "cancelAllTask msgid" + paramLong);
      }
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localTransFileController != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.jdField_a_of_type_Long == paramLong)
          {
            localTransFileController.c(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
            jdField_c_of_type_JavaUtilArrayList.remove(localTransferRequest);
          }
        }
      }
      return;
    }
  }
  
  public int c()
  {
    return super.c();
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveError");
      if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveError");
      }
    }
    f(2005);
    d(2005);
    o();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveSuccess");
      if (c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveSuccess");
      }
    }
    f(2003);
    d(2003);
    o();
  }
  
  public void f()
  {
    r();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructLongMessageDownloadProcessor", 2, "Direct download failed timeout");
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    }
    if (this.p == 5) {}
    for (int i = 13;; i = 14)
    {
      this.p = i;
      if ((this.f != null) && (!"".equals(this.f))) {
        FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(this.f));
      }
      p();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */