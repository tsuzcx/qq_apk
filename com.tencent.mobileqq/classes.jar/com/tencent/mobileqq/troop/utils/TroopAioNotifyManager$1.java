package com.tencent.mobileqq.troop.utils;

import alzf;
import bchk;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public final class TroopAioNotifyManager$1
  implements Runnable
{
  public TroopAioNotifyManager$1(QQAppInterface paramQQAppInterface, String paramString, alzf paramalzf) {}
  
  public void run()
  {
    List localList = bchk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    localList = bchk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ArrayList(), localList);
    this.jdField_a_of_type_Alzf.notifyUI(95, true, new Object[] { this.jdField_a_of_type_JavaLangString, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */