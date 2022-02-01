package com.tencent.mobileqq.confess;

import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Random;

public class TagUtils
{
  public static int a = 12;
  public static Random b = new Random();
  private static Paint c = new Paint();
  
  private static boolean a(int paramInt)
  {
    return ((paramInt >= 19968) && (paramInt <= 40959)) || (paramInt == 65292) || (paramInt == 12290) || (paramInt == 65281) || (paramInt == 8220) || (paramInt == 8221) || (paramInt == 65288) || (paramInt == 65289) || (paramInt == 126) || (paramInt == 65311);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      if (!a(paramString.codePointAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static float b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      c.setTextSize(36.0F);
      return c.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  private static boolean b(String paramString, ArrayList<Pair<String, Float>> paramArrayList)
  {
    paramString = paramString.trim();
    int i = 0;
    boolean bool = true;
    int k = -1;
    while (i < paramString.length())
    {
      String str;
      if (a(paramString.codePointAt(i)))
      {
        str = paramString.substring(i, i + 1);
        paramArrayList.add(new Pair(str, Float.valueOf(b(str))));
      }
      else
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        int m = i + 1;
        if (m < paramString.length())
        {
          k = j;
          if (!a(paramString.codePointAt(m))) {}
        }
        else
        {
          str = paramString.substring(j, m);
          paramArrayList.add(new Pair(str, Float.valueOf(b(str))));
          k = -1;
        }
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils
 * JD-Core Version:    0.7.0.1
 */