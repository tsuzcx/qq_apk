package com.tencent.widget;

import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

class QMultiImageTextView$MarginStyle
  extends SpanAdapter
{
  public int marginPix;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.start + " end:" + this.end + " marginPix:" + this.marginPix);
    }
    paramSpannableString.setSpan(new QMultiImageTextView.MarginSpan(this.marginPix), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.MarginStyle
 * JD-Core Version:    0.7.0.1
 */