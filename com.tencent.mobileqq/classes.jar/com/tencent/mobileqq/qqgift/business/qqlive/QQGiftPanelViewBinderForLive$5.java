package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;

class QQGiftPanelViewBinderForLive$5
  implements Observer<String>
{
  QQGiftPanelViewBinderForLive$5(QQGiftPanelViewBinderForLive paramQQGiftPanelViewBinderForLive, QQGiftPanelViewForLive paramQQGiftPanelViewForLive) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[bindCountDownView] onChanged,text:");
      localStringBuilder.append(paramString);
      QLog.i("GiftPanelViewBinder", 2, localStringBuilder.toString());
    }
    this.a.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewBinderForLive.5
 * JD-Core Version:    0.7.0.1
 */