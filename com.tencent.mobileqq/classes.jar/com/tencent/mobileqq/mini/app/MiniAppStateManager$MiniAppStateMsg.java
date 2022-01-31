package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;

public class MiniAppStateManager$MiniAppStateMsg
{
  public ApkgInfo apkgInfo;
  public String appId;
  public int state;
  public int versionType;
  
  public MiniAppStateManager$MiniAppStateMsg(int paramInt1, String paramString, int paramInt2, ApkgInfo paramApkgInfo)
  {
    this.state = paramInt1;
    this.appId = paramString;
    this.versionType = paramInt2;
    this.apkgInfo = paramApkgInfo;
  }
  
  public String toString()
  {
    return "MiniAppStateMsg{state=" + this.state + ", apkgInfo=" + this.apkgInfo + ", appId='" + this.appId + '\'' + ", versionType='" + this.versionType + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg
 * JD-Core Version:    0.7.0.1
 */