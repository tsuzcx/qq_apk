package com.tencent.mobileqq.profilecard.bussiness.photowall;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.qphone.base.util.QLog;

class ProfilePhotoWallComponent$1
  extends PhotoWallObserver
{
  ProfilePhotoWallComponent$1(ProfilePhotoWallComponent paramProfilePhotoWallComponent) {}
  
  protected void onDelQZonePhotoWall(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onDelQZonePhotoWall isSuc=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    ProfilePhotoWallComponent.access$400(this.this$0, paramBoolean);
  }
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onGetQZonePhotoWall isSuc=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString2 }));
    }
    ProfilePhotoWallComponent.access$000(this.this$0, paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp, paramString2);
    if ((ProfilePhotoWallComponent.access$100(this.this$0)) && (!ProfilePhotoWallComponent.access$200(this.this$0)))
    {
      ProfilePhotoWallComponent.access$202(this.this$0, true);
      ProfilePhotoWallComponent.access$300(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.ProfilePhotoWallComponent.1
 * JD-Core Version:    0.7.0.1
 */