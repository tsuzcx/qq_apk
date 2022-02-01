package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;

public class TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation
  extends Animation
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateMapViewSupportActivity.a.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int + this.b * paramFloat));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateMapViewSupportActivity.a.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation
 * JD-Core Version:    0.7.0.1
 */