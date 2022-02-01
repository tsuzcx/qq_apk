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
  protected static HttpCacheService a;
  protected static final String a = "com.tencent.open.base.http.HttpCacheService";
  protected DbCacheManager a;
  protected HashMap<String, HttpCacheData> a;
  
  protected HttpCacheService()
  {
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    try
    {
      if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager == null) {
        this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager = CacheManager.a().a(HttpCacheData.class, 0L, "http_cache_table");
      }
      int j = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a();
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(j);
      int i = 0;
      while (i < j)
      {
        HttpCacheData localHttpCacheData = (HttpCacheData)this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(i);
        if ((localHttpCacheData != null) && (localHttpCacheData.jdField_a_of_type_JavaLangString != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(localHttpCacheData.jdField_a_of_type_JavaLangString, localHttpCacheData);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      label109:
      break label109;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static HttpCacheService a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService == null) {
        jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService = new HttpCacheService();
      }
      HttpCacheService localHttpCacheService = jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService;
      return localHttpCacheService;
    }
    finally {}
  }
  
  public long a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).size() != 0))
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null)
      {
        l = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Long;
        break label55;
      }
    }
    long l = 0L;
    label55:
    paramString = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Get lastModify from cache. lastModify=");
    ((StringBuilder)localObject).append(l);
    LogUtility.c(paramString, ((StringBuilder)localObject).toString());
    return l;
  }
  
  public String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).size() != 0))
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null)
      {
        paramString = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
        break label53;
      }
    }
    paramString = "\"\"";
    label53:
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get ETag from cache. ETag=");
    localStringBuilder.append(paramString);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    return paramString;
  }
  
  protected void a()
  {
    try
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      long l2 = System.currentTimeMillis();
      long l1 = 9223372036854775807L;
      String str = null;
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HttpCacheData)((Iterator)localObject2).next();
        if (l2 - ((HttpCacheData)localObject3).jdField_b_of_type_Long >= 432000000L)
        {
          Object localObject4 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Clear out of date cache. urlkey=");
          localStringBuilder.append(((HttpCacheData)localObject3).jdField_a_of_type_JavaLangString);
          LogUtility.c((String)localObject4, localStringBuilder.toString());
          localObject4 = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("urlKey='");
          localStringBuilder.append(((HttpCacheData)localObject3).jdField_a_of_type_JavaLangString);
          localStringBuilder.append("'");
          ((DbCacheManager)localObject4).b(localStringBuilder.toString());
          ((Iterator)localObject2).remove();
        }
        else if (l1 > ((HttpCacheData)localObject3).jdField_b_of_type_Long)
        {
          l1 = ((HttpCacheData)localObject3).jdField_b_of_type_Long;
          str = ((HttpCacheData)localObject3).jdField_a_of_type_JavaLangString;
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 50)
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Reached max cache count:50. Clear last cache data. urlKey=");
        ((StringBuilder)localObject3).append(((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_JavaLangString);
        LogUtility.c((String)localObject2, ((StringBuilder)localObject3).toString());
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        localObject2 = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager;
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
  
  public void a(String paramString)
  {
    try
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        DbCacheManager localDbCacheManager = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager;
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
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (paramString1 != null) {}
    try
    {
      if ((!"".equals(paramString1.trim())) && (paramString3 != null))
      {
        paramString2 = new HttpCacheData(paramString1, paramString2, paramLong, paramString3, paramString4);
        paramString1 = MD5Utils.encodeHexStr(paramString1);
        if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager != null)
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
          {
            paramString3 = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager;
            paramString4 = new StringBuilder();
            paramString4.append("urlKey='");
            paramString4.append(paramString1);
            paramString4.append("'");
            paramString3.b(paramString2, paramString4.toString());
          }
          else
          {
            a();
            this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(paramString2, 1);
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
          paramString2 = jdField_a_of_type_JavaLangString;
          paramString3 = new StringBuilder();
          paramString3.append("Get 200, Save response data to cache. urlKey=");
          paramString3.append(paramString1);
          LogUtility.c(paramString2, paramString3.toString());
        }
      }
      else
      {
        paramString4 = jdField_a_of_type_JavaLangString;
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
  
  public String b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).size() != 0))
    {
      paramString = MD5Utils.encodeHexStr(paramString);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null)
      {
        paramString = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).d;
        break label53;
      }
    }
    paramString = "";
    label53:
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get lastModify from cache. lastModify=");
    localStringBuilder.append(paramString);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    return paramString;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    String str1 = "";
    String str2 = str1;
    if (localObject != null)
    {
      str2 = str1;
      if (((HashMap)localObject).size() != 0)
      {
        str2 = MD5Utils.encodeHexStr(paramString);
        paramString = str1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str2) != null) {
          paramString = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).c;
        }
        str1 = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Get 304, Load response data from cache. urlKey=");
        ((StringBuilder)localObject).append(str2);
        LogUtility.c(str1, ((StringBuilder)localObject).toString());
        str2 = paramString;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCacheService
 * JD-Core Version:    0.7.0.1
 */