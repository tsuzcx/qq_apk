package com.tencent.qqmini.sdk.widget.media.danmu;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class AnimationHelper
{
  public static Animation createTranslateAnim(Context paramContext, int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramInt1, paramInt2, 0.0F, 0.0F);
    localTranslateAnimation.setDuration((Math.abs(paramInt2 - paramInt1) * 1.0F / DisplayUtil.getScreenWidth(paramContext) * 3000.0F));
    localTranslateAnimation.setInterpolator(new DecelerateAccelerateInterpolator());
    localTranslateAnimation.setFillAfter(true);
    return localTranslateAnimation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.danmu.AnimationHelper
 * JD-Core Version:    0.7.0.1
 */