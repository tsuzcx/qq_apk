package com.tencent.mobileqq.qqexpand.profilecard;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfileExtendFriendComponent$4
  implements Runnable
{
  ProfileExtendFriendComponent$4(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  public void run()
  {
    if (ProfileExtendFriendComponent.e(this.this$0) != null)
    {
      int i = ((View)ProfileExtendFriendComponent.f(this.this$0)).getTop();
      if ((i >= 0) && (ProfileExtendFriendComponent.g(this.this$0) != null)) {
        ProfileExtendFriendComponent.h(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.4
 * JD-Core Version:    0.7.0.1
 */