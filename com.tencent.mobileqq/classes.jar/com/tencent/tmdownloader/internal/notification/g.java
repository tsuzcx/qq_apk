package com.tencent.tmdownloader.internal.notification;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      if (a(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label139;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label139:
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    if (!paramBoolean) {
      return a(paramString, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label154;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label154:
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label148;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label148:
      if ((!paramBoolean1) || (paramBoolean2)) {
        break label188;
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      if ((paramBoolean1) && (paramBoolean2)) {
        localStringBuilder.append("…");
      }
    }
  }
  
  public static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next());
    }
    return localStringBuilder.toString();
  }
  
  protected static boolean a(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.g
 * JD-Core Version:    0.7.0.1
 */