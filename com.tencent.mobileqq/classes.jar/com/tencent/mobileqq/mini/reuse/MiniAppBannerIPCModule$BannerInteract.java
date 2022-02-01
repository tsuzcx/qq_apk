package com.tencent.mobileqq.mini.reuse;

import allu;
import bdll;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.MiniAppController;

class MiniAppBannerIPCModule$BannerInteract
  implements allu
{
  private MiniAppConfig mAppConfig;
  
  MiniAppBannerIPCModule$BannerInteract(MiniAppConfig paramMiniAppConfig)
  {
    this.mAppConfig = paramMiniAppConfig;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    bdll.a(MiniAppBannerIPCModule.access$300(), "dc00898", "", "", "0X800A124", "0X800A124", 4, 0, "", "", "", "");
  }
  
  public void onEnter()
  {
    if (this.mAppConfig.launchParam != null) {
      this.mAppConfig.launchParam.scene = 2056;
    }
    MiniAppController.startApp(null, this.mAppConfig, null);
    bdll.a(MiniAppBannerIPCModule.access$300(), "dc00898", "", "", "0X800A123", "0X800A123", 4, 0, "", "", "", "");
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule.BannerInteract
 * JD-Core Version:    0.7.0.1
 */