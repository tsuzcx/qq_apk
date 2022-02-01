package com.tencent.smtt.sdk;

import android.content.Context;

public class TbsVideoUtils
{
  private static t a;
  
  private static void a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        Object localObject2 = f.a(true);
        Object localObject1 = null;
        ((f)localObject2).a(paramContext, false, false, null);
        localObject2 = f.a(true).a();
        paramContext = localObject1;
        if (localObject2 != null) {
          paramContext = ((v)localObject2).b();
        }
        if (paramContext != null) {
          a = new t(paramContext);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    a(paramContext);
    t localt = a;
    if (localt != null) {
      localt.a(paramContext, paramString);
    }
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    a(paramContext);
    t localt = a;
    if (localt != null) {
      return localt.a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */