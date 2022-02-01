package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopGagService;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import mqq.app.AppRuntime;

public class TroopGagServiceImpl
  implements ITroopGagService
{
  protected QQAppInterface mApp;
  
  public SelfGagInfo getSelfGagInfo(String paramString, boolean paramBoolean)
  {
    return ((TroopGagMgr)this.mApp.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramString, paramBoolean);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((QQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopGagServiceImpl
 * JD-Core Version:    0.7.0.1
 */