package com.tencent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;

class XPanelContainer$3
  implements ValueAnimator.AnimatorUpdateListener
{
  XPanelContainer$3(XPanelContainer paramXPanelContainer, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.b.g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "openAnim resetPosition");
      }
      XPanelContainer.a(this.b, 0);
      return;
    }
    XPanelContainer.a(this.b, this.a - i);
    this.b.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer.3
 * JD-Core Version:    0.7.0.1
 */