package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;
import com.tencent.qphone.base.util.QLog;

class NickWrapper$QQSmallEmojiTextUnit
  extends NickWrapper.TextUnit
{
  private ISmallEmojiSpan a;
  
  NickWrapper$QQSmallEmojiTextUnit(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    super(3, paramString);
    if (paramString.length() >= 6)
    {
      char[] arrayOfChar = new char[3];
      int i = paramString.charAt(3);
      boolean bool = false;
      arrayOfChar[0] = i;
      arrayOfChar[1] = paramString.charAt(4);
      arrayOfChar[2] = ((char)(paramString.charAt(5) & 0xFF));
      int j = 0;
      while (j < 3)
      {
        if (arrayOfChar[j] == 'ú') {
          arrayOfChar[j] = '\n';
        } else if (arrayOfChar[j] == 'þ') {
          arrayOfChar[j] = '\r';
        }
        j += 1;
      }
      paramString = (ISmallEmojiSpanService)QRoute.api(ISmallEmojiSpanService.class);
      if (paramInt1 == 511) {
        bool = true;
      }
      this.a = paramString.createSmallEmojiSpan(arrayOfChar, paramInt2, true, bool);
    }
  }
  
  float a(@NonNull Paint paramPaint)
  {
    paramPaint = this.a;
    if (paramPaint != null)
    {
      paramPaint = paramPaint.getDrawable();
      if (paramPaint != null)
      {
        float f = paramPaint.getBounds().width();
        if (QLog.isColorLevel())
        {
          paramPaint = new StringBuilder();
          paramPaint.append("getWidth small span width ");
          paramPaint.append(f);
          QLog.d("NickWrapper", 2, paramPaint.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickWrapper.QQSmallEmojiTextUnit
 * JD-Core Version:    0.7.0.1
 */