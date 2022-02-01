package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.newnearby.NearbyNewUserGuideView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class NearbyHippyBridgeImpl$3
  implements Runnable
{
  NearbyHippyBridgeImpl$3(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Activity paramActivity, List paramList) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(1946419226);
    View localView = this.a.findViewById(1946419225);
    if ((localViewGroup != null) && (localView != null))
    {
      localViewGroup.addView(new NearbyNewUserGuideView(this.a, this.b, localView.getTop(), localViewGroup), new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showBeginnerGuide error: has root=");
    boolean bool2 = false;
    if (localViewGroup != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localStringBuilder.append(bool1);
    localStringBuilder.append(" ,has qqnearby_viewpager=");
    boolean bool1 = bool2;
    if (localView != null) {
      bool1 = true;
    }
    localStringBuilder.append(bool1);
    QLog.e("NearbyHippyBridgeImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.3
 * JD-Core Version:    0.7.0.1
 */