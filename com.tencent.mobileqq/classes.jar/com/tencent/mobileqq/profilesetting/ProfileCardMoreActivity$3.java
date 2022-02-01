package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

class ProfileCardMoreActivity$3
  implements ActionSheet.OnButtonClickListener
{
  ProfileCardMoreActivity$3(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (Utils.c(this.a))) {
        ReportController.b(this.c.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
      }
    }
    else
    {
      ReportController.b(this.c.app, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileEntryUtils.getProfileEntryType(this.c.b.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.c.b)), "", "", "");
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.c.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.a, (byte)2);
        paramView = this.c.app.getHandler(ChatActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.a));
        }
        paramView = this.c.app.getHandler(ChatSettingActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.a));
        }
        if (this.c.E == null) {
          this.c.E = new Intent();
        }
        this.c.E.putExtra("finchat", true);
        paramView = this.c;
        paramView.setResult(-1, paramView.E);
        if (Utils.c(this.a)) {
          ReportController.b(this.c.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.c.finish();
      }
      else
      {
        this.c.notifyUser(2131888422, 1);
      }
    }
    this.b.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.3
 * JD-Core Version:    0.7.0.1
 */