package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.TabLayoutCompat;

class NearbyHippyBridgeImpl$9
  implements Runnable
{
  NearbyHippyBridgeImpl$9(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = (NearbyActivity)this.a;
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)((NearbyActivity)localObject).findViewById(1946419223);
    localObject = (QQBlurView)((NearbyActivity)localObject).findViewById(1946419215);
    localTabLayoutCompat.setVisibility(8);
    ((QQBlurView)localObject).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.9
 * JD-Core Version:    0.7.0.1
 */