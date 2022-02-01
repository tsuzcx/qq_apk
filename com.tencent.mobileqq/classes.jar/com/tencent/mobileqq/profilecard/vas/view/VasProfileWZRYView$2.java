package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.widget.ImageView;

class VasProfileWZRYView$2
  implements Runnable
{
  VasProfileWZRYView$2(VasProfileWZRYView paramVasProfileWZRYView) {}
  
  @TargetApi(11)
  public void run()
  {
    VasProfileWZRYView.access$100(this.this$0).setVisibility(0);
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.playTogether(new Animator[] { ObjectAnimator.ofFloat(VasProfileWZRYView.access$100(this.this$0), "scaleX", new float[] { 3.5F, 0.9F }), ObjectAnimator.ofFloat(VasProfileWZRYView.access$100(this.this$0), "scaleY", new float[] { 3.5F, 0.9F }) });
    localAnimatorSet1.setDuration(150L);
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(VasProfileWZRYView.access$100(this.this$0), "scaleX", new float[] { 0.9F, 1.1F }), ObjectAnimator.ofFloat(VasProfileWZRYView.access$100(this.this$0), "scaleY", new float[] { 0.9F, 1.1F }) });
    localAnimatorSet2.setDuration(100L);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(VasProfileWZRYView.access$100(this.this$0), "scaleX", new float[] { 1.1F, 1.0F }), ObjectAnimator.ofFloat(VasProfileWZRYView.access$100(this.this$0), "scaleY", new float[] { 1.1F, 1.0F }) });
    ((AnimatorSet)localObject).setDuration(50L);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2, localObject });
    localAnimatorSet3.start();
    VasProfileWZRYView.access$200(this.this$0).setVisibility(0);
    localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.playTogether(new Animator[] { ObjectAnimator.ofFloat(VasProfileWZRYView.access$200(this.this$0), "scaleX", new float[] { 2.0F, 3.0F }), ObjectAnimator.ofFloat(VasProfileWZRYView.access$200(this.this$0), "scaleY", new float[] { 2.0F, 3.0F }), ObjectAnimator.ofFloat(VasProfileWZRYView.access$200(this.this$0), "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet1.setDuration(50L);
    localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(VasProfileWZRYView.access$200(this.this$0), "scaleX", new float[] { 3.0F, 0.5F }), ObjectAnimator.ofFloat(VasProfileWZRYView.access$200(this.this$0), "scaleY", new float[] { 3.0F, 0.5F }) });
    localAnimatorSet2.setDuration(100L);
    localObject = ObjectAnimator.ofFloat(VasProfileWZRYView.access$200(this.this$0), "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(100L);
    localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2, localObject });
    localAnimatorSet3.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.2
 * JD-Core Version:    0.7.0.1
 */