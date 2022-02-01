package com.tencent.mobileqq.profilecard.activity;

import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;

class FriendProfileCardActivity$7
  implements Runnable
{
  FriendProfileCardActivity$7(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if (FriendProfileCardActivity.access$500(this.this$0).allInOne.pa == 0) {
      ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).onProfileRedTouchClick(FriendProfileCardActivity.access$1000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.7
 * JD-Core Version:    0.7.0.1
 */