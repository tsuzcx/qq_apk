package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import java.lang.ref.SoftReference;

class QQGiftView$CheckTimeOutRunnable
  implements Runnable
{
  private GiftAnimData a;
  private final QQGiftView.QQGiftAnimationResDownloadCallback b;
  private final SoftReference<QQGiftView> c;
  
  QQGiftView$CheckTimeOutRunnable(QQGiftView paramQQGiftView, GiftAnimData paramGiftAnimData, QQGiftView.QQGiftAnimationResDownloadCallback paramQQGiftAnimationResDownloadCallback)
  {
    this.a = paramGiftAnimData;
    this.b = paramQQGiftAnimationResDownloadCallback;
    this.c = new SoftReference(paramQQGiftView);
  }
  
  public void run()
  {
    QQGiftView localQQGiftView = (QQGiftView)this.c.get();
    if (localQQGiftView != null) {
      QQGiftView.a(localQQGiftView, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftView.CheckTimeOutRunnable
 * JD-Core Version:    0.7.0.1
 */