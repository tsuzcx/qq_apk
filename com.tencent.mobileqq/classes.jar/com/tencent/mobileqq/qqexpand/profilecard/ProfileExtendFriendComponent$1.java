package com.tencent.mobileqq.qqexpand.profilecard;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileExtendFriendComponent$1
  extends PhotoWallObserver
{
  ProfileExtendFriendComponent$1(ProfileExtendFriendComponent paramProfileExtendFriendComponent) {}
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    ProfileExtendFriendComponent.a(this.a, 1000L);
    QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetQZonePhotoWall isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.1
 * JD-Core Version:    0.7.0.1
 */