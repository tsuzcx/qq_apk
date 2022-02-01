package com.tencent.xweb.util;

import com.tencent.xweb.m;
import org.xwalk.core.Log;

public class BSpatch
{
  static
  {
    m.a("bspatch_utils", BSpatch.class.getClassLoader());
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doPatch oldFile:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",patchFile:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",newFile:");
    localStringBuilder.append(paramString3);
    Log.i("BSpatch", localStringBuilder.toString());
    long l = System.currentTimeMillis();
    h.B();
    int i;
    if (paramString1.equals(paramString3))
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramString1);
      paramString3.append(".temp");
      paramString3 = paramString3.toString();
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = new BSpatch().nativeDoPatch(paramString1, paramString2, paramString3);
    if (j < 0)
    {
      Log.i("BSpatch", "doPatch failed");
      h.C();
      return j;
    }
    Log.i("BSpatch", "doPatch successful");
    if (i != 0)
    {
      if (!c.a(paramString3, paramString1))
      {
        Log.e("BSpatch", "doPatch same path, copy failed");
        return -1;
      }
      c.a(paramString3);
    }
    h.f(System.currentTimeMillis() - l);
    return j;
  }
  
  public native int nativeDoPatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.BSpatch
 * JD-Core Version:    0.7.0.1
 */