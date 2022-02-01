package dov.com.qq.im.editipc;

import boqm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class PeakIpcModuleServer$2
  implements Runnable
{
  public PeakIpcModuleServer$2(boqm paramboqm, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.2
 * JD-Core Version:    0.7.0.1
 */