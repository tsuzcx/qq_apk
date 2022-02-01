package com.tencent.mobileqq.medalwall;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class MedalGuideView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  MedalGuideView$4(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    this.a.d.setAlpha(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("translate")).floatValue();
    this.a.d.setTranslationY(f);
    f = paramValueAnimator.getAnimatedFraction();
    if ((!this.a.o) && (f >= 0.8857143F))
    {
      MedalGuideView localMedalGuideView = this.a;
      localMedalGuideView.o = true;
      localMedalGuideView.a.sendEmptyMessage(4);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "send MSG_START_3D_ROTATE");
      }
    }
    if (f >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView.4
 * JD-Core Version:    0.7.0.1
 */