package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.xweb.util.e;

public class j
{
  public static String a(String paramString)
  {
    return a(paramString, e.b());
  }
  
  public static String a(String paramString, double paramDouble)
  {
    String[] arrayOfString = TextUtils.split(paramString, "]");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = arrayOfString[i];
      if (!TextUtils.isEmpty(paramString))
      {
        String str = paramString.trim();
        paramString = str;
        if (str.startsWith(";")) {
          paramString = str.substring(1);
        }
        int k = paramString.indexOf('[');
        str = paramString.substring(0, k);
        paramString = i.a(paramString.substring(k + 1));
        j.a locala = new j.a(null);
        locala.a = str;
        locala.b = paramString;
        if (locala.a(paramDouble)) {
          return str;
        }
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.j
 * JD-Core Version:    0.7.0.1
 */