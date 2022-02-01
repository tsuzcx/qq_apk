package com.tencent.mobileqq.qqgift.sso;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.utils.QQGiftCaptureContext;
import com.tencent.qphone.base.util.QLog;

public class QQGiftSsoModuleImpl
  implements IQQGiftSsoModule
{
  private IQQGiftSDK a;
  
  public void a() {}
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.a = paramIQQGiftSDK;
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, QQGiftBusinessObserver paramQQGiftBusinessObserver)
  {
    if (this.a == null)
    {
      QLog.e("QQGiftSsoModuleImpl", 1, "sendQQGiftMsfReq giftSDK is null");
      return;
    }
    AppInterface localAppInterface = QQGiftCaptureContext.a();
    if (localAppInterface == null)
    {
      QLog.e("QQGiftSsoModuleImpl", 1, "sendQQGiftMsfReq getAppInterface is null");
      return;
    }
    ((QQGiftBusinessHandler)localAppInterface.getBusinessHandler(QQGiftBusinessHandler.a)).a(this.a.c().a, paramString1, paramString2, paramArrayOfByte, 15000, paramInt, paramQQGiftBusinessObserver);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, QQGiftBusinessObserver paramQQGiftBusinessObserver)
  {
    if (this.a == null)
    {
      QLog.e("QQGiftSsoModuleImpl", 1, "sendQQGiftMsfReq giftSDK is null");
      return;
    }
    AppInterface localAppInterface = QQGiftCaptureContext.a();
    if (localAppInterface == null)
    {
      QLog.e("QQGiftSsoModuleImpl", 1, "sendQQGiftMsfReq getAppInterface is null");
      return;
    }
    ((QQGiftBusinessHandler)localAppInterface.getBusinessHandler(QQGiftBusinessHandler.a)).a(this.a.c().a, paramString1, paramString2, paramArrayOfByte, 10000, 0, paramQQGiftBusinessObserver);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.QQGiftSsoModuleImpl
 * JD-Core Version:    0.7.0.1
 */