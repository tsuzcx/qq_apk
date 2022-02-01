package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.util.HashMap;
import java.util.Map;

public class AppKeyRepository
{
  private static AppKeyRepository instance;
  private boolean isAdd = false;
  private String mAppKey = "";
  private String mBsGuid = "";
  private Map<String, Map<String, String>> mMapAppKey = new HashMap();
  private String mPlatfrom = "";
  private String mSdtfrom = "";
  private String mVsKey = "";
  
  public static AppKeyRepository getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new AppKeyRepository();
      }
      AppKeyRepository localAppKeyRepository = instance;
      return localAppKeyRepository;
    }
    finally {}
  }
  
  public void AddAppKey(String paramString, Map<String, String> paramMap)
  {
    if (!this.isAdd)
    {
      this.mBsGuid = ((String)paramMap.get("bsguid"));
      this.mVsKey = ((String)paramMap.get("vskey"));
      this.mPlatfrom = ((String)paramMap.get("platform"));
      this.mSdtfrom = ((String)paramMap.get("sdtfrom"));
      this.mAppKey = ((String)paramMap.get("appkey"));
    }
    this.mMapAppKey.put(paramString, paramMap);
    this.isAdd = true;
  }
  
  public String getAppKey(String paramString)
  {
    return (String)((Map)this.mMapAppKey.get(paramString)).get("appkey");
  }
  
  public String getBsGuid(String paramString)
  {
    return (String)((Map)this.mMapAppKey.get(paramString)).get("bsguid");
  }
  
  public String getPlatform(String paramString)
  {
    return (String)((Map)this.mMapAppKey.get(paramString)).get("platfrom");
  }
  
  public String getSdtfrom(String paramString)
  {
    return (String)((Map)this.mMapAppKey.get(paramString)).get("sdtfrom");
  }
  
  public String getVsKey(String paramString)
  {
    return (String)((Map)this.mMapAppKey.get(paramString)).get("vskey");
  }
  
  public String getmAppKey()
  {
    return this.mAppKey;
  }
  
  public String getmBsGuid()
  {
    return this.mBsGuid;
  }
  
  public String getmPlatfrom()
  {
    return this.mPlatfrom;
  }
  
  public String getmSdtfrom()
  {
    return this.mSdtfrom;
  }
  
  public String getmVsKey()
  {
    return this.mVsKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.AppKeyRepository
 * JD-Core Version:    0.7.0.1
 */