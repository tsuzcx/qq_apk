package com.tencent.open.base.http;

import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HttpCacheService
{
  protected static final String a = "com.tencent.open.base.http.HttpCacheService";
  protected static HttpCacheService b;
  protected DbCacheManager c = null;
  protected HashMap<String, HttpCacheData> d = null;
  
  protected HttpCacheService()
  {
    try
    {
      if (this.c == null) {
        this.c = CacheManager.a().a(HttpCacheData.class, 0L, "http_cache_table");
      }
      int j = this.c.i();
      this.d = new HashMap(j);
      int i = 0;
      while (i < j)
      {
        HttpCacheData localHttpCacheData = (HttpCacheData)this.c.a(i);
        if ((localHttpCacheData != null) && (localHttpCacheData.a != null)) {
          this.d.put(localHttpCacheData.a, localHttpCacheData);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      label109:
      break label109;
    }
    this.d = new HashMap();
  }
  
  public static HttpCacheService a()
  {
    try
    {
      if (b == null) {
        b = new HttpCacheService();
      }
      HttpCacheService localHttpCacheService = b;
      return localHttpCacheService;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((HashMap)localObject).size() != 0))
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (this.d.get(paramString) != null)
      {
        paramString = ((HttpCacheData)this.d.get(paramString)).b;
        break label53;
      }
    }
    paramString = "\"\"";
    label53:
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get ETag from cache. ETag=");
    localStringBuilder.append(paramString);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    return paramString;
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (paramString1 != null) {}
    try
    {
      if ((!"".equals(paramString1.trim())) && (paramString3 != null))
      {
        paramString2 = new HttpCacheData(paramString1, paramString2, paramLong, paramString3, paramString4);
        paramString1 = MD5Utils.encodeHexStr(paramString1);
        if (this.c != null)
        {
          if (this.d.containsKey(paramString1))
          {
            paramString3 = this.c;
            paramString4 = new StringBuilder();
            paramString4.append("urlKey='");
            paramString4.append(paramString1);
            paramString4.append("'");
            paramString3.b(paramString2, paramString4.toString());
          }
          else
          {
            b();
            this.c.a(paramString2, 1);
          }
          this.d.put(paramString1, paramString2);
          paramString2 = a;
          paramString3 = new StringBuilder();
          paramString3.append("Get 200, Save response data to cache. urlKey=");
          paramString3.append(paramString1);
          LogUtility.c(paramString2, paramString3.toString());
        }
      }
      else
      {
        paramString4 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveResponse error. params error\n url=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("; ETag=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("; lastModify=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("; response=");
        localStringBuilder.append(paramString3);
        LogUtility.e(paramString4, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
  }
  
  public long b(String paramString)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((HashMap)localObject).size() != 0))
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (this.d.get(paramString) != null)
      {
        l = ((HttpCacheData)this.d.get(paramString)).c;
        break label55;
      }
    }
    long l = 0L;
    label55:
    paramString = a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Get lastModify from cache. lastModify=");
    ((StringBuilder)localObject).append(l);
    LogUtility.c(paramString, ((StringBuilder)localObject).toString());
    return l;
  }
  
  protected void b()
  {
    try
    {
      Object localObject2 = this.d.values().iterator();
      long l2 = System.currentTimeMillis();
      long l1 = 9223372036854775807L;
      String str = null;
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HttpCacheData)((Iterator)localObject2).next();
        if (l2 - ((HttpCacheData)localObject3).d >= 432000000L)
        {
          Object localObject4 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Clear out of date cache. urlkey=");
          localStringBuilder.append(((HttpCacheData)localObject3).a);
          LogUtility.c((String)localObject4, localStringBuilder.toString());
          localObject4 = this.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("urlKey='");
          localStringBuilder.append(((HttpCacheData)localObject3).a);
          localStringBuilder.append("'");
          ((DbCacheManager)localObject4).b(localStringBuilder.toString());
          ((Iterator)localObject2).remove();
        }
        else if (l1 > ((HttpCacheData)localObject3).d)
        {
          l1 = ((HttpCacheData)localObject3).d;
          str = ((HttpCacheData)localObject3).a;
        }
      }
      if (this.d.size() >= 50)
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Reached max cache count:50. Clear last cache data. urlKey=");
        ((StringBuilder)localObject3).append(((HttpCacheData)this.d.get(str)).a);
        LogUtility.c((String)localObject2, ((StringBuilder)localObject3).toString());
        this.d.remove(str);
        localObject2 = this.c;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("urlKey='");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append("'");
        ((DbCacheManager)localObject2).b(((StringBuilder)localObject3).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public String c(String paramString)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((HashMap)localObject).size() != 0))
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (this.d.get(paramString) != null)
      {
        paramString = ((HttpCacheData)this.d.get(paramString)).f;
        break label53;
      }
    }
    paramString = "";
    label53:
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get lastModify from cache. lastModify=");
    localStringBuilder.append(paramString);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    return paramString;
  }
  
  public void c()
  {
    try
    {
      if (this.d != null) {
        this.d.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String d(String paramString)
  {
    Object localObject = this.d;
    String str1 = "";
    String str2 = str1;
    if (localObject != null)
    {
      str2 = str1;
      if (((HashMap)localObject).size() != 0)
      {
        str2 = MD5Utils.encodeHexStr(paramString);
        paramString = str1;
        if (this.d.get(str2) != null) {
          paramString = ((HttpCacheData)this.d.get(str2)).e;
        }
        str1 = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Get 304, Load response data from cache. urlKey=");
        ((StringBuilder)localObject).append(str2);
        LogUtility.c(str1, ((StringBuilder)localObject).toString());
        str2 = paramString;
      }
    }
    return str2;
  }
  
  public void e(String paramString)
  {
    try
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (paramString != null)
      {
        this.d.remove(paramString);
        DbCacheManager localDbCacheManager = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("urlKey='");
        localStringBuilder.append(paramString);
        localStringBuilder.append("'");
        localDbCacheManager.b(localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCacheService
 * JD-Core Version:    0.7.0.1
 */