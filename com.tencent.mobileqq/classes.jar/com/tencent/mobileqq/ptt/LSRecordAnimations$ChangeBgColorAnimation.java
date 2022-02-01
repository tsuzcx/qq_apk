package com.tencent.mobileqq.ptt;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public class LSRecordAnimations$ChangeBgColorAnimation
  extends Animation
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private LSRecordAnimations.TrackInfo jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
  private int b;
  
  public LSRecordAnimations$ChangeBgColorAnimation(View paramView, int paramInt1, int paramInt2, LSRecordAnimations.TrackInfo paramTrackInfo)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo = paramTrackInfo;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if ((paramTransformation != null) && ((paramTransformation instanceof LSRecordAnimations.LSRecordAnimationCallback))) {
      ((LSRecordAnimations.LSRecordAnimationCallback)paramTransformation).a(this, paramFloat);
    }
    paramTransformation = this.jdField_a_of_type_AndroidViewView;
    if (paramTransformation == null) {
      return;
    }
    int i = this.b;
    if (paramFloat < 1.0F)
    {
      i = Color.argb((int)(Color.alpha(this.jdField_a_of_type_Int) + (Color.alpha(this.b) - Color.alpha(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.red(this.jdField_a_of_type_Int) + (Color.red(this.b) - Color.red(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.green(this.jdField_a_of_type_Int) + (Color.green(this.b) - Color.green(this.jdField_a_of_type_Int)) * paramFloat), (int)(Color.blue(this.jdField_a_of_type_Int) + (Color.blue(this.b) - Color.blue(this.jdField_a_of_type_Int)) * paramFloat));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    }
    else
    {
      paramTransformation.setBackgroundColor(i);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    paramTransformation = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
    if (paramTransformation != null) {
      paramTransformation.jdField_a_of_type_Int = i;
    }
    if (QLog.isDevelopLevel())
    {
      paramTransformation = new StringBuilder();
      paramTransformation.append("LS applyTransformation: ");
      paramTransformation.append(paramFloat);
      paramTransformation.append(" CLR: ");
      paramTransformation.append(i);
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
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordAnimations.ChangeBgColorAnimation
 * JD-Core Version:    0.7.0.1
 */