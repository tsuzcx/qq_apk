package com.tencent.mobileqq.imaxad;

import avqq;
import avqs;
import bdla;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import oeq;
import oes;
import ofj;

public class ImaxAdRecentUserManager$2
  implements Runnable
{
  public ImaxAdRecentUserManager$2(avqs paramavqs, QQAppInterface paramQQAppInterface, String paramString, int paramInt, oeq paramoeq) {}
  
  public void run()
  {
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.getLastMessage(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if (localMessage != null)
    {
      if ("false".equals(localMessage.getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        localMessage.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(localMessage.frienduin, localMessage.msgtype, localMessage.uniseq, "extStr", localMessage.extStr);
        if (this.jdField_a_of_type_Oeq.a != null) {
          bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Oeq.a.jdField_a_of_type_JavaLangString, "0X8008F5E", "0X8008F5E", 0, 0, this.jdField_a_of_type_Oeq.a.c, "", ofj.a(), this.jdField_a_of_type_Oeq.a.b);
        }
      }
      if (this.jdField_a_of_type_Oeq.a != null)
      {
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Oeq.a.jdField_a_of_type_JavaLangString, "0X8008F60", "0X8008F60", 0, 0, this.jdField_a_of_type_Oeq.a.c, "", "", this.jdField_a_of_type_Oeq.a.b);
        if (this.jdField_a_of_type_Oeq.a.l == 2) {
          avqq.a().b(this.jdField_a_of_type_Oeq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2
 * JD-Core Version:    0.7.0.1
 */