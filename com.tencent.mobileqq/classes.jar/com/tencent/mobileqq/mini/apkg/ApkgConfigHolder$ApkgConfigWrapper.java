package com.tencent.mobileqq.mini.apkg;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ApkgConfigHolder$ApkgConfigWrapper
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public MiniAppInfo apkgConfig;
  public List<MiniAppInfo> oldConfigs;
  
  public ApkgConfigHolder$ApkgConfigWrapper() {}
  
  public ApkgConfigHolder$ApkgConfigWrapper(MiniAppInfo paramMiniAppInfo)
  {
    this.apkgConfig = paramMiniAppInfo;
  }
  
  public void updateConfig(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppInfo localMiniAppInfo = this.apkgConfig;
    this.apkgConfig = paramMiniAppInfo;
    if ((localMiniAppInfo != null) && (localMiniAppInfo.version != paramMiniAppInfo.version))
    {
      if (this.oldConfigs == null) {
        this.oldConfigs = new LinkedList();
      }
      this.oldConfigs.add(paramMiniAppInfo);
      if (this.oldConfigs.size() > 1)
      {
        paramMiniAppInfo = (MiniAppInfo)this.oldConfigs.get(0);
        this.oldConfigs.remove(0);
        ApkgConfigHolder.removeRes(paramMiniAppInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgConfigHolder.ApkgConfigWrapper
 * JD-Core Version:    0.7.0.1
 */