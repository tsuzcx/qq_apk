package com.tencent.mobileqq.qqguildsdk.manager.cachemgr;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MemberClientIdentityDynamicCacheMgr
{
  private Map<String, IGProClientIdentityInfo> a = new ConcurrentHashMap();
  private Map<String, Long> b = new ConcurrentHashMap();
  private Map<String, Long> c = new ConcurrentHashMap();
  private Vector<String> d = new Vector();
  private GPSManagerEngine e;
  private String f;
  
  public MemberClientIdentityDynamicCacheMgr(GPSManagerEngine paramGPSManagerEngine, String paramString)
  {
    this.e = paramGPSManagerEngine;
    this.f = paramString;
  }
  
  private void a()
  {
    while (this.a.size() > 200)
    {
      String str = (String)this.d.remove(0);
      this.c.remove(str);
      this.a.remove(str);
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if ((!this.b.containsKey(paramString1)) && (this.c.containsKey(paramString1)) && (paramLong - ((Long)this.c.get(paramString1)).longValue() > 60000L))
    {
      this.b.put(paramString1, Long.valueOf(paramLong));
      b(new ArrayList(Arrays.asList(new String[] { paramString1 })), paramString2);
    }
  }
  
  private void b(String paramString)
  {
    this.d.remove(paramString);
    this.d.add(paramString);
  }
  
  private void b(List<String> paramList, String paramString)
  {
    this.e.d(this.f, paramString, paramList);
  }
  
  public Map<String, IGProClientIdentityInfo> a(List<String> paramList, String paramString)
  {
    GProUtil.a(this.b);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (a(str, paramString))
      {
        a(l, str, paramString);
        b(str);
        localHashMap.put(str, this.a.get(str));
      }
      else if (!this.b.containsKey(str))
      {
        this.b.put(str, Long.valueOf(l));
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() > 0) {
      b(localArrayList, paramString);
    }
    return localHashMap;
  }
  
  public void a(String paramString)
  {
    this.b.remove(paramString);
  }
  
  public boolean a(String paramString, IGProClientIdentityInfo paramIGProClientIdentityInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIGProClientIdentityInfo == null) {
        return false;
      }
      a();
      if (this.a.containsKey(paramString))
      {
        IGProClientIdentityInfo localIGProClientIdentityInfo = (IGProClientIdentityInfo)this.a.get(paramString);
        if ((localIGProClientIdentityInfo != null) && ((!localIGProClientIdentityInfo.a().equals(paramIGProClientIdentityInfo.a())) || (!localIGProClientIdentityInfo.b().equals(paramIGProClientIdentityInfo.b()))))
        {
          this.a.put(paramString, paramIGProClientIdentityInfo);
          this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
          b(paramString);
          return true;
        }
        return false;
      }
      this.a.put(paramString, paramIGProClientIdentityInfo);
      this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
      b(paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    IGProClientIdentityInfo localIGProClientIdentityInfo = (IGProClientIdentityInfo)this.a.get(paramString1);
    if ((this.a.containsKey(paramString1)) && (localIGProClientIdentityInfo != null))
    {
      paramString1 = localIGProClientIdentityInfo.a();
      if ((paramString1.equals(paramString2)) || (GProConvert.b(paramString1) == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public IGProClientIdentityInfo b(String paramString1, String paramString2)
  {
    GProUtil.a(this.b);
    long l = System.currentTimeMillis();
    if (a(paramString1, paramString2))
    {
      a(l, paramString1, paramString2);
      b(paramString1);
      return (IGProClientIdentityInfo)this.a.get(paramString1);
    }
    if (!this.b.containsKey(paramString1))
    {
      this.b.put(paramString1, Long.valueOf(l));
      b(Arrays.asList(new String[] { paramString1 }), paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.cachemgr.MemberClientIdentityDynamicCacheMgr
 * JD-Core Version:    0.7.0.1
 */