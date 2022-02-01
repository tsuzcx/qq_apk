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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[FontStyle] start:");
      localStringBuilder.append(this.start);
      localStringBuilder.append(" end:");
      localStringBuilder.append(this.end);
      localStringBuilder.append(" fontColor:");
      localStringBuilder.append(this.fontColor);
      localStringBuilder.append(" fontSize:");
      localStringBuilder.append(this.fontSize);
      localStringBuilder.append(" fontBackgroundColor");
      localStringBuilder.append(this.fontBackgroundColor);
      QLog.d("spanStyle", 2, localStringBuilder.toString());
    }
    paramSpannableString.setSpan(new AbsoluteSizeSpan(this.fontSize, true), this.start, this.end, 17);
    paramSpannableString.setSpan(new ForegroundColorSpan(this.fontColor), this.start, this.end, 17);
    paramSpannableString.setSpan(new BackgroundColorSpan(this.fontBackgroundColor), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.FontStyle
 * JD-Core Version:    0.7.0.1
 */