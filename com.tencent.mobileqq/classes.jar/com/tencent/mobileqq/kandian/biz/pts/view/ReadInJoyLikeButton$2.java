package com.tencent.mobileqq.kandian.biz.pts.view;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ReadInJoyLikeButton$2
  extends D8SafeAnimatorListener
{
  ReadInJoyLikeButton$2(ReadInJoyLikeButton paramReadInJoyLikeButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a, false);
    ReadInJoyLikeButton.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLikeButton.2
 * JD-Core Version:    0.7.0.1
 */