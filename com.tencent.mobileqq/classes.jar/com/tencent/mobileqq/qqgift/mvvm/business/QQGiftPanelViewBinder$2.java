package com.tencent.mobileqq.qqgift.mvvm.business;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.qphone.base.util.QLog;

class QQGiftPanelViewBinder$2
  implements Observer<String>
{
  QQGiftPanelViewBinder$2(QQGiftPanelViewBinder paramQQGiftPanelViewBinder, IQQGiftPanelView paramIQQGiftPanelView) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[bindRechargeView] onRechargeData change,text:");
      localStringBuilder.append(paramString);
      QLog.i("GiftPanelViewBinder", 2, localStringBuilder.toString());
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewBinder.2
 * JD-Core Version:    0.7.0.1
 */