package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqui.R.styleable;

public class EdgeTransparentView
  extends FrameLayout
{
  private Paint a;
  private int b;
  private float c;
  private int d = 1;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int[] j;
  private float[] k;
  
  public EdgeTransparentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.d;
    this.e = (paramInt << 1);
    this.f = (paramInt << 2);
    this.g = (paramInt << 3);
    this.j = new int[] { -1, -1, 16777215 };
    this.k = new float[] { 0.0F, 0.5F, 1.0F };
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.a.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.c, this.j, this.k, Shader.TileMode.CLAMP));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new Paint(1);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.au);
    this.b = paramContext.getInt(R.styleable.av, 0);
    this.c = paramContext.getDimension(R.styleable.aw, 40.0F);
    paramContext.recycle();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int m = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    int n = this.b;
    if ((n == 0) || ((n & this.d) != 0)) {
      paramCanvas.drawRect(0.0F, 0.0F, this.h, this.c, this.a);
    }
    n = this.b;
    if ((n == 0) || ((n & this.e) != 0))
    {
      n = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.h / 2.0F, this.i / 2.0F);
      paramCanvas.drawRect(0.0F, 0.0F, this.h, this.c, this.a);
      paramCanvas.restoreToCount(n);
    }
    float f1 = (this.i - this.h) / 2.0F;
    n = this.b;
    if ((n == 0) || ((n & this.f) != 0))
    {
      n = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.h / 2.0F, this.i / 2.0F);
      paramCanvas.translate(0.0F, f1);
      paramCanvas.drawRect(0.0F - f1, 0.0F, this.h + f1, this.c, this.a);
      paramCanvas.restoreToCount(n);
    }
    n = this.b;
    if ((n == 0) || ((n & this.g) != 0))
    {
      n = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.h / 2.0F, this.i / 2.0F);
      paramCanvas.translate(0.0F, f1);
      paramCanvas.drawRect(0.0F - f1, 0.0F, this.h + f1, this.c, this.a);
      paramCanvas.restoreToCount(n);
    }
    paramCanvas.restoreToCount(m);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    this.h = getWidth();
    this.i = getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.EdgeTransparentView
 * JD-Core Version:    0.7.0.1
 */