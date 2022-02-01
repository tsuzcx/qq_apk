package com.tencent.mobileqq.qqgift.api.impl.service;

import com.tencent.mobileqq.qqgift.sso.QQGiftBusinessObserver;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.qphone.base.util.QLog;

class QQGiftServiceModuleImpl$6
  extends QQGiftBusinessObserver
{
  QQGiftServiceModuleImpl$6(QQGiftServiceModuleImpl paramQQGiftServiceModuleImpl) {}
  
  public void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData)
  {
    if ((paramBoolean) && (paramQQGiftRspData != null))
    {
      StringBuilder localStringBuilder;
      if (paramQQGiftRspData.d() != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyComboOver failed ProxyCode::");
        localStringBuilder.append(paramQQGiftRspData.d());
        QLog.e("QQGiftServiceModuleImpl", 1, localStringBuilder.toString());
        return;
      }
      if (paramQQGiftRspData.c() != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyComboOver failed BusinessErrorCode::");
        localStringBuilder.append(paramQQGiftRspData.c());
        QLog.e("QQGiftServiceModuleImpl", 1, localStringBuilder.toString());
        return;
      }
      QLog.i("QQGiftServiceModuleImpl", 1, "notifyComboOver success");
      return;
    }
    paramQQGiftRspData = new StringBuilder();
    paramQQGiftRspData.append("notifyComboOver failed suc::");
    paramQQGiftRspData.append(paramBoolean);
    QLog.e("QQGiftServiceModuleImpl", 1, paramQQGiftRspData.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl.6
 * JD-Core Version:    0.7.0.1
 */