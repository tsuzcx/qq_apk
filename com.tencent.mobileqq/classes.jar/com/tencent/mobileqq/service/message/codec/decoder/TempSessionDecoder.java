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
    if (paramInt2 != 133)
    {
      if (paramInt2 != 137)
      {
        if (paramInt2 != 144)
        {
          if (paramInt2 != 149)
          {
            if (paramInt2 != 153)
            {
              if (paramInt2 != 156)
              {
                if (paramInt2 != 160)
                {
                  if (paramInt2 != 161)
                  {
                    switch (paramInt2)
                    {
                    default: 
                      return paramInt1;
                    case 168: 
                      return 10009;
                    case 167: 
                      return 10010;
                    case 166: 
                      return 1045;
                    case 165: 
                      return 10008;
                    case 164: 
                      return 10007;
                    }
                    return 1044;
                  }
                  return 1038;
                }
                return 1036;
              }
              return 1032;
            }
            return 10004;
          }
          return 10002;
        }
        return 7400;
      }
      return 1010;
    }
    return 1023;
  }
  
  private static int a(msg_comm.Msg paramMsg, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 58)
        {
          if (paramInt2 != 121)
          {
            if (paramInt2 != 124)
            {
              if (paramInt2 != 134)
              {
                if ((paramInt2 != 140) && (paramInt2 != 142))
                {
                  if (paramInt2 != 201) {}
                  switch (paramInt2)
                  {
                  default: 
                    return a(paramInt1, paramInt2);
                  case 132: 
                    return 1020;
                  case 131: 
                    return 1009;
                  case 130: 
                    return 1006;
                    return 1005;
                  }
                }
                return 1008;
              }
              return 1022;
            }
            return 1001;
          }
          return 1021;
        }
        if ((!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get())))) {
          return 1024;
        }
        return 1025;
      }
      return 1004;
    }
    return 1000;
  }
  
  private int a(im_msg_body.TmpPtt paramTmpPtt, int paramInt)
  {
    if (paramTmpPtt.uint32_user_type.has())
    {
      int j = paramTmpPtt.uint32_user_type.get();
      i = j;
      if (j == 1) {
        return i;
      }
      if (j == 2) {
        return j;
      }
    }
    int i = paramInt;
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
    int i = paramTempSessionInfo.jdField_a_of_type_Int;
    if (i != 1001)
    {
      if (i != 7400)
      {
        if (i != 10002)
        {
          if (i != 10004)
          {
            if (i != 1005)
            {
              if (i != 1006)
              {
                if (i != 1044)
                {
                  if (i != 1045) {
                    switch (i)
                    {
                    default: 
                      switch (i)
                      {
                      default: 
                        switch (i)
                        {
                        default: 
                          switch (i)
                          {
                          default: 
                            paramMessageHandler = (TempSessionCache)paramMessageHandler.a.getMessageFacade().a().a().a(Integer.valueOf(paramTempSessionInfo.jdField_a_of_type_Int));
                            if (paramMessageHandler == null) {
                              break;
                            }
                            paramMessageHandler.a(paramDecodeProtoPkgContext, paramArrayOfByte);
                            return;
                          case 10010: 
                            paramMessageHandler.a.getMsgCache().o(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
                            return;
                          case 10009: 
                            paramMessageHandler.a.getMsgCache().d(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
                            return;
                          case 10008: 
                            paramMessageHandler.a.getMsgCache().e(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
                            return;
                          case 10007: 
                            if (!paramDecodeProtoPkgContext.i) {
                              break;
                            }
                            paramMessageHandler.a.getMsgCache().c(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
                            return;
                          }
                          break;
                        case 1032: 
                        case 1033: 
                        case 1034: 
                          paramMessageHandler.a.getMsgCache().a(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
                          return;
                        }
                        break;
                      case 1024: 
                      case 1025: 
                        paramMessageHandler.a.getMsgCache().c(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
                        return;
                      case 1023: 
                        paramTempSessionInfo = new byte[paramArrayOfByte.length + 2];
                        paramTempSessionInfo[0] = paramByte1;
                        paramTempSessionInfo[1] = paramByte2;
                        PkgTools.copyData(paramTempSessionInfo, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
                        paramMessageHandler.a.getMsgCache().b(String.valueOf(paramDecodeProtoPkgContext.g), paramTempSessionInfo);
                        return;
                      case 1022: 
                        paramMessageHandler.a.getMsgCache().n(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
                        return;
                      case 1021: 
                        paramMessageHandler.a.getMsgCache().l(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
                        return;
                      }
                      break;
                    case 1010: 
                      paramMessageHandler.a.getMsgCache().k(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
                      return;
                    case 1009: 
                      paramMessageHandler.a.getMsgCache().f(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
                      return;
                    case 1008: 
                      paramTempSessionInfo = new byte[paramArrayOfByte.length + 2];
                      paramTempSessionInfo[0] = paramByte1;
                      paramTempSessionInfo[1] = paramByte2;
                      PkgTools.copyData(paramTempSessionInfo, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
                      paramMessageHandler.a.getMsgCache().e(String.valueOf(paramDecodeProtoPkgContext.g), paramTempSessionInfo);
                      return;
                    }
                  } else {
                    paramMessageHandler.a.getMsgCache().a(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte, false);
                  }
                }
                else {
                  paramMessageHandler.a.getMsgCache().b(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long), paramArrayOfByte);
                }
              }
              else
              {
                paramMessageHandler = new byte[paramArrayOfByte.length + 2];
                paramMessageHandler[0] = paramByte1;
                paramMessageHandler[1] = paramByte2;
                PkgTools.copyData(paramMessageHandler, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
              }
            }
            else
            {
              paramTempSessionInfo = new byte[paramArrayOfByte.length + 2];
              paramTempSessionInfo[0] = paramByte1;
              paramTempSessionInfo[1] = paramByte2;
              PkgTools.copyData(paramTempSessionInfo, 2, paramArrayOfByte, 0, paramArrayOfByte.length);
              paramMessageHandler.a.getMsgCache().a(String.valueOf(paramDecodeProtoPkgContext.g), paramTempSessionInfo);
            }
          }
          else {
            paramMessageHandler.a.getMsgCache().i(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
          }
        }
        else {
          paramMessageHandler.a.getMsgCache().h(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
        }
      }
      else {
        paramMessageHandler.a.getMsgCache().j(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
      }
    }
    else {
      paramMessageHandler.a.getMsgCache().g(String.valueOf(paramDecodeProtoPkgContext.g), paramArrayOfByte);
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i = ((msg_comm.MsgHead)localObject).msg_type.get();
    boolean bool = false;
    if ((i == 529) && (((msg_comm.MsgHead)localObject).c2c_cmd.get() == 6)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((((msg_comm.MsgHead)localObject).c2c_tmp_msg_head.has()) && (paramMsg.msg_body.has()) && ((i != 0) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())))
    {
      localObject = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localObject).c2c_tmp_msg_head.get();
      int j = ((msg_comm.C2CTmpMsgHead)localObject).c2c_type.get();
      int k = ((msg_comm.C2CTmpMsgHead)localObject).service_type.get();
      if (a(paramMessageHandler, paramTempSessionInfo, paramDecodeProtoPkgContext, (msg_comm.C2CTmpMsgHead)localObject)) {
        return;
      }
      if ((!paramDecodeProtoPkgContext.jdField_d_of_type_Boolean) && (((msg_comm.C2CTmpMsgHead)localObject).sig.has()))
      {
        localObject = ((msg_comm.C2CTmpMsgHead)localObject).sig.get().toByteArray();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tempHead.sig.get()----> sig:");
          localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject));
          localStringBuilder.append(",length:");
          localStringBuilder.append(localObject.length);
          QLog.d("TempSessionDecoder", 4, localStringBuilder.toString());
        }
      }
      else
      {
        localObject = null;
      }
      if (localObject != null) {
        a(paramMessageHandler, paramTempSessionInfo, paramDecodeProtoPkgContext, (byte)j, (byte)k, (byte[])localObject);
      }
      if ((paramMsg.content_head.has()) && (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has()))
      {
        if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() == 1) {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      if (i == 0) {
        localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      } else {
        localObject = null;
      }
      a(paramMessageHandler, paramList, paramMsg, paramTempSessionInfo, paramDecodeProtoPkgContext, bool, (List)localObject);
      return;
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext, boolean paramBoolean, List<im_msg_body.Elem> paramList1)
  {
    if (paramBoolean)
    {
      if (paramList1 != null)
      {
        if (paramList1.size() <= 0) {
          return;
        }
        paramMessageHandler = (im_msg_body.Text)((im_msg_body.Elem)paramList1.get(0)).text.get();
        if (paramDecodeProtoPkgContext.jdField_b_of_type_Boolean) {
          return;
        }
        paramMsg = new StringBuilder();
        paramMsg.append(BaseApplication.getContext().getString(2131690244));
        paramMsg.append(" ");
        paramMsg.append(paramMessageHandler.str.get().toStringUtf8());
        paramMessageHandler = paramMsg.toString();
        paramMsg = MessageRecordFactory.a(-10000);
        paramMsg.msgtype = -10000;
        paramMsg.msg = paramMessageHandler;
        paramList.add(paramMsg);
      }
    }
    else if (paramTempSessionInfo != null) {
      b(paramMessageHandler, paramList, paramMsg, paramTempSessionInfo, paramDecodeProtoPkgContext);
    }
  }
  
  private static void a(TempSessionInfo paramTempSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
      localStringBuilder.append(" c2cType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" serviceType:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("direction_flag:");
      localStringBuilder.append(paramTempSessionInfo.jdField_b_of_type_Int);
      localStringBuilder.append(" info:");
      localStringBuilder.append(paramTempSessionInfo.toString());
      QLog.d("TempSessionDecoder", 2, localStringBuilder.toString());
    }
  }
  
  private static void a(TempSessionInfo paramTempSessionInfo, msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead, int paramInt)
  {
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 132) {}
      }
      else
      {
        paramTempSessionInfo.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
        paramTempSessionInfo.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_code.get();
        return;
      }
    }
    paramTempSessionInfo.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
    paramTempSessionInfo.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_uin.get();
  }
  
  private static void a(msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead)
  {
    if (!paramC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("TempSessionDecoder", 2, "It doesn't has a c2cType.");
      }
    }
    else if ((!paramC2CTmpMsgHead.service_type.has()) && (QLog.isColorLevel())) {
      QLog.e("TempSessionDecoder", 2, "Invalid service type, the pb data has no service type.");
    }
  }
  
  private boolean a(MessageHandler paramMessageHandler, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext, msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead)
  {
    if ((!paramDecodeProtoPkgContext.jdField_d_of_type_Boolean) && (paramTempSessionInfo.jdField_a_of_type_Int == 1006))
    {
      paramTempSessionInfo = paramC2CTmpMsgHead.from_phone.get();
      if ((paramC2CTmpMsgHead.from_phone.has()) && (paramTempSessionInfo != null) && (!paramTempSessionInfo.equals("+0")))
      {
        paramMessageHandler = paramMessageHandler.a;
        paramTempSessionInfo = paramC2CTmpMsgHead.from_phone.get();
        paramC2CTmpMsgHead = new StringBuilder();
        paramC2CTmpMsgHead.append(paramDecodeProtoPkgContext.g);
        paramC2CTmpMsgHead.append("");
        ContactUtils.a(paramMessageHandler, paramTempSessionInfo, paramC2CTmpMsgHead.toString());
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramMessageHandler = new StringBuilder();
          paramMessageHandler.append("<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : ");
          paramMessageHandler.append(paramC2CTmpMsgHead.from_phone.get());
          QLog.d("TempSessionDecoder", 2, paramMessageHandler.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  private void b(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject2;
    int m;
    if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
    {
      paramDecodeProtoPkgContext = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject1 = new im_msg_body.TmpPtt();
      try
      {
        localObject1 = (im_msg_body.TmpPtt)((im_msg_body.TmpPtt)localObject1).mergeFrom(paramDecodeProtoPkgContext);
      }
      catch (InvalidProtocolBufferMicroException paramDecodeProtoPkgContext)
      {
        paramDecodeProtoPkgContext.printStackTrace();
        localObject1 = null;
      }
      if ((localObject1 != null) && (((im_msg_body.TmpPtt)localObject1).uint32_file_type.has()) && (((im_msg_body.TmpPtt)localObject1).uint32_file_type.get() == 4) && (((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.has()))
      {
        paramDecodeProtoPkgContext = ((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.get().toStringUtf8();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<---decodeC2CMsgPkg_Temp2 : ptt uuid:");
          ((StringBuilder)localObject2).append(paramDecodeProtoPkgContext);
          QLog.d("TempSessionDecoder", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new RichMsg.PttRec();
        ((RichMsg.PttRec)localObject2).localPath.set(((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.get().toStringUtf8());
        ((RichMsg.PttRec)localObject2).size.set(((im_msg_body.TmpPtt)localObject1).uint32_file_size.get());
        ((RichMsg.PttRec)localObject2).type.set(2);
        ((RichMsg.PttRec)localObject2).uuid.set(paramDecodeProtoPkgContext);
        paramDecodeProtoPkgContext = ((RichMsg.PttRec)localObject2).isRead;
        j = 0;
        k = 0;
        paramDecodeProtoPkgContext.set(false);
        ((RichMsg.PttRec)localObject2).serverStorageSource.set("pttcenter");
        ((RichMsg.PttRec)localObject2).isReport.set(0);
        ((RichMsg.PttRec)localObject2).version.set(5);
        ((RichMsg.PttRec)localObject2).pttFlag.set(0);
        m = a((im_msg_body.TmpPtt)localObject1, 0);
        if (((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.has()) {
          paramDecodeProtoPkgContext = new ptt_reserve.ReserveStruct();
        }
      }
    }
    try
    {
      paramDecodeProtoPkgContext.mergeFrom(((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.get().toByteArray());
      i = paramDecodeProtoPkgContext.uint32_change_voice.get();
    }
    catch (Exception paramDecodeProtoPkgContext)
    {
      for (;;)
      {
        int i;
        label405:
        long l1;
        long l2;
        j = k;
      }
    }
    try
    {
      k = paramDecodeProtoPkgContext.uint32_autototext_voice.get();
    }
    catch (Exception paramDecodeProtoPkgContext)
    {
      break label416;
    }
    try
    {
      paramDecodeProtoPkgContext = paramDecodeProtoPkgContext.bytes_voice_text_abs.get().toStringUtf8();
      j = i;
      i = k;
    }
    catch (Exception paramDecodeProtoPkgContext)
    {
      break label405;
    }
    j = i;
    i = k;
    break label423;
    label416:
    j = i;
    i = 0;
    label423:
    paramDecodeProtoPkgContext = "";
    break label439;
    paramDecodeProtoPkgContext = "";
    i = 0;
    label439:
    ((RichMsg.PttRec)localObject2).longPttVipFlag.set(m);
    l1 = System.currentTimeMillis() / 1000L;
    l2 = paramMsg.msg_head.msg_time.get();
    ((RichMsg.PttRec)localObject2).msgRecTime.set(l1);
    ((RichMsg.PttRec)localObject2).msgTime.set(l2);
    ((RichMsg.PttRec)localObject2).voiceChangeFlag.set(j);
    ((RichMsg.PttRec)localObject2).busiType.set(((im_msg_body.TmpPtt)localObject1).uint32_busi_type.get());
    ((RichMsg.PttRec)localObject2).autototext_voice.set(i);
    ((RichMsg.PttRec)localObject2).sttText.set(paramDecodeProtoPkgContext);
    paramDecodeProtoPkgContext = MessageRecordFactory.a(-2002);
    paramDecodeProtoPkgContext.msgtype = -2002;
    paramDecodeProtoPkgContext.msgData = ((RichMsg.PttRec)localObject2).toByteArray();
    ((MessageForPtt)paramDecodeProtoPkgContext).parse();
    if ((((im_msg_body.TmpPtt)localObject1).uint64_msg_id.has()) && (((im_msg_body.TmpPtt)localObject1).uint64_msg_id.get() != 0L))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((im_msg_body.TmpPtt)localObject1).uint64_msg_id.get());
      ((StringBuilder)localObject2).append("");
      paramDecodeProtoPkgContext.saveExtInfoToExtStr("pa_msgId", ((StringBuilder)localObject2).toString());
    }
    ConfessMsgUtil.a(paramMsg, paramDecodeProtoPkgContext, paramMessageHandler.a);
    QidianUtils.a(paramTempSessionInfo, paramMsg, paramDecodeProtoPkgContext);
    paramList.add(paramDecodeProtoPkgContext);
    return;
    return;
    Object localObject1 = new MessageInfo();
    ((MessageInfo)localObject1).a = String.valueOf(paramDecodeProtoPkgContext.g);
    MessageProtoCodec.a(paramMessageHandler, paramList, paramMsg, true, paramDecodeProtoPkgContext.jdField_b_of_type_Boolean, (MessageInfo)localObject1, paramTempSessionInfo, paramDecodeProtoPkgContext);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    TempSessionInfo localTempSessionInfo = a(paramMsg, paramMessageHandler.a);
    int i;
    if (localTempSessionInfo.jdField_a_of_type_Int == -1)
    {
      i = 0;
    }
    else
    {
      if ((localTempSessionInfo.jdField_a_of_type_Int == 1000) || (localTempSessionInfo.jdField_a_of_type_Int == 1020) || (localTempSessionInfo.jdField_a_of_type_Int == 1004)) {
        paramDecodeProtoPkgContext.jdField_b_of_type_Long = localTempSessionInfo.jdField_b_of_type_Long;
      }
      i = 1;
    }
    if (i != 0)
    {
      paramDecodeProtoPkgContext.jdField_d_of_type_Int = localTempSessionInfo.jdField_b_of_type_Int;
      a(paramMessageHandler, paramList, paramMsg, localTempSessionInfo, paramDecodeProtoPkgContext);
      paramDecodeProtoPkgContext.c = localTempSessionInfo.jdField_a_of_type_Int;
    }
    if ((paramList.size() > 0) && (ConfessMsgUtil.a((MessageRecord)paramList.get(0))))
    {
      if (((MessageRecord)paramList.get(0)).isSelfConfessor()) {
        i = 1033;
      } else {
        i = 1034;
      }
      localTempSessionInfo.jdField_a_of_type_Int = i;
      paramDecodeProtoPkgContext.c = localTempSessionInfo.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("friendType:");
      paramMessageHandler.append(paramDecodeProtoPkgContext.c);
      paramMessageHandler.append(", direction_flag:");
      paramMessageHandler.append(paramDecodeProtoPkgContext.jdField_d_of_type_Int);
      QLog.d("TempSessionDecoder", 2, paramMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.TempSessionDecoder
 * JD-Core Version:    0.7.0.1
 */