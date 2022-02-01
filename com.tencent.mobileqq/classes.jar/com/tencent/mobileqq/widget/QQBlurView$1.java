package com.tencent.mobileqq.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class QQBlurView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  QQBlurView$1(QQBlurView paramQQBlurView) {}
  
  public boolean onPreDraw()
  {
    if (!QQBlurView.a(this.a)) {
      return true;
    }
    if (!QQBlurView.b(this.a).a()) {
      return true;
    }
    return QQBlurView.b(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlurView.1
 * JD-Core Version:    0.7.0.1
 */