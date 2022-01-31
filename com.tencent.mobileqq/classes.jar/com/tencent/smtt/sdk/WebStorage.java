package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage
{
  private static WebStorage mInstance;
  
  private static WebStorage createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WebStorage();
      }
      WebStorage localWebStorage = mInstance;
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    return createInstance();
  }
  
  public void deleteAllData()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webStorageDeleteAllData();
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
  }
  
  public void deleteOrigin(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webStorageDeleteOrigin(paramString);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webStorageGetOrigins(paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webStorageGetQuotaForOrigin(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webStorageGetUsageForOrigin(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webStorageSetQuotaForOrigin(paramString, paramLong);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
  }
  
  public static class Origin
  {
    private String mOrigin = null;
    private long mQuota = 0L;
    private long mUsage = 0L;
    
    protected Origin(String paramString)
    {
      this.mOrigin = paramString;
    }
    
    protected Origin(String paramString, long paramLong)
    {
      this.mOrigin = paramString;
      this.mQuota = paramLong;
    }
    
    protected Origin(String paramString, long paramLong1, long paramLong2)
    {
      this.mOrigin = paramString;
      this.mQuota = paramLong1;
      this.mUsage = paramLong2;
    }
    
    public String getOrigin()
    {
      return this.mOrigin;
    }
    
    public long getQuota()
    {
      return this.mQuota;
    }
    
    public long getUsage()
    {
      return this.mUsage;
    }
  }
  
  @Deprecated
  public static abstract interface QuotaUpdater
  {
    public abstract void updateQuota(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage
 * JD-Core Version:    0.7.0.1
 */