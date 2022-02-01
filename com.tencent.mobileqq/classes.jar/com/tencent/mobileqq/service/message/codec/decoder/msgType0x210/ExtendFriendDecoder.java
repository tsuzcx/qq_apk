package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class ExtendFriendDecoder
  implements SubTypeDecoder
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendDecoder", 2, "extendfriend limitchat offLinePush receive submsgtype0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message");
    }
    int i = paramMsgType0x210.sub_msg_type.get();
    paramList = (IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class);
    long l = i;
    paramList.notifyPushEvent(l, paramMsgType0x210.msg_content.get().toByteArray());
    try
    {
      paramList = new submsgtype0x128.MsgBody();
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      ((IExpandHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramList, l);
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("SubMsgType0x27.ChatMatchInfo subType ");
      paramMsgType0x210.append(i);
      QLog.d("ExtendFriendDecoderExtendFriendLimitChat", 2, paramMsgType0x210.toString());
      MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.a());
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("troopFormLog offLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->");
      paramMsg.append(paramMsgType0x210.getMessage());
      paramMsg.append(" msgType");
      paramMsg.append(i);
      QLog.e("ExtendFriendDecoder", 1, paramMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.ExtendFriendDecoder
 * JD-Core Version:    0.7.0.1
 */