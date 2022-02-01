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

public class Bootes
{
  public static final String FILE_NAME;
  public Handler ch;
  
  static
  {
    StringBuilder localStringBuilder = do.b("ias_");
    localStringBuilder.append(float.rf);
    localStringBuilder.append("_");
    localStringBuilder.append("xqFull");
    FILE_NAME = localStringBuilder.toString();
  }
  
  public Bootes(Handler paramHandler)
  {
    this.ch = paramHandler;
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
  
  public long A(Context paramContext)
  {
    paramContext = e(paramContext, "201");
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
  
  public continue<Long> B(Context paramContext)
  {
    System.currentTimeMillis();
    continue localcontinue = new continue(6);
    paramContext = e(paramContext, "101").split("_");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i];
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
      i += 1;
    }
    return localcontinue;
  }
  
  public void a(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    a(paramContext, "201", localStringBuilder.toString(), true);
  }
  
  public void a(Context paramContext, continue<Long> paramcontinue)
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
    a(paramContext, "101", localStringBuilder.toString(), true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    if (paramBoolean)
    {
      a(paramContext, localHashMap);
      return;
    }
    this.ch.post(new Auriga(this, paramContext, localHashMap));
  }
  
  public final void a(Context paramContext, Map<String, String> paramMap)
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
          label102:
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
        break label102;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bootes
 * JD-Core Version:    0.7.0.1
 */