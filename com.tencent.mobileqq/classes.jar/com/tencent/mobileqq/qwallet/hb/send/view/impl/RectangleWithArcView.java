package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;

public class RectangleWithArcView
  extends View
{
  private Paint a;
  private Path b;
  private String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public RectangleWithArcView(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramContext);
    this.c = paramString;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
    this.a = new Paint();
    this.b = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      this.a.setColor(Color.parseColor(this.c));
      this.a.setStyle(Paint.Style.FILL);
      this.b.moveTo(this.d, this.e - 200);
      this.b.lineTo(this.d, this.e - this.g);
      this.b.quadTo(this.h, this.i, this.d + this.f, this.e - this.g);
      this.b.lineTo(this.d + this.f, this.e);
      this.b.lineTo(this.d, this.e);
      this.b.close();
      paramCanvas.drawPath(this.b, this.a);
      return;
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RectangleWithArcView
 * JD-Core Version:    0.7.0.1
 */