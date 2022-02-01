package com.tencent.mobileqq.profilecard.activity;

import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$6
  implements Runnable
{
  FriendProfileCardActivity$6(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    try
    {
      ProfileNameUtils.initNameArray(FriendProfileCardActivity.access$1000(this.this$0), FriendProfileCardActivity.access$500(this.this$0));
      ProfileNameUtils.updateProfileName(FriendProfileCardActivity.access$500(this.this$0));
      if ((!ProfilePAUtils.isPaTypeFriend(FriendProfileCardActivity.access$500(this.this$0).allInOne)) && (!ProfilePAUtils.isPaTypeStrangerInContact(FriendProfileCardActivity.access$500(this.this$0).allInOne)))
      {
        FriendProfileCardActivity.access$1100(this.this$0, false, true, null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate inner init fail.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.6
 * JD-Core Version:    0.7.0.1
 */