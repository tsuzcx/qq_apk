package com.tencent.mobileqq.qqguildsdk.manager.cachemgr;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.util.GProUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DynamicCacheMgr<T>
{
  protected Map<String, T> a;
  private Vector<String> b;
  private Map<String, Long> c = new ConcurrentHashMap();
  private Map<String, Long> d = new ConcurrentHashMap();
  
  public DynamicCacheMgr()
  {
    this.a = new ConcurrentHashMap();
    this.b = new Vector();
  }
  
  public DynamicCacheMgr(Map<String, T> paramMap, Vector<String> paramVector)
  {
    this.a = paramMap;
    this.b = paramVector;
  }
  
  private void a()
  {
    while (this.a.size() > 200)
    {
      String str = (String)this.b.remove(0);
      this.d.remove(str);
      this.a.remove(str);
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if ((!this.c.containsKey(paramString)) && (this.d.containsKey(paramString)) && (paramLong - ((Long)this.d.get(paramString)).longValue() > 60000L))
    {
      this.c.put(paramString, Long.valueOf(paramLong));
      a(new ArrayList(Arrays.asList(new String[] { paramString })));
    }
  }
  
  private void b(String paramString)
  {
    this.b.remove(paramString);
    this.b.add(paramString);
  }
  
  protected abstract void a(List<String> paramList);
  
  protected abstract boolean a(Object paramObject);
  
  protected boolean a(String paramString)
  {
    return (this.a.containsKey(paramString)) && (this.a.get(paramString) != null);
  }
  
  protected abstract boolean a(String paramString, Object paramObject);
  
  public T c(String paramString)
  {
    GProUtil.a(this.c);
    long l = System.currentTimeMillis();
    if (a(paramString))
    {
      a(l, paramString);
      b(paramString);
      return this.a.get(paramString);
    }
    if (!this.c.containsKey(paramString))
    {
      this.c.put(paramString, Long.valueOf(l));
      a(Arrays.asList(new String[] { paramString }));
    }
    return null;
  }
  
  protected abstract T c(String paramString, Object paramObject);
  
  public Map<String, T> c(List<String> paramList)
  {
    GProUtil.a(this.c);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (a(str))
      {
        a(l, str);
        b(str);
        localHashMap.put(str, this.a.get(str));
      }
      else if (!this.c.containsKey(str))
      {
        this.c.put(str, Long.valueOf(l));
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() > 0)
    {
      a(localArrayList);
      paramList = new StringBuilder();
      paramList.append("fetchList ：");
      paramList.append(localArrayList);
      GProLog.a("DynamicCacheMgr", false, "cache", "getDatas ", "fetch data from svr", paramList.toString());
    }
    return localHashMap;
  }
  
  public void d(String paramString)
  {
    this.c.remove(paramString);
  }
  
  public boolean d(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (a(paramObject)) {
        return false;
      }
      a();
      if (this.a.containsKey(paramString))
      {
        if (a(paramString, paramObject))
        {
          this.d.put(paramString, Long.valueOf(System.currentTimeMillis()));
          b(paramString);
          return true;
        }
        return false;
      }
      this.a.put(paramString, c(paramString, paramObject));
      this.d.put(paramString, Long.valueOf(System.currentTimeMillis()));
      b(paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.cachemgr.DynamicCacheMgr
 * JD-Core Version:    0.7.0.1
 */