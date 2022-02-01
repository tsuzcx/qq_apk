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

public class Andromeda
{
  public static final String FILE_NAME = final.jf + "_" + "xqFull";
  public Handler Jg;
  
  public Andromeda(Handler paramHandler)
  {
    this.Jg = paramHandler;
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
  
  public void a(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    a(paramContext, "201", "" + l, true);
  }
  
  public void a(Context paramContext, finally<Long> paramfinally)
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
    this.Jg.post(new synchronized(this, paramContext, localHashMap));
  }
  
  public final void a(Context paramContext, Map<String, String> paramMap)
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
  
  public long n(Context paramContext)
  {
    paramContext = c(paramContext, "201");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public finally<Long> o(Context paramContext)
  {
    System.currentTimeMillis();
    finally localfinally = new finally(6);
    paramContext = c(paramContext, "101").split("_");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i];
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
      i += 1;
    }
    return localfinally;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Andromeda
 * JD-Core Version:    0.7.0.1
 */