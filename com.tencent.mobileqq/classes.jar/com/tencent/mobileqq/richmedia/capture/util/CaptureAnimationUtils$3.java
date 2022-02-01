package com.tencent.mobileqq.richmedia.capture.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.qphone.base.util.QLog;

final class CaptureAnimationUtils$3
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  @TargetApi(11)
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QIMAnimationUtils", 2, "alphaAnimation value = " + paramFloat1);
    }
    paramFloat = paramFloat1.floatValue();
    if (this.a != null)
    {
      this.a.setAlpha(paramFloat);
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureAnimationUtils.3
 * JD-Core Version:    0.7.0.1
 */