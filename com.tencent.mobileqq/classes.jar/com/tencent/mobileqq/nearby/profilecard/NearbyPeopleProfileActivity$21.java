package com.tencent.mobileqq.nearby.profilecard;

import anpo;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$21
  implements Runnable
{
  NearbyPeopleProfileActivity$21(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString) {}
  
  public void run()
  {
    if (NearbyPeopleProfileActivity.a(this.this$0) != null)
    {
      NearbyPeopleProfileActivity.a(this.this$0).a(this.a);
      return;
    }
    QLog.i("Q.nearby_people_card.", 1, "mDynamicAvatarDownloadManager is NULL!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.21
 * JD-Core Version:    0.7.0.1
 */