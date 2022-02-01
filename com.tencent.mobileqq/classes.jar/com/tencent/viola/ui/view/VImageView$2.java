package com.tencent.viola.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.tencent.viola.ui.component.VImage;

class VImageView$2
  extends AnimatorListenerAdapter
{
  VImageView$2(VImageView paramVImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.this$0.getComponent() != null) {
      this.this$0.getComponent().resetAlphaAnimState();
    }
    if (this.this$0.getDrawable() != null) {
      this.this$0.getDrawable().setAlpha(255);
    }
    VImageView.access$002(this.this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.this$0.getComponent() != null) {
      this.this$0.getComponent().resetAlphaAnimState();
    }
    VImageView.access$002(this.this$0, false);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    if (this.this$0.getComponent() != null) {
      this.this$0.getComponent().resetAlphaAnimState();
    }
    VImageView.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView.2
 * JD-Core Version:    0.7.0.1
 */