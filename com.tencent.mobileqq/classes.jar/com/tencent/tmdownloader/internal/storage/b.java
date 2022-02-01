package com.tencent.tmdownloader.internal.storage;

import android.content.Context;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistant.common.jce.ShareUrlConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
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
    if (b == null) {
      try
      {
        if (b == null) {
          b = new b();
        }
      }
      finally {}
    }
    return b;
  }
  
  public <T extends JceStruct> T a(String paramString, Class<T> paramClass)
  {
    if (this.a.containsKey(paramString)) {}
    try
    {
      paramClass = (JceStruct)this.a.get(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("value of ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" found, return");
      ab.c("JceCacheManager", ((StringBuilder)localObject).toString());
      return paramClass;
    }
    catch (Exception paramString)
    {
      Object localObject;
      label66:
      break label66;
    }
    ab.e("JceCacheManager", "<get> type cast error!");
    break label196;
    localObject = Settings.getInstance().getBlob(paramString);
    if (localObject != null) {}
    try
    {
      paramClass = ProtocolPackage.bytes2JceObj((byte[])localObject, paramClass);
      if (paramClass != null)
      {
        this.a.put(paramString, paramClass);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<get> Get value of ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" from database and save it to cache");
        ab.c("JceCacheManager", ((StringBuilder)localObject).toString());
        return paramClass;
      }
      paramClass = new StringBuilder();
      paramClass.append("<get> value of ");
      paramClass.append(paramString);
      paramClass.append(" is null !");
      ab.c("JceCacheManager", paramClass.toString());
    }
    catch (Exception paramString)
    {
      label189:
      label196:
      break label189;
    }
    ab.e("JceCacheManager", "<get> type cast error!");
    return null;
  }
  
  public List<String> a(Context paramContext)
  {
    if (GlobalUtil.getInstance().getContext() == null)
    {
      ab.c("JceCacheManager", "<getFilterConfig> GlobalUtil context is null, set it");
      GlobalUtil.getInstance().setContext(paramContext.getApplicationContext());
    }
    if (this.c != null)
    {
      ab.c("JceCacheManager", "<getFilterConfig> cache is available using cache");
      return this.c.blackList;
    }
    paramContext = Settings.getInstance().getBlob("key_filter_config");
    if (paramContext != null) {
      try
      {
        paramContext = (ShareUrlConfig)ProtocolPackage.bytes2JceObj(paramContext, ShareUrlConfig.class);
        localStringBuilder = new StringBuilder();
        Object localObject = paramContext.blackList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append("\n");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<getFilterConfig> config content : ");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
        ((StringBuilder)localObject).append(", and setting cache");
        ab.c("JceCacheManager", ((StringBuilder)localObject).toString());
        this.c = paramContext;
        paramContext = paramContext.blackList;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<getFilterConfig> decode ShareUrlConfig error!!! error = ");
        localStringBuilder.append(paramContext.getMessage());
        ab.e("JceCacheManager", localStringBuilder.toString());
      }
    }
    ab.c("JceCacheManager", "<getFilterConfig> data is null");
    return new ArrayList();
  }
  
  public <T extends JceStruct> void a(String paramString, byte[] paramArrayOfByte, Class<T> paramClass)
  {
    k.a().post(new c(this, paramString, paramArrayOfByte, paramClass));
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
      localObject = (ShareUrlConfig)ProtocolPackage.bytes2JceObj(paramArrayOfByte, ShareUrlConfig.class);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShareUrlConfig is ok, config.blackList = ");
        localStringBuilder.append(((ShareUrlConfig)localObject).blackList);
        ab.c("JceCacheManager", localStringBuilder.toString());
        this.c = ((ShareUrlConfig)localObject);
      }
      else
      {
        ab.c("JceCacheManager", "ShareUrlConfig is null");
      }
      Settings.getInstance().setBlob("key_filter_config", paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveFilterConfig error ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      ab.c("JceCacheManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public NewQqCenterConfig c()
  {
    byte[] arrayOfByte = Settings.getInstance().getBlob("key_new_app_center_config");
    if (arrayOfByte != null) {
      return (NewQqCenterConfig)ProtocolPackage.bytes2JceObj(arrayOfByte, NewQqCenterConfig.class);
    }
    return null;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    Settings.getInstance().setBlob("key_new_app_center_config", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.b
 * JD-Core Version:    0.7.0.1
 */