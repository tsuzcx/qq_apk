package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.presseffect.PressEffectHelper;

public class RoundRectUrlImageView
  extends URLImageView
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private Path f;
  private boolean g = false;
  
  public RoundRectUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundRectUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundRectUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.f = new Path();
    int i = this.a;
    if (i == 0)
    {
      this.f.addRect(0.0F, 0.0F, this.b, this.c, Path.Direction.CCW);
      return;
    }
    i = Math.min(i * 2, Math.min(this.b, this.c)) / 2;
    Path localPath = this.f;
    RectF localRectF = new RectF(0.0F, 0.0F, this.b, this.c);
    float f1 = i;
    localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CCW);
  }
  
  private void b()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    int i = ((Drawable)localObject).getIntrinsicWidth();
    int j = ((Drawable)localObject).getIntrinsicHeight();
    if ((i == this.d) && (j == this.e)) {
      return;
    }
    this.d = i;
    this.e = j;
    if ((this.d == 0) && (this.e == 0)) {
      return;
    }
    i = this.d;
    j = this.c;
    int k = this.b;
    int m = this.e;
    float f1;
    if (i * j > k * m) {
      f1 = j / m;
    } else {
      f1 = k / i;
    }
    localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    setImageMatrix((Matrix)localObject);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Integer localInteger;
    if (this.f != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.f);
    }
    else
    {
      localInteger = null;
    }
    super.dispatchDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b();
    Integer localInteger;
    if (this.f != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.f);
    }
    else
    {
      localInteger = null;
    }
    super.onDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if ((paramInt1 == this.b) && (paramInt2 == this.c)) {
      return;
    }
    this.b = paramInt1;
    this.c = paramInt2;
    a();
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isClickable()) && (isEnabled()) && (this.g))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          PressEffectHelper.b(this);
        }
        return super.onTouchEvent(paramMotionEvent);
      }
      PressEffectHelper.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAllRadius(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (this.a == i) {
      return;
    }
    this.a = i;
    a();
    invalidate();
  }
  
  public void setEnableEffect(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RoundRectUrlImageView
 * JD-Core Version:    0.7.0.1
 */