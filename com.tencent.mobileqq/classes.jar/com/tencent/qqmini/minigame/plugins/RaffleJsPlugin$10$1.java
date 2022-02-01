package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.action.AudioFocusEvent;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ExpParam;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;

class RaffleJsPlugin$10$1
  implements AdProxy.IRewardVideoAdListener
{
  RaffleJsPlugin$10$1(RaffleJsPlugin.10 param10) {}
  
  public void onADClick()
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADClick, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(str, localStringBuilder.toString());
  }
  
  public void onADClose(String paramString)
  {
    paramString = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADClose,  time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(paramString, localStringBuilder.toString());
    RaffleJsPlugin.access$2900(this.a.this$0, this.a.a);
    if (RaffleJsPlugin.access$3000(this.a.this$0) != null) {
      RaffleJsPlugin.access$3100(this.a.this$0).performAction(AudioFocusEvent.obtain(1));
    }
    AdFrequencyLimit.setRewardVideoAdShowing(false);
  }
  
  public void onADExpose()
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADExpose, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(str, localStringBuilder.toString());
  }
  
  public void onADLoad(List<AdProxy.ExpParam> paramList)
  {
    paramList = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADLoad, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(paramList, localStringBuilder.toString());
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
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onADShow, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(str, localStringBuilder.toString());
  }
  
  public void onError(int paramInt, String paramString)
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(", errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    QMLog.i(str, localStringBuilder.toString());
    this.a.this$0.hideLoading();
    RaffleJsPlugin.access$3200(this.a.this$0, this.a.a);
    RaffleJsPlugin.access$2002(this.a.this$0, null);
    RaffleJsPlugin.access$2302(this.a.this$0, false);
    RaffleJsPlugin.access$2402(this.a.this$0, false);
    RaffleJsPlugin.access$600(this.a.this$0, 7);
  }
  
  public void onReward()
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReward, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(str, localStringBuilder.toString());
    RaffleJsPlugin.access$2802(this.a.this$0, true);
  }
  
  public void onVideoCached()
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoCached, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(str, localStringBuilder.toString());
  }
  
  public void onVideoComplete()
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoComplete, time = ");
    localStringBuilder.append(System.currentTimeMillis());
    QMLog.i(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.10.1
 * JD-Core Version:    0.7.0.1
 */