package com.tencent.tfd.sdk.wxa;

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
  public Handler qd;
  
  static
  {
    StringBuilder localStringBuilder = do.b("turingfd_conf_");
    localStringBuilder.append(final.Rb);
    localStringBuilder.append("_");
    localStringBuilder.append("wxaMini");
    FILE_NAME = localStringBuilder.toString();
  }
  
  public Canesatici(Handler paramHandler)
  {
    this.qd = paramHandler;
  }
  
  public static long F(Context paramContext)
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
        paramContext.putString(str1, void.a(void.b(str2.getBytes(), void.l())));
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
          paramContext = void.a(paramContext, void.l());
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
  
  public long A(Context paramContext)
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
  
  public String B(Context paramContext)
  {
    return d(paramContext, "404");
  }
  
  public String C(Context paramContext)
  {
    return d(paramContext, "202");
  }
  
  public long D(Context paramContext)
  {
    return c(paramContext, "109");
  }
  
  public instanceof E(Context paramContext)
  {
    try
    {
      str1 = d(paramContext, "101");
      if (TextUtils.isEmpty(str1))
      {
        paramContext = instanceof.g(1);
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
      instanceof.do localdo;
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
    localdo = instanceof.create(0);
    localdo.Nc = l1;
    localdo.Mc = str1;
    localdo.Qc = str2;
    localdo.Rc = str3;
    localdo.Sc = str4;
    localdo.Tc = str5;
    localdo.Uc = new CanisMinor(paramContext);
    paramContext = localdo.build();
    return paramContext;
    return instanceof.g(1);
  }
  
  public void G(Context paramContext)
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
  
  public void a(Context paramContext, instanceof paraminstanceof)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", paraminstanceof.Mc);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paraminstanceof.Nc);
    localHashMap.put("102", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paraminstanceof.Qc)) {
      localHashMap.put("104", paraminstanceof.Qc);
    }
    if (!TextUtils.isEmpty(paraminstanceof.Rc)) {
      localHashMap.put("105", paraminstanceof.Rc);
    }
    if (!TextUtils.isEmpty(paraminstanceof.Sc)) {
      localHashMap.put("106", paraminstanceof.Sc);
    }
    if (!TextUtils.isEmpty(paraminstanceof.Tc)) {
      localHashMap.put("110", paraminstanceof.Tc);
    }
    paraminstanceof = paraminstanceof.Uc;
    if ((paraminstanceof != null) && (!TextUtils.isEmpty(paraminstanceof.toString()))) {
      localHashMap.put("111", paraminstanceof.toString());
    }
    a(paramContext, localHashMap, true);
  }
  
  public void a(Context paramContext, private<Long> paramprivate)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramprivate.size())
    {
      localStringBuilder.append(paramprivate.Ic.get(i));
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
    this.qd.post(new Caelum(this, paramContext, paramMap));
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
  
  public void c(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBoolean);
    a(paramContext, "403", localStringBuilder.toString(), true);
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
  
  public String u(Context paramContext)
  {
    return d(paramContext, "201");
  }
  
  public String v(Context paramContext)
  {
    return d(paramContext, "205");
  }
  
  public String w(Context paramContext)
  {
    return d(paramContext, "203");
  }
  
  public long x(Context paramContext)
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
  
  public boolean y(Context paramContext)
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
  
  public String z(Context paramContext)
  {
    return d(paramContext, "405");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Canesatici
 * JD-Core Version:    0.7.0.1
 */