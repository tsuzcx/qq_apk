package com.tencent.mobileqq.qzone.api.text;

import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class QzoneTextBuilder
  extends QQTextBuilder
{
  public static Editable.Factory a = new QzoneTextBuilder.1();
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public String toPlainText()
  {
    int m = length();
    char[] arrayOfChar = new char[m];
    int i = 0;
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])getSpans(0, m, EmoticonSpan.class);
    Arrays.sort(arrayOfEmoticonSpan, new QzoneTextBuilder.SpanComparator(this));
    int n = arrayOfEmoticonSpan.length;
    int k;
    for (int j = 0; i < n; j = k)
    {
      Object localObject = arrayOfEmoticonSpan[i];
      int i1 = getSpanStart(localObject);
      k = getSpanEnd(localObject);
      if ((localObject == null) || (i1 >= k) || (k <= 0)) {
        break;
      }
      if (i1 > j) {
        localStringBuilder.append(arrayOfChar, j, i1 - j);
      }
      j = ((EmoticonSpan)localObject).emojiType;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2) {
            localStringBuilder.append(((EmoticonSpan)localObject).getDescription());
          }
        }
        else
        {
          localObject = QQSysFaceUtil.getFaceDescription(0x7FFFFFFF & ((EmoticonSpan)localObject).index);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localStringBuilder.append((String)localObject);
          } else {
            QLog.e("QzoneTextBuilder", 1, "不支持的表情");
          }
        }
      }
      else
      {
        j = QQEmojiUtil.getEmojiUnicode(((EmoticonSpan)localObject).index);
        if (j != -1) {
          localStringBuilder.append(String.valueOf(Character.toChars(j)));
        } else {
          try
          {
            localObject = toString();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() >= k)) {
              localStringBuilder.append(((String)localObject).substring(i1, k));
            }
          }
          catch (Exception localException)
          {
            QLog.e("QzoneTextBuilder", 1, localException.getStackTrace());
          }
        }
      }
      i += 1;
    }
    if (j < m) {
      localStringBuilder.append(arrayOfChar, j, m - j);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzone.api.text.QzoneTextBuilder
 * JD-Core Version:    0.7.0.1
 */