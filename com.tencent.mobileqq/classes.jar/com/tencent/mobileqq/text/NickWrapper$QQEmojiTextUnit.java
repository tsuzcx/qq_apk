package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;

class NickWrapper$QQEmojiTextUnit
  extends NickWrapper.TextUnit
{
  private EmoticonSpan a;
  
  NickWrapper$QQEmojiTextUnit(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    super(2, paramString);
    this.a = new EmoticonSpan(paramInt1, paramInt2, 1);
  }
  
  float a(@NonNull Paint paramPaint)
  {
    float f = this.a.getDrawable().getBounds().width();
    if (QLog.isColorLevel())
    {
      paramPaint = new StringBuilder();
      paramPaint.append("getWidth normal span width ");
      paramPaint.append(f);
      QLog.d("NickWrapper", 2, paramPaint.toString());
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickWrapper.QQEmojiTextUnit
 * JD-Core Version:    0.7.0.1
 */