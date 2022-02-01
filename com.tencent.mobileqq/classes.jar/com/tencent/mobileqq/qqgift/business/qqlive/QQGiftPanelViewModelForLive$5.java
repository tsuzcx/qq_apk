package com.tencent.mobileqq.qqgift.business.qqlive;

import com.tencent.mobileqq.qqgift.callback.service.IQQGiftSendCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;

class QQGiftPanelViewModelForLive$5
  implements IQQGiftSendCallback
{
  QQGiftPanelViewModelForLive$5(QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive, int paramInt, GiftServiceData paramGiftServiceData) {}
  
  public void a()
  {
    QQGiftPanelViewModelForLive localQQGiftPanelViewModelForLive = this.c;
    QQGiftPanelViewModelForLive.a(localQQGiftPanelViewModelForLive, QQGiftPanelViewModelForLive.c(localQQGiftPanelViewModelForLive) + this.a);
    this.c.a(true, this.b, 0);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c.a(false, this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive.5
 * JD-Core Version:    0.7.0.1
 */