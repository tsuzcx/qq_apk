package com.tencent.mobileqq.gamecenter.share;

import avej;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class GameShareNetHelper$2$1
  implements Runnable
{
  public GameShareNetHelper$2$1(avej paramavej, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(this.jdField_a_of_type_Avej.a.frienduin, this.jdField_a_of_type_Avej.a.istroop, this.jdField_a_of_type_Avej.a.uniseq, "extStr", this.jdField_a_of_type_Avej.a.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2.1
 * JD-Core Version:    0.7.0.1
 */