package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class extends
{
  public Handler lc;
  
  public extends(Handler paramHandler)
  {
    this.lc = paramHandler;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("turingfd_conf_105668_xqMini", 0);
    if (paramContext == null) {
      paramContext = "";
    }
    do
    {
      return paramContext;
      paramString = paramContext.getString(paramString, "");
      paramContext = paramString;
    } while (TextUtils.isEmpty(paramString));
    try
    {
      int j = paramString.length() / 2;
      paramContext = new byte[j];
      paramString = paramString.toUpperCase().toCharArray();
      int i = 0;
      while (i < j)
      {
        int k = i * 2;
        int m = paramString[k];
        m = (byte)"0123456789ABCDEF".indexOf(m);
        k = paramString[(k + 1)];
        paramContext[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(k) | m << 4));
        i += 1;
      }
      paramContext = for.a(paramContext, for.c());
      paramContext = new String(paramContext, "UTF-8");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public while<Long> a(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    while localwhile = new while(paramInt);
    paramContext = c(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localwhile.offer(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label61:
        break label61;
      }
      paramInt += 1;
    }
    return localwhile;
  }
  
  public void a(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, "202", paramInt + "_" + paramLong);
  }
  
  public void a(Context paramContext, long paramLong)
  {
    a(paramContext, "204", "" + paramLong);
  }
  
  public void a(Context paramContext, while<Long> paramwhile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramwhile.size())
    {
      localStringBuilder.append(paramwhile.Kb.get(i));
      if (i != paramwhile.size() - 1) {
        localStringBuilder.append("_");
      }
      i += 1;
    }
    a(paramContext, "402", localStringBuilder.toString(), true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, false);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, paramBoolean);
  }
  
  public final void a(Context paramContext, Map<String, String> paramMap)
  {
    paramContext = paramContext.getSharedPreferences("turingfd_conf_105668_xqMini", 0);
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.edit();
    } while (paramContext == null);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      try
      {
        paramContext.putString(str1, for.a(for.b(str2.getBytes(), for.c())));
      }
      catch (Throwable localThrowable) {}
    }
    try
    {
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public final void a(Context paramContext, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramMap);
      return;
    }
    this.lc.post(new default(this, paramContext, paramMap));
  }
  
  public final long b(Context paramContext, String paramString)
  {
    paramContext = c(paramContext, paramString);
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public void b(Context paramContext, long paramLong)
  {
    a(paramContext, "201", "" + paramLong);
  }
  
  public void b(Context paramContext, public parampublic)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", parampublic.Pb);
    localHashMap.put("102", "" + parampublic.Qb);
    if (!TextUtils.isEmpty(parampublic.Tb)) {
      localHashMap.put("104", parampublic.Tb);
    }
    if (!TextUtils.isEmpty(parampublic.Ub)) {
      localHashMap.put("105", parampublic.Ub);
    }
    if (!TextUtils.isEmpty(parampublic.Vb)) {
      localHashMap.put("106", parampublic.Vb);
    }
    a(paramContext, localHashMap, true);
  }
  
  public void c(Context paramContext, long paramLong)
  {
    a(paramContext, "203", "" + paramLong);
  }
  
  public void c(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "403", "" + paramBoolean, true);
  }
  
  public void d(Context paramContext, long paramLong)
  {
    a(paramContext, "107", "" + paramLong, true);
    a(paramContext, "108", "" + System.currentTimeMillis() / 1000L, true);
  }
  
  public void d(Context paramContext, String paramString)
  {
    a(paramContext, "404", paramString, true);
  }
  
  public void e(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    a(paramContext, "401", "" + l, true);
  }
  
  public void f(Context paramContext, long paramLong)
  {
    a(paramContext, "109", "" + paramLong, true);
  }
  
  public String n(Context paramContext)
  {
    return c(paramContext, "201");
  }
  
  public String o(Context paramContext)
  {
    return c(paramContext, "203");
  }
  
  public long p(Context paramContext)
  {
    paramContext = c(paramContext, "401");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public boolean q(Context paramContext)
  {
    paramContext = c(paramContext, "403");
    try
    {
      if (TextUtils.isEmpty(paramContext)) {
        return true;
      }
      boolean bool = Boolean.valueOf(paramContext).booleanValue();
      return bool;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public long r(Context paramContext)
  {
    paramContext = c(paramContext, "107");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public String s(Context paramContext)
  {
    return c(paramContext, "301");
  }
  
  public String t(Context paramContext)
  {
    return c(paramContext, "404");
  }
  
  public String u(Context paramContext)
  {
    return c(paramContext, "202");
  }
  
  public long v(Context paramContext)
  {
    paramContext = c(paramContext, "109");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public public w(Context paramContext)
  {
    String str1 = c(paramContext, "101");
    if (TextUtils.isEmpty(str1)) {
      return public.c(1);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(c(paramContext, "102")).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      label40:
      String str2;
      String str3;
      public.do localdo;
      break label40;
    }
    str2 = c(paramContext, "104");
    str3 = c(paramContext, "105");
    paramContext = c(paramContext, "106");
    localdo = public.create(0);
    localdo.Qb = l1;
    localdo.Pb = str1;
    localdo.Tb = str2;
    localdo.Ub = str3;
    localdo.Vb = paramContext;
    return localdo.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.extends
 * JD-Core Version:    0.7.0.1
 */