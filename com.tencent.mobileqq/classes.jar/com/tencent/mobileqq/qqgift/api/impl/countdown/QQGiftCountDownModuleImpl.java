package com.tencent.mobileqq.qqgift.api.impl.countdown;

import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.manager.QQGiftCountDownManager;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;

public class QQGiftCountDownModuleImpl
  implements IQQGiftCountDownModule
{
  private IQQGiftSDK a;
  
  private String e()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((IQQGiftSDK)localObject).c() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.c().a);
      ((StringBuilder)localObject).append("");
      return ((StringBuilder)localObject).toString();
    }
    return "global";
  }
  
  public void a() {}
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.a = paramIQQGiftSDK;
  }
  
  public void b() {}
  
  public void c()
  {
    QQGiftCountDownManager.a().b(e());
  }
  
  public void d()
  {
    QQGiftCountDownManager.a().c(e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.countdown.QQGiftCountDownModuleImpl
 * JD-Core Version:    0.7.0.1
 */