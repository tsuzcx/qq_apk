package com.tencent.mobileqq.guild.animate;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public final class AnimationCompatUtils
{
  public static Animator a(View paramView, float paramFloat1, float paramFloat2)
  {
    return ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramFloat1, paramFloat2 });
  }
  
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
  
  public static Animator b(View paramView, float paramFloat1, float paramFloat2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat1, paramFloat2 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.AnimationCompatUtils
 * JD-Core Version:    0.7.0.1
 */