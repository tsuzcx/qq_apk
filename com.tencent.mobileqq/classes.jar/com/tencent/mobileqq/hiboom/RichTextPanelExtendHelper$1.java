package com.tencent.mobileqq.hiboom;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;

class RichTextPanelExtendHelper$1
  implements ValueAnimator.AnimatorUpdateListener
{
  RichTextPanelExtendHelper$1(RichTextPanelExtendHelper paramRichTextPanelExtendHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a.a.getParent() != null) {
      this.a.a.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper.1
 * JD-Core Version:    0.7.0.1
 */