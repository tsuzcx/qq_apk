package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfileExtendFriendComponent$7
  implements Runnable
{
  ProfileExtendFriendComponent$7(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  public void run()
  {
    if (ProfileExtendFriendComponent.access$2400(this.this$0) != null)
    {
      int i = ((View)ProfileExtendFriendComponent.access$2500(this.this$0)).getTop();
      if ((i >= 0) && (ProfileExtendFriendComponent.access$2600(this.this$0) != null)) {
        ProfileExtendFriendComponent.access$2700(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.7
 * JD-Core Version:    0.7.0.1
 */