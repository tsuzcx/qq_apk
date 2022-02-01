package dov.com.qq.im.capture.text;

import android.text.Spanned;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;

class RelaxedAfternoon$1
  extends EditTextDialog.LengthInputFilter
{
  RelaxedAfternoon$1(RelaxedAfternoon paramRelaxedAfternoon, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureTextRelaxedAfternoon.b() == 0) {
      return super.a(paramCharSequence);
    }
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureTextRelaxedAfternoon.b() == 0) {}
    for (this.jdField_a_of_type_Int = 20;; this.jdField_a_of_type_Int = 18) {
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.RelaxedAfternoon.1
 * JD-Core Version:    0.7.0.1
 */