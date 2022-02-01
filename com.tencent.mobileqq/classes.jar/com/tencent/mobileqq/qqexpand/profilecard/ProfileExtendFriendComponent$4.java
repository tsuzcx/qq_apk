package com.tencent.mobileqq.qqexpand.profilecard;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfileExtendFriendComponent$4
  implements Runnable
{
  ProfileExtendFriendComponent$4(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  public void run()
  {
    if (ProfileExtendFriendComponent.a(this.this$0) != null)
    {
      int i = ((View)ProfileExtendFriendComponent.b(this.this$0)).getTop();
      if ((i >= 0) && (ProfileExtendFriendComponent.c(this.this$0) != null)) {
        ProfileExtendFriendComponent.d(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.4
 * JD-Core Version:    0.7.0.1
 */