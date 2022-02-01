package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import java.io.File;

public abstract class ApkgBaseInfo
{
  public String apkgFolderPath;
  public String apkgName;
  public String appId;
  public String iconUrl;
  public String mConfigStr;
  
  public ApkgBaseInfo() {}
  
  public ApkgBaseInfo(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    this.apkgFolderPath = paramString;
    if (paramMiniAppBaseInfo != null)
    {
      this.appId = paramMiniAppBaseInfo.appId;
      this.apkgName = paramMiniAppBaseInfo.name;
      this.iconUrl = paramMiniAppBaseInfo.iconUrl;
    }
  }
  
  public static boolean equalObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static String normalize(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int j = paramString.indexOf("?");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ApkgBaseInfo))) {}
    while ((this != paramObject) && (!equalObj(this.appId, ((ApkgBaseInfo)paramObject).appId))) {
      return false;
    }
    return true;
  }
  
  public String getApkgFolderPath()
  {
    return this.apkgFolderPath;
  }
  
  public String getChildFileAbsolutePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(getRootPath(), paramString).getAbsolutePath();
  }
  
  public String getRootPath()
  {
    return this.apkgFolderPath;
  }
  
  public abstract String getRootPath(String paramString);
  
  public abstract String getWorkerPath(String paramString1, String paramString2);
  
  public abstract void init(String paramString);
  
  public abstract boolean isUrlResReady(String paramString, MiniAppInfo paramMiniAppInfo);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:").append(this.appId).append(", name:").append(this.apkgName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
 * JD-Core Version:    0.7.0.1
 */