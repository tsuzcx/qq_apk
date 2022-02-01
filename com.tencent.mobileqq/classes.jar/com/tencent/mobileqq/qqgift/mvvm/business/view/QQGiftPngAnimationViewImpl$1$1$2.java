package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;

class QQGiftPngAnimationViewImpl$1$1$2
  implements Animator.AnimatorListener
{
  QQGiftPngAnimationViewImpl$1$1$2(QQGiftPngAnimationViewImpl.1.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QQGiftPngAnimationViewImpl.e(this.a.a.this$0)) {
      return;
    }
    if (QQGiftPngAnimationViewImpl.d(this.a.a.this$0) != null) {
      QQGiftPngAnimationViewImpl.d(this.a.a.this$0).b();
    }
    QQGiftPngAnimationViewImpl.a(this.a.a.this$0).setImageBitmap(null);
    if (QQGiftPngAnimationViewImpl.c(this.a.a.this$0) != null)
    {
      QQGiftPngAnimationViewImpl.c(this.a.a.this$0).recycle();
      QQGiftPngAnimationViewImpl.a(this.a.a.this$0, null);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QQGiftPngAnimationViewImpl.d(this.a.a.this$0) != null) {
      QQGiftPngAnimationViewImpl.d(this.a.a.this$0).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPngAnimationViewImpl.1.1.2
 * JD-Core Version:    0.7.0.1
 */