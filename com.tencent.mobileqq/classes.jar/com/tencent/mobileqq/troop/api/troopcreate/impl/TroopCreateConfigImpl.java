package com.tencent.mobileqq.troop.api.troopcreate.impl;

import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateConfig;
import mqq.app.AppRuntime;

public class TroopCreateConfigImpl
  implements ITroopCreateConfig
{
  private AppRuntime mApp;
  private TroopManager tm;
  
  public boolean isShow3KTroopTips()
  {
    this.tm = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER));
    return this.tm.a.a;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.tm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.TroopCreateConfigImpl
 * JD-Core Version:    0.7.0.1
 */