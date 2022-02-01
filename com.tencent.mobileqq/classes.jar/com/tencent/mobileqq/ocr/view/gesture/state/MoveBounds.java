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
  private static final Matrix a = new Matrix();
  private static final float[] b = new float[2];
  private static final Point c = new Point();
  private static final Rect d = new Rect();
  private static final RectF e = new RectF();
  private final Settings f;
  private final RectF g = new RectF();
  private float h;
  private float i;
  private float j;
  
  public MoveBounds(Settings paramSettings)
  {
    this.f = paramSettings;
  }
  
  private void a(Rect paramRect)
  {
    GravityUtils.a(this.f, c);
    b[0] = c.x;
    b[1] = c.y;
    if (!State.c(this.h, 0.0F))
    {
      a.setRotate(-this.h, this.i, this.j);
      a.mapPoints(b);
    }
    this.g.left = (b[0] - paramRect.width());
    RectF localRectF = this.g;
    float[] arrayOfFloat = b;
    localRectF.right = arrayOfFloat[0];
    localRectF.top = (arrayOfFloat[1] - paramRect.height());
    this.g.bottom = b[1];
  }
  
  private void a(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width())
    {
      this.g.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
      this.g.right = paramRectF.left;
    }
    else
    {
      RectF localRectF = this.g;
      f1 = paramRect.left;
      localRectF.right = f1;
      localRectF.left = f1;
    }
    if (paramRectF.height() < paramRect.height())
    {
      this.g.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.g.bottom = paramRectF.top;
      return;
    }
    paramRectF = this.g;
    float f1 = paramRect.top;
    paramRectF.bottom = f1;
    paramRectF.top = f1;
  }
  
  private void b(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width())
    {
      this.g.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
      this.g.right = paramRectF.left;
    }
    else
    {
      this.g.left = paramRectF.left;
      this.g.right = (paramRectF.right - paramRect.width());
    }
    if (paramRectF.height() < paramRect.height())
    {
      this.g.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.g.bottom = paramRectF.top;
      return;
    }
    this.g.top = paramRectF.top;
    this.g.bottom = (paramRectF.bottom - paramRect.height());
  }
  
  private void c(RectF paramRectF, Rect paramRect)
  {
    this.g.left = (paramRectF.left - paramRect.width());
    this.g.right = paramRectF.right;
    this.g.top = (paramRectF.top - paramRect.height());
    this.g.bottom = paramRectF.bottom;
  }
  
  public MoveBounds a(State paramState)
  {
    Object localObject = e;
    GravityUtils.a(this.f, d);
    ((RectF)localObject).set(d);
    Rect localRect = d;
    if (this.f.q() == Settings.Fit.OUTSIDE)
    {
      this.h = paramState.e();
      this.i = ((RectF)localObject).centerX();
      this.j = ((RectF)localObject).centerY();
      if (!State.c(this.h, 0.0F))
      {
        a.setRotate(-this.h, this.i, this.j);
        a.mapRect((RectF)localObject);
      }
    }
    else
    {
      this.h = 0.0F;
      this.j = 0.0F;
      this.i = 0.0F;
    }
    paramState.a(a);
    if (!State.c(this.h, 0.0F)) {
      a.postRotate(-this.h, this.i, this.j);
    }
    GravityUtils.a(a, this.f, localRect);
    int k = MoveBounds.1.a[this.f.r().ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            this.g.set(-5.368709E+008F, -5.368709E+008F, 5.368709E+008F, 5.368709E+008F);
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
    if (this.f.q() != Settings.Fit.OUTSIDE)
    {
      paramState.a(a);
      paramState = e;
      paramState.set(0.0F, 0.0F, this.f.g(), this.f.h());
      a.mapRect(paramState);
      localObject = b;
      localObject[1] = 0.0F;
      localObject[0] = 0.0F;
      a.mapPoints((float[])localObject);
      this.g.offset(b[0] - paramState.left, b[1] - paramState.top);
    }
    return this;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = b;
    localObject[0] = paramFloat1;
    localObject[1] = paramFloat2;
    paramFloat1 = this.h;
    if (paramFloat1 != 0.0F)
    {
      a.setRotate(-paramFloat1, this.i, this.j);
      a.mapPoints(b);
    }
    localObject = this.g;
    float[] arrayOfFloat = b;
    ((RectF)localObject).union(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    float[] arrayOfFloat = b;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    paramFloat1 = this.h;
    if (paramFloat1 != 0.0F)
    {
      a.setRotate(-paramFloat1, this.i, this.j);
      a.mapPoints(b);
    }
    arrayOfFloat = b;
    arrayOfFloat[0] = MathUtils.a(arrayOfFloat[0], this.g.left - paramFloat3, this.g.right + paramFloat3);
    arrayOfFloat = b;
    arrayOfFloat[1] = MathUtils.a(arrayOfFloat[1], this.g.top - paramFloat4, this.g.bottom + paramFloat4);
    paramFloat1 = this.h;
    if (paramFloat1 != 0.0F)
    {
      a.setRotate(paramFloat1, this.i, this.j);
      a.mapPoints(b);
    }
    arrayOfFloat = b;
    paramPointF.set(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    a(paramFloat1, paramFloat2, 0.0F, 0.0F, paramPointF);
  }
  
  public void a(RectF paramRectF)
  {
    float f1 = this.h;
    if (f1 == 0.0F)
    {
      paramRectF.set(this.g);
      return;
    }
    a.setRotate(f1, this.i, this.j);
    a.mapRect(paramRectF, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.MoveBounds
 * JD-Core Version:    0.7.0.1
 */