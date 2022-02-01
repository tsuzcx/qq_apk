package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class LoadingView
  extends View
{
  private Paint a;
  private Paint b;
  private RectF c;
  private Rect d;
  private Rect e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public LoadingView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = new RectF();
    this.d = new Rect();
    this.e = new Rect();
    this.a = new Paint();
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(Color.parseColor("#E8E8E7"));
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setStrokeWidth(AIOUtils.b(2.0F, getResources()));
    this.b.setColor(Color.parseColor("#ffffff"));
    this.f = AIOUtils.b(28.0F, getResources());
    this.g = AIOUtils.b(100.0F, getResources());
    this.h = AIOUtils.b(15.0F, getResources());
    double d1 = DeviceInfoUtil.D();
    Double.isNaN(d1);
    this.j = ((int)(d1 * 0.29D));
    this.i = (this.j * 4 / 3);
    this.k = AIOUtils.b(9.0F, getResources());
    this.l = AIOUtils.b(18.0F, getResources());
  }
  
  private void a(Canvas paramCanvas)
  {
    this.c.left = (getLeft() + getPaddingLeft());
    RectF localRectF = this.c;
    localRectF.top = ((this.h + this.l * 2) / 2 - this.f / 2);
    localRectF.right = (localRectF.left + this.f);
    localRectF = this.c;
    localRectF.bottom = (localRectF.top + this.f);
    paramCanvas.drawRect(this.c, this.a);
  }
  
  private void b(Canvas paramCanvas)
  {
    this.d.left = ((int)(getLeft() + this.k + this.c.right));
    Rect localRect = this.d;
    localRect.top = this.l;
    localRect.right = (localRect.left + this.g);
    localRect = this.d;
    localRect.bottom = (localRect.top + this.h);
    paramCanvas.drawRect(this.d, this.a);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.e.left = (getLeft() + getPaddingLeft());
    this.e.top = (this.d.bottom + this.l);
    Rect localRect = this.e;
    localRect.right = (localRect.left + (int)DeviceInfoUtil.D());
    localRect = this.e;
    localRect.bottom = (localRect.top + this.i);
    paramCanvas.drawRect(this.e, this.a);
  }
  
  private void d(Canvas paramCanvas)
  {
    paramCanvas.drawLine(this.e.left + this.j, this.e.top, this.e.left + this.j, this.e.left + this.e.top + this.i, this.b);
    paramCanvas.drawLine(this.e.left + this.j * 2, this.e.top, this.e.left + this.j * 2, this.e.top + this.i, this.b);
    paramCanvas.drawLine(this.e.left + this.j * 3, this.e.top, this.e.left + this.j * 3, this.e.top + this.i, this.b);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.h;
    paramInt2 = this.l;
    int m = this.i;
    setMeasuredDimension((int)DeviceInfoUtil.D(), paramInt1 + paramInt2 * 2 + m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.LoadingView
 * JD-Core Version:    0.7.0.1
 */