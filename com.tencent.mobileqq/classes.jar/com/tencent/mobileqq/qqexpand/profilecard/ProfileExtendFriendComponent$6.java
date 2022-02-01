package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class ProfileExtendFriendComponent$6
  implements View.OnClickListener
{
  ProfileExtendFriendComponent$6(ProfileExtendFriendComponent paramProfileExtendFriendComponent, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131429883)
    {
      if ((ProfileExtendFriendComponent.p(this.b) != null) && (ProfileExtendFriendComponent.p(this.b).isShowing())) {
        ProfileExtendFriendComponent.p(this.b).dismiss();
      }
      if (TextUtils.isEmpty(this.a.declaration))
      {
        ReportController.b(ProfileExtendFriendComponent.q(this.b), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(ProfileExtendFriendComponent.r(this.b), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2131429947)
    {
      if (TextUtils.isEmpty(this.a.declaration))
      {
        ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragment(ProfileExtendFriendComponent.s(this.b), null);
      }
      else
      {
        paramView = InterestSwitchEditActivity.a(ProfileExtendFriendComponent.t(this.b));
        ProfileExtendFriendComponent.u(this.b).startActivityForResult(paramView, 1022);
      }
      if ((ProfileExtendFriendComponent.p(this.b) != null) && (ProfileExtendFriendComponent.p(this.b).isShowing())) {
        ProfileExtendFriendComponent.p(this.b).dismiss();
      }
      if (TextUtils.isEmpty(this.a.declaration))
      {
        ReportController.b(ProfileExtendFriendComponent.v(this.b), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(ProfileExtendFriendComponent.w(this.b), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.6
 * JD-Core Version:    0.7.0.1
 */