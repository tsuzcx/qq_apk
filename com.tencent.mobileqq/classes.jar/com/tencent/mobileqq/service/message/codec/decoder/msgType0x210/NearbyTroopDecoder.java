package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;

public class NearbyTroopDecoder
  implements SubTypeDecoder
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
    }
    paramList = new submsgtype0x67.MsgBody();
    try
    {
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel())
      {
        paramDecodeProtoPkgContext = new StringBuilder();
        paramDecodeProtoPkgContext.append("receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: ");
        paramDecodeProtoPkgContext.append(paramMsgType0x210.toString());
        QLog.d("nearbyTroopPush", 2, paramDecodeProtoPkgContext.toString());
      }
    }
    if (paramList.rpt_msg_grpinfo.has())
    {
      paramMsgType0x210 = paramList.rpt_msg_grpinfo.get();
      paramList = (LBSHandler)paramMessageHandler.n.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
      if (paramList != null) {
        paramList.a(paramMsgType0x210);
      }
    }
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.NearbyTroopDecoder
 * JD-Core Version:    0.7.0.1
 */