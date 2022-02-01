package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class GradientProgressView
  extends View
{
  int a = 5;
  int b = 0;
  SweepGradient c;
  int d = 0;
  int e = -1;
  Paint f = new Paint();
  RectF g;
  
  public GradientProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int i = this.d;
      int j = this.e;
      this.c = new SweepGradient(paramInt1 / 2, paramInt2 / 2, new int[] { i, j }, new float[] { 0.0F, 1.0F });
      i = this.a;
      this.g = new RectF(i, i, paramInt1 - i, paramInt2 - i);
      this.f.setStrokeWidth(this.a);
      this.f.setAntiAlias(true);
      this.f.setStyle(Paint.Style.STROKE);
      this.f.setShader(this.c);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.b += 3;
    int k = this.b;
    if (k > 360) {
      this.b = (k - 360);
    }
    paramCanvas.rotate(this.b, i / 2, j / 2);
    paramCanvas.drawArc(this.g, 0.0F, 360.0F, true, this.f);
    postInvalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setEndColor(int paramInt)
  {
    this.e = paramInt;
    a(getWidth(), getHeight());
  }
  
  public void setStartColor(int paramInt)
  {
    this.d = paramInt;
    a(getWidth(), getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GradientProgressView
 * JD-Core Version:    0.7.0.1
 */