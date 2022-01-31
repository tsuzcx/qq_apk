package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CircleGuideView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 180;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private float b;
  private float c;
  
  public CircleGuideView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CircleGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setARGB(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(Color.argb(this.jdField_a_of_type_Int, 0, 0, 0));
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawCircle(this.jdField_a_of_type_Float, this.b, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight()), null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleGuideView", 2, localThrowable.toString());
        }
      }
      paramCanvas.drawColor(Color.argb(this.jdField_a_of_type_Int, 0, 0, 0));
    }
  }
  
  public void setCircle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.confess.CircleGuideView
 * JD-Core Version:    0.7.0.1
 */