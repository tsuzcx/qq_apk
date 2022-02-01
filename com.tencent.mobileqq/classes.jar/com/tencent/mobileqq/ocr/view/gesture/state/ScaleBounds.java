package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;
import com.tencent.mobileqq.ocr.view.gesture.utils.MathUtils;

public class ScaleBounds
{
  private static final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_a_of_type_Float;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private float b;
  private float c;
  
  public ScaleBounds(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(float paramFloat1, float paramFloat2)
  {
    return MathUtils.a(paramFloat1, this.jdField_a_of_type_Float / paramFloat2, this.b * paramFloat2);
  }
  
  public ScaleBounds a(State paramState)
  {
    float f5 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e();
    float f6 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f();
    float f7 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c();
    float f8 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d();
    if ((f5 != 0.0F) && (f6 != 0.0F) && (f7 != 0.0F) && (f8 != 0.0F))
    {
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a();
      this.b = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.b();
      float f9 = paramState.d();
      float f3 = f5;
      float f1 = f6;
      float f2 = f7;
      float f4 = f8;
      if (!State.a(f9, 0.0F)) {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a() == Settings.Fit.OUTSIDE)
        {
          jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-f9);
          jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f7, f8);
          jdField_a_of_type_AndroidGraphicsMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
          f2 = jdField_a_of_type_AndroidGraphicsRectF.width();
          f4 = jdField_a_of_type_AndroidGraphicsRectF.height();
          f3 = f5;
          f1 = f6;
        }
        else
        {
          jdField_a_of_type_AndroidGraphicsMatrix.setRotate(f9);
          jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f5, f6);
          jdField_a_of_type_AndroidGraphicsMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
          f3 = jdField_a_of_type_AndroidGraphicsRectF.width();
          f1 = jdField_a_of_type_AndroidGraphicsRectF.height();
          f4 = f8;
          f2 = f7;
        }
      }
      int i = ScaleBounds.1.a[this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a().ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              f1 = this.jdField_a_of_type_Float;
              if (f1 <= 0.0F) {
                f1 = 1.0F;
              }
              this.c = f1;
            }
            else
            {
              this.c = Math.max(f2 / f3, f4 / f1);
            }
          }
          else {
            this.c = Math.min(f2 / f3, f4 / f1);
          }
        }
        else {
          this.c = (f4 / f1);
        }
      }
      else {
        this.c = (f2 / f3);
      }
      if (this.jdField_a_of_type_Float <= 0.0F) {
        this.jdField_a_of_type_Float = this.c;
      }
      if (this.b <= 0.0F) {
        this.b = this.c;
      }
      if (this.c > this.b) {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a()) {
          this.b = this.c;
        } else {
          this.c = this.b;
        }
      }
      f1 = this.jdField_a_of_type_Float;
      f2 = this.b;
      if (f1 > f2) {
        this.jdField_a_of_type_Float = f2;
      }
      if (this.c < this.jdField_a_of_type_Float)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a())
        {
          this.jdField_a_of_type_Float = this.c;
          return this;
        }
        this.c = this.jdField_a_of_type_Float;
      }
      return this;
    }
    this.c = 1.0F;
    this.b = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
    return this;
  }
  
  public float b()
  {
    return this.b;
  }
  
  public float c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.ScaleBounds
 * JD-Core Version:    0.7.0.1
 */