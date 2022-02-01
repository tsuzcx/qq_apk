package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

public class AlphaMaskFrameLayout
  extends FrameLayout
{
  private static final int[] c = { -1, 0 };
  private static final float[] d = { 0.0F, 1.0F };
  private Paint a;
  private int b;
  private Bitmap e;
  private Bitmap f;
  
  public AlphaMaskFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlphaMaskFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AlphaMaskFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = ((int)(paramContext.getResources().getDisplayMetrics().density * 15.0F + 0.5F));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.a == null)
    {
      this.a = new Paint();
      this.a.setStyle(Paint.Style.FILL);
      this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
    }
    Object localObject1 = this.e;
    Object localObject2;
    if ((localObject1 == null) || (((Bitmap)localObject1).getWidth() != getWidth()))
    {
      this.e = Bitmap.createBitmap(getWidth(), this.b, Bitmap.Config.ARGB_8888);
      this.e.setDensity(getResources().getDisplayMetrics().densityDpi);
      localObject1 = new Canvas(this.e);
      localObject2 = new Paint(1);
      ((Paint)localObject2).setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.b, c, d, Shader.TileMode.CLAMP));
      ((Canvas)localObject1).drawRect(0.0F, 0.0F, ((Canvas)localObject1).getWidth(), ((Canvas)localObject1).getHeight(), (Paint)localObject2);
    }
    localObject1 = this.f;
    if (((localObject1 == null) || (((Bitmap)localObject1).getWidth() != getWidth())) && (this.e != null))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).preScale(1.0F, -1.0F);
      localObject2 = this.e;
      this.f = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, false);
      this.f.setDensity(getResources().getDisplayMetrics().densityDpi);
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, this.a);
    }
    localObject1 = this.f;
    if (localObject1 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, getHeight() - this.f.getHeight(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AlphaMaskFrameLayout
 * JD-Core Version:    0.7.0.1
 */