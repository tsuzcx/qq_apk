package com.tencent.mobileqq.imaxad;

import asya;
import asyc;
import azqs;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import nlo;
import nlq;
import nmh;

public class ImaxAdRecentUserManager$2
  implements Runnable
{
  public ImaxAdRecentUserManager$2(asyc paramasyc, QQAppInterface paramQQAppInterface, String paramString, int paramInt, nlo paramnlo) {}
  
  public void run()
  {
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if (localMessage != null)
    {
      if ("false".equals(localMessage.getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        localMessage.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessage.frienduin, localMessage.msgtype, localMessage.uniseq, "extStr", localMessage.extStr);
        if (this.jdField_a_of_type_Nlo.a != null) {
          azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Nlo.a.jdField_a_of_type_JavaLangString, "0X8008F5E", "0X8008F5E", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", nmh.a(), this.jdField_a_of_type_Nlo.a.b);
        }
      }
      if (this.jdField_a_of_type_Nlo.a != null)
      {
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Nlo.a.jdField_a_of_type_JavaLangString, "0X8008F60", "0X8008F60", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", "", this.jdField_a_of_type_Nlo.a.b);
        if (this.jdField_a_of_type_Nlo.a.l == 2) {
          asya.a().b(this.jdField_a_of_type_Nlo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2
 * JD-Core Version:    0.7.0.1
 */