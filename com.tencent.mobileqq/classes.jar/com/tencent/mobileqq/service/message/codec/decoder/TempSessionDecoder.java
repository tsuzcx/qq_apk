package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.codec.TempSessionCache;
import com.tencent.imcore.message.core.codec.TempSessionCacheGenerator;
import com.tencent.imcore.message.core.codec.TempSessionServiceType;
import com.tencent.imcore.message.core.codec.TempSessionServiceTypeGenerator;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qidian.util.QidianUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TmpPtt;

public class TempSessionDecoder
  implements Decoder<MessageHandler>
{
  private static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 134: 
    case 135: 
    case 136: 
    case 138: 
    case 139: 
    case 140: 
    case 141: 
    case 142: 
    case 143: 
    case 145: 
    case 146: 
    case 147: 
    case 148: 
    case 150: 
    case 151: 
    case 152: 
    case 154: 
    case 155: 
    case 157: 
    case 158: 
    case 162: 
    default: 
      return paramInt1;
    case 133: 
      return 1023;
    case 137: 
      return 1010;
    case 144: 
      return 7400;
    case 149: 
      return 10002;
    case 153: 
      return 10004;
    case 160: 
      return 1036;
    case 156: 
      return 1032;
    case 159: 
      return 1037;
    case 161: 
      return 1038;
    case 163: 
      return 1044;
    case 164: 
      return 10007;
    case 165: 
      return 10008;
    case 166: 
      return 1045;
    case 167: 
      return 10010;
    }
    return 10009;
  }
  
  private static int a(msg_comm.Msg paramMsg, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt1 = a(paramInt1, paramInt2);
    case 0: 
    case 1: 
    case 58: 
      do
      {
        return paramInt1;
        return 1000;
        return 1004;
        paramInt1 = 1024;
      } while ((!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get()))));
      return 1025;
    case 201: 
      return 1005;
    case 129: 
    case 140: 
    case 142: 
      return 1008;
    case 130: 
      return 1006;
    case 131: 
      return 1009;
    case 124: 
      return 1001;
    case 132: 
      return 1020;
    case 121: 
      return 1021;
    }
    return 1022;
  }
  
  private int a(im_msg_body.TmpPtt paramTmpPtt, int paramInt)
  {
    int i = paramInt;
    if (paramTmpPtt.uint32_user_type.has())
    {
      int j = paramTmpPtt.uint32_user_type.get();
      if (j != 1)
      {
        i = paramInt;
        if (j != 2) {}
      }
      else
      {
        i = j;
      }
    }
    return i;
  }
  
  public static TempSessionInfo a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface)
  {
    TempSessionInfo localTempSessionInfo = new TempSessionInfo();
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    a(localC2CTmpMsgHead);
    localTempSessionInfo.jdField_b_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
    int i = localC2CTmpMsgHead.c2c_type.get();
    int j = localC2CTmpMsgHead.service_type.get();
    localTempSessionInfo.jdField_a_of_type_Int = a(paramMsg, -1, j);
    localTempSessionInfo.jdField_a_of_type_Long = -1L;
    localTempSessionInfo.jdField_b_of_type_Long = -1L;
    a(localTempSessionInfo, localC2CTmpMsgHead, j);
    paramQQAppInterface = (TempSessionServiceType)paramQQAppInterface.getMessageFacade().a().a().a(Integer.valueOf(j));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramMsg, localTempSessionInfo);
    }
    a(localTempSessionInfo, i, j);
    return localTempSessionInfo;
  }
  
  private void a(MessageHandler paramMessageHandler, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte)
  {
    switch (paramTempSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramMessageHandler = (TempSessionCache)paramMessageHandler.a.getMessageFacade().a().a().a(Integer.valueOf(paramTempSessionInfo.jdField_a_of_type_Int));
      if (paramMessageHandler != null) {
        paramMessageHandler.a(paramDecodeProtoPkgContext, paramArrayOfByte);
      }
    case 1005: 
    case 1023: 
    case 1024: 
    case 1025: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1001: 
    case 10002: 
    case 10004: 
    case 1021: 
    case 1022: 
    case 1010: 
    case 7400: 
    case 1032: 
    case 1033: 
    case 1034: 
    case 1037: 
    case 1044: 
    case 1045: 
    case 10007: 
      do
      {
        return;
        paramTempSessionInfo = new byte[paramArrayOfByte.length + 2];
        paramTempSessionInfo[0] = paramByte1;
        paramTempSessionInfo[1] = paramByte2;
        PkgTools.copyData(paramTempSessionInfo, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
        paramMessageHandler.a.getMsgCache().a(String.valueOf(paramDecodeProtoPkgContext.e), paramTempSessionInfo);
        return;
        paramTempSessionInfo = new byte[paramArrayOfByte.length + 2];
        paramTempSessionInfo[0] = paramByte1;
        paramTempSessionInfo[1] = paramByte2;
        PkgTools.copyData(paramTempSessionInfo, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
        paramMessageHandler.a.getMsgCache().b(String.valueOf(paramDecodeProtoPkgContext.e), paramTempSessionInfo);
        return;
        paramMessageHandler.a.getMsgCache().c(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler = new byte[paramArrayOfByte.length + 2];
        paramMessageHandler[0] = paramByte1;
        paramMessageHandler[1] = paramByte2;
        PkgTools.copyData(paramMessageHandler, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
        return;
        paramTempSessionInfo = new byte[paramArrayOfByte.length + 2];
        paramTempSessionInfo[0] = paramByte1;
        paramTempSessionInfo[1] = paramByte2;
        PkgTools.copyData(paramTempSessionInfo, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
        paramMessageHandler.a.getMsgCache().e(String.valueOf(paramDecodeProtoPkgContext.e), paramTempSessionInfo);
        return;
        paramMessageHandler.a.getMsgCache().f(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().g(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().h(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().i(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().l(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().n(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().k(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().j(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().a(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().b(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().c(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
        return;
        paramMessageHandler.a.getMsgCache().a(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte, false);
        return;
      } while (!paramDecodeProtoPkgContext.i);
      paramMessageHandler.a.getMsgCache().d(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
      return;
    case 10008: 
      paramMessageHandler.a.getMsgCache().f(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
      return;
    case 10009: 
      paramMessageHandler.a.getMsgCache().e(String.valueOf(paramDecodeProtoPkgContext.e), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
      return;
    }
    paramMessageHandler.a.getMsgCache().o(String.valueOf(paramDecodeProtoPkgContext.e), paramArrayOfByte);
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i;
    if ((((msg_comm.MsgHead)localObject).msg_type.get() == 529) && (((msg_comm.MsgHead)localObject).c2c_cmd.get() == 6))
    {
      i = 1;
      if ((((msg_comm.MsgHead)localObject).c2c_tmp_msg_head.has()) && (paramMsg.msg_body.has()) && ((i != 0) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))) {
        break label94;
      }
    }
    label94:
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead;
    int j;
    int k;
    do
    {
      return;
      i = 0;
      break;
      localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localObject).c2c_tmp_msg_head.get();
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
    } while (a(paramMessageHandler, paramTempSessionInfo, paramDecodeProtoPkgContext, localC2CTmpMsgHead));
    byte[] arrayOfByte = null;
    localObject = arrayOfByte;
    if (!paramDecodeProtoPkgContext.jdField_d_of_type_Boolean)
    {
      localObject = arrayOfByte;
      if (localC2CTmpMsgHead.sig.has())
      {
        arrayOfByte = localC2CTmpMsgHead.sig.get().toByteArray();
        localObject = arrayOfByte;
        if (QLog.isDevelopLevel())
        {
          QLog.d("TempSessionDecoder", 4, "tempHead.sig.get()----> sig:" + HexUtil.bytes2HexStr(arrayOfByte) + ",length:" + arrayOfByte.length);
          localObject = arrayOfByte;
        }
      }
    }
    if (localObject != null) {
      a(paramMessageHandler, paramTempSessionInfo, paramDecodeProtoPkgContext, (byte)j, (byte)k, (byte[])localObject);
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsg.content_head.has())
    {
      bool1 = bool2;
      if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has())
      {
        if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() != 1) {
          break label374;
        }
        bool1 = true;
      }
    }
    if (i == 0) {}
    for (localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();; localObject = null)
    {
      a(paramMessageHandler, paramList, paramMsg, paramTempSessionInfo, paramDecodeProtoPkgContext, bool1, (List)localObject);
      return;
      label374:
      bool1 = false;
      break;
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext, boolean paramBoolean, List<im_msg_body.Elem> paramList1)
  {
    if (paramBoolean) {
      if ((paramList1 != null) && (paramList1.size() > 0)) {}
    }
    while (paramTempSessionInfo == null)
    {
      do
      {
        return;
        paramMessageHandler = (im_msg_body.Text)((im_msg_body.Elem)paramList1.get(0)).text.get();
      } while (paramDecodeProtoPkgContext.jdField_b_of_type_Boolean);
      paramMessageHandler = BaseApplication.getContext().getString(2131690323) + " " + paramMessageHandler.str.get().toStringUtf8();
      paramMsg = MessageRecordFactory.a(-10000);
      paramMsg.msgtype = -10000;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    b(paramMessageHandler, paramList, paramMsg, paramTempSessionInfo, paramDecodeProtoPkgContext);
  }
  
  private static void a(TempSessionInfo paramTempSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
      localStringBuilder.append(" c2cType:").append(paramInt1).append(" serviceType:").append(paramInt2).append("direction_flag:").append(paramTempSessionInfo.jdField_b_of_type_Int).append(" info:").append(paramTempSessionInfo.toString());
      QLog.d("TempSessionDecoder", 2, localStringBuilder.toString());
    }
  }
  
  private static void a(TempSessionInfo paramTempSessionInfo, msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 132: 
      paramTempSessionInfo.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
      paramTempSessionInfo.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_uin.get();
      return;
    }
    paramTempSessionInfo.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
    paramTempSessionInfo.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_code.get();
  }
  
  private static void a(msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead)
  {
    if (!paramC2CTmpMsgHead.c2c_type.has()) {
      if (QLog.isColorLevel()) {
        QLog.e("TempSessionDecoder", 2, "It doesn't has a c2cType.");
      }
    }
    while ((paramC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.e("TempSessionDecoder", 2, "Invalid service type, the pb data has no service type.");
  }
  
  private boolean a(MessageHandler paramMessageHandler, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext, msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead)
  {
    if ((!paramDecodeProtoPkgContext.jdField_d_of_type_Boolean) && (paramTempSessionInfo.jdField_a_of_type_Int == 1006))
    {
      paramTempSessionInfo = paramC2CTmpMsgHead.from_phone.get();
      if ((!paramC2CTmpMsgHead.from_phone.has()) || (paramTempSessionInfo == null) || (paramTempSessionInfo.equals("+0")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + paramC2CTmpMsgHead.from_phone.get());
        }
        return true;
      }
      ContactUtils.a(paramMessageHandler.a, paramC2CTmpMsgHead.from_phone.get(), paramDecodeProtoPkgContext.e + "");
    }
    return false;
  }
  
  private void b(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject1;
    if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
    {
      paramDecodeProtoPkgContext = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject1 = new im_msg_body.TmpPtt();
      try
      {
        paramDecodeProtoPkgContext = (im_msg_body.TmpPtt)((im_msg_body.TmpPtt)localObject1).mergeFrom(paramDecodeProtoPkgContext);
        RichMsg.PttRec localPttRec;
        int n;
        int k;
        int i;
        int m;
        int j;
        if ((paramDecodeProtoPkgContext != null) && (paramDecodeProtoPkgContext.uint32_file_type.has()) && (paramDecodeProtoPkgContext.uint32_file_type.get() == 4) && (paramDecodeProtoPkgContext.bytes_file_uuid.has()))
        {
          localObject1 = paramDecodeProtoPkgContext.bytes_file_uuid.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + (String)localObject1);
          }
          localPttRec = new RichMsg.PttRec();
          localPttRec.localPath.set(paramDecodeProtoPkgContext.bytes_file_uuid.get().toStringUtf8());
          localPttRec.size.set(paramDecodeProtoPkgContext.uint32_file_size.get());
          localPttRec.type.set(2);
          localPttRec.uuid.set((String)localObject1);
          localPttRec.isRead.set(false);
          localPttRec.serverStorageSource.set("pttcenter");
          localPttRec.isReport.set(0);
          localPttRec.version.set(5);
          localPttRec.pttFlag.set(0);
          n = a(paramDecodeProtoPkgContext, 0);
          k = 0;
          i = 0;
          m = 0;
          j = 0;
          str = "";
          localObject1 = str;
          if (paramDecodeProtoPkgContext.bytes_pb_reserve.has())
          {
            localObject1 = new ptt_reserve.ReserveStruct();
            j = m;
            i = k;
          }
        }
        try
        {
          ((ptt_reserve.ReserveStruct)localObject1).mergeFrom(paramDecodeProtoPkgContext.bytes_pb_reserve.get().toByteArray());
          j = m;
          i = k;
          k = ((ptt_reserve.ReserveStruct)localObject1).uint32_change_voice.get();
          j = m;
          i = k;
          m = ((ptt_reserve.ReserveStruct)localObject1).uint32_autototext_voice.get();
          j = m;
          i = k;
          localObject1 = ((ptt_reserve.ReserveStruct)localObject1).bytes_voice_text_abs.get().toStringUtf8();
          i = k;
          j = m;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l1;
            long l2;
            Object localObject2 = str;
          }
        }
        localPttRec.longPttVipFlag.set(n);
        l1 = System.currentTimeMillis() / 1000L;
        l2 = paramMsg.msg_head.msg_time.get();
        localPttRec.msgRecTime.set(l1);
        localPttRec.msgTime.set(l2);
        localPttRec.voiceChangeFlag.set(i);
        localPttRec.busiType.set(paramDecodeProtoPkgContext.uint32_busi_type.get());
        localPttRec.autototext_voice.set(j);
        localPttRec.sttText.set((String)localObject1);
        localObject1 = MessageRecordFactory.a(-2002);
        ((MessageRecord)localObject1).msgtype = -2002;
        ((MessageRecord)localObject1).msgData = localPttRec.toByteArray();
        ((MessageForPtt)localObject1).parse();
        if ((paramDecodeProtoPkgContext.uint64_msg_id.has()) && (paramDecodeProtoPkgContext.uint64_msg_id.get() != 0L)) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("pa_msgId", paramDecodeProtoPkgContext.uint64_msg_id.get() + "");
        }
        ConfessMsgUtil.a(paramMsg, (MessageRecord)localObject1, paramMessageHandler.a);
        QidianUtils.a(paramTempSessionInfo, paramMsg, (MessageRecord)localObject1);
        paramList.add(localObject1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramDecodeProtoPkgContext)
      {
        for (;;)
        {
          paramDecodeProtoPkgContext.printStackTrace();
          paramDecodeProtoPkgContext = null;
        }
      }
    }
    else
    {
      localObject1 = new MessageInfo();
      ((MessageInfo)localObject1).a = String.valueOf(paramDecodeProtoPkgContext.e);
      MessageProtoCodec.a(paramMessageHandler, paramList, paramMsg, true, paramDecodeProtoPkgContext.jdField_b_of_type_Boolean, (MessageInfo)localObject1, paramTempSessionInfo, paramDecodeProtoPkgContext);
      return;
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    int j = 1;
    TempSessionInfo localTempSessionInfo = a(paramMsg, paramMessageHandler.a);
    if (localTempSessionInfo.jdField_a_of_type_Int == -1)
    {
      i = 0;
      if (i != 0)
      {
        paramDecodeProtoPkgContext.jdField_d_of_type_Int = localTempSessionInfo.jdField_b_of_type_Int;
        a(paramMessageHandler, paramList, paramMsg, localTempSessionInfo, paramDecodeProtoPkgContext);
        paramDecodeProtoPkgContext.c = localTempSessionInfo.jdField_a_of_type_Int;
      }
      if ((paramList.size() > 0) && (ConfessMsgUtil.a((MessageRecord)paramList.get(0)))) {
        if (!((MessageRecord)paramList.get(0)).isSelfConfessor()) {
          break label230;
        }
      }
    }
    label230:
    for (int i = 1033;; i = 1034)
    {
      localTempSessionInfo.jdField_a_of_type_Int = i;
      paramDecodeProtoPkgContext.c = localTempSessionInfo.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("TempSessionDecoder", 2, "friendType:" + paramDecodeProtoPkgContext.c + ", direction_flag:" + paramDecodeProtoPkgContext.jdField_d_of_type_Int);
      }
      return;
      if ((localTempSessionInfo.jdField_a_of_type_Int != 1000) && (localTempSessionInfo.jdField_a_of_type_Int != 1020))
      {
        i = j;
        if (localTempSessionInfo.jdField_a_of_type_Int != 1004) {
          break;
        }
      }
      paramDecodeProtoPkgContext.jdField_b_of_type_Long = localTempSessionInfo.jdField_b_of_type_Long;
      i = j;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.TempSessionDecoder
 * JD-Core Version:    0.7.0.1
 */