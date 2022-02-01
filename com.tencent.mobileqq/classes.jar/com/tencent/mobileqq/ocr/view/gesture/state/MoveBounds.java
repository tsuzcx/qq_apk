package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;
import com.tencent.mobileqq.ocr.view.gesture.utils.GravityUtils;
import com.tencent.mobileqq.ocr.view.gesture.utils.MathUtils;

public class MoveBounds
{
  private static final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private static final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private float jdField_a_of_type_Float;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private float jdField_b_of_type_Float;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private float c;
  
  public MoveBounds(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
  }
  
  private void a(Rect paramRect)
  {
    GravityUtils.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsPoint);
    jdField_a_of_type_ArrayOfFloat[0] = jdField_a_of_type_AndroidGraphicsPoint.x;
    jdField_a_of_type_ArrayOfFloat[1] = jdField_a_of_type_AndroidGraphicsPoint.y;
    if (!State.a(this.jdField_a_of_type_Float, 0.0F))
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.left = (jdField_a_of_type_ArrayOfFloat[0] - paramRect.width());
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    localRectF.right = arrayOfFloat[0];
    localRectF.top = (arrayOfFloat[1] - paramRect.height());
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = jdField_a_of_type_ArrayOfFloat[1];
  }
  
  private void a(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width())
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
      this.jdField_b_of_type_AndroidGraphicsRectF.right = paramRectF.left;
    }
    else
    {
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      f = paramRect.left;
      localRectF.right = f;
      localRectF.left = f;
    }
    if (paramRectF.height() < paramRect.height())
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = paramRectF.top;
      return;
    }
    paramRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f = paramRect.top;
    paramRectF.bottom = f;
    paramRectF.top = f;
  }
  
  private void b(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width())
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
      this.jdField_b_of_type_AndroidGraphicsRectF.right = paramRectF.left;
    }
    else
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = paramRectF.left;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = (paramRectF.right - paramRect.width());
    }
    if (paramRectF.height() < paramRect.height())
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = paramRectF.top;
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.top = paramRectF.top;
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (paramRectF.bottom - paramRect.height());
  }
  
  private void c(RectF paramRectF, Rect paramRect)
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.left = (paramRectF.left - paramRect.width());
    this.jdField_b_of_type_AndroidGraphicsRectF.right = paramRectF.right;
    this.jdField_b_of_type_AndroidGraphicsRectF.top = (paramRectF.top - paramRect.height());
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = paramRectF.bottom;
  }
  
  public MoveBounds a(State paramState)
  {
    Object localObject = jdField_a_of_type_AndroidGraphicsRectF;
    GravityUtils.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsRect);
    ((RectF)localObject).set(jdField_a_of_type_AndroidGraphicsRect);
    Rect localRect = jdField_a_of_type_AndroidGraphicsRect;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a() == Settings.Fit.OUTSIDE)
    {
      this.jdField_a_of_type_Float = paramState.d();
      this.jdField_b_of_type_Float = ((RectF)localObject).centerX();
      this.c = ((RectF)localObject).centerY();
      if (!State.a(this.jdField_a_of_type_Float, 0.0F))
      {
        jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
        jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.c = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
    }
    paramState.a(jdField_a_of_type_AndroidGraphicsMatrix);
    if (!State.a(this.jdField_a_of_type_Float, 0.0F)) {
      jdField_a_of_type_AndroidGraphicsMatrix.postRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
    }
    GravityUtils.a(jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, localRect);
    int i = MoveBounds.1.a[this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            this.jdField_b_of_type_AndroidGraphicsRectF.set(-5.368709E+008F, -5.368709E+008F, 5.368709E+008F, 5.368709E+008F);
          } else {
            a(localRect);
          }
        }
        else {
          c((RectF)localObject, localRect);
        }
      }
      else {
        b((RectF)localObject, localRect);
      }
    }
    else {
      a((RectF)localObject, localRect);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a() != Settings.Fit.OUTSIDE)
    {
      paramState.a(jdField_a_of_type_AndroidGraphicsMatrix);
      paramState = jdField_a_of_type_AndroidGraphicsRectF;
      paramState.set(0.0F, 0.0F, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e(), this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f());
      jdField_a_of_type_AndroidGraphicsMatrix.mapRect(paramState);
      localObject = jdField_a_of_type_ArrayOfFloat;
      localObject[1] = 0.0F;
      localObject[0] = 0.0F;
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints((float[])localObject);
      this.jdField_b_of_type_AndroidGraphicsRectF.offset(jdField_a_of_type_ArrayOfFloat[0] - paramState.left, jdField_a_of_type_ArrayOfFloat[1] - paramState.top);
    }
    return this;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = jdField_a_of_type_ArrayOfFloat;
    localObject[0] = paramFloat1;
    localObject[1] = paramFloat2;
    paramFloat1 = this.jdField_a_of_type_Float;
    if (paramFloat1 != 0.0F)
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-paramFloat1, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
    float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    ((RectF)localObject).union(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    paramFloat1 = this.jdField_a_of_type_Float;
    if (paramFloat1 != 0.0F)
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-paramFloat1, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] = MathUtils.a(arrayOfFloat[0], this.jdField_b_of_type_AndroidGraphicsRectF.left - paramFloat3, this.jdField_b_of_type_AndroidGraphicsRectF.right + paramFloat3);
    arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[1] = MathUtils.a(arrayOfFloat[1], this.jdField_b_of_type_AndroidGraphicsRectF.top - paramFloat4, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + paramFloat4);
    paramFloat1 = this.jdField_a_of_type_Float;
    if (paramFloat1 != 0.0F)
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(paramFloat1, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    paramPointF.set(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    a(paramFloat1, paramFloat2, 0.0F, 0.0F, paramPointF);
  }
  
  public void a(RectF paramRectF)
  {
    float f = this.jdField_a_of_type_Float;
    if (f == 0.0F)
    {
      paramRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
      return;
    }
    jdField_a_of_type_AndroidGraphicsMatrix.setRotate(f, this.jdField_b_of_type_Float, this.c);
    jdField_a_of_type_AndroidGraphicsMatrix.mapRect(paramRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.MoveBounds
 * JD-Core Version:    0.7.0.1
 */