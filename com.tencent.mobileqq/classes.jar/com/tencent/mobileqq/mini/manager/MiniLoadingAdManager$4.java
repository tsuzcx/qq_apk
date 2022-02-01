package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class MiniLoadingAdManager$4
  implements Runnable
{
  MiniLoadingAdManager$4(MiniLoadingAdManager paramMiniLoadingAdManager, MiniAppConfig paramMiniAppConfig, String paramString) {}
  
  public void run()
  {
    MiniLoadingAdManager.requestPreloadLoadingAd(this.val$mGameAppConfig, this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.4
 * JD-Core Version:    0.7.0.1
 */