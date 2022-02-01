package dov.com.tencent.mobileqq.shortvideo.widget;

import android.graphics.Canvas;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$Draw
{
  boolean d = true;
  boolean e = true;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = false;
  int g;
  
  TCProgressBar$Draw(TCProgressBar paramTCProgressBar) {}
  
  void a(Canvas paramCanvas)
  {
    this.jdField_f_of_type_Boolean = false;
  }
  
  boolean a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.jdField_f_of_type_Int + ",x_coord + length = " + (this.jdField_f_of_type_Int + this.g));
    }
    return (paramFloat > this.jdField_f_of_type_Int) && (paramFloat < this.jdField_f_of_type_Int + this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar.Draw
 * JD-Core Version:    0.7.0.1
 */