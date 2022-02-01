package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class EdgeTransparentRelativeLayout
  extends RelativeLayout
{
  private int[] a = { -1, 0 };
  private final float[] b = { 0.0F, 1.0F };
  private final Paint c = new Paint(1);
  private int d = 0;
  private float e;
  private int f;
  private int g;
  
  public EdgeTransparentRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EdgeTransparentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EdgeTransparentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private void a()
  {
    this.c.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.e, this.a, this.b, Shader.TileMode.CLAMP));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (this.d == 0) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((this.d & 0x1) != 0) {
      paramCanvas.drawRect(0.0F, 0.0F, this.f, this.e, this.c);
    }
    if ((this.d & 0x2) != 0)
    {
      j = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.f / 2.0F, this.g / 2.0F);
      paramCanvas.drawRect(0.0F, 0.0F, this.f, this.e, this.c);
      paramCanvas.restoreToCount(j);
    }
    int j = (this.g - this.f) / 2;
    int k;
    if ((this.d & 0x4) != 0)
    {
      k = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.f / 2.0F, this.g / 2.0F);
      paramCanvas.translate(0.0F, j);
      paramCanvas.drawRect(-j, 0.0F, this.f + j, this.e, this.c);
      paramCanvas.restoreToCount(k);
    }
    if ((this.d & 0x8) != 0)
    {
      k = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.f / 2.0F, this.g / 2.0F);
      paramCanvas.translate(0.0F, j);
      paramCanvas.drawRect(-j, 0.0F, this.f + j, this.e, this.c);
      paramCanvas.restoreToCount(k);
    }
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    this.f = getWidth();
    this.g = getHeight();
  }
  
  public void setPositionAndDrawSize(int paramInt, float paramFloat)
  {
    this.d = paramInt;
    this.e = paramFloat;
  }
  
  public void setmGradientColors(int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.EdgeTransparentRelativeLayout
 * JD-Core Version:    0.7.0.1
 */