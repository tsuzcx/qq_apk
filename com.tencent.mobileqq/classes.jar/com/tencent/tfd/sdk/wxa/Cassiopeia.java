package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Cassiopeia
{
  public static Cassiopeia ad = new Cassiopeia();
  
  public void H(Context paramContext)
  {
    try
    {
      new File(K(paramContext)).delete();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public Map<Integer, Integer> I(Context paramContext)
  {
    Object localObject = ad.N(paramContext);
    paramContext = new HashMap();
    if (localObject == null) {
      return paramContext;
    }
    localObject = ((interface)localObject).t;
    if (localObject == null) {
      return paramContext;
    }
    return localObject;
  }
  
  public String J(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = ad.N(paramContext);
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.r);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext.version);
    }
    return localStringBuilder.toString();
  }
  
  public String K(Context paramContext)
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
    localStringBuilder.append(final.Rb);
    localStringBuilder.append("_");
    localStringBuilder.append("wxaMini");
    localStringBuilder.append("_");
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  public long L(Context paramContext)
  {
    paramContext = ad.N(paramContext);
    if (paramContext == null) {
      return 57600L;
    }
    long l = paramContext.u;
    if (l <= 0L) {
      return 57600L;
    }
    return l;
  }
  
  public long M(Context paramContext)
  {
    paramContext = ad.N(paramContext);
    if (paramContext == null) {
      return 0L;
    }
    paramContext = paramContext.v;
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
  
  public final interface N(Context paramContext)
  {
    try
    {
      interface localinterface = new interface();
      localinterface.a(new int(package.g(K(paramContext))));
      return localinterface;
    }
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public void a(Context paramContext, interface paraminterface)
  {
    paraminterface = paraminterface.toByteArray();
    package.a(K(paramContext), paraminterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Cassiopeia
 * JD-Core Version:    0.7.0.1
 */