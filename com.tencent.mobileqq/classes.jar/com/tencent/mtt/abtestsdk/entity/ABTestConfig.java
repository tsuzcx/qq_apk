package com.tencent.mtt.abtestsdk.entity;

import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ABTestConfig
{
  public static final String ENV_DEBUG = "DEBUG";
  public static final String ENV_RELEASE = "RELEASE";
  public static final String GUID = "guid";
  public static final String GUID_DEV = "guid_dev";
  private static final String TAG = "ABTestConfig";
  private String appId;
  private String appKey;
  private List<String> layerCodes = new ArrayList();
  private Map<String, String> mCustomProfiles = new HashMap();
  private String mEnv = "DEBUG";
  private String mGuid = "guid_dev";
  private String sceneId;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getAppKey()
  {
    return this.appKey;
  }
  
  public Map<String, String> getCustomTag()
  {
    return this.mCustomProfiles;
  }
  
  public String getEnv()
  {
    return this.mEnv;
  }
  
  public String getGuid()
  {
    return this.mGuid;
  }
  
  public List<String> getLayerCodes()
  {
    return this.layerCodes;
  }
  
  public String getRequestUrl()
  {
    String str;
    if ("DEBUG".equals(this.mEnv)) {
      str = "https://qbad.sparta.html5.qq.com/wabt/get_gray_policy_response";
    }
    do
    {
      return str;
      str = "https://casestudy.html5.qq.com/wabt/get_gray_policy_response";
    } while (!"505".equals(this.appId));
    return "https://505.ab.qq.com/wabt/get_gray_policy_response";
  }
  
  public String getSceneId()
  {
    return this.sceneId;
  }
  
  public void removeCustomProfiles(String paramString)
  {
    if (this.mCustomProfiles.containsKey(paramString))
    {
      this.mCustomProfiles.remove(paramString);
      return;
    }
    ABTestLog.error("remove profiles error. [" + paramString + "]" + "is not exist.", new Object[0]);
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setAppKey(String paramString)
  {
    this.appKey = paramString;
  }
  
  public void setBrand(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCustomProfiles.put("brand", paramString);
  }
  
  public void setCity(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCustomProfiles.put("city", paramString);
  }
  
  public void setCustomProfiles(String paramString1, String paramString2)
  {
    this.mCustomProfiles.put(paramString1, paramString2);
  }
  
  public void setEnv(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals("DEBUG")) || (!paramString.equals("RELEASE"))) {
      this.mEnv = "DEBUG";
    }
    this.mEnv = paramString;
  }
  
  public void setGuid(String paramString)
  {
    this.mGuid = paramString;
  }
  
  public void setLayerCodes(List<String> paramList)
  {
    this.layerCodes = paramList;
  }
  
  public void setModel(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCustomProfiles.put("model", paramString);
  }
  
  public void setPlatform(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.equals(paramString, "ios")) || (!TextUtils.equals(paramString, "android"))) {
      return;
    }
    this.mCustomProfiles.put("platform", paramString);
  }
  
  public void setPlatformVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCustomProfiles.put("platform_version", paramString);
  }
  
  public void setProvince(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCustomProfiles.put("province", paramString);
  }
  
  public void setResolutionRatio(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCustomProfiles.put("resolution_ratio", paramString);
  }
  
  public void setSceneId(String paramString)
  {
    this.sceneId = paramString;
  }
  
  public void setSex(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.equals(paramString, "male")) || (!TextUtils.equals(paramString, "female"))) {
      return;
    }
    this.mCustomProfiles.put("sex", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.ABTestConfig
 * JD-Core Version:    0.7.0.1
 */