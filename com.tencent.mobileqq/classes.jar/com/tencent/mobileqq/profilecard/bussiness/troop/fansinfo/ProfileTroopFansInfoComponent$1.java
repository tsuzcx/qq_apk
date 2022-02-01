package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import com.tencent.mobileqq.troop.fans.api.TroopFansObserver;

class ProfileTroopFansInfoComponent$1
  extends TroopFansObserver
{
  ProfileTroopFansInfoComponent$1(ProfileTroopFansInfoComponent paramProfileTroopFansInfoComponent) {}
  
  protected void onGetIdolInfoOfCard(boolean paramBoolean, long paramLong, Object paramObject, int paramInt)
  {
    ProfileTroopFansInfoComponent.access$000(this.this$0, paramBoolean, paramLong, paramObject, paramInt);
    if ((ProfileTroopFansInfoComponent.access$100(this.this$0)) && (!ProfileTroopFansInfoComponent.access$200(this.this$0)))
    {
      ProfileTroopFansInfoComponent.access$202(this.this$0, true);
      ProfileTroopFansInfoComponent.access$300(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.1
 * JD-Core Version:    0.7.0.1
 */