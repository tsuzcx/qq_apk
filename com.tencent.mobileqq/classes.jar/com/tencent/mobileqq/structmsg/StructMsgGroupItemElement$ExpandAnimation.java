package com.tencent.mobileqq.structmsg;

import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class StructMsgGroupItemElement$ExpandAnimation
  extends Animation
{
  int jdField_a_of_type_Int;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  public StructMsgGroupItemElement$ExpandAnimation(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.measure(i, j);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.getMeasuredHeight();
    paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramViewGroup.height = 0;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupItemElement.ExpandAnimation
 * JD-Core Version:    0.7.0.1
 */