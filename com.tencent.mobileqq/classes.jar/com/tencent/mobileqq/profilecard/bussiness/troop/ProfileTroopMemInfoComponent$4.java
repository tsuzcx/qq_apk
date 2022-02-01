package com.tencent.mobileqq.profilecard.bussiness.troop;

import android.text.TextUtils;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class ProfileTroopMemInfoComponent$4
  implements Runnable
{
  ProfileTroopMemInfoComponent$4(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent, ProfileCardInfo paramProfileCardInfo) {}
  
  public void run()
  {
    Object localObject = ProfileTroopMemInfoComponent.access$3800(this.this$0, this.val$cardInfo);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131906226));
      localStringBuilder.append(TroopNewGuidePopWindow.a(((MessageRecord)localObject).time, true, false, true).toString());
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.val$cardInfo.troopRecentSaid = ((String)localObject);
    }
    if (ProfileTroopMemInfoComponent.access$3900(this.this$0) == null) {
      return;
    }
    if (!ProfileTroopMemInfoComponent.access$4000(this.this$0).isResume()) {
      return;
    }
    ProfileTroopMemInfoComponent.access$4500(this.this$0).runOnUiThread(new ProfileTroopMemInfoComponent.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.4
 * JD-Core Version:    0.7.0.1
 */