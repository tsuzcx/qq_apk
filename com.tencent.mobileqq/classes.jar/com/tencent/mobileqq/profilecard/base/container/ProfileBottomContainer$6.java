package com.tencent.mobileqq.profilecard.base.container;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.api.ITroopInfoService.GetTroopCodeCallback;

class ProfileBottomContainer$6
  implements ITroopInfoService.GetTroopCodeCallback
{
  ProfileBottomContainer$6(ProfileBottomContainer paramProfileBottomContainer, Intent paramIntent) {}
  
  public void onResult(Object paramObject)
  {
    if (((paramObject instanceof String)) && (ProfileBottomContainer.access$2200(this.this$0) != null))
    {
      this.val$intent.putExtra("troop_uin", (String)paramObject);
      this.val$intent.putExtra("cSpecialFlag", 0);
      ProfileBottomContainer.access$2300(this.this$0).startActivity(this.val$intent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.6
 * JD-Core Version:    0.7.0.1
 */