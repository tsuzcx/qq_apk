package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

class NearbyPeopleProfileActivity$19
  implements ConditionSearchManager.IConfigListener
{
  NearbyPeopleProfileActivity$19(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      if ((NearbyPeopleProfileActivity.a(this.a) == null) || (this.a.e != 1)) {
        break label41;
      }
      NearbyPeopleProfileActivity.a(this.a).d();
    }
    label41:
    while (NearbyPeopleProfileActivity.a(this.a) == null) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.19
 * JD-Core Version:    0.7.0.1
 */