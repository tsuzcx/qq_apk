package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import java.util.ArrayList;
import java.util.List;

final class TroopAioNotifyManager$1
  implements Runnable
{
  TroopAioNotifyManager$1(QQAppInterface paramQQAppInterface, String paramString, TroopHandler paramTroopHandler) {}
  
  public void run()
  {
    List localList = TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    localList = TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ArrayList(), localList);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.notifyUI(TroopNotificationConstants.aR, true, new Object[] { this.jdField_a_of_type_JavaLangString, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */