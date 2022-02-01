package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileExtendFriendComponent$1
  extends CardObserver
{
  ProfileExtendFriendComponent$1(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  public void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    ProfileExtendFriendComponent.access$000(this.this$0, 1000L);
    QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetQZonePhotoWall isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.1
 * JD-Core Version:    0.7.0.1
 */