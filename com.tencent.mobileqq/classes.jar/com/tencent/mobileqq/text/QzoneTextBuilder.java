package com.tencent.mobileqq.text;

import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class QzoneTextBuilder
  extends QQTextBuilder
{
  public static Editable.Factory EMOCTATION_FACORY = new QzoneTextBuilder.1();
  
  public QzoneTextBuilder(int paramInt)
  {
    super(paramInt);
  }
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public <T> T getNextSpan(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    int i = 1;
    int j = 0;
    paramInt1 = nextSpanTransition(paramInt1, paramInt2, paramClass);
    if (paramInt1 >= paramInt2) {
      return null;
    }
    paramClass = getSpans(paramInt1, paramInt2, paramClass);
    if (paramClass.length >= 1)
    {
      int k = getSpanStart(paramClass[0]);
      paramInt2 = j;
      paramInt1 = i;
      while (paramInt1 < paramClass.length)
      {
        if (getSpanStart(paramClass[paramInt1]) < k) {
          paramInt2 = paramInt1;
        }
        paramInt1 += 1;
      }
      return paramClass[paramInt2];
    }
    return null;
  }
  
  public String toPlainText()
  {
    int j = 0;
    int m = length();
    char[] arrayOfChar = new char[m];
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    QQText.EmoticonSpan[] arrayOfEmoticonSpan = (QQText.EmoticonSpan[])getSpans(0, m, QQText.EmoticonSpan.class);
    Arrays.sort(arrayOfEmoticonSpan, new QzoneTextBuilder.SpanComparator(this));
    int n = arrayOfEmoticonSpan.length;
    int i = 0;
    Object localObject;
    int i1;
    int k;
    if (i < n)
    {
      localObject = arrayOfEmoticonSpan[i];
      i1 = getSpanStart(localObject);
      k = getSpanEnd(localObject);
      if ((localObject != null) && (i1 < k) && (k > 0)) {}
    }
    else
    {
      if (j < m) {
        localStringBuilder.append(arrayOfChar, j, m - j);
      }
      return localStringBuilder.toString();
    }
    if (i1 > j) {
      localStringBuilder.append(arrayOfChar, j, i1 - j);
    }
    switch (((QQText.EmoticonSpan)localObject).emojiType)
    {
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      j = QQEmojiUtil.getEmojiUnicode(((QQText.EmoticonSpan)localObject).index);
      if (j != -1)
      {
        localStringBuilder.append(String.valueOf(Character.toChars(j)));
      }
      else
      {
        try
        {
          localObject = toString();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).length() < k)) {
            continue;
          }
          localStringBuilder.append(((String)localObject).substring(i1, k));
        }
        catch (Exception localException)
        {
          QLog.e("QzoneTextBuilder", 1, localException.getStackTrace());
        }
        continue;
        localStringBuilder.append(localException.getDescription());
        continue;
        String str = QQSysFaceUtil.getFaceDescription(0x7FFFFFFF & localException.index);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append(str);
        } else {
          QLog.e("QzoneTextBuilder", 1, "不支持的表情");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QzoneTextBuilder
 * JD-Core Version:    0.7.0.1
 */