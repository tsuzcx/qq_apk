package com.tencent.timi.game.component.chat.util;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;

public class EmotionCodecUtils
{
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j;
    for (int k = 0; i < paramString.length(); k = j)
    {
      if (paramString.charAt(i) == '\024')
      {
        int n = i + 1;
        if (n < paramString.length())
        {
          int i1 = QQSysFaceUtil.convertToServer(paramString.charAt(n));
          m = i;
          j = k;
          if (i1 < 0) {
            break label151;
          }
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)(i1 / 128 + 65));
          localStringBuilder.append((char)(i1 % 128 + 65));
          j = k + 1;
          m = n;
          break label151;
        }
      }
      localStringBuilder.append(paramString.charAt(i));
      j = k + 1;
      int m = i;
      label151:
      if (j >= paramInt) {
        return localStringBuilder.toString();
      }
      i = m + 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString)
  {
    return QQSysFaceUtil.containsExpression(paramString);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    for (int i = 0; i < paramString.length(); i = j + 1)
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 1;
        if (k < paramString.length())
        {
          int m = QQSysFaceUtil.convertToServer(paramString.charAt(k));
          j = i;
          if (m < 0) {
            continue;
          }
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)(m / 128 + 65));
          localStringBuilder.append((char)(m % 128 + 65));
          j = k;
          continue;
        }
      }
      localStringBuilder.append(paramString.charAt(i));
      j = i;
    }
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 2;
        if (k < paramString.length())
        {
          int j = i + 1;
          k = (paramString.charAt(j) - 'A') * 128 + paramString.charAt(k) - 65;
          if (k < 0) {
            break label123;
          }
          localStringBuilder.append(String.valueOf(new char[] { '\024', (char)QQSysFaceUtil.convertToLocal(k) }));
          i = j + 1;
          break label123;
        }
      }
      localStringBuilder.append(paramString.charAt(i));
      label123:
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.util.EmotionCodecUtils
 * JD-Core Version:    0.7.0.1
 */