package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.newnearby.NearbyActivityController;

class NearbyHippyBridgeImpl$1
  implements Runnable
{
  NearbyHippyBridgeImpl$1(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Activity paramActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    ((NearbyActivity)this.a).getController().a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.1
 * JD-Core Version:    0.7.0.1
 */