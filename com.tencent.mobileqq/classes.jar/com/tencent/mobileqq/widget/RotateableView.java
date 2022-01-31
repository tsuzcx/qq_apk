package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import bbnq;

public class RotateableView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new bbnq(this);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public RotateableView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotateableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.rotate(this.jdField_a_of_type_Float, this.b / 2.0F, this.c / 2.0F);
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, localPaint);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Float += 8.0F;
      if (this.jdField_a_of_type_Float >= 360.0F) {
        this.jdField_a_of_type_Float -= 360.0F;
      }
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.c = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.b = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    setMeasuredDimension(this.b, this.c);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateableView
 * JD-Core Version:    0.7.0.1
 */