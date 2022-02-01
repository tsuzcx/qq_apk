package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;

public class TroopNewsDecoder
  implements SubTypeDecoder
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopgetnews..troop.notification_center", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
    }
    ((ITroopOnlinePushHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER)).a(paramMsgType0x210.msg_content.get().toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TroopNewsDecoder
 * JD-Core Version:    0.7.0.1
 */