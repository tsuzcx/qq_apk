package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class QQGiftView$QQGiftAnimationResDownloadCallback
  implements IQQGiftAnimationResDownloadCallback
{
  private final SoftReference<QQGiftView> a;
  private final GiftAnimData b;
  private boolean c = false;
  
  public QQGiftView$QQGiftAnimationResDownloadCallback(QQGiftView paramQQGiftView, GiftAnimData paramGiftAnimData)
  {
    this.a = new SoftReference(paramQQGiftView);
    this.b = paramGiftAnimData;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.c)
    {
      paramString = new StringBuilder();
      paramString.append("load ");
      paramString.append(this.b.d);
      paramString.append(" success but timeOut");
      QLog.e("QQGiftView", 1, paramString.toString());
      return;
    }
    QQGiftView localQQGiftView = (QQGiftView)this.a.get();
    if (localQQGiftView != null) {
      QQGiftView.b(localQQGiftView, paramString, this.b);
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.c)
    {
      paramString = new StringBuilder();
      paramString.append("load ");
      paramString.append(this.b.d);
      paramString.append(" failed and timeOut");
      QLog.e("QQGiftView", 1, paramString.toString());
      return;
    }
    QQGiftView localQQGiftView = (QQGiftView)this.a.get();
    if (localQQGiftView != null) {
      QQGiftView.a(localQQGiftView, paramString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftView.QQGiftAnimationResDownloadCallback
 * JD-Core Version:    0.7.0.1
 */