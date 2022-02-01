package com.tencent.mobileqq.olympic.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class ARTipsCircleProgress
  extends TextView
{
  private int a;
  private int b = 8;
  private int c = getResources().getColor(2131165626);
  private int d = -1;
  private Paint e;
  private RectF f;
  
  public ARTipsCircleProgress(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARTipsCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARTipsCircleProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.e == null)
    {
      this.e = new Paint();
      this.e.setStyle(Paint.Style.STROKE);
      this.e.setStrokeWidth(this.b);
      this.e.setAntiAlias(true);
    }
    if (this.f != null)
    {
      this.e.setColor(this.d);
      paramCanvas.drawArc(this.f, -90.0F, 360.0F, false, this.e);
      this.e.setColor(this.c);
      paramCanvas.drawArc(this.f, -90.0F, this.a / 100.0F * 360.0F, false, this.e);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f == null) {
      this.f = new RectF();
    }
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    RectF localRectF = this.f;
    paramInt3 = this.b;
    localRectF.left = (paramInt3 / 2);
    localRectF.top = (paramInt3 / 2);
    localRectF.right = (paramInt1 - paramInt3 / 2);
    localRectF.bottom = (paramInt2 - paramInt3 / 2);
  }
  
  public void setProgress(int paramInt)
  {
    this.a = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("%");
    setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsCircleProgress
 * JD-Core Version:    0.7.0.1
 */