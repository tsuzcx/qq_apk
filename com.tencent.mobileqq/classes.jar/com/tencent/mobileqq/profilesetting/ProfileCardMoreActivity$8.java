package com.tencent.mobileqq.profilesetting;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ProfileCardMoreActivity$8
  implements ActionSheet.OnButtonClickListener
{
  ProfileCardMoreActivity$8(ProfileCardMoreActivity paramProfileCardMoreActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.j();
      ((IGPSService)this.b.app.getRuntimeService(IGPSService.class, "")).removeGuild(this.b.b.troopUin, new ProfileCardMoreActivity.8.1(this));
    }
    this.a.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.8
 * JD-Core Version:    0.7.0.1
 */