package com.tencent.securemodule.impl;

import java.io.Serializable;

public class AppInfo
  implements Serializable
{
  private static final long serialVersionUID = -7230176056725930756L;
  public String apkPath;
  public int appType;
  public String certMd5;
  public long fileSize;
  public int isOfficial;
  public String pkgName;
  public int safeLevel;
  public int safeType;
  public String softName;
  public int versionCode;
  public String versionName;
  
  public String getApkPath()
  {
    return this.apkPath;
  }
  
  public int getAppType()
  {
    return this.appType;
  }
  
  public String getCertMd5()
  {
    return this.certMd5;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getSoftName()
  {
    return this.softName;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public void setApkPath(String paramString)
  {
    this.apkPath = paramString;
  }
  
  public void setAppType(int paramInt)
  {
    this.appType = paramInt;
  }
  
  public void setCertMd5(String paramString)
  {
    this.certMd5 = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public void setSoftName(String paramString)
  {
    this.softName = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.impl.AppInfo
 * JD-Core Version:    0.7.0.1
 */