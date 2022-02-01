package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class QQGiftPngAnimationViewImpl$1$1
  implements Runnable
{
  QQGiftPngAnimationViewImpl$1$1(QQGiftPngAnimationViewImpl.1 param1) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (this.a.a.equals(QQGiftPngAnimationViewImpl.b(this.a.this$0))))
    {
      QQGiftPngAnimationViewImpl.a(this.a.this$0).setImageBitmap(QQGiftPngAnimationViewImpl.c(this.a.this$0));
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1600.0F });
      localValueAnimator.setDuration(1600L);
      localValueAnimator.addUpdateListener(new QQGiftPngAnimationViewImpl.1.1.1(this));
      localValueAnimator.addListener(new QQGiftPngAnimationViewImpl.1.1.2(this));
      localValueAnimator.start();
      return;
    }
    QLog.e("QQGiftPngAnimationViewImpl", 1, "playCancel cause path is not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPngAnimationViewImpl.1.1
 * JD-Core Version:    0.7.0.1
 */