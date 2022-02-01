package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$19$1
  implements Runnable
{
  NearbyPeopleProfileActivity$19$1(NearbyPeopleProfileActivity.19 param19, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.c.a.mMode == 1) {
      return;
    }
    if (NearbyPeopleProfileActivity.access$400(this.c.a) != null)
    {
      NearbyPeopleProfileActivity.access$400(this.c.a).a(this.a, this.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NearbyPeopleProfileActivity", 2, "mDisplayModel == null ！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.19.1
 * JD-Core Version:    0.7.0.1
 */