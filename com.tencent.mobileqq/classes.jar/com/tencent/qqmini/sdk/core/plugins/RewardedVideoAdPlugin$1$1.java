package com.tencent.qqmini.sdk.core.plugins;

import begv;
import begz;
import beiw;
import bejm;
import beka;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener;

class RewardedVideoAdPlugin$1$1
  implements AdProxy.IRewardVideoAdListener
{
  RewardedVideoAdPlugin$1$1(RewardedVideoAdPlugin.1 param1) {}
  
  public void onADClick()
  {
    besl.b("RewardedVideoAdPlugin", "onADClick, time = " + System.currentTimeMillis());
  }
  
  public void onADClose()
  {
    besl.b("RewardedVideoAdPlugin", "onADClose, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$500(this.this$1.this$0, this.this$1.val$req, false, this.this$1.val$pos_id, this.this$1.val$compId);
    beiw.a(new RewardedVideoAdPlugin.1.1.1(this), 16, null, true);
    if (this.this$1.this$0.mMiniAppContext != null) {
      this.this$1.this$0.mMiniAppContext.a(bejm.a(1));
    }
    begv.a(false);
  }
  
  public void onADExpose()
  {
    besl.b("RewardedVideoAdPlugin", "onADExpose, time = " + System.currentTimeMillis());
  }
  
  public void onADLoad()
  {
    besl.b("RewardedVideoAdPlugin", "onADLoad, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$200(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$300(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    this.this$1.val$req.a();
    RewardedVideoAdPlugin.access$002(this.this$1.this$0, false);
  }
  
  public void onADShow()
  {
    if (this.this$1.this$0.mMiniAppContext != null) {
      this.this$1.this$0.mMiniAppContext.a(bejm.a(2));
    }
    besl.b("RewardedVideoAdPlugin", "onADShow, time = " + System.currentTimeMillis());
  }
  
  public void onError(int paramInt, String paramString)
  {
    besl.b("RewardedVideoAdPlugin", "onError, time = " + System.currentTimeMillis() + ", errCode = " + paramInt + ", errMsg = " + paramString);
    RewardedVideoAdPlugin.access$700(this.this$1.this$0, this.this$1.val$req, paramInt, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$002(this.this$1.this$0, false);
    RewardedVideoAdPlugin.access$102(this.this$1.this$0, null);
  }
  
  public void onReward()
  {
    besl.b("RewardedVideoAdPlugin", "onReward, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$402(this.this$1.this$0, true);
    RewardedVideoAdPlugin.access$500(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$pos_id, this.this$1.val$compId);
  }
  
  public void onVideoCached()
  {
    besl.b("RewardedVideoAdPlugin", "onVideoCached, time = " + System.currentTimeMillis());
  }
  
  public void onVideoComplete()
  {
    besl.b("RewardedVideoAdPlugin", "onVideoComplete, time = " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */