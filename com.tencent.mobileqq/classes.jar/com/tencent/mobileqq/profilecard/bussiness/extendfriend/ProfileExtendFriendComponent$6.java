package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import android.os.Handler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class ProfileExtendFriendComponent$6
  extends ExtendFriendObserver
{
  ProfileExtendFriendComponent$6(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  public void onGetExtendFriendInfo(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      if (paramCard == null) {
        break label124;
      }
    }
    label124:
    for (paramCard = paramCard.declaration;; paramCard = null)
    {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetExtendFriendInfo success=%s declaration=%s", new Object[] { Boolean.valueOf(paramBoolean), paramCard }));
      if (ProfileExtendFriendComponent.access$2100(this.this$0) != null) {
        ProfileExtendFriendComponent.access$2100(this.this$0).removeCallbacks(ProfileExtendFriendComponent.access$2200(this.this$0));
      }
      if (ProfileExtendFriendComponent.access$2300(this.this$0) != null)
      {
        ProfileExtendFriendComponent.access$2300(this.this$0).dismiss();
        ProfileExtendFriendComponent.access$2302(this.this$0, null);
      }
      if (!ProfileExtendFriendComponent.access$300(this.this$0))
      {
        ProfileExtendFriendComponent.access$302(this.this$0, true);
        ProfileExtendFriendComponent.access$400(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.6
 * JD-Core Version:    0.7.0.1
 */