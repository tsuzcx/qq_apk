package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class VasProfileTagView$13
  extends AnimatorListenerAdapter
{
  VasProfileTagView$13(VasProfileTagView paramVasProfileTagView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VasProfileTagView.access$1706(this.this$0);
    this.val$child.setVisibility(4);
    this.val$child.setTranslationX(0.0F);
    this.val$child.setTranslationY(0.0F);
    VasProfileTagView.access$202(this.this$0, false);
    if (VasProfileTagView.access$1700(this.this$0) == 0) {
      this.this$0.checkTagUpdateFlag();
    }
    paramAnimator = this.this$0;
    VasProfileTagView.access$2300(paramAnimator, VasProfileTagView.access$2200(paramAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.13
 * JD-Core Version:    0.7.0.1
 */