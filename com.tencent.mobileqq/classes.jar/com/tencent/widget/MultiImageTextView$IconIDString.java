package com.tencent.widget;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

class MultiImageTextView$IconIDString
  extends SpanAdapter
{
  public Drawable a;
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ImageStyle] start:");
      localStringBuilder.append(this.start);
      localStringBuilder.append(" end:");
      localStringBuilder.append(this.end);
      QLog.d("spanStyle", 2, localStringBuilder.toString());
    }
    paramSpannableString.setSpan(new MultiImageTextView.AlignCenterImageSpan(this.a, 1), this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView.IconIDString
 * JD-Core Version:    0.7.0.1
 */