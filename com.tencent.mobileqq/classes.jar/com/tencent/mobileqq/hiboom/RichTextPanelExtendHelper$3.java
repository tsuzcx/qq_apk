package com.tencent.mobileqq.hiboom;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;

class RichTextPanelExtendHelper$3
  implements ValueAnimator.AnimatorUpdateListener
{
  RichTextPanelExtendHelper$3(RichTextPanelExtendHelper paramRichTextPanelExtendHelper, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.a) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.a = i;
    if (this.b.f.getParent() != null) {
      this.b.f.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper.3
 * JD-Core Version:    0.7.0.1
 */