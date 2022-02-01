package com.tencent.widget;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;

class MultiImageTextView$FontStyle
  extends SpanAdapter
{
  public int a;
  public int b;
  public int c;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[FontStyle] start:" + this.start + " end:" + this.end + " fontColor:" + this.a + " fontSize:" + this.b + " fontBackgroundColor" + this.c);
    }
    paramSpannableString.setSpan(new AbsoluteSizeSpan(this.b, true), this.start, this.end, 17);
    paramSpannableString.setSpan(new ForegroundColorSpan(this.a), this.start, this.end, 17);
    paramSpannableString.setSpan(new BackgroundColorSpan(this.c), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.FontStyle
 * JD-Core Version:    0.7.0.1
 */