package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;

public class BusinessCardChildViewTransform
{
  public float a;
  public int a;
  public Rect a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  
  public BusinessCardChildViewTransform()
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public static void a(View paramView)
  {
    ViewHelper.f(paramView, 0.0F);
    ViewHelper.g(paramView, 0.0F);
    ViewHelper.b(paramView, 1.0F);
    ViewHelper.c(paramView, 1.0F);
    ViewHelper.a(paramView, 1.0F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.c = 0.0F;
  }
  
  public void a(View paramView, int paramInt, Interpolator paramInterpolator, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b(ViewHelper.b(paramView))) {
      ViewHelper.g(paramView, this.jdField_b_of_type_Int);
    }
    if (a(ViewHelper.a(paramView)))
    {
      ViewHelper.b(paramView, this.jdField_a_of_type_Float);
      ViewHelper.c(paramView, this.jdField_a_of_type_Float);
    }
  }
  
  public boolean a(float paramFloat)
  {
    return Float.compare(this.jdField_a_of_type_Float, paramFloat) != 0;
  }
  
  public boolean b(float paramFloat)
  {
    return Float.compare(this.jdField_b_of_type_Int, paramFloat) != 0;
  }
  
  public String toString()
  {
    return "TaskViewTransform delay: " + this.jdField_a_of_type_Int + " y: " + this.jdField_b_of_type_Int + " scale: " + this.jdField_a_of_type_Float + " alpha: " + this.jdField_b_of_type_Float + " visible: " + this.jdField_a_of_type_Boolean + " rect: " + this.jdField_a_of_type_AndroidGraphicsRect + " p: " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.helpers.BusinessCardChildViewTransform
 * JD-Core Version:    0.7.0.1
 */