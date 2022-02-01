package com.tencent.mobileqq.troop.utils;

import aoip;
import bgql;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public final class TroopAioNotifyManager$1
  implements Runnable
{
  public TroopAioNotifyManager$1(QQAppInterface paramQQAppInterface, String paramString, aoip paramaoip) {}
  
  public void run()
  {
    List localList = bgql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    localList = bgql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ArrayList(), localList);
    this.jdField_a_of_type_Aoip.notifyUI(95, true, new Object[] { this.jdField_a_of_type_JavaLangString, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */