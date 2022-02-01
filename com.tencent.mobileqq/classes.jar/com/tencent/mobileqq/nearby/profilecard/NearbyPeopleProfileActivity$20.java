package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

class NearbyPeopleProfileActivity$20
  implements ConditionSearchManager.IConfigListener
{
  NearbyPeopleProfileActivity$20(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.dismissWaittingDialog();
    if (!paramBoolean)
    {
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.a;
      localNearbyPeopleProfileActivity.showToast(localNearbyPeopleProfileActivity.getString(2131691057));
      return;
    }
    if ((this.a.mMode == 1) && (paramInt == 2)) {
      NearbyPeopleProfileActivity.access$400(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.20
 * JD-Core Version:    0.7.0.1
 */