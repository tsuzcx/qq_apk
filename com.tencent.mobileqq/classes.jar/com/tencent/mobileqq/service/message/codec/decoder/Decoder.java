package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public abstract interface Decoder<MsgHandlerT>
{
  public abstract void a(MsgHandlerT paramMsgHandlerT, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.Decoder
 * JD-Core Version:    0.7.0.1
 */