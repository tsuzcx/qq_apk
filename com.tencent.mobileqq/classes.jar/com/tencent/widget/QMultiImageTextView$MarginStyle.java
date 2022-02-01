package com.tencent.widget;

import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

class QMultiImageTextView$MarginStyle
  extends SpanAdapter
{
  public int marginPix;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MarginStyle] start:");
      localStringBuilder.append(this.start);
      localStringBuilder.append(" end:");
      localStringBuilder.append(this.end);
      localStringBuilder.append(" marginPix:");
      localStringBuilder.append(this.marginPix);
      QLog.d("spanStyle", 2, localStringBuilder.toString());
    }
    paramSpannableString.setSpan(new QMultiImageTextView.MarginSpan(this.marginPix), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.MarginStyle
 * JD-Core Version:    0.7.0.1
 */