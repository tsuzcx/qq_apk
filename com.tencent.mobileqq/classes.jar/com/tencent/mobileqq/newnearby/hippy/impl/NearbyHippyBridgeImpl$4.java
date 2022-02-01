package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.activity.NearbyActivity;

class NearbyHippyBridgeImpl$4
  implements Runnable
{
  NearbyHippyBridgeImpl$4(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Activity paramActivity) {}
  
  public void run()
  {
    NearbyActivity localNearbyActivity = (NearbyActivity)this.a;
    View localView = localNearbyActivity.getTitleBarView();
    Window localWindow = localNearbyActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21) {
      localWindow.setStatusBarColor(localNearbyActivity.getResources().getColor(1946288134));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      localView.setForeground(new ColorDrawable(1996488704));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.4
 * JD-Core Version:    0.7.0.1
 */