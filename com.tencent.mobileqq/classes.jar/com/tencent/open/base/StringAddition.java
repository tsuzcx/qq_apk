package com.tencent.open.base;

import android.text.TextUtils;
import java.io.PrintStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class StringAddition
{
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("\\n", "\n").replace("&#92;", "\\").replace("&#39;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<");
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
    while (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        j = paramInt + 2;
        paramString = localCharBuffer.subSequence(paramInt, j).toString();
        paramInt = j;
      }
      else
      {
        j = paramInt + 1;
        paramString = localCharBuffer.subSequence(paramInt, j).toString();
        paramInt = j;
      }
      j = c(paramString);
      if (i >= j)
      {
        i -= j;
        localStringBuilder.append(paramString);
      }
      else
      {
        localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
        localStringBuilder.append("…");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    Object localObject;
    if (!TextUtils.isEmpty(paramString2)) {
      localObject = paramString2;
    } else {
      localObject = "UTF-8";
    }
    paramString2 = paramString1;
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (paramString1.getBytes((String)localObject).length > paramInt) {
          break label201;
        }
        return paramString1;
      }
      catch (Exception paramString1)
      {
        int k;
        paramString3 = System.out;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StructMsg sSubString error : ");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        paramString3.println(((StringBuilder)localObject).toString());
        return paramString2;
      }
      paramString2 = paramString1;
      if (i < paramString1.length())
      {
        k = i + 1;
        paramString2 = paramString1;
        j += paramString1.substring(i, k).getBytes((String)localObject).length;
        if (j > paramInt)
        {
          paramString2 = paramString1;
          paramString1 = paramString1.substring(0, i);
          localObject = paramString1;
          paramString2 = paramString1;
          if (!TextUtils.isEmpty(paramString3))
          {
            paramString2 = paramString1;
            localObject = new StringBuilder();
            paramString2 = paramString1;
            ((StringBuilder)localObject).append(paramString1);
            paramString2 = paramString1;
            ((StringBuilder)localObject).append(paramString3);
            paramString2 = paramString1;
            localObject = ((StringBuilder)localObject).toString();
          }
          return localObject;
        }
        i = k;
      }
      else
      {
        return paramString1;
        label201:
        i = 0;
        j = 0;
      }
    }
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
    while (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        j = paramInt + 2;
        paramString = localCharBuffer.subSequence(paramInt, j).toString();
        paramInt = j;
      }
      else
      {
        j = paramInt + 1;
        paramString = localCharBuffer.subSequence(paramInt, j).toString();
        paramInt = j;
      }
      j = c(paramString);
      if (i >= j)
      {
        i -= j;
        localStringBuilder.append(paramString);
      }
      else
      {
        localStringBuilder.append("…");
      }
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
    while (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        j = paramInt + 2;
        paramString = localCharBuffer.subSequence(paramInt, j).toString();
        paramInt = j;
      }
      else
      {
        j = paramInt + 1;
        paramString = localCharBuffer.subSequence(paramInt, j).toString();
        paramInt = j;
      }
      j = c(paramString);
      if (i >= j)
      {
        i -= j;
        localStringBuilder.append(paramString);
      }
      else if ((paramBoolean1) && (!paramBoolean2))
      {
        localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
        localStringBuilder.append("…");
      }
      else if ((paramBoolean1) && (paramBoolean2))
      {
        localStringBuilder.append("…");
      }
    }
    return localStringBuilder.toString();
  }
  
  protected static boolean a(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString2.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j;
      for (int i = 0;; i = paramString2.length() + j)
      {
        j = paramString1.indexOf(paramString2, i);
        if (j < 0)
        {
          localArrayList.add(paramString1.substring(i));
          i = localArrayList.size() - 1;
          while ((i >= 0) && (((String)localArrayList.get(i)).length() == 0))
          {
            localArrayList.remove(i);
            i -= 1;
          }
          return (String[])localArrayList.toArray(new String[0]);
        }
        localArrayList.add(paramString1.substring(i, j));
      }
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("%7D", "%257D").replace("%3A;", "%253A").replace("%2C';", "%252C").replace("}", "%7D").replace(":", "%3A").replace(",", "%2C");
  }
  
  public static int c(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    while (j < paramString.length())
    {
      if (a(paramString.charAt(j))) {
        i += 2;
      } else {
        i += 1;
      }
      j += 1;
    }
    return i;
  }
  
  public static boolean d(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.StringAddition
 * JD-Core Version:    0.7.0.1
 */