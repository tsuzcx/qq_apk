package dov.com.tencent.mobileqq.shortvideo.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$DeleteImage
  extends TCProgressBar.Draw
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = true;
  int d = 0;
  int e;
  
  TCProgressBar$DeleteImage(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
  }
  
  int a()
  {
    return this.f + this.d;
  }
  
  void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.left = this.f;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.right = (this.f + this.g);
    int i = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.top;
    int j = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.bottom;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.bottom = this.e;
    if (this.jdField_a_of_type_Boolean) {
      a(paramCanvas, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.top = i;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.bottom = j;
      super.a(paramCanvas);
      return;
      a(paramCanvas, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsBitmap);
    }
  }
  
  void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
      }
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    paramCanvas.drawBitmap(paramBitmap, null, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(false);
  }
  
  boolean a()
  {
    if (this.jdField_c_of_type_Int < 0) {}
    for (int i = -this.jdField_c_of_type_Int; i > 1; i = this.jdField_c_of_type_Int) {
      return true;
    }
    return false;
  }
  
  boolean a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.f + ",x_coord + length = " + (this.f + this.g));
    }
    return (paramFloat > this.f - 25) && (paramFloat < this.f + this.g + 25);
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getX();
    int i = paramMotionEvent.getAction();
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Float = f;
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Boolean = false;
        return true;
        this.jdField_c_of_type_Int = ((int)(f - this.jdField_a_of_type_Float));
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Float = f;
        this.jdField_b_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = false;
      } while (!a());
      this.f += this.jdField_c_of_type_Int;
      return true;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar.DeleteImage
 * JD-Core Version:    0.7.0.1
 */