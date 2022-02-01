package com.tencent.viola.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import com.tencent.viola.ui.component.VImage;

class VImageView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  VImageView$3(VImageView paramVImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (this.this$0.getDrawable() != null)
    {
      if ((this.this$0.getComponent() != null) && (!this.this$0.getComponent().isNeedDoAlpha()))
      {
        VImageView.access$002(this.this$0, false);
        this.this$0.getDrawable().setAlpha(255);
        return;
      }
      if (VImageView.access$000(this.this$0)) {
        this.this$0.getDrawable().setAlpha((int)(f * 255.0F));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView.3
 * JD-Core Version:    0.7.0.1
 */