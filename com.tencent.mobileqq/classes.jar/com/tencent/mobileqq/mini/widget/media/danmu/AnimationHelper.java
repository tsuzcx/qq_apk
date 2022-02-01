package com.tencent.mobileqq.mini.widget.media.danmu;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import bhtq;

public class AnimationHelper
{
  public static Animation createTranslateAnim(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new TranslateAnimation(paramInt1, paramInt2, 0.0F, 0.0F);
    paramContext.setDuration((Math.abs(paramInt2 - paramInt1) * 1.0F / bhtq.a() * 3000.0F));
    paramContext.setInterpolator(new DecelerateAccelerateInterpolator());
    paramContext.setFillAfter(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.danmu.AnimationHelper
 * JD-Core Version:    0.7.0.1
 */