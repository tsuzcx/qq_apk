package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class RefreshEyeView
  extends ImageView
{
  private PaintFlagsDrawFilter a;
  private double b = 0.0D;
  private double c = 0.2000000029802322D;
  private Bitmap d;
  private Paint e = new Paint();
  private Bitmap f;
  private Bitmap[] g = new Bitmap[19];
  private double h = 0.0D;
  private int i = 0;
  private boolean j = false;
  private long k = 0L;
  
  public RefreshEyeView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public RefreshEyeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public RefreshEyeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private int a(Context paramContext, double paramDouble)
  {
    double d1 = paramContext.getResources().getDisplayMetrics().density;
    Double.isNaN(d1);
    return (int)(paramDouble * d1 + 0.5D);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.e.reset();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    double d1 = this.h;
    int m = 0;
    while (m < paramInt1)
    {
      double d2 = paramInt1;
      Double.isNaN(d2);
      d2 = 2.827433388230814D / d2;
      double d3 = m;
      Double.isNaN(d3);
      d2 = Math.sin(d2 * d3 + this.b);
      d3 = paramInt2;
      Double.isNaN(d3);
      d2 = (float)(d2 * 15.0D + d3 * ((1.0D - d1) * 2.5D - 0.2D));
      float f1 = m;
      localCanvas.drawLine(f1, paramInt2 * 4, f1, (float)d2, this.e);
      m += 1;
    }
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, this.e);
    return localBitmap;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return this.d;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  public void a()
  {
    this.j = true;
    this.i = 0;
  }
  
  public void b()
  {
    this.j = false;
  }
  
  public void c()
  {
    this.k = System.currentTimeMillis();
    this.a = new PaintFlagsDrawFilter(0, 3);
    setWillNotDraw(false);
    this.f = a(getResources().getDrawable(2130851465));
    this.e.setAntiAlias(true);
    this.g[0] = a(getResources().getDrawable(2130851446));
    this.g[1] = a(getResources().getDrawable(2130851447));
    this.g[2] = a(getResources().getDrawable(2130851448));
    this.g[3] = a(getResources().getDrawable(2130851449));
    this.g[4] = a(getResources().getDrawable(2130851450));
    this.g[5] = a(getResources().getDrawable(2130851451));
    this.g[6] = a(getResources().getDrawable(2130851452));
    this.g[7] = a(getResources().getDrawable(2130851453));
    this.g[8] = a(getResources().getDrawable(2130851454));
    this.g[9] = a(getResources().getDrawable(2130851455));
    this.g[10] = a(getResources().getDrawable(2130851456));
    this.g[11] = a(getResources().getDrawable(2130851457));
    this.g[12] = a(getResources().getDrawable(2130851458));
    this.g[13] = a(getResources().getDrawable(2130851459));
    this.g[14] = a(getResources().getDrawable(2130851460));
    this.g[15] = a(getResources().getDrawable(2130851461));
    this.g[16] = a(getResources().getDrawable(2130851462));
    this.g[17] = a(getResources().getDrawable(2130851463));
    this.g[18] = a(getResources().getDrawable(2130851464));
  }
  
  public double getWaveHeightPercent()
  {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawBitmap(this.f, 0.0F, 0.0F, null);
    if (!this.j)
    {
      paramCanvas.setDrawFilter(this.a);
      Bitmap localBitmap = this.d;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(a(localBitmap, localBitmap.getWidth(), this.d.getHeight()), 0.0F, 0.0F, null);
      }
      if (this.b > 999999999.0D) {
        this.b = 0.0D;
      }
      this.b += this.c;
    }
    else
    {
      long l = System.currentTimeMillis();
      paramCanvas.drawBitmap(this.d, 0.0F, 0.0F, null);
      if (l >= this.k + 55L)
      {
        this.i = ((this.i + 1) % 19);
        paramCanvas.drawBitmap(this.g[this.i], a(getContext(), 11.0D), a(getContext(), 8.0D), null);
        this.k = l;
      }
      else
      {
        paramCanvas.drawBitmap(this.g[this.i], a(getContext(), 11.0D), a(getContext(), 8.0D), null);
      }
    }
    postDelayed(new RefreshEyeView.1(this), 10L);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    this.d = a(paramDrawable);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setWaveHeightPercent(double paramDouble)
  {
    this.h = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshEyeView
 * JD-Core Version:    0.7.0.1
 */