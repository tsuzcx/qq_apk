package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ProfileTitleContainer$5
  implements ActionSheet.OnButtonClickListener
{
  ProfileTitleContainer$5(ProfileTitleContainer paramProfileTitleContainer, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          ReportController.b(ProfileTitleContainer.access$1700(this.this$0), "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
        }
      }
      else
      {
        ProfileCardUtil.a(ProfileTitleContainer.access$1500(this.this$0));
        ReportController.b(ProfileTitleContainer.access$1600(this.this$0), "dc00898", "", "", "0X800A97D", "0X800A97D", 2, 0, "0", "0", "", "");
      }
    }
    else
    {
      ProfileTitleContainer.access$1300(this.this$0);
      ReportController.b(ProfileTitleContainer.access$1400(this.this$0), "dc00898", "", "", "0X800A97D", "0X800A97D", 1, 0, "0", "0", "", "");
    }
    try
    {
      this.val$actionSheet.dismiss();
      this.val$actionSheet.setOnPreShowListener(null);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("ProfileTitleContainer", 1, "showMoreActionSheet actionSheet dismiss fail.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.5
 * JD-Core Version:    0.7.0.1
 */