package com.tencent.mobileqq.qqgift.business.qqlive;

import com.tencent.mobileqq.qqgift.callback.service.IQQGiftBalanceCallback;
import com.tencent.qphone.base.util.QLog;

class QQGiftPanelViewModelForLive$3
  implements IQQGiftBalanceCallback
{
  QQGiftPanelViewModelForLive$3(QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[refreshBalance] ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",seq:");
      localStringBuilder.append(paramLong2);
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
    }
    if (!QQGiftPanelViewModelForLive.a(this.a, paramLong2)) {
      return;
    }
    QQGiftPanelViewModelForLive.b(this.a, paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive.3
 * JD-Core Version:    0.7.0.1
 */