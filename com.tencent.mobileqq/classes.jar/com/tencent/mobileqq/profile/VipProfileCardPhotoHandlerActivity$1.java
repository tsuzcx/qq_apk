package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
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
    paramArrayOfString = this.a;
    VipProfileCardPhotoHandlerActivity.a(paramArrayOfString, ProfileCardUtils.enterSnapshot(paramArrayOfString, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.1
 * JD-Core Version:    0.7.0.1
 */