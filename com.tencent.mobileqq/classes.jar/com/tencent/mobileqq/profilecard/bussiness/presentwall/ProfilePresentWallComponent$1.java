package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ProfilePresentWallComponent$1
  implements View.OnClickListener
{
  ProfilePresentWallComponent$1(ProfilePresentWallComponent paramProfilePresentWallComponent) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag)) {}
    switch (((DataTag)localObject).a)
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    localObject = new Intent(ProfilePresentWallComponent.access$000(this.this$0), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", ((ProfileCardInfo)ProfilePresentWallComponent.access$100(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataCard.presentCustourl);
    ProfilePresentWallComponent.access$200(this.this$0).startActivity((Intent)localObject);
    ThreadManager.getFileThreadHandler().post(new ProfilePresentWallComponent.1.1(this));
    if (((ProfileCardInfo)ProfilePresentWallComponent.access$300(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
      ReportController.b(ProfilePresentWallComponent.access$400(this.this$0), "", "", "", "0X800A1C7", "0X800A1C7", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ProfileCardReport.reportPresentClick(ProfilePresentWallComponent.access$600(this.this$0), (ProfileCardInfo)ProfilePresentWallComponent.access$700(this.this$0));
      break;
      ReportController.b(ProfilePresentWallComponent.access$500(this.this$0), "", "", "", "0X800A1C9", "0X800A1C9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent.1
 * JD-Core Version:    0.7.0.1
 */