package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class NumberProgressBar
  extends View
{
  protected final RectF a;
  protected int b;
  protected final Paint c;
  protected float d;
  protected int e = -1;
  protected String f;
  private Rect g;
  
  public NumberProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NumberProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = DisplayUtil.a(paramContext, 5.0F);
    this.f = "xx";
    this.d = 0.0F;
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.a = new RectF();
    this.g = new Rect();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = Math.min(paramCanvas.getHeight(), paramCanvas.getWidth()) / 2 - this.b / 2;
    float f2 = paramCanvas.getWidth();
    f1 *= 2.0F;
    f2 = (f2 - f1) / 2.0F;
    float f3 = (paramCanvas.getHeight() - f1) / 2.0F;
    float f4 = this.b / 2;
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.b);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.a.set(f2 + f4, f3 + f4, f2 + f1 - f4, f3 + f1 - f4);
    this.c.setColor(1073741823);
    paramCanvas.drawArc(this.a, 0.0F, 360.0F, false, this.c);
    int i = this.e;
    if (i != 0)
    {
      this.c.setColor(i);
      paramCanvas.drawArc(this.a, -90.0F, -this.d, false, this.c);
    }
    else
    {
      paramCanvas.drawArc(this.a, -90.0F, -this.d, false, this.c);
    }
    double d1 = this.d;
    Double.isNaN(d1);
    i = -(int)(d1 / 3.6D);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.c.setShader(null);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(-1);
    this.c.setTextSize(DisplayUtil.c(getContext(), 16.0F));
    this.c.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.g);
    i = this.g.width();
    int j = this.g.height();
    String str = this.f;
    if ((str != null) && (!str.isEmpty()))
    {
      paramCanvas.drawText((String)localObject, (paramCanvas.getWidth() - i) / 2, (paramCanvas.getHeight() + j) / 2, this.c);
      this.c.setTextSize(DisplayUtil.c(getContext(), 16.0F));
      return;
    }
    paramCanvas.drawText((String)localObject, (paramCanvas.getWidth() - i) / 2, (paramCanvas.getHeight() + j) / 2, this.c);
  }
  
  public void setProgress(float paramFloat)
  {
    this.d = (paramFloat * -360.0F);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.NumberProgressBar
 * JD-Core Version:    0.7.0.1
 */