package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.SubTypeDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

public class GameMsgOfflineDecoder
  implements SubTypeDecoder
{
  public static final String a = GameCenterUnissoHandler.a + "GameMsgOfflineDecoder";
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    QLog.d(a, 1, "GameMsg, OFFLINE SubType0x11c receive");
    paramList = new MsgBody();
    try
    {
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      paramList.uint32_cmd.get();
      paramList.uint32_timestamp.get();
      paramMsgType0x210 = new JSONObject(paramList.bytes_data.get().toStringUtf8());
      GameMsgGrayTipsHandler.a(paramMessageHandler.a, paramMsgType0x210);
      MessageProtoCodec.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      for (;;)
      {
        paramMsgType0x210.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgOfflineDecoder
 * JD-Core Version:    0.7.0.1
 */