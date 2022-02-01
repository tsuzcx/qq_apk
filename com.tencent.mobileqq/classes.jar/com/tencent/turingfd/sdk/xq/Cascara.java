package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Cascara
{
  public static final String FILE_NAME;
  public Handler ch;
  
  static
  {
    StringBuilder localStringBuilder = do.b("turingfd_conf_");
    localStringBuilder.append(float.rf);
    localStringBuilder.append("_");
    localStringBuilder.append("xqFull");
    FILE_NAME = localStringBuilder.toString();
  }
  
  public Cascara(Handler paramHandler)
  {
    this.ch = paramHandler;
  }
  
  public static Set<String> D(Context paramContext)
  {
    HashSet localHashSet = new HashSet();
    paramContext = e(paramContext, "701");
    if (TextUtils.isEmpty(paramContext)) {
      return localHashSet;
    }
    localHashSet.addAll(Arrays.asList(paramContext.split("_")));
    return localHashSet;
  }
  
  public static long L(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(e(paramContext, "801")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public static Map<String, String> R(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = D(paramContext).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TSS_");
      localStringBuilder.append(str);
      localHashMap.put(str, e(paramContext, localStringBuilder.toString()));
    }
    return localHashMap;
  }
  
  public static long S(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(e(paramContext, "503")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public static void T(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = do.b("");
    localStringBuilder.append(System.currentTimeMillis());
    localHashMap.put("801", localStringBuilder.toString());
    a(paramContext, localHashMap);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TSS_");
    localStringBuilder.append(paramInt);
    localHashMap.put(localStringBuilder.toString(), paramString);
    paramString = D(paramContext);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    if (!paramString.contains(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      paramString.add(localStringBuilder.toString());
      paramString = paramString.iterator();
      localStringBuilder = new StringBuilder();
      while (paramString.hasNext())
      {
        localStringBuilder.append((String)paramString.next());
        if (paramString.hasNext()) {
          localStringBuilder.append("_");
        }
      }
      localHashMap.put("701", localStringBuilder.toString());
    }
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
        paramContext.putString(str1, void.b(void.b(str2.getBytes(), void.m())));
      }
      catch (Throwable localThrowable)
      {
        break label99;
      }
    }
  }
  
  public static String e(Context paramContext, String paramString)
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
          paramContext = void.a(void.e(paramContext), void.m());
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
    paramContext = paramContext.getString(paramString, "");
    if (TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    return "";
  }
  
  public static void g(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("602", paramString);
    a(paramContext, localHashMap);
  }
  
  public long E(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(e(paramContext, "802")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public String F(Context paramContext)
  {
    return e(paramContext, "201");
  }
  
  public String G(Context paramContext)
  {
    return e(paramContext, "205");
  }
  
  public String H(Context paramContext)
  {
    return e(paramContext, "203");
  }
  
  public long I(Context paramContext)
  {
    paramContext = e(paramContext, "401");
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
  
  public boolean J(Context paramContext)
  {
    paramContext = e(paramContext, "403");
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
  
  public String K(Context paramContext)
  {
    return e(paramContext, "405");
  }
  
  public long M(Context paramContext)
  {
    paramContext = e(paramContext, "107");
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
  
  public String N(Context paramContext)
  {
    return e(paramContext, "404");
  }
  
  public String O(Context paramContext)
  {
    return e(paramContext, "202");
  }
  
  public long P(Context paramContext)
  {
    return f(paramContext, "109");
  }
  
  public Bilberry Q(Context paramContext)
  {
    try
    {
      str1 = e(paramContext, "101");
      if (TextUtils.isEmpty(str1))
      {
        paramContext = Bilberry.g(1);
        return paramContext;
      }
      l1 = 0L;
    }
    catch (Throwable paramContext)
    {
      String str1;
      long l1;
      long l2;
      label44:
      String str2;
      String str3;
      String str4;
      String str5;
      Bilberry.do localdo;
      label156:
      break label156;
    }
    try
    {
      l2 = Long.valueOf(e(paramContext, "102")).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      break label44;
    }
    str2 = e(paramContext, "104");
    str3 = e(paramContext, "105");
    str4 = e(paramContext, "106");
    str5 = e(paramContext, "110");
    paramContext = e(paramContext, "111");
    localdo = Bilberry.create(0);
    localdo.jdField_a_of_type_Long = l1;
    localdo.jdField_a_of_type_JavaLangString = str1;
    localdo.b = str2;
    localdo.c = str3;
    localdo.d = str4;
    localdo.e = str5;
    localdo.jdField_a_of_type_ComTencentTuringfdSdkXqCherry = new Cherry(paramContext);
    paramContext = localdo.a();
    return paramContext;
    return Bilberry.g(1);
  }
  
  public void U(Context paramContext)
  {
    StringBuilder localStringBuilder = do.b("");
    localStringBuilder.append(System.currentTimeMillis());
    a(paramContext, "501", localStringBuilder.toString(), true);
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
  
  public void a(Context paramContext, Bilberry paramBilberry)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", paramBilberry.Eh);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBilberry.Fh);
    localHashMap.put("102", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramBilberry.Hh)) {
      localHashMap.put("104", paramBilberry.Hh);
    }
    if (!TextUtils.isEmpty(paramBilberry.Ih)) {
      localHashMap.put("105", paramBilberry.Ih);
    }
    if (!TextUtils.isEmpty(paramBilberry.Jh)) {
      localHashMap.put("106", paramBilberry.Jh);
    }
    if (!TextUtils.isEmpty(paramBilberry.Kh)) {
      localHashMap.put("110", paramBilberry.Kh);
    }
    paramBilberry = paramBilberry.Lh;
    if ((paramBilberry != null) && (!TextUtils.isEmpty(paramBilberry.toString()))) {
      localHashMap.put("111", paramBilberry.toString());
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
    this.ch.post(new Casaba(this, paramContext, paramMap));
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBoolean);
    a(paramContext, "403", localStringBuilder.toString(), true);
  }
  
  public void b(Context paramContext, long paramLong)
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
  
  public void b(Context paramContext, continue<Long> paramcontinue)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramcontinue.size())
    {
      localStringBuilder.append(paramcontinue.qg.get(i));
      if (i != paramcontinue.size() - 1) {
        localStringBuilder.append("_");
      }
      i += 1;
    }
    a(paramContext, "402", localStringBuilder.toString(), true);
  }
  
  public continue<Long> c(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    continue localcontinue = new continue(paramInt);
    paramContext = e(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localcontinue.offer(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label62:
        break label62;
      }
      paramInt += 1;
    }
    return localcontinue;
  }
  
  public void c(Context paramContext, long paramLong)
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
  
  public void d(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramContext, "109", localStringBuilder.toString(), true);
  }
  
  public void e(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramContext, "503", localStringBuilder.toString(), true);
  }
  
  public final long f(Context paramContext, String paramString)
  {
    paramContext = e(paramContext, paramString);
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
  
  public void h(Context paramContext, String paramString)
  {
    a(paramContext, "404", paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cascara
 * JD-Core Version:    0.7.0.1
 */