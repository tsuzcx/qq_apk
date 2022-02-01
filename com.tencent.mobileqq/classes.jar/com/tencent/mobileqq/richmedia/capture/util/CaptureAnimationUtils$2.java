package com.tencent.mobileqq.richmedia.capture.util;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

final class CaptureAnimationUtils$2
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    int i = Color.argb(paramInteger.intValue(), 255, 255, 255);
    this.a.setBackgroundColor(i);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */