package com.tencent.mobileqq.guild.channel.create;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class AnimateHelper
{
  private static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    paramView.setPivotX(0.0F);
    paramView.setPivotY(0.0F);
    paramView.setTranslationX(paramFloat3);
    paramView.setTranslationY(paramFloat4);
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat1, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat2, 1.0F });
    localObjectAnimator2.setDuration(paramLong);
    localObjectAnimator1.setDuration(paramLong);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat3, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat4, 0.0F });
    localObjectAnimator3.setDuration(paramLong);
    paramView.setDuration(paramLong);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1, localObjectAnimator3, paramView });
    localAnimatorSet.start();
  }
  
  public static void a(View paramView1, View paramView2, boolean paramBoolean, long paramLong)
  {
    paramView2.setVisibility(0);
    int[] arrayOfInt1 = new int[2];
    int i = paramView1.getWidth();
    int j = paramView1.getHeight();
    paramView1.getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    int k = paramView2.getWidth();
    int m = paramView2.getHeight();
    paramView2.getLocationOnScreen(arrayOfInt2);
    float f1 = i / k;
    float f2 = j / m;
    float f3 = arrayOfInt1[0] - arrayOfInt2[0];
    float f4 = arrayOfInt1[1] - arrayOfInt2[1];
    if (paramBoolean) {
      paramView1.setVisibility(4);
    }
    a(paramView2, f1, f2, f3, f4, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.AnimateHelper
 * JD-Core Version:    0.7.0.1
 */