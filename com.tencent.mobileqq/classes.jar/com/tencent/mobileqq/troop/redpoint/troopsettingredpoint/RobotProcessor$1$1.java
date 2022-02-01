package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qphone.base.util.QLog;

class RobotProcessor$1$1
  implements Runnable
{
  RobotProcessor$1$1(RobotProcessor.1 param1) {}
  
  public void run()
  {
    int k = 0;
    int i;
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      i = 1;
      if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
        break label173;
      }
    }
    label173:
    for (int j = 1;; j = 0)
    {
      if ((i & j) != 0)
      {
        RobotProcessor.a(this.a.a, RobotUtils.c(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("RobotProcessor", 2, "onGetRobotsRedList : needShowRobotRedPoint = " + RobotProcessor.a(this.a.a));
        }
        QQAppInterface localQQAppInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.a.a.jdField_a_of_type_JavaLangString;
        i = k;
        if (RobotProcessor.a(this.a.a)) {
          i = 1;
        }
        RedPointUtils.a(localQQAppInterface, str, "troop", 1, i);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.RobotProcessor.1.1
 * JD-Core Version:    0.7.0.1
 */