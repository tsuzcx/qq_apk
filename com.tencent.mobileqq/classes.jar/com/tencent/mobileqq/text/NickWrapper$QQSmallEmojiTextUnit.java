package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.qphone.base.util.QLog;

class NickWrapper$QQSmallEmojiTextUnit
  extends NickWrapper.TextUnit
{
  private SmallEmojiSpan a;
  
  NickWrapper$QQSmallEmojiTextUnit(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    super(3, paramString);
    if (paramString.length() >= 6)
    {
      char[] arrayOfChar = new char[3];
      arrayOfChar[0] = paramString.charAt(3);
      arrayOfChar[1] = paramString.charAt(4);
      arrayOfChar[2] = ((char)(paramString.charAt(5) & 0xFF));
      int i = 0;
      if (i < 3)
      {
        if (arrayOfChar[i] == 'ú') {
          arrayOfChar[i] = '\n';
        }
        for (;;)
        {
          i += 1;
          break;
          if (arrayOfChar[i] == 'þ') {
            arrayOfChar[i] = '\r';
          }
        }
      }
      if (paramInt1 == 511) {
        bool = true;
      }
      this.a = new SmallEmojiSpan(arrayOfChar, paramInt2, true, bool);
    }
  }
  
  float a(@NonNull Paint paramPaint)
  {
    if (this.a != null)
    {
      paramPaint = this.a.getDrawable();
      if (paramPaint != null)
      {
        float f = paramPaint.getBounds().width();
        if (QLog.isColorLevel()) {
          QLog.d("NickWrapper", 2, "getWidth small span width " + f);
        }
        return f;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NickWrapper", 2, "getWidth with error drawable");
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickWrapper.QQSmallEmojiTextUnit
 * JD-Core Version:    0.7.0.1
 */