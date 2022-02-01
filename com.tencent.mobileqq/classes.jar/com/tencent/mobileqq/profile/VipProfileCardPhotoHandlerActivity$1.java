package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class VipProfileCardPhotoHandlerActivity$1
  implements QQPermissionCallback
{
  VipProfileCardPhotoHandlerActivity$1(VipProfileCardPhotoHandlerActivity paramVipProfileCardPhotoHandlerActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "takePhoto requestPermission user denied");
    }
    DialogUtil.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "takePhoto requestPermission user grant");
    }
    VipProfileCardPhotoHandlerActivity.a(this.a, ProfileActivity.a(this.a, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.1
 * JD-Core Version:    0.7.0.1
 */