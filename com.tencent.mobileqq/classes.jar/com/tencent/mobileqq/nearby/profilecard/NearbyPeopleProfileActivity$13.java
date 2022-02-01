package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.friend.observer.FriendObserver;

class NearbyPeopleProfileActivity$13
  extends FriendObserver
{
  NearbyPeopleProfileActivity$13(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((this.a.mMode == 3) && (!this.a.isFriend) && (NearbyPeopleProfileActivity.access$300(this.a) != null))
      {
        if (!paramString.equals(NearbyPeopleProfileActivity.access$300(this.a).uin)) {
          return;
        }
        this.a.checkIsFriend();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.13
 * JD-Core Version:    0.7.0.1
 */