package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class UpgradeController$3
  implements Runnable
{
  UpgradeController$3(UpgradeController paramUpgradeController) {}
  
  public void run()
  {
    BannerManager.a().b(UpgradeBannerProcessor.a, 3000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.3
 * JD-Core Version:    0.7.0.1
 */