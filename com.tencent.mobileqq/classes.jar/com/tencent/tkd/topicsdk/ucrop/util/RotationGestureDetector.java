package com.tencent.tkd.topicsdk.ucrop.util;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/util/RotationGestureDetector;", "", "mListener", "Lcom/tencent/tkd/topicsdk/ucrop/util/RotationGestureDetector$OnRotationGestureListener;", "(Lcom/tencent/tkd/topicsdk/ucrop/util/RotationGestureDetector$OnRotationGestureListener;)V", "<set-?>", "", "angle", "getAngle", "()F", "fX", "fY", "mIsFirstTouch", "", "mPointerIndex1", "", "mPointerIndex2", "sX", "sY", "calculateAngleBetweenLines", "fx1", "fy1", "fx2", "fy2", "sx1", "sy1", "sx2", "sy2", "calculateAngleDelta", "angleFrom", "angleTo", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "OnRotationGestureListener", "SimpleOnRotationGestureListener", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class RotationGestureDetector
{
  public static final RotationGestureDetector.Companion a = new RotationGestureDetector.Companion(null);
  private float b;
  private float c;
  private float d;
  private float e;
  private int f;
  private int g;
  private float h;
  private boolean i;
  private final RotationGestureDetector.OnRotationGestureListener j;
  
  public RotationGestureDetector(@Nullable RotationGestureDetector.OnRotationGestureListener paramOnRotationGestureListener)
  {
    this.j = paramOnRotationGestureListener;
    this.f = -1;
    this.g = -1;
  }
  
  private final float a(float paramFloat1, float paramFloat2)
  {
    this.h = (paramFloat2 % 360.0F - paramFloat1 % 360.0F);
    paramFloat1 = this.h;
    if (paramFloat1 < -180.0F) {
      this.h = (paramFloat1 + 360.0F);
    } else if (paramFloat1 > 180.0F) {
      this.h = (paramFloat1 - 360.0F);
    }
    return this.h;
  }
  
  private final float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return a((float)Math.toDegrees(Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3)), (float)Math.toDegrees(Math.atan2(paramFloat6 - paramFloat8, paramFloat5 - paramFloat7)));
  }
  
  public final float a()
  {
    return this.h;
  }
  
  public final boolean a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 5)
          {
            if (k != 6) {
              return true;
            }
            this.g = -1;
            return true;
          }
          this.b = paramMotionEvent.getX();
          this.c = paramMotionEvent.getY();
          this.g = paramMotionEvent.findPointerIndex(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
          this.h = 0.0F;
          this.i = true;
          return true;
        }
        if ((this.f != -1) && (this.g != -1) && (paramMotionEvent.getPointerCount() > this.g))
        {
          float f1 = paramMotionEvent.getX(this.f);
          float f2 = paramMotionEvent.getY(this.f);
          float f3 = paramMotionEvent.getX(this.g);
          float f4 = paramMotionEvent.getY(this.g);
          if (this.i)
          {
            this.h = 0.0F;
            this.i = false;
          }
          else
          {
            a(this.b, this.c, this.d, this.e, f3, f4, f1, f2);
          }
          paramMotionEvent = this.j;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(this);
          }
          this.b = f3;
          this.c = f4;
          this.d = f1;
          this.e = f2;
          return true;
        }
      }
      else
      {
        this.f = -1;
        return true;
      }
    }
    else
    {
      this.d = paramMotionEvent.getX();
      this.e = paramMotionEvent.getY();
      this.f = paramMotionEvent.findPointerIndex(paramMotionEvent.getPointerId(0));
      this.h = 0.0F;
      this.i = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector
 * JD-Core Version:    0.7.0.1
 */