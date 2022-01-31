package com.tencent.qqmini.sdk.core.plugins;

import bdcz;
import bdfm;
import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener;

class RewardedVideoAdPlugin$2$1
  implements AdProxy.IRewardVideoAdListener
{
  RewardedVideoAdPlugin$2$1(RewardedVideoAdPlugin.2 param2) {}
  
  public void onADClick()
  {
    bdnw.d("RewardedVideoAdPlugin", "onADClick, time = " + System.currentTimeMillis());
  }
  
  public void onADClose()
  {
    bdnw.d("RewardedVideoAdPlugin", "onADClose, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$600(this.this$1.this$0, this.this$1.val$req, false, this.this$1.val$pos_id, this.this$1.val$compId);
    if (this.this$1.this$0.mMiniAppContext != null) {
      this.this$1.this$0.mMiniAppContext.a(bdfm.a(1));
    }
  }
  
  public void onADExpose()
  {
    bdnw.d("RewardedVideoAdPlugin", "onADExpose, time = " + System.currentTimeMillis());
  }
  
  public void onADLoad()
  {
    bdnw.d("RewardedVideoAdPlugin", "onADLoad, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$300(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$400(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$compId);
    this.this$1.val$req.a();
    RewardedVideoAdPlugin.access$102(this.this$1.this$0, false);
  }
  
  public void onADShow()
  {
    if (this.this$1.this$0.mMiniAppContext != null) {
      this.this$1.this$0.mMiniAppContext.a(bdfm.a(2));
    }
    bdnw.d("RewardedVideoAdPlugin", "onADShow, time = " + System.currentTimeMillis());
  }
  
  public void onError(int paramInt, String paramString)
  {
    bdnw.d("RewardedVideoAdPlugin", "onError, time = " + System.currentTimeMillis() + ", errCode = " + paramInt + ", errMsg = " + paramString);
    RewardedVideoAdPlugin.access$700(this.this$1.this$0, this.this$1.val$req, paramInt, this.this$1.val$compId);
    RewardedVideoAdPlugin.access$102(this.this$1.this$0, false);
  }
  
  public void onReward()
  {
    bdnw.d("RewardedVideoAdPlugin", "onReward, time = " + System.currentTimeMillis());
    RewardedVideoAdPlugin.access$502(this.this$1.this$0, true);
    RewardedVideoAdPlugin.access$600(this.this$1.this$0, this.this$1.val$req, true, this.this$1.val$pos_id, this.this$1.val$compId);
  }
  
  public void onVideoCached()
  {
    bdnw.d("RewardedVideoAdPlugin", "onVideoCached, time = " + System.currentTimeMillis());
  }
  
  public void onVideoComplete()
  {
    bdnw.d("RewardedVideoAdPlugin", "onVideoComplete, time = " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */