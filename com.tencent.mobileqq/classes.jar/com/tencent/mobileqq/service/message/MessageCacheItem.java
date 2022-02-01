package com.tencent.mobileqq.service.message;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class MessageCacheItem
{
  public static final String[] a = { "msg_cached_max_seq", "msg_cached_min_seq", "msg_readed_seq", "msg_expired_seq" };
  private AppRuntime b;
  private int c;
  private String d;
  private SharedPreferences e;
  private MessageCache.AsyncEditor f;
  private ArrayList<ConcurrentHashMap<String, Long>> g = null;
  private ConcurrentHashMap<String, Integer> h = new ConcurrentHashMap(2);
  private ConcurrentHashMap<String, ArrayList<Object[]>> i = new ConcurrentHashMap(2);
  
  public MessageCacheItem(AppRuntime paramAppRuntime, int paramInt, String paramString, SharedPreferences paramSharedPreferences, MessageCache.AsyncEditor paramAsyncEditor)
  {
    this.b = paramAppRuntime;
    this.c = paramInt;
    this.d = paramString;
    this.e = paramSharedPreferences;
    this.f = paramAsyncEditor;
    this.g = new ArrayList(a.length);
    paramInt = 0;
    while (paramInt <= 3)
    {
      this.g.add(new ConcurrentHashMap(2));
      paramInt += 1;
    }
  }
  
  public int a(String paramString)
  {
    if (!this.h.containsKey(paramString)) {
      this.h.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.h.get(paramString)).intValue();
  }
  
  public String a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt <= 3) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append(this.d);
      localStringBuilder.append("_");
      localStringBuilder.append(a[paramInt]);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a()
  {
    int j = 0;
    while (j <= 3)
    {
      ((ConcurrentHashMap)this.g.get(j)).clear();
      j += 1;
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= 3))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      long l1;
      if (paramInt2 == 1)
      {
        l1 = Math.max(paramLong, b(paramInt1, paramString));
      }
      else
      {
        l1 = paramLong;
        if (paramInt2 == 2)
        {
          long l2 = b(paramInt1, paramString);
          l1 = paramLong;
          if (l2 != 0L) {
            l1 = Math.min(paramLong, l2);
          }
        }
      }
      ((ConcurrentHashMap)this.g.get(paramInt1)).put(paramString, Long.valueOf(l1));
      if (this.b.getCurrentAccountUin() != null) {
        this.f.putLong(a(paramInt1, paramString), l1);
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.i.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.i.put(paramString, localArrayList1);
  }
  
  public long b(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      if (this.b.getCurrentAccountUin() == null) {
        return 0L;
      }
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.g.get(paramInt);
      if (!localConcurrentHashMap.containsKey(paramString)) {
        localConcurrentHashMap.put(paramString, Long.valueOf(this.e.getLong(a(paramInt, paramString), 0L)));
      }
      return ((Long)localConcurrentHashMap.get(paramString)).longValue();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCacheItem
 * JD-Core Version:    0.7.0.1
 */