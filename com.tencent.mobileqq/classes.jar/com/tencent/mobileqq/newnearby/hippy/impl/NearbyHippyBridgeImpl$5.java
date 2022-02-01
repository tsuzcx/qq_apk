package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.activity.NearbyActivity;

class NearbyHippyBridgeImpl$5
  implements Runnable
{
  NearbyHippyBridgeImpl$5(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Activity paramActivity) {}
  
  public void run()
  {
    NearbyActivity localNearbyActivity = (NearbyActivity)this.a;
    View localView = localNearbyActivity.getTitleBarView();
    Window localWindow = localNearbyActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21) {
      localWindow.setStatusBarColor(localNearbyActivity.getResources().getColor(1946288129));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      localView.setForeground(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.5
 * JD-Core Version:    0.7.0.1
 */