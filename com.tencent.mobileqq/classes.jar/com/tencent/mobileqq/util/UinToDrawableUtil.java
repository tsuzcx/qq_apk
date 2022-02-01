package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import mqq.app.MobileQQ;

public class UinToDrawableUtil
{
  public static Drawable a(String paramString)
  {
    String[] arrayOfString1 = paramString.split("&");
    int m = arrayOfString1.length;
    paramString = "";
    int i = 0;
    int j = 1;
    while (i < m)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=");
      if (arrayOfString2.length == 2)
      {
        int k;
        if (arrayOfString2[0].equals("type"))
        {
          k = Integer.parseInt(arrayOfString2[1]);
        }
        else
        {
          k = j;
          if (arrayOfString2[0].equals("uin"))
          {
            paramString = arrayOfString2[1];
            k = j;
          }
        }
        i += 1;
        j = k;
      }
      else
      {
        throw new IllegalArgumentException("query string illegal");
      }
    }
    paramString = a(paramString, j);
    if (paramString != null) {
      return paramString;
    }
    paramString = new IllegalStateException("Drawable is null.");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static Drawable a(String paramString, int paramInt)
  {
    return FaceDrawable.getFaceDrawable((AppInterface)MobileQQ.getMobileQQ().waitAppRuntime(null), paramInt, 4, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.UinToDrawableUtil
 * JD-Core Version:    0.7.0.1
 */