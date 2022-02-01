package dov.com.qq.im.editipc;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

class PeakIpcModuleServer$3
  implements Runnable
{
  PeakIpcModuleServer$3(PeakIpcModuleServer paramPeakIpcModuleServer, QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.3
 * JD-Core Version:    0.7.0.1
 */