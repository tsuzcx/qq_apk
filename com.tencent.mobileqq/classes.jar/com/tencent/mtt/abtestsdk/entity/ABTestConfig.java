package com.tencent.mtt.abtestsdk.entity;

import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ABTestConfig
{
  public static final String ENV = "ENV";
  public static final String ENV_DEBUG = "DEBUG";
  public static final String ENV_RELEASE = "RELEASE";
  public static final String GUID = "guid";
  public static final String GUID_DEV = "guid_dev";
  public static final String KEY_OF_BRAND = "brand";
  public static final String KEY_OF_BUNDLE_INFO = "bundle_app_info";
  public static final String KEY_OF_BUNDLE_VERSION = "bundle_version";
  public static final String KEY_OF_CITY = "city";
  public static final String KEY_OF_DEVICE_BRAND = "device_brand";
  public static final String KEY_OF_DEVICE_HEIGHT = "device_height";
  public static final String KEY_OF_DEVICE_VERSION = "device_version";
  public static final String KEY_OF_DEVICE_WIDTH = "device_width";
  public static final String KEY_OF_LANGUAGE = "language";
  public static final String KEY_OF_MODEL = "model";
  public static final String KEY_OF_OS_VERSION = "os_version";
  public static final String KEY_OF_PLATFORM = "platform";
  public static final String KEY_OF_PLATFORM_VERSION = "platform_version";
  public static final String KEY_OF_PROVINCE = "province";
  public static final String KEY_OF_RESOLUTION_RATIO = "resolution_ratio";
  public static final String KEY_OF_ROMA_BRAND = "ROMA_BRAND";
  public static final String KEY_OF_ROMA_BUNDLE_ID = "ROMA_BUNDLE_ID";
  public static final String KEY_OF_ROMA_BUNDLE_NAME = "ROMA_BUNDLE_NAME";
  public static final String KEY_OF_ROMA_BUNDLE_VER = "ROMA_BUNDLE_VER";
  public static final String KEY_OF_ROMA_OS_MODEL = "ROMA_OS_MODEL";
  public static final String KEY_OF_ROMA_OS_VER = "ROMA_OS_VER";
  public static final String KEY_OF_ROMA_PLATFORM = "ROMA_PLATFORM";
  public static final String KEY_OF_ROMA_RESOLUTION = "ROMA_RESOLUTION";
  public static final String KEY_OF_ROMA_SDK_VERSION = "ROMA_SDK_VERSION";
  public static final String KEY_OF_SEX = "sex";
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
    if ("DEBUG".equals(this.mEnv)) {
      return "https://qbad.sparta.html5.qq.com/wabt/get_gray_policy_response";
    }
    return "https://ad.browser.qq.com/wabt/get_gray_policy_response";
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