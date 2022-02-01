package com.tencent.widget;

import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

class MultiImageTextView$MarginStyle
  extends SpanAdapter
{
  public int a;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.start + " end:" + this.end + " marginPix:" + this.a);
    }
    paramSpannableString.setSpan(new MultiImageTextView.MarginSpan(this.a), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.MarginStyle
 * JD-Core Version:    0.7.0.1
 */