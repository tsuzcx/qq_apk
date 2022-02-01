package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import java.io.Serializable;

public class MiniAppConfig
  implements Serializable
{
  public BaseLibInfo baseLibInfo;
  public ApkgConfig config;
  public LaunchParam launchParam;
  
  public MiniAppConfig(ApkgConfig paramApkgConfig, BaseLibInfo paramBaseLibInfo)
  {
    this.config = paramApkgConfig;
    this.baseLibInfo = paramBaseLibInfo;
  }
  
  public static boolean isValid(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      paramMiniAppConfig = paramMiniAppConfig.config;
      if ((paramMiniAppConfig != null) && (!TextUtils.isEmpty(paramMiniAppConfig.mini_appid))) {
        return true;
      }
    }
    return false;
  }
  
  public int getRuntimeType()
  {
    ApkgConfig localApkgConfig = this.config;
    if (localApkgConfig == null) {
      return 0;
    }
    return localApkgConfig.getRuntimeType();
  }
  
  public boolean isDebugVersionChange(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (getRuntimeType() == 1))
    {
      if (getRuntimeType() != paramMiniAppConfig.getRuntimeType()) {
        return false;
      }
      if ((paramMiniAppConfig.config.mini_appid.equals(this.config.mini_appid)) && (!paramMiniAppConfig.config.qq_qr_code.equals(this.config.qq_qr_code))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isInnerUser()
  {
    ApkgConfig localApkgConfig = this.config;
    return (localApkgConfig != null) && (localApkgConfig.isInnerUser());
  }
  
  public boolean isRiskOpen()
  {
    ApkgConfig localApkgConfig = this.config;
    return (localApkgConfig != null) && (localApkgConfig.isRiskOpen());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppConfig{config=");
    localStringBuilder.append(this.config);
    localStringBuilder.append(", launchParam=");
    localStringBuilder.append(this.launchParam);
    localStringBuilder.append(", baseLibInfo=");
    localStringBuilder.append(this.baseLibInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.MiniAppConfig
 * JD-Core Version:    0.7.0.1
 */