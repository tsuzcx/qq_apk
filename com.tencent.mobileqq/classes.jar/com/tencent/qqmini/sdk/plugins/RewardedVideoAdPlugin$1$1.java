package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.AudioFocusEvent;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ExpParam;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;

class RewardedVideoAdPlugin$1$1
  implements AdProxy.IRewardVideoAdListener
{
  RewardedVideoAdPlugin$1$1(RewardedVideoAdPlugin.1 param1, AdProxy.AbsRewardVideoAdView paramAbsRewardVideoAdView) {}
  
  public void onADClick()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADClick, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
  }
  
  public void onADClose(String paramString)
  {
    RewardedVideoAdPlugin.access$102(this.this$1.this$0, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADClose,  time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
    RewardedVideoAdPlugin.access$800(this.this$1.this$0, this.this$1.val$req, paramString);
    ThreadManager.executeOnComputationThreadPool(new RewardedVideoAdPlugin.1.1.1(this, paramString));
    if (RewardedVideoAdPlugin.access$1000(this.this$1.this$0) != null) {
      RewardedVideoAdPlugin.access$1100(this.this$1.this$0).performAction(AudioFocusEvent.obtain(1));
    }
    AdFrequencyLimit.setRewardVideoAdShowing(false);
    RewardedVideoAdPlugin.access$1202(this.this$1.this$0, true);
  }
  
  public void onADExpose()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADExpose, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
  }
  
  public void onADLoad(List<AdProxy.ExpParam> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADLoad, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(" showAdAfterLoad:");
    localStringBuilder.append(this.this$1.val$showAdAfterLoad);
    QMLog.i("RealTimeRewardedVideoAdPlugin", localStringBuilder.toString());
    RewardedVideoAdPlugin.access$200(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$300(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    this.this$1.val$req.ok();
    RewardedVideoAdPlugin.access$002(this.this$1.this$0, false);
    RewardedVideoAdPlugin.access$400(this.this$1.this$0, this.this$1.val$context, this.this$1.val$req, this.this$1.val$compId, this.this$1.val$showAdAfterLoad, paramList);
  }
  
  public void onADShow()
  {
    if (RewardedVideoAdPlugin.access$500(this.this$1.this$0) != null) {
      RewardedVideoAdPlugin.access$600(this.this$1.this$0).performAction(AudioFocusEvent.obtain(2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADShow, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
  }
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(", errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" showAdAfterLoad：");
    localStringBuilder.append(this.this$1.val$showAdAfterLoad);
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
    if (this.this$1.val$showAdAfterLoad)
    {
      QMLog.i("RealTimeRewardedVideoAdPlugin", "showAdAfterLoad 实时load的广告拉取失败了 展示之前的广告");
      RewardedVideoAdPlugin.access$1300(this.this$1.this$0, this.val$lastRewardedVideoAd, this.this$1.val$context, this.this$1.val$req, this.this$1.val$compId);
      return;
    }
    RewardedVideoAdPlugin.access$1400(this.this$1.this$0, this.this$1.val$req, paramInt, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$002(this.this$1.this$0, false);
    RewardedVideoAdPlugin.access$102(this.this$1.this$0, null);
    RewardedVideoAdPlugin.access$1202(this.this$1.this$0, true);
    RewardedVideoAdPlugin.access$1500(this.this$1.this$0);
  }
  
  public void onReward()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReward, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
    RewardedVideoAdPlugin.access$702(this.this$1.this$0, true);
  }
  
  public void onVideoCached()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoCached, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
  }
  
  public void onVideoComplete()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoComplete, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i("RewardedVideoAdPlugin", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */