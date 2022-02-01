package com.tencent.widget;

import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

class MultiImageTextView$LabelStyle
  extends SpanAdapter
{
  public int a;
  private MultiImageTextView.RoundBackgroundSpan a;
  public int b;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[LabelStyle] start:" + this.start + " end:" + this.end + " labelColor:" + this.jdField_a_of_type_Int + " labelIcon:" + this.b);
    }
    paramSpannableString.setSpan(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView$RoundBackgroundSpan, this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.LabelStyle
 * JD-Core Version:    0.7.0.1
 */