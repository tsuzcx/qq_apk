package com.tencent.mtt.abtestsdk.entity;

import android.content.res.Resources.NotFoundException;
import android.support.annotation.XmlRes;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ABTestConfig
{
  public static final String ENV_DEBUG = "DEBUG";
  public static final String ENV_RELEASE = "RELEASE";
  private static final int XML_DEFAULT_RESOURCE = -1;
  protected String appId = "";
  protected String appKey = "";
  private List<ABTestConfig.ClientType> clientTypeList = new ArrayList();
  protected boolean isDiskCache = true;
  private List<String> layerCodes = new ArrayList();
  protected String mCurEnv = "RELEASE";
  private Map<String, String> mCustomProfiles = new HashMap();
  protected String mGuid = "";
  private List<String> sceneIds = new ArrayList();
  private int xmlDefaultResource = -1;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getAppKey()
  {
    return this.appKey;
  }
  
  public List<ABTestConfig.ClientType> getClientTypeList()
  {
    if (this.clientTypeList.isEmpty()) {
      this.clientTypeList.add(ABTestConfig.ClientType.ABClient);
    }
    return this.clientTypeList;
  }
  
  public String getCurEnv()
  {
    return this.mCurEnv;
  }
  
  public Map<String, String> getCustomProfiles()
  {
    return this.mCustomProfiles;
  }
  
  public String getExperimentUrl()
  {
    if ("DEBUG".equals(this.mCurEnv)) {
      return "https://tdata.ab.qq.com/wabt/get_gray_policy";
    }
    if ("1505".equals(this.appId)) {
      return "https://qqdata.ab.qq.com/wabt/get_gray_policy";
    }
    return "https://data.ab.qq.com/wabt/get_gray_policy";
  }
  
  public String getFeatureUrl()
  {
    if ("DEBUG".equals(this.mCurEnv)) {
      return "https://tdata.ab.qq.com/wabt/get_feature_policy";
    }
    if ("1505".equals(this.appId)) {
      return "https://qqdata.ab.qq.com/wabt/get_feature_policy";
    }
    return "https://data.ab.qq.com/wabt/get_feature_policy";
  }
  
  public String getGuid()
  {
    return this.mGuid;
  }
  
  public List<String> getLayerCodes()
  {
    return this.layerCodes;
  }
  
  public String getRemoteConfigUrl()
  {
    if ("DEBUG".equals(this.mCurEnv)) {
      return "http://configserver.tab.sparta.html5.qq.com/trpc.tab.rconfigserver.RemoteConfigServer/GetRemoteConfig";
    }
    return "https://config.ab.qq.com/trpc.tab.rconfigserver.RemoteConfigServer/GetRemoteConfig";
  }
  
  public List<String> getSceneIds()
  {
    return this.sceneIds;
  }
  
  public int getXmlDefaultResource()
  {
    int i = this.xmlDefaultResource;
    if (i != -1) {
      return i;
    }
    throw new Resources.NotFoundException();
  }
  
  public boolean isDiskCache()
  {
    return this.isDiskCache;
  }
  
  public void removeCustomProfiles(String paramString)
  {
    if (this.mCustomProfiles.containsKey(paramString))
    {
      this.mCustomProfiles.remove(paramString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remove profiles error. [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]is not exist.");
    ABTestLog.error(localStringBuilder.toString(), new Object[0]);
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setAppKey(String paramString)
  {
    this.appKey = paramString;
  }
  
  public void setClientTypeList(List<ABTestConfig.ClientType> paramList)
  {
    this.clientTypeList = paramList;
  }
  
  public void setCurEnv(String paramString)
  {
    this.mCurEnv = paramString;
  }
  
  public void setCustomProfiles(Map<String, String> paramMap)
  {
    this.mCustomProfiles = paramMap;
  }
  
  public void setDiskCache(boolean paramBoolean)
  {
    this.isDiskCache = paramBoolean;
  }
  
  public void setGuid(String paramString)
  {
    this.mGuid = paramString;
  }
  
  public void setLayerCodes(List<String> paramList)
  {
    this.layerCodes = paramList;
  }
  
  public void setSceneIds(List<String> paramList)
  {
    this.sceneIds = paramList;
  }
  
  public void setXmlDefaultResource(@XmlRes int paramInt)
  {
    this.xmlDefaultResource = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.ABTestConfig
 * JD-Core Version:    0.7.0.1
 */