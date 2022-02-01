package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;

public class SectorProgressView
  extends View
{
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private static Bitmap k;
  private static Rect l;
  public boolean a = false;
  private int b;
  private boolean c;
  private Paint d;
  private Rect e = new Rect();
  private RectF f = new RectF();
  private Rect m = new Rect();
  
  public SectorProgressView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public SectorProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public SectorProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    if (g == 0) {
      g = DisplayUtil.a(getContext(), 26.0F);
    }
    if (h == 0) {
      h = DisplayUtil.a(getContext(), 3.0F);
    }
    if (i == 0) {
      i = DisplayUtil.a(getContext(), 18.0F);
    }
    if (j == 0) {
      j = DisplayUtil.a(getContext(), 8.0F);
    }
    if (k == null)
    {
      k = ImageUtil.a(getResources(), 2130849297);
      l = new Rect(0, 0, k.getWidth(), k.getHeight());
    }
  }
  
  public void a()
  {
    boolean bool = this.c;
    this.c = true;
    if (!bool) {
      invalidate();
    }
  }
  
  public void b()
  {
    boolean bool = this.c;
    this.c = false;
    if (bool) {
      invalidate();
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d == null)
    {
      this.d = new Paint();
      this.d.setAntiAlias(true);
    }
    this.e.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    int n;
    int i1;
    int i2;
    int i3;
    if (this.c)
    {
      this.d.setColor(1073741824);
      paramCanvas.drawRect(this.e, this.d);
      float f1 = this.b * 360 / 100;
      n = (getMeasuredWidth() - g) / 2;
      i1 = (getMeasuredHeight() - g) / 2;
      i2 = (getMeasuredWidth() + g) / 2;
      i3 = (getMeasuredWidth() + g) / 2;
      this.f.set(n, i1, i2, i3);
      this.d.setColor(-8354924);
      this.d.setStrokeWidth(h);
      this.d.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, g / 2, this.d);
      this.d.setColor(-13646081);
      paramCanvas.drawArc(this.f, -90.0F, -f1, false, this.d);
      return;
    }
    if (this.a)
    {
      n = getMeasuredWidth() - j - i;
      i2 = getMeasuredHeight();
      i3 = j;
      i1 = i;
      i2 = i2 - i3 - i1;
      this.m.set(n, i2, n + i1, i1 + i2);
      paramCanvas.drawBitmap(k, l, this.m, this.d);
    }
  }
  
  public void setProgress(int paramInt)
  {
    int n = this.b;
    this.b = paramInt;
    if (n != this.b) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.SectorProgressView
 * JD-Core Version:    0.7.0.1
 */