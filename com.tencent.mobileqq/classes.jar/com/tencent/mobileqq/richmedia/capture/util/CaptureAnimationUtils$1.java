package com.tencent.mobileqq.richmedia.capture.util;

import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.qphone.base.util.QLog;

final class CaptureAnimationUtils$1
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QIMAnimationUtils", 2, "heightAnimation value = " + paramInteger);
    }
    paramValueAnimation = this.a.getLayoutParams();
    paramValueAnimation.height = paramInteger.intValue();
    this.a.setLayoutParams(paramValueAnimation);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureAnimationUtils.1
 * JD-Core Version:    0.7.0.1
 */