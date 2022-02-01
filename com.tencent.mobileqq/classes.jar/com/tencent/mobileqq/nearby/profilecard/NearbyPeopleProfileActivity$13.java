package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;

class NearbyPeopleProfileActivity$13
  extends FriendListObserver
{
  NearbyPeopleProfileActivity$13(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a()
  {
    boolean bool = this.a.g;
    FriendsManager localFriendsManager = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null) {
      bool = localFriendsManager.b(NearbyPeopleProfileActivity.a(this.a).uin);
    }
    for (;;)
    {
      if (bool != this.a.g)
      {
        this.a.g = bool;
        this.a.runOnUiThread(new NearbyPeopleProfileActivity.13.1(this));
      }
      return;
    }
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.e != 3) || (this.a.g) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    a();
  }
  
  public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.e != 3) || (this.a.g) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    a();
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2)) {}
    while ((this.a.e != 3) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.13
 * JD-Core Version:    0.7.0.1
 */