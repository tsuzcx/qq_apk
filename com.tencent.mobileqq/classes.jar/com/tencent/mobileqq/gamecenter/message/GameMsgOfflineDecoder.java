package com.tencent.mobileqq.gamecenter.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.SubTypeDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

public class GameMsgOfflineDecoder
  implements SubTypeDecoder
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    QLog.i("GameMsgOfflineDecoder", 1, "GameMsg, OFFLINE SubType0x11c receive");
    paramList = new MsgBody();
    try
    {
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      int i = paramList.uint32_cmd.get();
      paramList.uint32_timestamp.get();
      paramMsgType0x210 = new JSONObject(paramList.bytes_data.get().toStringUtf8());
      long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      paramList = new StringBuilder();
      paramList.append("cmd:");
      paramList.append(i);
      QLog.i("GameMsgOfflineDecoder", 1, paramList.toString());
      if (i == 5)
      {
        GameMsgGrayTipsHandler.a(paramMessageHandler.n, paramMsgType0x210, l);
      }
      else if (i == 8)
      {
        paramList = paramMsgType0x210.optString("gameId");
        i = paramMsgType0x210.optInt("switchType");
        int j = paramMsgType0x210.optInt("value");
        ((IGameMsgManagerService)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IGameMsgManagerService.class, "all")).onGameSwitchChange(paramList, i, j);
      }
    }
    catch (Throwable paramMsgType0x210)
    {
      paramMsgType0x210.printStackTrace();
    }
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgOfflineDecoder
 * JD-Core Version:    0.7.0.1
 */