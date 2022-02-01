package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

public class BitmapDrawableWithMargin
  extends BitmapDrawable
{
  private int a;
  private int b;
  private int c = 0;
  private final Paint d = new Paint();
  private float e = URLDrawableHelper.getRoundCorner() * 160.0F;
  
  public BitmapDrawableWithMargin(Resources paramResources, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramResources, paramBitmap);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.e = (URLDrawableHelper.getRoundCorner() * (paramResources.getDisplayMetrics().densityDpi / 160.0F));
    super.setGravity(17);
  }
  
  public BitmapDrawableWithMargin(Resources paramResources, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    super(paramResources, paramBitmap);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.e = (paramFloat * (paramResources.getDisplayMetrics().densityDpi / 160.0F));
    setGravity(17);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.c;
    if (i >>> 24 != 0)
    {
      this.d.setColor(i);
      RectF localRectF = new RectF(getBounds());
      float f = this.e;
      paramCanvas.drawRoundRect(localRectF, f, f, this.d);
    }
    super.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    int i = this.b;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.a;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.d.getAlpha()) {
      this.d.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setTargetDensity(int paramInt)
  {
    this.e = (URLDrawableHelper.getRoundCorner() * (paramInt / 160.0F));
    super.setTargetDensity(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.BitmapDrawableWithMargin
 * JD-Core Version:    0.7.0.1
 */