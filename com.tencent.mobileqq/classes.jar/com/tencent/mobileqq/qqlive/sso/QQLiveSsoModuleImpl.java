package com.tencent.mobileqq.qqlive.sso;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.utils.QQLiveCaptureContext;
import com.tencent.qphone.base.util.QLog;

public class QQLiveSsoModuleImpl
  implements IQQLiveSsoModule
{
  private IQQLiveSDK a;
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, QQLiveBusinessObserver paramQQLiveBusinessObserver)
  {
    if (this.a == null)
    {
      QLog.e("QQLiveSsoModuleImpl", 1, "the live sdk is null");
      return;
    }
    AppInterface localAppInterface = QQLiveCaptureContext.a();
    if (localAppInterface == null)
    {
      QLog.e("QQLiveSsoModuleImpl", 1, "getAppInterface null");
      return;
    }
    ((QQLiveBusinessHandler)localAppInterface.getBusinessHandler(QQLiveBusinessHandler.a)).a(this.a.getAppId(), paramString1, paramString2, paramArrayOfByte, 15000, paramInt, paramQQLiveBusinessObserver);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, QQLiveBusinessObserver paramQQLiveBusinessObserver)
  {
    if (this.a == null)
    {
      QLog.e("QQLiveSsoModuleImpl", 1, "the live sdk is null");
      return;
    }
    AppInterface localAppInterface = QQLiveCaptureContext.a();
    if (localAppInterface == null)
    {
      QLog.e("QQLiveSsoModuleImpl", 1, "getAppInterface null");
      return;
    }
    ((QQLiveBusinessHandler)localAppInterface.getBusinessHandler(QQLiveBusinessHandler.a)).a(this.a.getAppId(), paramString1, paramString2, paramArrayOfByte, 15000, 0, paramQQLiveBusinessObserver);
  }
  
  public void destroy() {}
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.a = paramIQQLiveSDK;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.QQLiveSsoModuleImpl
 * JD-Core Version:    0.7.0.1
 */