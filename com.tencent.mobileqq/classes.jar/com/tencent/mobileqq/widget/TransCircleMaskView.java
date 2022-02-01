package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.view.View;

public class TransCircleMaskView
  extends View
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int c;
  private int d;
  private int e;
  private int f = -1;
  
  public TransCircleMaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public static int a(Context paramContext)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * 11.0F + 0.5F);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.c = getResources().getColor(2131167150);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.d = getWidth();
    this.e = getHeight();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.c);
    if (this.f == -1) {}
    for (int i = a(getContext());; i = this.f)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawCircle(this.d / 2, i + this.e / 2, this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt3)) || (paramInt2 != paramInt4)) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Int = ((int)(paramInt2 * 0.5F * 0.83F));
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        continue;
        this.jdField_a_of_type_Int = ((int)(paramInt2 * 0.5F) - this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void setIsUseMaskRadiusRatios(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setMaskRadius(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setUITopOffset(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setmMaskRadiusBless(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.c = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransCircleMaskView
 * JD-Core Version:    0.7.0.1
 */