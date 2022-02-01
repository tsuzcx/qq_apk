package com.tencent.mobileqq.guild.mainframe.leftbar.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.View;

public class LeftBarAnimationUtils
{
  public static int a = 300;
  public static int b = 800;
  
  @NonNull
  public static ObjectAnimator a(@NonNull View paramView, float[] paramArrayOfFloat, long paramLong)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", paramArrayOfFloat);
    paramView.setDuration(paramLong);
    return paramView;
  }
  
  public static ValueAnimator a(View paramView, long paramLong, int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new LeftBarAnimationUtils.4(paramView));
    localValueAnimator.setDuration(paramLong);
    return localValueAnimator;
  }
  
  public static ValueAnimator a(View paramView, long paramLong, ColorAniData paramColorAniData1, ColorAniData paramColorAniData2)
  {
    paramColorAniData1 = ValueAnimator.ofObject(new LeftBarAnimationUtils.ColorEvaluator(), new Object[] { paramColorAniData1, paramColorAniData2 });
    paramColorAniData1.addUpdateListener(new LeftBarAnimationUtils.1(paramView));
    paramColorAniData1.setTarget(paramView);
    paramColorAniData1.setDuration(paramLong);
    return paramColorAniData1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils
 * JD-Core Version:    0.7.0.1
 */