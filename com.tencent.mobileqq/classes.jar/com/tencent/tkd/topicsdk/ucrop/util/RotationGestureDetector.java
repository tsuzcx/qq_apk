package com.tencent.tkd.topicsdk.ucrop.util;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/util/RotationGestureDetector;", "", "mListener", "Lcom/tencent/tkd/topicsdk/ucrop/util/RotationGestureDetector$OnRotationGestureListener;", "(Lcom/tencent/tkd/topicsdk/ucrop/util/RotationGestureDetector$OnRotationGestureListener;)V", "<set-?>", "", "angle", "getAngle", "()F", "fX", "fY", "mIsFirstTouch", "", "mPointerIndex1", "", "mPointerIndex2", "sX", "sY", "calculateAngleBetweenLines", "fx1", "fy1", "fx2", "fy2", "sx1", "sy1", "sx2", "sy2", "calculateAngleDelta", "angleFrom", "angleTo", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "OnRotationGestureListener", "SimpleOnRotationGestureListener", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class RotationGestureDetector
{
  public static final RotationGestureDetector.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final RotationGestureDetector.OnRotationGestureListener jdField_a_of_type_ComTencentTkdTopicsdkUcropUtilRotationGestureDetector$OnRotationGestureListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  private float d;
  private float e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkUcropUtilRotationGestureDetector$Companion = new RotationGestureDetector.Companion(null);
  }
  
  public RotationGestureDetector(@Nullable RotationGestureDetector.OnRotationGestureListener paramOnRotationGestureListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropUtilRotationGestureDetector$OnRotationGestureListener = paramOnRotationGestureListener;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  private final float a(float paramFloat1, float paramFloat2)
  {
    this.e = (paramFloat2 % 360.0F - paramFloat1 % 360.0F);
    paramFloat1 = this.e;
    if (paramFloat1 < -180.0F) {
      this.e = (paramFloat1 + 360.0F);
    } else if (paramFloat1 > 180.0F) {
      this.e = (paramFloat1 - 360.0F);
    }
    return this.e;
  }
  
  private final float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return a((float)Math.toDegrees(Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3)), (float)Math.toDegrees(Math.atan2(paramFloat6 - paramFloat8, paramFloat5 - paramFloat7)));
  }
  
  public final float a()
  {
    return this.e;
  }
  
  public final boolean a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5)
          {
            if (i != 6) {
              return true;
            }
            this.jdField_b_of_type_Int = -1;
            return true;
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.jdField_b_of_type_Float = paramMotionEvent.getY();
          this.jdField_b_of_type_Int = paramMotionEvent.findPointerIndex(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
          this.e = 0.0F;
          this.jdField_a_of_type_Boolean = true;
          return true;
        }
        if ((this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1) && (paramMotionEvent.getPointerCount() > this.jdField_b_of_type_Int))
        {
          float f1 = paramMotionEvent.getX(this.jdField_a_of_type_Int);
          float f2 = paramMotionEvent.getY(this.jdField_a_of_type_Int);
          float f3 = paramMotionEvent.getX(this.jdField_b_of_type_Int);
          float f4 = paramMotionEvent.getY(this.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_Boolean)
          {
            this.e = 0.0F;
            this.jdField_a_of_type_Boolean = false;
          }
          else
          {
            a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c, this.d, f3, f4, f1, f2);
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropUtilRotationGestureDetector$OnRotationGestureListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(this);
          }
          this.jdField_a_of_type_Float = f3;
          this.jdField_b_of_type_Float = f4;
          this.c = f1;
          this.d = f2;
          return true;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = -1;
        return true;
      }
    }
    else
    {
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = paramMotionEvent.findPointerIndex(paramMotionEvent.getPointerId(0));
      this.e = 0.0F;
      this.jdField_a_of_type_Boolean = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector
 * JD-Core Version:    0.7.0.1
 */