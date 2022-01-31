package com.tencent.mobileqq.text;

import aint;
import ainu;
import android.text.Editable.Factory;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class QzoneTextBuilder
  extends QQTextBuilder
{
  public static Editable.Factory b = new aint();
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public String a()
  {
    int i = 0;
    int m = length();
    char[] arrayOfChar = new char[m];
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    QQText.EmoticonSpan[] arrayOfEmoticonSpan = (QQText.EmoticonSpan[])getSpans(0, m, QQText.EmoticonSpan.class);
    Arrays.sort(arrayOfEmoticonSpan, new ainu(this));
    int n = arrayOfEmoticonSpan.length;
    int j = 0;
    QQText.EmoticonSpan localEmoticonSpan;
    int i1;
    int k;
    if (j < n)
    {
      localEmoticonSpan = arrayOfEmoticonSpan[j];
      i1 = getSpanStart(localEmoticonSpan);
      k = getSpanEnd(localEmoticonSpan);
      if ((localEmoticonSpan != null) && (i1 < k) && (k > 0)) {}
    }
    else
    {
      if (i < m) {
        localStringBuilder.append(arrayOfChar, i, m - i);
      }
      return localStringBuilder.toString();
    }
    if (i1 > i) {
      localStringBuilder.append(arrayOfChar, i, i1 - i);
    }
    switch (localEmoticonSpan.c)
    {
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      try
      {
        localStringBuilder.append(TextUtils.b(localEmoticonSpan.a));
      }
      catch (Exception localException1)
      {
        try
        {
          String str = toString();
          if ((android.text.TextUtils.isEmpty(str)) || (str.length() < k)) {
            continue;
          }
          localStringBuilder.append(str.substring(i1, k));
        }
        catch (Exception localException2)
        {
          QLog.e("QzoneTextBuilder", 1, localException2.getStackTrace());
        }
      }
      continue;
      localStringBuilder.append(localException2.a());
      continue;
      localStringBuilder.append(EmotcationConstants.a[(localException2.a & 0x7FFFFFFF)]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.text.QzoneTextBuilder
 * JD-Core Version:    0.7.0.1
 */