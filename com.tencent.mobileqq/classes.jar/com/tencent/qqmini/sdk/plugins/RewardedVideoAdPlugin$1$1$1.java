package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RewardedVideoAdPlugin$1$1$1
  implements Runnable
{
  RewardedVideoAdPlugin$1$1$1(RewardedVideoAdPlugin.1.1 param1, String paramString) {}
  
  public void run()
  {
    QMLog.i("RealTimeRewardedVideoAdPlugin", "onADClose 关闭广告后重新拉取");
    RewardedVideoAdPlugin.access$900(this.this$2.this$1.this$0, this.this$2.this$1.val$req, this.this$2.this$1.val$posId, this.val$showCompId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.1.1.1
 * JD-Core Version:    0.7.0.1
 */