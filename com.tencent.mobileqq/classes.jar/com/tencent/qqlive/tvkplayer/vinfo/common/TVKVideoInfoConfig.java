package com.tencent.qqlive.tvkplayer.vinfo.common;

import java.util.HashMap;
import java.util.Map;

public class TVKVideoInfoConfig
{
  private static final int CGI_MAX_RETRY_TIME = 3;
  private static final int CGI_REQUEST_TIME_OUT = 3000;
  private static TVKVideoInfoConfig mCgiConfig = null;
  private int mCgiRetryTime = 3;
  private int mCgiTimeoutMS = 3000;
  private String mChecktimeBkUrl;
  private String mChecktimeUrl;
  private boolean mEnableHttps = false;
  private String mGetvinfoBkUrl;
  private String mGetvinfoUrl;
  private String mGetvkeyBkUrl;
  private String mGetvkeyUrl;
  private Map<String, Map<String, String>> mRequestExtParam = new HashMap();
  private boolean mVinfoEnableHttps = true;
  private boolean mVkeyEnableHttps = true;
  
  public static TVKVideoInfoConfig getInstance()
  {
    try
    {
      if (mCgiConfig == null) {
        mCgiConfig = new TVKVideoInfoConfig();
      }
      TVKVideoInfoConfig localTVKVideoInfoConfig = mCgiConfig;
      return localTVKVideoInfoConfig;
    }
    finally {}
  }
  
  public int getCgiRetryTime()
  {
    return this.mCgiRetryTime;
  }
  
  public int getCgiTimeoutMS()
  {
    return this.mCgiTimeoutMS;
  }
  
  public String getChecktimeBkUrl()
  {
    return this.mChecktimeBkUrl;
  }
  
  public String getChecktimeUrl()
  {
    return this.mChecktimeUrl;
  }
  
  public String getGetvinfoBkUrl()
  {
    return this.mGetvinfoBkUrl;
  }
  
  public String getGetvinfoUrl()
  {
    return this.mGetvinfoUrl;
  }
  
  public String getGetvkeyBkUrl()
  {
    return this.mGetvkeyBkUrl;
  }
  
  public String getGetvkeyUrl()
  {
    return this.mGetvkeyUrl;
  }
  
  public Map<String, String> getRequestExtParam(String paramString)
  {
    synchronized (this.mRequestExtParam)
    {
      paramString = (Map)this.mRequestExtParam.get(paramString);
      return paramString;
    }
  }
  
  public boolean isEnableHttps()
  {
    return this.mEnableHttps;
  }
  
  public boolean isVinfoEnableHttps()
  {
    return this.mVinfoEnableHttps;
  }
  
  public boolean isVkeyEnableHttps()
  {
    return this.mVkeyEnableHttps;
  }
  
  public void removeRequestExtParam(String paramString)
  {
    synchronized (this.mRequestExtParam)
    {
      this.mRequestExtParam.remove(paramString);
      return;
    }
  }
  
  public void setCgiRetryTime(int paramInt)
  {
    this.mCgiRetryTime = paramInt;
  }
  
  public void setCgiTimeoutMS(int paramInt)
  {
    this.mCgiTimeoutMS = paramInt;
  }
  
  public void setChecktimeBkUrl(String paramString)
  {
    this.mChecktimeBkUrl = paramString;
  }
  
  public void setChecktimeUrl(String paramString)
  {
    this.mChecktimeUrl = paramString;
  }
  
  public void setEnableHttps(boolean paramBoolean)
  {
    this.mEnableHttps = paramBoolean;
  }
  
  public void setGetvinfoBkUrl(String paramString)
  {
    this.mGetvinfoBkUrl = paramString;
  }
  
  public void setGetvinfoUrl(String paramString)
  {
    this.mGetvinfoUrl = paramString;
  }
  
  public void setGetvkeyBkUrl(String paramString)
  {
    this.mGetvkeyBkUrl = paramString;
  }
  
  public void setGetvkeyUrl(String paramString)
  {
    this.mGetvkeyUrl = paramString;
  }
  
  public void setRequestExtParam(String paramString, Map<String, String> paramMap)
  {
    Map localMap = this.mRequestExtParam;
    if (paramMap != null) {}
    try
    {
      if (!paramMap.isEmpty()) {
        this.mRequestExtParam.put(paramString, paramMap);
      }
      return;
    }
    finally {}
  }
  
  public void setVinfoEnableHttps(boolean paramBoolean)
  {
    this.mVinfoEnableHttps = paramBoolean;
  }
  
  public void setVkeyEnableHttps(boolean paramBoolean)
  {
    this.mVkeyEnableHttps = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig
 * JD-Core Version:    0.7.0.1
 */