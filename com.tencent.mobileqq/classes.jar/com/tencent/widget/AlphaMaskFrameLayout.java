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
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 1.0F };
  private static final int[] jdField_a_of_type_ArrayOfInt = { -1, 0 };
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Bitmap b;
  
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
    this.jdField_a_of_type_Int = ((int)(paramContext.getResources().getDisplayMetrics().density * 15.0F + 0.5F));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
    }
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject2;
    if ((localObject1 == null) || (((Bitmap)localObject1).getWidth() != getWidth()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsBitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
      localObject1 = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      localObject2 = new Paint(1);
      ((Paint)localObject2).setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int, jdField_a_of_type_ArrayOfInt, jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
      ((Canvas)localObject1).drawRect(0.0F, 0.0F, ((Canvas)localObject1).getWidth(), ((Canvas)localObject1).getHeight(), (Paint)localObject2);
    }
    localObject1 = this.b;
    if (((localObject1 == null) || (((Bitmap)localObject1).getWidth() != getWidth())) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).preScale(1.0F, -1.0F);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      this.b = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, false);
      this.b.setDensity(getResources().getDisplayMetrics().densityDpi);
    }
    localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject1 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, getHeight() - this.b.getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AlphaMaskFrameLayout
 * JD-Core Version:    0.7.0.1
 */