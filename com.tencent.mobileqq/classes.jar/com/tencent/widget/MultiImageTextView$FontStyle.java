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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[FontStyle] start:");
      localStringBuilder.append(this.start);
      localStringBuilder.append(" end:");
      localStringBuilder.append(this.end);
      localStringBuilder.append(" fontColor:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" fontSize:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" fontBackgroundColor");
      localStringBuilder.append(this.c);
      QLog.d("spanStyle", 2, localStringBuilder.toString());
    }
    paramSpannableString.setSpan(new AbsoluteSizeSpan(this.b, true), this.start, this.end, 17);
    paramSpannableString.setSpan(new ForegroundColorSpan(this.a), this.start, this.end, 17);
    paramSpannableString.setSpan(new BackgroundColorSpan(this.c), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.FontStyle
 * JD-Core Version:    0.7.0.1
 */