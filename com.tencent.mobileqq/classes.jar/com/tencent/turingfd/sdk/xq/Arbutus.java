package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Arbutus
{
  public static Arbutus zg = new Arbutus();
  
  public void D(Context paramContext)
  {
    try
    {
      new File(G(paramContext)).delete();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public Map<Integer, Integer> E(Context paramContext)
  {
    Object localObject = zg.J(paramContext);
    paramContext = new HashMap();
    if (localObject == null) {}
    do
    {
      return paramContext;
      localObject = ((Bootes)localObject).I;
    } while (localObject == null);
    return localObject;
  }
  
  public String F(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = zg.J(paramContext);
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.G);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext.version);
    }
    return localStringBuilder.toString();
  }
  
  public String G(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + "12");
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    return paramContext.getAbsolutePath() + File.separator + final.jf + "_" + "xqFull" + "_" + "1";
  }
  
  public long H(Context paramContext)
  {
    paramContext = zg.J(paramContext);
    if (paramContext == null) {}
    long l;
    do
    {
      return 57600L;
      l = paramContext.J;
    } while (l <= 0L);
    return l;
  }
  
  public long I(Context paramContext)
  {
    paramContext = zg.J(paramContext);
    if (paramContext == null) {}
    do
    {
      return 0L;
      paramContext = paramContext.K;
    } while ((paramContext == null) || (!paramContext.containsKey("1")));
    try
    {
      l = Long.valueOf((String)paramContext.get("1")).longValue();
      l = l * 3600L * 1000L;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
    return l;
  }
  
  public final Bootes J(Context paramContext)
  {
    try
    {
      Bootes localBootes = new Bootes();
      localBootes.a(new try(extends.i(G(paramContext))));
      return localBootes;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public void a(Context paramContext, Bootes paramBootes)
  {
    paramBootes = paramBootes.toByteArray();
    extends.a(G(paramContext), paramBootes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Arbutus
 * JD-Core Version:    0.7.0.1
 */