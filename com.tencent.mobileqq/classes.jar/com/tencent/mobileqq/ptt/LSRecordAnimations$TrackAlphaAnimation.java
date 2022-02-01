package com.tencent.mobileqq.ptt;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$TrackAlphaAnimation
  extends AlphaAnimation
{
  private float jdField_a_of_type_Float;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private LSRecordAnimations.TrackInfo jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
  private float b;
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if ((paramTransformation != null) && ((paramTransformation instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)paramTransformation).a(this, paramFloat);
    }
    float f = 0.0F;
    paramTransformation = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
    if (paramTransformation != null)
    {
      f = this.jdField_a_of_type_Float;
      f += (this.b - f) * paramFloat;
      paramTransformation.b = f;
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
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordAnimations.TrackAlphaAnimation
 * JD-Core Version:    0.7.0.1
 */