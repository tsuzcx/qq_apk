package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class ProfileLogicContainer$4
  implements Runnable
{
  ProfileLogicContainer$4(ProfileLogicContainer paramProfileLogicContainer) {}
  
  public void run()
  {
    if (ProfileLogicContainer.access$1300(this.this$0) != null) {
      ProfileLogicContainer.access$1500(this.this$0).checkAndSwitch2Friend(false, false, ((ProfileCardInfo)ProfileLogicContainer.access$1400(this.this$0)).allInOne.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.4
 * JD-Core Version:    0.7.0.1
 */