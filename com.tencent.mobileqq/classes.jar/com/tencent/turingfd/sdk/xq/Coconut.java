package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Coconut
{
  public static Coconut Tg = new Coconut();
  
  public void V(Context paramContext)
  {
    try
    {
      new File(Y(paramContext)).delete();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public Map<Integer, Integer> W(Context paramContext)
  {
    Object localObject = Tg.ba(paramContext);
    paramContext = new HashMap();
    if (localObject == null) {
      return paramContext;
    }
    localObject = ((Lacerta)localObject).S;
    if (localObject == null) {
      return paramContext;
    }
    return localObject;
  }
  
  public String X(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = Tg.ba(paramContext);
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.Q);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext.version);
    }
    return localStringBuilder.toString();
  }
  
  public String Y(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(do.a(localStringBuilder, File.separator, "12"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(float.rf);
    localStringBuilder.append("_");
    localStringBuilder.append("xqFull");
    localStringBuilder.append("_");
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  public long Z(Context paramContext)
  {
    paramContext = Tg.ba(paramContext);
    if (paramContext == null) {
      return 57600L;
    }
    long l = paramContext.U;
    if (l <= 0L) {
      return 57600L;
    }
    return l;
  }
  
  public void a(Context paramContext, Lacerta paramLacerta)
  {
    paramLacerta = paramLacerta.toByteArray();
    abstract.a(Y(paramContext), paramLacerta);
  }
  
  public long aa(Context paramContext)
  {
    paramContext = Tg.ba(paramContext);
    if (paramContext == null) {
      return 0L;
    }
    paramContext = paramContext.W;
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
  
  public final Lacerta ba(Context paramContext)
  {
    try
    {
      Lacerta localLacerta = new Lacerta();
      localLacerta.a(new try(abstract.j(Y(paramContext))));
      return localLacerta;
    }
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Coconut
 * JD-Core Version:    0.7.0.1
 */