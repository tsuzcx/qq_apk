package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.newnearby.NearbyActivityController;

class NearbyHippyBridgeImpl$11
  implements Runnable
{
  NearbyHippyBridgeImpl$11(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    NearbyActivity localNearbyActivity = (NearbyActivity)this.a;
    if (this.b == 1)
    {
      localNearbyActivity.getController().e();
      return;
    }
    localNearbyActivity.getController().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.11
 * JD-Core Version:    0.7.0.1
 */