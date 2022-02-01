package com.tencent.turingfd.sdk.ams.ga;

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

public class Canesatici
{
  public static final String FILE_NAME;
  public Handler Ed;
  
  static
  {
    StringBuilder localStringBuilder = do.b("turingfd_conf_");
    localStringBuilder.append(final.gc);
    localStringBuilder.append("_");
    localStringBuilder.append("gaMini");
    FILE_NAME = localStringBuilder.toString();
  }
  
  public Canesatici(Handler paramHandler)
  {
    this.Ed = paramHandler;
  }
  
  public static long B(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(d(paramContext, "801")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public static long J(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(d(paramContext, "503")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public static void K(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = do.b("");
    localStringBuilder.append(System.currentTimeMillis());
    localHashMap.put("801", localStringBuilder.toString());
    a(paramContext, localHashMap);
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(FILE_NAME, 0);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        try
        {
          Iterator localIterator;
          label99:
          paramContext.commit();
          return;
        }
        catch (Throwable paramContext) {}
        paramContext = paramContext;
      }
    }
    paramContext = null;
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.edit();
    if (paramContext == null) {
      return;
    }
    localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      try
      {
        paramContext.putString(str1, goto.a(goto.b(str2.getBytes(), goto.m())));
      }
      catch (Throwable localThrowable)
      {
        break label99;
      }
    }
  }
  
  public static String d(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getSharedPreferences(FILE_NAME, 0);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        try
        {
          int j = paramString.length() / 2;
          paramContext = new byte[j];
          paramString = paramString.toUpperCase().toCharArray();
          if (i < j)
          {
            int k = i * 2;
            int m = (byte)"0123456789ABCDEF".indexOf(paramString[k]);
            paramContext[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(paramString[(k + 1)]) | m << 4));
            i += 1;
            continue;
          }
          paramContext = goto.a(paramContext, goto.m());
          paramContext = new String(paramContext, "UTF-8");
          return paramContext;
        }
        catch (Throwable paramContext) {}
        paramContext = paramContext;
      }
    }
    paramContext = null;
    if (paramContext == null) {
      return "";
    }
    paramString = paramContext.getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return "";
  }
  
  public static void g(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("901", paramString);
    a(paramContext, localHashMap);
  }
  
  public String A(Context paramContext)
  {
    return d(paramContext, "405");
  }
  
  public long C(Context paramContext)
  {
    paramContext = d(paramContext, "107");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label17:
      break label17;
    }
    return 0L;
  }
  
  public String D(Context paramContext)
  {
    return d(paramContext, "404");
  }
  
  public String E(Context paramContext)
  {
    return d(paramContext, "202");
  }
  
  public long F(Context paramContext)
  {
    return c(paramContext, "109");
  }
  
  public long G(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(d(paramContext, "902")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public String H(Context paramContext)
  {
    return d(paramContext, "901");
  }
  
  public implements I(Context paramContext)
  {
    try
    {
      str1 = d(paramContext, "101");
      if (TextUtils.isEmpty(str1))
      {
        paramContext = implements.g(1);
        return paramContext;
      }
      l1 = 0L;
    }
    catch (Throwable paramContext)
    {
      String str1;
      long l1;
      long l2;
      label42:
      String str2;
      String str3;
      String str4;
      String str5;
      implements.do localdo;
      label149:
      break label149;
    }
    try
    {
      l2 = Long.valueOf(d(paramContext, "102")).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      break label42;
    }
    str2 = d(paramContext, "104");
    str3 = d(paramContext, "105");
    str4 = d(paramContext, "106");
    str5 = d(paramContext, "110");
    paramContext = d(paramContext, "111");
    localdo = implements.create(0);
    localdo.bd = l1;
    localdo.ad = str1;
    localdo.ed = str2;
    localdo.gd = str3;
    localdo.hd = str4;
    localdo.jd = str5;
    localdo.kd = new CanisMinor(paramContext);
    paramContext = localdo.build();
    return paramContext;
    return implements.g(1);
  }
  
  public void L(Context paramContext)
  {
    StringBuilder localStringBuilder = do.b("");
    localStringBuilder.append(System.currentTimeMillis());
    a(paramContext, "501", localStringBuilder.toString(), true);
  }
  
  public void a(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramContext, "107", localStringBuilder.toString(), true);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(System.currentTimeMillis() / 1000L);
    a(paramContext, "108", localStringBuilder.toString(), true);
  }
  
  public void a(Context paramContext, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    a(paramContext, "203", localStringBuilder.toString());
  }
  
  public void a(Context paramContext, implements paramimplements)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", paramimplements.ad);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramimplements.bd);
    localHashMap.put("102", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramimplements.ed)) {
      localHashMap.put("104", paramimplements.ed);
    }
    if (!TextUtils.isEmpty(paramimplements.gd)) {
      localHashMap.put("105", paramimplements.gd);
    }
    if (!TextUtils.isEmpty(paramimplements.hd)) {
      localHashMap.put("106", paramimplements.hd);
    }
    if (!TextUtils.isEmpty(paramimplements.jd)) {
      localHashMap.put("110", paramimplements.jd);
    }
    paramimplements = paramimplements.kd;
    if ((paramimplements != null) && (!TextUtils.isEmpty(paramimplements.toString()))) {
      localHashMap.put("111", paramimplements.toString());
    }
    a(paramContext, localHashMap, true);
  }
  
  public void a(Context paramContext, private<Long> paramprivate)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramprivate.size())
    {
      localStringBuilder.append(paramprivate.Xc.get(i));
      if (i != paramprivate.size() - 1) {
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
  
  public final void a(Context paramContext, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramMap);
      return;
    }
    this.Ed.post(new Caelum(this, paramContext, paramMap));
  }
  
  public void b(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    a(paramContext, "401", localStringBuilder.toString(), true);
  }
  
  public void b(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBoolean);
    a(paramContext, "403", localStringBuilder.toString(), true);
  }
  
  public final long c(Context paramContext, String paramString)
  {
    paramContext = d(paramContext, paramString);
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public private<Long> c(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    private localprivate = new private(paramInt);
    paramContext = d(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localprivate.offer(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label62:
        break label62;
      }
      paramInt += 1;
    }
    return localprivate;
  }
  
  public void c(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramContext, "109", localStringBuilder.toString(), true);
  }
  
  public void d(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramContext, "503", localStringBuilder.toString(), true);
  }
  
  public void e(Context paramContext, String paramString)
  {
    a(paramContext, "404", paramString, true);
  }
  
  public void f(Context paramContext, String paramString)
  {
    a(paramContext, "202", paramString);
  }
  
  public long u(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(d(paramContext, "802")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public String v(Context paramContext)
  {
    return d(paramContext, "201");
  }
  
  public String w(Context paramContext)
  {
    return d(paramContext, "205");
  }
  
  public String x(Context paramContext)
  {
    return d(paramContext, "203");
  }
  
  public long y(Context paramContext)
  {
    paramContext = d(paramContext, "401");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label18:
      break label18;
    }
    return 0L;
  }
  
  public boolean z(Context paramContext)
  {
    paramContext = d(paramContext, "403");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Canesatici
 * JD-Core Version:    0.7.0.1
 */