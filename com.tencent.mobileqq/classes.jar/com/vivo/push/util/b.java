package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
{
  protected Context a;
  private String b;
  private volatile SharedPreferences c;
  private HashMap<String, String> d = new HashMap();
  private HashMap<String, Long> e = new HashMap();
  private HashMap<String, Integer> f = new HashMap();
  private HashMap<String, Boolean> g = new HashMap();
  
  public static void a(SharedPreferences.Editor paramEditor)
  {
    if (paramEditor == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  private void a(Map<String, String> paramMap)
  {
    if (paramMap.size() > 0)
    {
      b();
      if (this.c != null)
      {
        SharedPreferences.Editor localEditor = this.c.edit();
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)paramMap.get(str1);
          this.d.put(str1, str2);
          localEditor.putString(str1, str2);
        }
        a(localEditor);
      }
    }
  }
  
  private void b()
  {
    if (this.c == null)
    {
      Context localContext = this.a;
      if (localContext != null)
      {
        this.c = localContext.getSharedPreferences(this.b, 0);
        return;
      }
      throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }
  }
  
  public final int a(String paramString)
  {
    Object localObject = (Integer)this.f.get(paramString);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    b();
    if (this.c != null)
    {
      Integer localInteger = Integer.valueOf(this.c.getInt(paramString, 0));
      localObject = localInteger;
      if (!localInteger.equals(Integer.valueOf(0)))
      {
        this.f.put(paramString, localInteger);
        localObject = localInteger;
      }
    }
    return ((Integer)localObject).intValue();
  }
  
  public final void a()
  {
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.d.clear();
    b();
    if (this.c != null)
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.clear();
      a(localEditor);
    }
  }
  
  public final void a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b = paramString;
      this.c = paramContext.getSharedPreferences(this.b, 0);
      this.a = paramContext;
      paramContext = new HashMap();
      paramContext.put("com.vivo.push.secure_sub_iv", "34,32,33,37,33,34,32,33,33,33,34,41,35,35,32,32");
      paramContext.put("com.vivo.push.secure_sub_key", "33,34,35,36,37,38,39,40,41,32,38,37,33,35,34,33");
      paramContext.put("com.vivo.push.secure_cache_iv", "34,32,33,37,33,34,32,33,33,33,34,41,35,32,32,32");
      paramContext.put("com.vivo.push.secure_cache_key", "33,34,35,36,37,38,39,40,41,32,38,37,36,35,34,33");
      a(paramContext);
      return;
    }
    throw new RuntimeException("sharedFileName can't be null");
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.f.put(paramString, Integer.valueOf(paramInt));
    b();
    if (this.c != null)
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.putInt(paramString, paramInt);
      a(localEditor);
    }
  }
  
  public final void a(String paramString, long paramLong)
  {
    this.e.put(paramString, Long.valueOf(paramLong));
    b();
    if (this.c != null)
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.putLong(paramString, paramLong);
      a(localEditor);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.d.put(paramString1, paramString2);
    b();
    if (this.c != null)
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.putString(paramString1, paramString2);
      a(localEditor);
    }
  }
  
  public final long b(String paramString, long paramLong)
  {
    Object localObject = (Long)this.e.get(paramString);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    b();
    if (this.c != null)
    {
      Long localLong = Long.valueOf(this.c.getLong(paramString, paramLong));
      localObject = localLong;
      if (!localLong.equals(Long.valueOf(paramLong)))
      {
        this.e.put(paramString, localLong);
        localObject = localLong;
      }
    }
    return ((Long)localObject).longValue();
  }
  
  public final String b(String paramString1, String paramString2)
  {
    Object localObject = (String)this.d.get(paramString1);
    if (localObject != null) {
      return localObject;
    }
    b();
    if (this.c != null)
    {
      String str = this.c.getString(paramString1, paramString2);
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!str.equals(paramString2))
        {
          this.d.put(paramString1, str);
          localObject = str;
        }
      }
    }
    return localObject;
  }
  
  public final void b(String paramString)
  {
    this.e.remove(paramString);
    this.f.remove(paramString);
    this.g.remove(paramString);
    this.d.remove(paramString);
    b();
    if (this.c != null)
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      if (this.c.contains(paramString))
      {
        localEditor.remove(paramString);
        a(localEditor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.b
 * JD-Core Version:    0.7.0.1
 */