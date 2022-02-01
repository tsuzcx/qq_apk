package com.tencent.mobileqq.gamecenter.util;

import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.qphone.base.util.QLog;

final class QQGameHelper$3
  implements Runnable
{
  public void run()
  {
    QLog.d("QQGameHelper", 1, " now start preload NewQQGamePa Hippy");
    HippyAccessHelper.OpenHippyInfo localOpenHippyInfo = new HippyAccessHelper.OpenHippyInfo();
    localOpenHippyInfo.bundleName = "SGameOfficial";
    localOpenHippyInfo.isPreload = true;
    localOpenHippyInfo.isInToolProcess = false;
    HippyAccessHelper.checkAndPreloadHippyPage(localOpenHippyInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper.3
 * JD-Core Version:    0.7.0.1
 */