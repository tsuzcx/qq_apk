package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;

class QQGiftPanelViewBinderForLive$6
  implements Observer<Integer>
{
  QQGiftPanelViewBinderForLive$6(QQGiftPanelViewBinderForLive paramQQGiftPanelViewBinderForLive, QQGiftPanelViewForLive paramQQGiftPanelViewForLive) {}
  
  public void a(Integer paramInteger)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[bindSendGiftView] onChanged,viewType:");
      localStringBuilder.append(paramInteger);
      QLog.i("GiftPanelViewBinder", 2, localStringBuilder.toString());
    }
    this.a.a(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewBinderForLive.6
 * JD-Core Version:    0.7.0.1
 */