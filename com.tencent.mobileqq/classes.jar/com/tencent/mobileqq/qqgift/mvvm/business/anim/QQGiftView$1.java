package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;

class QQGiftView$1
  implements IQQGiftAnimationListener
{
  QQGiftView$1(QQGiftView paramQQGiftView) {}
  
  public void a()
  {
    if (QQGiftView.a(this.a) != null) {
      QQGiftView.a(this.a).onAnimationStart(QQGiftView.b(this.a));
    }
  }
  
  public void b()
  {
    if (QQGiftView.a(this.a) != null) {
      QQGiftView.a(this.a).onAnimationEnd(QQGiftView.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftView.1
 * JD-Core Version:    0.7.0.1
 */