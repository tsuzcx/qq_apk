package com.tencent.widget;

import android.content.res.Resources;
import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;

class QMultiImageTextView$LabelStyle
  extends SpanAdapter
{
  public int labelColor;
  public int labelIcon;
  private QMultiImageTextView.RoundBackgroundSpan span;
  
  public QMultiImageTextView$LabelStyle(Resources paramResources)
  {
    this.span = new QMultiImageTextView.RoundBackgroundSpan(this.labelColor, this.labelIcon, paramResources);
  }
  
  public void getSpan(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[LabelStyle] start:" + this.start + " end:" + this.end + " labelColor:" + this.labelColor + " labelIcon:" + this.labelIcon);
    }
    paramSpannableString.setSpan(this.span, this.start, this.end, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.LabelStyle
 * JD-Core Version:    0.7.0.1
 */