package com.tencent.mobileqq.guild.mainframe.leftbar.animation;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

public class LeftBarAnimationUtils$ColorEvaluator
  implements TypeEvaluator<ColorAniData>
{
  public ColorAniData a(float paramFloat, ColorAniData paramColorAniData1, ColorAniData paramColorAniData2)
  {
    ArgbEvaluator localArgbEvaluator = new ArgbEvaluator();
    return new ColorAniData(((Integer)localArgbEvaluator.evaluate(paramFloat, Integer.valueOf(paramColorAniData1.a), Integer.valueOf(paramColorAniData2.a))).intValue(), ((Integer)localArgbEvaluator.evaluate(paramFloat, Integer.valueOf(paramColorAniData1.b), Integer.valueOf(paramColorAniData2.b))).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils.ColorEvaluator
 * JD-Core Version:    0.7.0.1
 */