package com.tencent.mobileqq.colornote.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircularRevealCompatLayout
  extends FrameLayout
{
  private float a;
  private float b;
  private float c;
  private final Path d = new Path();
  private boolean e;
  private RectF f = new RectF();
  private float g;
  private final Path h = new Path();
  private boolean i;
  
  public CircularRevealCompatLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealCompatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularRevealCompatLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.e)
    {
      if (!this.d.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.d);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    if (this.i)
    {
      if (!this.h.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.h);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public float getRadius()
  {
    if (this.e) {
      return this.c;
    }
    return -1.0F;
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.i = false;
      invalidate();
      return;
    }
    this.i = true;
    this.f.set(paramRectF);
    this.g = paramFloat;
    this.h.reset();
    paramRectF = this.h;
    RectF localRectF = this.f;
    paramFloat = this.g;
    paramRectF.addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
    this.h.close();
  }
  
  public void setEnableClip(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setRevealClip(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    float f1 = getWidth() - paramFloat1;
    float f2 = getWidth() - paramFloat2;
    boolean bool;
    if (Math.max(paramFloat1 * paramFloat1, f1 * f1) + Math.max(paramFloat2 * paramFloat2, f2 * f2) > paramFloat3 * paramFloat3) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    this.d.reset();
    this.d.addCircle(this.a, this.b, this.c, Path.Direction.CW);
    this.d.close();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.CircularRevealCompatLayout
 * JD-Core Version:    0.7.0.1
 */