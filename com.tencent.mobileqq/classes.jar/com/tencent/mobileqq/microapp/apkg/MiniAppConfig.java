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
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.mini_appid));
  }
  
  public int getRuntimeType()
  {
    if (this.config == null) {
      return 0;
    }
    return this.config.getRuntimeType();
  }
  
  public boolean isDebugVersionChange(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if ((paramMiniAppConfig == null) || (getRuntimeType() != 1) || (getRuntimeType() != paramMiniAppConfig.getRuntimeType())) {
      bool = false;
    }
    while ((paramMiniAppConfig.config.mini_appid.equals(this.config.mini_appid)) && (!paramMiniAppConfig.config.qq_qr_code.equals(this.config.qq_qr_code))) {
      return bool;
    }
    return false;
  }
  
  public boolean isInnerUser()
  {
    return (this.config != null) && (this.config.isInnerUser());
  }
  
  public boolean isRiskOpen()
  {
    return (this.config != null) && (this.config.isRiskOpen());
  }
  
  public String toString()
  {
    return "MiniAppConfig{config=" + this.config + ", launchParam=" + this.launchParam + ", baseLibInfo=" + this.baseLibInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.MiniAppConfig
 * JD-Core Version:    0.7.0.1
 */