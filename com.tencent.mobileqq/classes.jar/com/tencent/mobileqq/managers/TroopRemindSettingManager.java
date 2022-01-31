package com.tencent.mobileqq.managers;

import adse;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
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
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_remind", false).commit();
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
    localTroopRemindSettingData.troopUin = paramString;
    localTroopRemindSettingData.isOpenState = 1;
    paramQQAppInterface.b(localTroopRemindSettingData);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_remind", true);
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = (TroopRemindSettingData)paramQQAppInterface.getEntityManagerFactory().createEntityManager().a(TroopRemindSettingData.class, paramString);
    return (paramString != null) && (paramString.isOpenState == 0);
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new adse(this, paramQQAppInterface, paramString), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopRemindSettingManager
 * JD-Core Version:    0.7.0.1
 */