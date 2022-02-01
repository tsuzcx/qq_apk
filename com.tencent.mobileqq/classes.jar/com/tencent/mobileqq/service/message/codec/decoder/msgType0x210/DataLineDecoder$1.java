package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import msf.msgcomm.msg_comm.Msg;

class DataLineDecoder$1
  implements Runnable
{
  DataLineDecoder$1(DataLineDecoder paramDataLineDecoder, MessageHandler paramMessageHandler, msg_comm.Msg paramMsg) {}
  
  public void run()
  {
    ((DataLineHandler)this.a.n.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.DataLineDecoder.1
 * JD-Core Version:    0.7.0.1
 */