package com.tencent.mobileqq.shortvideo.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class VideoAnimation
{
  public static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat5, paramFloat6);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, paramFloat1, 0, paramFloat2, 0, paramFloat3, 0, paramFloat4);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setDuration(paramInt);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillBefore(true);
    localAnimationSet.setFillAfter(true);
    paramView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.VideoAnimation
 * JD-Core Version:    0.7.0.1
 */