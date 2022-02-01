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

public class Almond
{
  public static final String FILE_NAME = final.jf + "_" + "xqFull";
  public Handler Jg;
  
  public Almond(Handler paramHandler)
  {
    this.Jg = paramHandler;
  }
  
  public static long B(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(c(paramContext, "503")).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(FILE_NAME, 0);
      if (paramContext == null) {
        return;
      }
    }
    catch (Throwable paramContext)
    {
      do
      {
        for (;;)
        {
          paramContext = null;
        }
        paramContext = paramContext.edit();
      } while (paramContext == null);
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        try
        {
          paramContext.putString(str1, this.b(this.b(str2.getBytes(), this.e())));
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
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(FILE_NAME, 0);
      if (paramContext == null)
      {
        paramContext = "";
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      do
      {
        for (;;)
        {
          paramContext = null;
        }
        paramString = paramContext.getString(paramString, "");
        paramContext = paramString;
      } while (TextUtils.isEmpty(paramString));
      try
      {
        paramContext = this.a(this.e(paramString), this.e());
        paramContext = new String(paramContext, "UTF-8");
        return paramContext;
      }
      catch (Throwable paramContext) {}
    }
    return "";
  }
  
  public static void e(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("602", paramString);
    a(paramContext, localHashMap);
  }
  
  public static void g(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("601", paramString);
    a(paramContext, localHashMap);
  }
  
  public Serpens A(Context paramContext)
  {
    String str1 = c(paramContext, "101");
    if (TextUtils.isEmpty(str1)) {
      return Serpens.f(1);
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
      String str4;
      String str5;
      Serpens.do localdo;
      break label40;
    }
    str2 = c(paramContext, "104");
    str3 = c(paramContext, "105");
    str4 = c(paramContext, "106");
    str5 = c(paramContext, "110");
    paramContext = c(paramContext, "111");
    localdo = Serpens.create(0);
    localdo.Pg = l1;
    localdo.Og = str1;
    localdo.Rg = str2;
    localdo.Sg = str3;
    localdo.Tg = str4;
    localdo.Ug = str5;
    localdo.Vg = new Apple(paramContext);
    return localdo.build();
  }
  
  public void C(Context paramContext)
  {
    a(paramContext, "501", System.currentTimeMillis(), true);
  }
  
  public finally<Long> a(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    finally localfinally = new finally(paramInt);
    paramContext = c(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localfinally.offer(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label62:
        break label62;
      }
      paramInt += 1;
    }
    return localfinally;
  }
  
  public void a(Context paramContext, long paramLong, int paramInt)
  {
    a(paramContext, "203", "" + paramLong + "_" + paramInt);
  }
  
  public void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("").append(paramLong).append("_");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      a(paramContext, "204", str);
      return;
    }
  }
  
  public void a(Context paramContext, Serpens paramSerpens)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", paramSerpens.Og);
    localHashMap.put("102", "" + paramSerpens.Pg);
    if (!TextUtils.isEmpty(paramSerpens.Rg)) {
      localHashMap.put("104", paramSerpens.Rg);
    }
    if (!TextUtils.isEmpty(paramSerpens.Sg)) {
      localHashMap.put("105", paramSerpens.Sg);
    }
    if (!TextUtils.isEmpty(paramSerpens.Tg)) {
      localHashMap.put("106", paramSerpens.Tg);
    }
    if (!TextUtils.isEmpty(paramSerpens.Ug)) {
      localHashMap.put("110", paramSerpens.Ug);
    }
    paramSerpens = paramSerpens.Vg;
    if ((paramSerpens != null) && (!TextUtils.isEmpty(paramSerpens.toString()))) {
      localHashMap.put("111", paramSerpens.toString());
    }
    a(paramContext, localHashMap, true);
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
  
  public final void a(Context paramContext, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramMap);
      return;
    }
    this.Jg.post(new Vulpecula(this, paramContext, paramMap));
  }
  
  public void b(Context paramContext, long paramLong)
  {
    a(paramContext, "107", "" + paramLong, true);
    a(paramContext, "108", "" + System.currentTimeMillis() / 1000L, true);
  }
  
  public void b(Context paramContext, finally<Long> paramfinally)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramfinally.size())
    {
      localStringBuilder.append(paramfinally.Xf.get(i));
      if (i != paramfinally.size() - 1) {
        localStringBuilder.append("_");
      }
      i += 1;
    }
    a(paramContext, "402", localStringBuilder.toString(), true);
  }
  
  public void c(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    a(paramContext, "401", "" + l, true);
  }
  
  public void c(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "403", "" + paramBoolean, true);
  }
  
  public final long d(Context paramContext, String paramString)
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
  
  public void d(Context paramContext, long paramLong)
  {
    a(paramContext, "109", "" + paramLong, true);
  }
  
  public void e(Context paramContext, long paramLong)
  {
    a(paramContext, "503", "" + paramLong, true);
  }
  
  public void f(Context paramContext, String paramString)
  {
    a(paramContext, "404", paramString, true);
  }
  
  public String q(Context paramContext)
  {
    return c(paramContext, "201");
  }
  
  public String r(Context paramContext)
  {
    return c(paramContext, "205");
  }
  
  public String s(Context paramContext)
  {
    return c(paramContext, "203");
  }
  
  public long t(Context paramContext)
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
  
  public boolean u(Context paramContext)
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
  
  public String v(Context paramContext)
  {
    return c(paramContext, "405");
  }
  
  public long w(Context paramContext)
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
  
  public String x(Context paramContext)
  {
    return c(paramContext, "404");
  }
  
  public String y(Context paramContext)
  {
    return c(paramContext, "202");
  }
  
  public long z(Context paramContext)
  {
    return d(paramContext, "109");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Almond
 * JD-Core Version:    0.7.0.1
 */