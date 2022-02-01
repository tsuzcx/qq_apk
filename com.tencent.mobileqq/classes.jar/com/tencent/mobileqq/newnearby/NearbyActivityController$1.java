package com.tencent.mobileqq.newnearby;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.TabLayoutCompat;

class NearbyActivityController$1
  implements Runnable
{
  NearbyActivityController$1(NearbyActivityController paramNearbyActivityController) {}
  
  public void run()
  {
    if ((((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).hasMatchTab()) && (NearbyActivityController.a == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(2))) {
      return;
    }
    NearbyActivityController.b(this.this$0).setBackgroundColor(NearbyActivityController.a(this.this$0).getResources().getColor(1946288129));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyActivityController.1
 * JD-Core Version:    0.7.0.1
 */