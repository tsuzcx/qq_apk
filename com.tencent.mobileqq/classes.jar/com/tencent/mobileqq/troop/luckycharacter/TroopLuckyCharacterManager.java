package com.tencent.mobileqq.troop.luckycharacter;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class TroopLuckyCharacterManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopLuckyCharacterConfig jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterTroopLuckyCharacterConfig = new TroopLuckyCharacterConfig();
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopLuckyCharacterManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.getSubThreadHandler().post(new TroopLuckyCharacterManager.1(this));
  }
  
  public void a(TroopLuckyCharacterConfig paramTroopLuckyCharacterConfig)
  {
    ThreadManager.getSubThreadHandler().post(new TroopLuckyCharacterManager.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin))) {}
    for (;;)
    {
      return false;
      if (QQTheme.e())
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TroopLuckyCharacterManager", 2, "isSupportLuckyCharacter isNowSimpleUI");
          return false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterTroopLuckyCharacterConfig != null) {}
        for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterTroopLuckyCharacterConfig.a(paramTroopInfo.troopuin); (bool) && (a()); bool = false) {
          return true;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterManager
 * JD-Core Version:    0.7.0.1
 */