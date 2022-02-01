package com.tencent.mobileqq.nearby.profilecard;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.NearbyPeopleCard;

class NearbyPeopleProfileActivity$14
  extends FriendListObserver
{
  NearbyPeopleProfileActivity$14(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
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
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        return;
      }
      if ((this.a.mMode == 3) && (NearbyPeopleProfileActivity.access$300(this.a) != null))
      {
        if (TextUtils.isEmpty(NearbyPeopleProfileActivity.access$300(this.a).uin)) {
          return;
        }
        this.a.checkIsFriend();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.14
 * JD-Core Version:    0.7.0.1
 */