package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.stt.ISttManagerService;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;

public class SttResultDecoder
  implements SubTypeDecoder
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    ((ISttManagerService)paramMessageHandler.n.getRuntimeService(ISttManagerService.class)).onSttResultPush(paramMsgType0x210.msg_content.get().toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.SttResultDecoder
 * JD-Core Version:    0.7.0.1
 */