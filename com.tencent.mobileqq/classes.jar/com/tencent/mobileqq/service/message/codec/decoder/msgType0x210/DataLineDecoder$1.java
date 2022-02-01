package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import ansr;
import bctf;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import msf.msgcomm.msg_comm.Msg;

public class DataLineDecoder$1
  implements Runnable
{
  public DataLineDecoder$1(bctf parambctf, MessageHandler paramMessageHandler, msg_comm.Msg paramMsg) {}
  
  public void run()
  {
    ((ansr)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.DataLineDecoder.1
 * JD-Core Version:    0.7.0.1
 */