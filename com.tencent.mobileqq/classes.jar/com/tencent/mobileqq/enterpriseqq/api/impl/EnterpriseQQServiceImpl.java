package com.tencent.mobileqq.enterpriseqq.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.enterpriseqq.api.IEnterpriseQQService;
import mqq.app.AppRuntime;

public class EnterpriseQQServiceImpl
  implements IEnterpriseQQService
{
  private EnterpriseQQManager eQQManager = null;
  private QQAppInterface mApp;
  
  public void getMenuFromNet(String paramString, boolean paramBoolean)
  {
    this.eQQManager.a(this.mApp, paramString, paramBoolean);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((QQAppInterface)paramAppRuntime);
    this.eQQManager = EnterpriseQQManager.a(this.mApp);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.api.impl.EnterpriseQQServiceImpl
 * JD-Core Version:    0.7.0.1
 */