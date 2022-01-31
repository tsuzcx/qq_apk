package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CaptureCircleProgress
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c;
  
  public CaptureCircleProgress(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CaptureCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_Int != this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    Object localObject = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    Rect localRect = new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    localObject = new RectF(-30.0F, -30.0F, this.jdField_a_of_type_Int + 30, this.jdField_b_of_type_Int + 30);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawArc((RectF)localObject, -90.0F, -(float)(3.6D * (100 - this.c)), true, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
  }
  
  public void setProgress(int paramInt)
  {
    int i = 100;
    if (paramInt > 100) {}
    for (;;)
    {
      this.c = i;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.c = i;
      invalidate();
      return;
      i = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureCircleProgress
 * JD-Core Version:    0.7.0.1
 */