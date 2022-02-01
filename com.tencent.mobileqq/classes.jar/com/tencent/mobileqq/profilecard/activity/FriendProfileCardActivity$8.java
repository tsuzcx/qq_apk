package com.tencent.mobileqq.profilecard.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class FriendProfileCardActivity$8
  extends BroadcastReceiver
{
  FriendProfileCardActivity$8(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = FriendProfileCardActivity.access$1000(this.this$0).getCurrentAccountUin();
    if (FriendProfileCardActivity.access$500(this.this$0).allInOne.uin.equals(paramContext))
    {
      paramContext = ((IProfileDataService)FriendProfileCardActivity.access$1000(this.this$0).getRuntimeService(IProfileDataService.class, "all")).getProfileCard(FriendProfileCardActivity.access$500(this.this$0).allInOne.uin, false);
      if (paramContext != null) {
        FriendProfileCardActivity.access$1200(this.this$0, paramContext.feedPreviewTime, paramContext.vSeed, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */