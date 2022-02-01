package dov.com.tencent.mobileqq.shortvideo.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$ProgressBlock
  extends TCProgressBar.Draw
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  boolean g;
  boolean h = false;
  
  TCProgressBar$ProgressBlock(TCProgressBar paramTCProgressBar, boolean paramBoolean)
  {
    super(paramTCProgressBar);
    this.jdField_g_of_type_Boolean = false;
    this.c = paramBoolean;
  }
  
  void a(Canvas paramCanvas)
  {
    if (this.c)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_g_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.h);
      super.a(paramCanvas);
      return;
    }
    int i;
    if (this.jdField_f_of_type_Boolean) {
      i = this.jdField_g_of_type_Int;
    }
    for (;;)
    {
      boolean bool = a(this.jdField_a_of_type_Int - 5);
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "ProgressBlock:hasMorePart=" + this.jdField_a_of_type_Boolean + " bounds=" + bool);
      }
      if ((!this.jdField_a_of_type_Boolean) || (!bool)) {
        break label392;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.i);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.jdField_f_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.j);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      i = this.jdField_g_of_type_Int - this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.l;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = (this.jdField_f_of_type_Int + i);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.k);
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
    }
    label392:
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.jdField_f_of_type_Int);
    if (this.b) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.j);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.i);
    }
  }
  
  boolean a(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int) && (paramInt < this.jdField_f_of_type_Int + this.jdField_g_of_type_Int - this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar.l);
  }
  
  boolean b(int paramInt)
  {
    return (paramInt < this.jdField_f_of_type_Int) || (a(paramInt));
  }
  
  boolean c(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int + this.jdField_g_of_type_Int) || (a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar.ProgressBlock
 * JD-Core Version:    0.7.0.1
 */