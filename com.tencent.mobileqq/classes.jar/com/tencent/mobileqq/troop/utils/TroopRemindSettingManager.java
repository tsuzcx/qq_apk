package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRemindSettingManager
{
  private static TroopRemindSettingManager a;
  
  public static TroopRemindSettingManager a()
  {
    if (a == null) {
      a = new TroopRemindSettingManager();
    }
    return a;
  }
  
  public static void a()
  {
    if (a != null) {
      a = null;
    }
  }
  
  public void a(EntityManager paramEntityManager, AppInterface paramAppInterface)
  {
    paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getAccount(), 0).edit().putBoolean("init_troop_remind", false).commit();
  }
  
  public void a(String paramString, AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
    localTroopRemindSettingData.troopUin = paramString;
    localTroopRemindSettingData.isOpenState = 1;
    paramAppInterface.persistOrReplace(localTroopRemindSettingData);
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getAccount(), 0).getBoolean("init_troop_remind", true);
  }
  
  public boolean a(String paramString, AppInterface paramAppInterface)
  {
    paramString = (TroopRemindSettingData)paramAppInterface.getEntityManagerFactory().createEntityManager().find(TroopRemindSettingData.class, paramString);
    return (paramString != null) && (paramString.isOpenState == 0);
  }
  
  public void b(String paramString, AppInterface paramAppInterface)
  {
    ThreadManager.post(new TroopRemindSettingManager.1(this, paramAppInterface, paramString), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRemindSettingManager
 * JD-Core Version:    0.7.0.1
 */