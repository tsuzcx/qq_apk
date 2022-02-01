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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[LabelStyle] start:");
      localStringBuilder.append(this.start);
      localStringBuilder.append(" end:");
      localStringBuilder.append(this.end);
      localStringBuilder.append(" labelColor:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" labelIcon:");
      localStringBuilder.append(this.b);
      QLog.d("spanStyle", 2, localStringBuilder.toString());
    }
    paramSpannableString.setSpan(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView$RoundBackgroundSpan, this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.LabelStyle
 * JD-Core Version:    0.7.0.1
 */