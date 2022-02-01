package com.tencent.mobileqq.shortvideo.widget;

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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_g_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.h);
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.i);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.j);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      i = this.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.l;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = (this.jdField_f_of_type_Int + i);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.k);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
    }
    label392:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b.right = (i + this.jdField_f_of_type_Int);
    if (this.b) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.j);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a);
      break;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.i);
    }
  }
  
  boolean a(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int) && (paramInt < this.jdField_f_of_type_Int + this.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar.ProgressBlock
 * JD-Core Version:    0.7.0.1
 */