package com.tencent.mobileqq.newnearby.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.newnearby.NearbyActivityController;
import com.tencent.mobileqq.newnearby.model.TabInfo;
import com.tencent.mobileqq.widget.TabLayoutCompat;

class NearbyTabBuilderImpl$2
  implements Runnable
{
  NearbyTabBuilderImpl$2(NearbyTabBuilderImpl paramNearbyTabBuilderImpl, Activity paramActivity, TabLayoutCompat paramTabLayoutCompat) {}
  
  public void run()
  {
    NearbyTabBuilderImpl.access$200(this.this$0, this.a, this.b);
    Activity localActivity = this.a;
    if ((localActivity instanceof NearbyActivity))
    {
      ((NearbyActivity)localActivity).getController().b();
      return;
    }
    if ((localActivity instanceof BaseMsgBoxActivity)) {
      ((BaseMsgBoxActivity)localActivity).initQQNearbyTabs(TabInfo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyTabBuilderImpl.2
 * JD-Core Version:    0.7.0.1
 */