package com.tencent.mobileqq.qqexpand.profilecard;

import android.os.Handler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class ProfileExtendFriendComponent$7
  extends ExpandObserver
{
  ProfileExtendFriendComponent$7(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      if (paramCard != null) {
        paramCard = paramCard.declaration;
      } else {
        paramCard = null;
      }
      QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetExtendFriendInfo success=%s declaration=%s", new Object[] { Boolean.valueOf(paramBoolean), paramCard }));
    }
    if (ProfileExtendFriendComponent.a(this.a) != null) {
      ProfileExtendFriendComponent.a(this.a).removeCallbacks(ProfileExtendFriendComponent.a(this.a));
    }
    if (ProfileExtendFriendComponent.a(this.a) != null)
    {
      ProfileExtendFriendComponent.a(this.a).dismiss();
      ProfileExtendFriendComponent.a(this.a, null);
    }
    if (!ProfileExtendFriendComponent.a(this.a))
    {
      ProfileExtendFriendComponent.a(this.a, true);
      ProfileExtendFriendComponent.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.7
 * JD-Core Version:    0.7.0.1
 */