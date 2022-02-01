package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Fig
{
  public static long a = TimeUnit.HOURS.toMillis(32L);
  public static Fig b = new Fig();
  
  public static long a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    paramContext = b.c(paramContext);
    if (paramContext == null) {
      return paramLong1;
    }
    paramContext = paramContext.k;
    if (paramContext == null) {
      return paramLong1;
    }
    if (!paramContext.containsKey(paramString)) {
      return paramLong1;
    }
    try
    {
      long l = Long.valueOf((String)paramContext.get(paramString)).longValue();
      return l * paramLong2;
    }
    finally {}
    return paramLong1;
  }
  
  public String a(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    paramContext = File.separator;
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("12");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(paramContext);
    localStringBuilder.append(native.a);
    localStringBuilder.append("_");
    localStringBuilder.append("xqMini");
    localStringBuilder.append("_");
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  public boolean b(Context paramContext)
  {
    try
    {
      int i = Integer.parseInt((String)b.c(paramContext).k.get("enable_auto_detect"));
      if (i > 0) {
        return true;
      }
    }
    finally
    {
      label30:
      break label30;
    }
    return false;
  }
  
  public final Lyra c(Context paramContext)
  {
    try
    {
      Lyra localLyra = new Lyra();
      localLyra.a(new try(instanceof.b(a(paramContext))));
      return localLyra;
    }
    finally
    {
      label29:
      break label29;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Fig
 * JD-Core Version:    0.7.0.1
 */