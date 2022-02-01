package com.tencent.mobileqq.nearby.profilecard;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$19
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  NearbyPeopleProfileActivity$19(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadUpdate  url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("   progress:");
      localStringBuilder.append(paramInt);
      QLog.i("NearbyPeopleProfileActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!this.a.mIsPlayDynamicAvatar) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDownloadFinish  url:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("   isSuccess:");
        localStringBuilder.append(paramBoolean1);
        localStringBuilder.append("  isFileExist:");
        localStringBuilder.append(paramBoolean2);
        QLog.i("NearbyPeopleProfileActivity", 2, localStringBuilder.toString());
      }
      this.a.runOnUiThread(new NearbyPeopleProfileActivity.19.1(this, paramString, paramBoolean1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.19
 * JD-Core Version:    0.7.0.1
 */