package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class LuckyCharacterProcessor
  extends AbsBaseProcessor
{
  private boolean a;
  
  public LuckyCharacterProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String a()
  {
    return "LuckyCharacterProcessor";
  }
  
  public void a()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Object localObject = (TroopLuckyCharacterConfig)QConfigManager.a().a(696);
    boolean bool;
    String str;
    if ((localObject != null) && (((TroopLuckyCharacterConfig)localObject).a(this.jdField_a_of_type_JavaLangString)) && (DBUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("LuckyCharacterProcessor", 2, "initTroopSettingRedPointInfo : needShowLuckyCharacterRedPoint = " + this.jdField_a_of_type_Boolean);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label136;
      }
    }
    for (;;)
    {
      RedPointUtils.a((QQAppInterface)localObject, str, "troop", 4, i);
      return;
      bool = false;
      break;
      label136:
      i = 0;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LuckyCharacterProcessor", 2, "cleanTroopSettingRedPointInfo : needShowLuckyCharacterRedPoint = " + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      DBUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.LuckyCharacterProcessor
 * JD-Core Version:    0.7.0.1
 */