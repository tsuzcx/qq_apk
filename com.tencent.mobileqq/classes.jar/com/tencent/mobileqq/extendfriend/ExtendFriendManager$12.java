package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;

class ExtendFriendManager$12
  implements Runnable
{
  ExtendFriendManager$12(ExtendFriendManager paramExtendFriendManager) {}
  
  public void run()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new ExtendFriendManager.12.1(this, "extend_friend", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.12
 * JD-Core Version:    0.7.0.1
 */