package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class GameCardProcessor
  extends AbsBaseProcessor
{
  private boolean a;
  
  public GameCardProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String a()
  {
    return "GameCardProcessor";
  }
  
  public void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Boolean = DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, false);
    if (QLog.isColorLevel()) {
      QLog.d("GameCardProcessor", 2, "initTroopSettingRedPointInfo : needShowGameCardRedPoint = " + this.jdField_a_of_type_Boolean);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    RedPointUtils.a(localQQAppInterface, str, "troop", 3, i);
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.GameCardProcessor
 * JD-Core Version:    0.7.0.1
 */