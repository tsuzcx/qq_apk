package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.action.AudioFocusEvent;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RaffleJsPlugin$10$1
  implements AdProxy.IRewardVideoAdListener
{
  RaffleJsPlugin$10$1(RaffleJsPlugin.10 param10) {}
  
  public void onADClick()
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onADClick, time = " + System.currentTimeMillis());
  }
  
  public void onADClose(String paramString)
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onADClose,  time = " + System.currentTimeMillis());
    RaffleJsPlugin.access$2900(this.a.this$0, this.a.a);
    if (RaffleJsPlugin.access$3000(this.a.this$0) != null) {
      RaffleJsPlugin.access$3100(this.a.this$0).performAction(AudioFocusEvent.obtain(1));
    }
    AdFrequencyLimit.setRewardVideoAdShowing(false);
  }
  
  public void onADExpose()
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onADExpose, time = " + System.currentTimeMillis());
  }
  
  public void onADLoad()
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onADLoad, time = " + System.currentTimeMillis());
    RaffleJsPlugin.access$2302(this.a.this$0, false);
    if (!RaffleJsPlugin.access$2400(this.a.this$0))
    {
      this.a.this$0.hideLoading();
      RaffleJsPlugin.access$2500(this.a.this$0, this.a.a);
    }
    RaffleJsPlugin.access$2402(this.a.this$0, false);
  }
  
  public void onADShow()
  {
    if (RaffleJsPlugin.access$2600(this.a.this$0) != null) {
      RaffleJsPlugin.access$2700(this.a.this$0).performAction(AudioFocusEvent.obtain(2));
    }
    QMLog.i(RaffleJsPlugin.access$200(), "onADShow, time = " + System.currentTimeMillis());
  }
  
  public void onError(int paramInt, String paramString)
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onError, time = " + System.currentTimeMillis() + ", errCode = " + paramInt + ", errMsg = " + paramString);
    this.a.this$0.hideLoading();
    RaffleJsPlugin.access$3200(this.a.this$0, this.a.a);
    RaffleJsPlugin.access$2002(this.a.this$0, null);
    RaffleJsPlugin.access$2302(this.a.this$0, false);
    RaffleJsPlugin.access$2402(this.a.this$0, false);
    RaffleJsPlugin.access$600(this.a.this$0, 7);
  }
  
  public void onReward()
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onReward, time = " + System.currentTimeMillis());
    RaffleJsPlugin.access$2802(this.a.this$0, true);
  }
  
  public void onVideoCached()
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onVideoCached, time = " + System.currentTimeMillis());
  }
  
  public void onVideoComplete()
  {
    QMLog.i(RaffleJsPlugin.access$200(), "onVideoComplete, time = " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.10.1
 * JD-Core Version:    0.7.0.1
 */