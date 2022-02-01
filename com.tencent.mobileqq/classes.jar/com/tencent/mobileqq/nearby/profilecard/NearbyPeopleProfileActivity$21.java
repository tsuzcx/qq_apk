package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

class NearbyPeopleProfileActivity$21
  implements ConditionSearchManager.IConfigListener
{
  NearbyPeopleProfileActivity$21(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      if ((NearbyPeopleProfileActivity.access$300(this.a) != null) && (this.a.mMode == 1))
      {
        NearbyPeopleProfileActivity.access$300(this.a).g();
        return;
      }
      NearbyPeopleProfileActivity.access$400(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.21
 * JD-Core Version:    0.7.0.1
 */