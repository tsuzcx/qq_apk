package com.tencent.mobileqq.litelivesdk.api;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;

public abstract interface ILiveSDK
{
  public abstract BusinessConfig a();
  
  public abstract LoginResult a();
  
  public abstract void a();
  
  public abstract void a(BusinessConfig paramBusinessConfig);
  
  public abstract void a(BizLoginRequest paramBizLoginRequest);
  
  public abstract void a(String paramString, int paramInt, Class<? extends BaseSDKPageBizBootModules> paramClass);
  
  public abstract void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver);
  
  public abstract void a(String paramString, ILiveLoginTicketListener paramILiveLoginTicketListener);
  
  public abstract void a(String paramString, Class<? extends ServiceBaseInterface> paramClass, Class<? extends BaseServiceBuilder> paramClass1);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract void b();
  
  public abstract void b(BusinessConfig paramBusinessConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.ILiveSDK
 * JD-Core Version:    0.7.0.1
 */