package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class UpgradeController$2
  implements Runnable
{
  UpgradeController$2(UpgradeController paramUpgradeController) {}
  
  public void run()
  {
    BannerManager.a().b(InstallUpgradeBannerProcessor.a, 3000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.2
 * JD-Core Version:    0.7.0.1
 */