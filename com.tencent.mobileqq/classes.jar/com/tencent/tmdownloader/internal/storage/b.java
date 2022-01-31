package com.tencent.tmdownloader.internal.storage;

import android.content.Context;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.ShareUrlConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.f;
import com.tencent.tmassistantbase.util.g;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b b;
  private Map<String, JceStruct> a = new ConcurrentHashMap();
  private ShareUrlConfig c;
  
  public static b a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new b();
      }
      return b;
    }
    finally {}
  }
  
  public <T extends JceStruct> T a(String paramString, Class<T> paramClass)
  {
    if (this.a.containsKey(paramString)) {
      try
      {
        paramClass = (JceStruct)this.a.get(paramString);
        r.c("JceCacheManager", "value of " + paramString + " found, return");
        return paramClass;
      }
      catch (Exception paramString)
      {
        r.e("JceCacheManager", "<get> type cast error!");
      }
    }
    for (;;)
    {
      return null;
      byte[] arrayOfByte = Settings.getInstance().getBlob(paramString);
      if (arrayOfByte != null)
      {
        try
        {
          paramClass = ProtocolPackage.bytes2JceObj(arrayOfByte, paramClass);
          if (paramClass == null) {
            break label144;
          }
          this.a.put(paramString, paramClass);
          r.c("JceCacheManager", "<get> Get value of " + paramString + " from database and save it to cache");
          return paramClass;
        }
        catch (Exception paramString)
        {
          r.e("JceCacheManager", "<get> type cast error!");
        }
        continue;
        label144:
        r.c("JceCacheManager", "<get> value of " + paramString + " is null !");
      }
    }
  }
  
  public List<String> a(Context paramContext)
  {
    if (GlobalUtil.getInstance().getContext() == null)
    {
      r.c("JceCacheManager", "<getFilterConfig> GlobalUtil context is null, set it");
      GlobalUtil.getInstance().setContext(paramContext.getApplicationContext());
    }
    if (this.c != null)
    {
      r.c("JceCacheManager", "<getFilterConfig> cache is available using cache");
      return this.c.blackList;
    }
    paramContext = Settings.getInstance().getBlob("key_filter_config");
    StringBuilder localStringBuilder;
    if (paramContext != null) {
      try
      {
        paramContext = (ShareUrlConfig)ProtocolPackage.bytes2JceObj(paramContext, ShareUrlConfig.class);
        localStringBuilder = new StringBuilder();
        Iterator localIterator = paramContext.blackList.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append((String)localIterator.next());
          localStringBuilder.append("\n");
        }
        r.c("JceCacheManager", "<getFilterConfig> data is null");
      }
      catch (Exception paramContext)
      {
        r.e("JceCacheManager", "<getFilterConfig> decode ShareUrlConfig error!!! error = " + paramContext.getMessage());
      }
    } else {
      return new ArrayList();
    }
    r.c("JceCacheManager", "<getFilterConfig> config content : " + localStringBuilder.toString() + ", and setting cache");
    this.c = paramContext;
    paramContext = paramContext.blackList;
    return paramContext;
  }
  
  public <T extends JceStruct> void a(String paramString, byte[] paramArrayOfByte, Class<T> paramClass)
  {
    f.a(g.b).post(new c(this, paramString, paramArrayOfByte, paramClass));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Settings.getInstance().setBlob("key_report_config", paramArrayOfByte);
  }
  
  public BatchReportConfig b()
  {
    byte[] arrayOfByte = Settings.getInstance().getBlob("key_report_config");
    if (arrayOfByte != null) {
      return (BatchReportConfig)ProtocolPackage.bytes2JceObj(arrayOfByte, BatchReportConfig.class);
    }
    return null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    try
    {
      ShareUrlConfig localShareUrlConfig = (ShareUrlConfig)ProtocolPackage.bytes2JceObj(paramArrayOfByte, ShareUrlConfig.class);
      if (localShareUrlConfig != null)
      {
        r.c("JceCacheManager", "ShareUrlConfig is ok, config.blackList = " + localShareUrlConfig.blackList);
        this.c = localShareUrlConfig;
      }
      for (;;)
      {
        Settings.getInstance().setBlob("key_filter_config", paramArrayOfByte);
        return;
        r.c("JceCacheManager", "ShareUrlConfig is null");
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      r.c("JceCacheManager", "saveFilterConfig error " + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.b
 * JD-Core Version:    0.7.0.1
 */