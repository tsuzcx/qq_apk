package com.tencent.mobileqq.ptt;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$TrackAlphaAnimation
  extends AlphaAnimation
{
  private float a;
  private float b;
  private LSRecordAnimations.TrackInfo c;
  private Animation.AnimationListener d;
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.d;
    if ((paramTransformation != null) && ((paramTransformation instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)paramTransformation).a(this, paramFloat);
    }
    float f = 0.0F;
    paramTransformation = this.c;
    if (paramTransformation != null)
    {
      f = this.a;
      f += (this.b - f) * paramFloat;
      paramTransformation.c = f;
    }
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" Alpha: ");
      paramTransformation.append(f);
      QLog.d("LsRecord", 4, paramTransformation.toString());
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    super.setAnimationListener(paramAnimationListener);
    this.d = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordAnimations.TrackAlphaAnimation
 * JD-Core Version:    0.7.0.1
 */