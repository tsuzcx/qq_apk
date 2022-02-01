package com.tencent.mobileqq.qqgift.mvvm.business;

import com.tencent.mobileqq.qqgift.callback.service.IQQGiftBalanceCallback;
import com.tencent.qphone.base.util.QLog;

class QQGiftPanelViewModel$4
  implements IQQGiftBalanceCallback
{
  QQGiftPanelViewModel$4(QQGiftPanelViewModel paramQQGiftPanelViewModel) {}
  
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
    if (!QQGiftPanelViewModel.a(this.a, paramLong2)) {
      return;
    }
    QQGiftPanelViewModel.b(this.a, paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewModel.4
 * JD-Core Version:    0.7.0.1
 */