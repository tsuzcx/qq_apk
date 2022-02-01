package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;

class RIJAdShakeManagerImpl$3
  implements Runnable
{
  RIJAdShakeManagerImpl$3(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl, boolean paramBoolean) {}
  
  public void run()
  {
    if (RIJAdShakeManagerImpl.access$100()) {
      return;
    }
    if ((RIJAdShakeManagerImpl.access$2500()) && (!this.a))
    {
      RIJAdShakeManagerImpl.access$300(this.this$0);
      if (RIJAdShakeManagerImpl.access$400(this.this$0) != null) {
        RIJAdShakeManagerImpl.access$400(this.this$0).a(RIJAdShakeManagerImpl.access$500(this.this$0));
      }
    }
    else
    {
      RIJAdShakeManagerImpl localRIJAdShakeManagerImpl = this.this$0;
      int i;
      if (this.a) {
        i = 0;
      } else {
        i = 1000;
      }
      RIJAdShakeManagerImpl.access$700(localRIJAdShakeManagerImpl, i);
      localRIJAdShakeManagerImpl = this.this$0;
      RIJAdShakeManagerImpl.access$1200(localRIJAdShakeManagerImpl, (Activity)RIJAdShakeManagerImpl.access$1000(localRIJAdShakeManagerImpl), RIJAdShakeManagerImpl.access$500(this.this$0), RIJAdShakeManagerImpl.access$1100(), true, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */