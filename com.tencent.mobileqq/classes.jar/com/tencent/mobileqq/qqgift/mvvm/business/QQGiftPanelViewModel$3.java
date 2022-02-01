package com.tencent.mobileqq.qqgift.mvvm.business;

import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QQGiftPanelViewModel$3
  implements IQQGiftRechargeCallback
{
  QQGiftPanelViewModel$3(QQGiftPanelViewModel paramQQGiftPanelViewModel) {}
  
  public Map<String, String> a()
  {
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onRechargeBack] success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg:");
      localStringBuilder.append(paramString);
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      QQGiftPanelViewModel.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewModel.3
 * JD-Core Version:    0.7.0.1
 */