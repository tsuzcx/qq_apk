package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;

class ProfileLogicContainer$2
  extends FriendObserver
{
  ProfileLogicContainer$2(ProfileLogicContainer paramProfileLogicContainer) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (!paramBoolean3) {
        return;
      }
      ProfileLogicContainer.access$900(this.this$0, paramString, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.2
 * JD-Core Version:    0.7.0.1
 */