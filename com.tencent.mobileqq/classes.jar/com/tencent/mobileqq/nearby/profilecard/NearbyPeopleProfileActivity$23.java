package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$23
  implements Runnable
{
  NearbyPeopleProfileActivity$23(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString) {}
  
  public void run()
  {
    if (NearbyPeopleProfileActivity.access$1100(this.this$0) != null)
    {
      NearbyPeopleProfileActivity.access$1100(this.this$0).a(this.a);
      return;
    }
    QLog.i("NearbyPeopleProfileActivity", 1, "mDynamicAvatarDownloadManager is NULL!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.23
 * JD-Core Version:    0.7.0.1
 */