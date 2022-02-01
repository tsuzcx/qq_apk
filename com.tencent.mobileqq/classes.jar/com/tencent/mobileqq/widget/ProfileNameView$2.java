package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileNameView$2
  implements View.OnClickListener
{
  ProfileNameView$2(ProfileNameView paramProfileNameView, ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://qun.qq.com/interactive/userhonor?gc=").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("&_wv=3&&_wwv=128");
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", (String)localObject);
    paramView.getContext().startActivity(localIntent);
    localObject = null;
    if ((paramView instanceof TroopMemberNewLevelView)) {
      localObject = (TroopMemberNewLevelView)paramView;
    }
    int i;
    if (localObject != null) {
      if ((((TroopMemberNewLevelView)localObject).a()) && (((TroopMemberNewLevelView)localObject).b())) {
        i = 3;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B201", "0X800B201", i, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((TroopMemberNewLevelView)localObject).a()) {
        i = 1;
      } else if (((TroopMemberNewLevelView)localObject).b()) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView.2
 * JD-Core Version:    0.7.0.1
 */