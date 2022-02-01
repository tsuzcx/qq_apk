package com.tencent.mobileqq.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;

final class ScreenShotUtil$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ScreenShotUtil$4(TDProgressDialog paramTDProgressDialog) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.a(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.4
 * JD-Core Version:    0.7.0.1
 */