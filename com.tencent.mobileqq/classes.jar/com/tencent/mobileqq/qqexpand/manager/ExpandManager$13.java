package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;

class ExpandManager$13
  implements Runnable
{
  ExpandManager$13(ExpandManager paramExpandManager) {}
  
  public void run()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new ExpandManager.13.1(this, "extend_friend", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.13
 * JD-Core Version:    0.7.0.1
 */