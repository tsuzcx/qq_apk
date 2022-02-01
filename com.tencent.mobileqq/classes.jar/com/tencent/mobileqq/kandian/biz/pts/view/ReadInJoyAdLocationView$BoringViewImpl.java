package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

class ReadInJoyAdLocationView$BoringViewImpl
  extends LinearLayout
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = -16777216;
  private Paint h;
  private Paint i;
  
  public ReadInJoyAdLocationView$BoringViewImpl(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != 0)
    {
      if (this.h == null)
      {
        this.h = new Paint();
        this.h.setAntiAlias(true);
      }
      this.h.setColor(this.a);
      VirtualViewUtils.drawBackground(paramCanvas, this.h, getWidth(), getHeight(), this.f, this.b, this.c, this.d, this.e);
    }
    super.onDraw(paramCanvas);
    if (this.f > 0)
    {
      if (this.i == null)
      {
        this.i = new Paint();
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
      }
      this.i.setStrokeWidth(this.f);
      this.i.setColor(this.g);
      VirtualViewUtils.drawBorder(paramCanvas, this.i, getWidth(), getHeight(), this.f, this.b, this.c, this.d, this.e);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyAdLocationView.BoringViewImpl
 * JD-Core Version:    0.7.0.1
 */