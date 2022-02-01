package com.tencent.mobileqq.nearby.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class GradientAnimTextView
  extends TextView
{
  private LinearGradient a;
  private Matrix b;
  private Paint c;
  private int d = 0;
  private int e = 0;
  private int f = -1;
  private int g = -1;
  private ValueAnimator h;
  
  public GradientAnimTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientAnimTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GradientAnimTextView);
    this.f = paramContext.getColor(1, -1);
    this.g = paramContext.getColor(0, -1);
    paramContext.recycle();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.h;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.h.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.h == null)
    {
      this.h = ValueAnimator.ofInt(new int[] { 0, this.d * 2 });
      this.h.setDuration(1500L);
      this.h.setInterpolator(new LinearInterpolator());
      this.h.setRepeatCount(-1);
      this.h.addUpdateListener(new GradientAnimTextView.1(this));
      this.h.start();
    }
    paramCanvas = this.b;
    if (paramCanvas != null)
    {
      paramCanvas.setTranslate(this.e, 0.0F);
      this.a.setLocalMatrix(this.b);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f != -1)
    {
      if (this.g == -2) {
        return;
      }
      if (this.d == 0)
      {
        this.d = getMeasuredWidth();
        if (this.d > 0)
        {
          this.c = getPaint();
          paramInt1 = this.d;
          float f1 = paramInt1 * -2;
          float f2 = paramInt1;
          paramInt1 = this.f;
          paramInt2 = this.g;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          this.a = new LinearGradient(f1, 0.0F, f2, 0.0F, new int[] { paramInt1, paramInt2, paramInt1, paramInt2 }, null, localTileMode);
          this.c.setShader(this.a);
          this.b = new Matrix();
        }
      }
    }
  }
  
  public void setGradientAnimColor(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.GradientAnimTextView
 * JD-Core Version:    0.7.0.1
 */