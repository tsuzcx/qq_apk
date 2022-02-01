package com.tencent.mobileqq.qqgift.api;

import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import mqq.app.AppRuntime;

public abstract interface IQQGiftSDK
{
  public abstract IQQGiftModule a(String paramString);
  
  public abstract void a(AppRuntime paramAppRuntime, QQGiftSDKConfig paramQQGiftSDKConfig);
  
  public abstract boolean a();
  
  public abstract AppRuntime b();
  
  public abstract QQGiftSDKConfig c();
  
  public abstract IQQGiftServiceModule d();
  
  public abstract IQQGiftViewModule e();
  
  public abstract IQQGiftRechargeModule f();
  
  public abstract IQQGiftResDownloadModule g();
  
  public abstract IQQGiftWalletIdentifyModule h();
  
  public abstract IQQGiftCountDownModule i();
  
  public abstract void j();
  
  public abstract boolean k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.IQQGiftSDK
 * JD-Core Version:    0.7.0.1
 */