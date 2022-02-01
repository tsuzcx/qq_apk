package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Cassiopeia
{
  public static Cassiopeia rd = new Cassiopeia();
  
  public void M(Context paramContext)
  {
    try
    {
      new File(P(paramContext)).delete();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public Map<Integer, Integer> N(Context paramContext)
  {
    Object localObject = rd.S(paramContext);
    paramContext = new HashMap();
    if (localObject == null) {
      return paramContext;
    }
    localObject = ((volatile)localObject).u;
    if (localObject == null) {
      return paramContext;
    }
    return localObject;
  }
  
  public String O(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = rd.S(paramContext);
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.s);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext.version);
    }
    return localStringBuilder.toString();
  }
  
  public String P(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("12");
    paramContext = new File(localStringBuilder.toString());
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(final.gc);
    localStringBuilder.append("_");
    localStringBuilder.append("gaMini");
    localStringBuilder.append("_");
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  public long Q(Context paramContext)
  {
    paramContext = rd.S(paramContext);
    if (paramContext == null) {
      return 57600L;
    }
    long l = paramContext.v;
    if (l <= 0L) {
      return 57600L;
    }
    return l;
  }
  
  public long R(Context paramContext)
  {
    paramContext = rd.S(paramContext);
    if (paramContext == null) {
      return 0L;
    }
    paramContext = paramContext.A;
    if (paramContext == null) {
      return 0L;
    }
    if (!paramContext.containsKey("1")) {
      return 0L;
    }
    try
    {
      long l = Long.valueOf((String)paramContext.get("1")).longValue();
      return l * 3600L * 1000L;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public final volatile S(Context paramContext)
  {
    try
    {
      volatile localvolatile = new volatile();
      localvolatile.a(new int(package.g(P(paramContext))));
      return localvolatile;
    }
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public void a(Context paramContext, volatile paramvolatile)
  {
    paramvolatile = paramvolatile.toByteArray();
    package.a(P(paramContext), paramvolatile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Cassiopeia
 * JD-Core Version:    0.7.0.1
 */