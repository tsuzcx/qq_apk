package com.tencent.widget;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;

class QMultiImageTextView$FontStyle
  extends SpanAdapter
{
  public int fontBackgroundColor;
  public int fontColor;
  public int fontSize;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[FontStyle] start:" + this.start + " end:" + this.end + " fontColor:" + this.fontColor + " fontSize:" + this.fontSize + " fontBackgroundColor" + this.fontBackgroundColor);
    }
    paramSpannableString.setSpan(new AbsoluteSizeSpan(this.fontSize, true), this.start, this.end, 17);
    paramSpannableString.setSpan(new ForegroundColorSpan(this.fontColor), this.start, this.end, 17);
    paramSpannableString.setSpan(new BackgroundColorSpan(this.fontBackgroundColor), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.FontStyle
 * JD-Core Version:    0.7.0.1
 */