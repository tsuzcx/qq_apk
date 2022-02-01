package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CircularProgressBar
  extends View
{
  private int a = 60;
  private int b = 5;
  private int c = 5;
  private int d = -1442840576;
  private int e = -1428300323;
  private Paint f = new Paint();
  private Paint g = new Paint();
  private RectF h = new RectF();
  private RectF i = new RectF();
  private int j = 2;
  private int k = 0;
  private Handler l = new CircularProgressBar.1(this);
  private int m = 0;
  private boolean n = false;
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.f.setColor(this.d);
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setStrokeWidth(this.b);
    this.g.setColor(this.e);
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeWidth(this.c);
  }
  
  private void b()
  {
    this.h = new RectF(0.0F, 0.0F, getLayoutParams().width, getLayoutParams().height);
    int i1 = this.b;
    this.i = new RectF(i1, i1, getLayoutParams().width - this.b, getLayoutParams().height - this.b);
  }
  
  public int getBarColor()
  {
    return this.d;
  }
  
  public int getBarLength()
  {
    return this.a;
  }
  
  public int getBarWidth()
  {
    return this.b;
  }
  
  public int getDelayMillis()
  {
    return this.k;
  }
  
  public int getRimColor()
  {
    return this.e;
  }
  
  public Shader getRimShader()
  {
    return this.g.getShader();
  }
  
  public int getRimWidth()
  {
    return this.c;
  }
  
  public int getSpinSpeed()
  {
    return this.j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.i, 360.0F, 360.0F, false, this.g);
    if (this.n)
    {
      paramCanvas.drawArc(this.i, this.m - 90, this.a, false, this.f);
      return;
    }
    paramCanvas.drawArc(this.i, -90.0F, this.m, false, this.f);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
    a();
    invalidate();
  }
  
  public void setBarColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setBarLength(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setBarWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setDelayMillis(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.n = false;
    this.m = paramInt;
    this.l.sendEmptyMessage(0);
  }
  
  public void setRimColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setRimShader(Shader paramShader)
  {
    this.g.setShader(paramShader);
  }
  
  public void setRimWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSpinSpeed(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.CircularProgressBar
 * JD-Core Version:    0.7.0.1
 */