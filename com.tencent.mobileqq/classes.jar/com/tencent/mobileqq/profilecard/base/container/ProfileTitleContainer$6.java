package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ProfileTitleContainer$6
  implements View.OnClickListener
{
  ProfileTitleContainer$6(ProfileTitleContainer paramProfileTitleContainer, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(ProfileTitleContainer.access$1800(this.this$0), "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
    this.val$actionSheet.mDefaultDismissListener.onClick(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.6
 * JD-Core Version:    0.7.0.1
 */