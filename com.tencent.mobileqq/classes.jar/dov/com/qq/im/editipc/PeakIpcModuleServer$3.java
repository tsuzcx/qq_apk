package dov.com.qq.im.editipc;

import boqm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

public class PeakIpcModuleServer$3
  implements Runnable
{
  public PeakIpcModuleServer$3(boqm paramboqm, QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.3
 * JD-Core Version:    0.7.0.1
 */