package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qphone.base.util.QLog;

public class RobotProcessor
  extends AbsBaseProcessor
{
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new RobotProcessor.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  
  public RobotProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramQQAppInterface, paramString);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
  }
  
  public String a()
  {
    return "RobotProcessor";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Boolean = RobotUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("RobotProcessor", 2, "initTroopSettingRedPointInfo : needShowRobotRedPoint = " + this.jdField_a_of_type_Boolean);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      RedPointUtils.a(localQQAppInterface, str, "troop", 1, i);
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RobotProcessor", 2, "cleanTroopSettingRedPointInfo : needShowRobotRedPoint = " + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      RobotUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.RobotProcessor
 * JD-Core Version:    0.7.0.1
 */