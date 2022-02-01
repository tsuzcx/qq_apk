package com.tencent.mobileqq.troop.utils;

import aoep;
import bgif;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public final class TroopAioNotifyManager$1
  implements Runnable
{
  public TroopAioNotifyManager$1(QQAppInterface paramQQAppInterface, String paramString, aoep paramaoep) {}
  
  public void run()
  {
    List localList = bgif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    localList = bgif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ArrayList(), localList);
    this.jdField_a_of_type_Aoep.notifyUI(95, true, new Object[] { this.jdField_a_of_type_JavaLangString, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */