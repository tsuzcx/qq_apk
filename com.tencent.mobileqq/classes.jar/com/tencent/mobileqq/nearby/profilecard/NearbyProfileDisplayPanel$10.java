package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayPanel$10
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$10(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(String.valueOf(NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).tinyId));
    Object localObject;
    if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).gender == 0)
    {
      localObject = "1";
      localReportTask.a(new String[] { localObject }).a();
      if (!this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:")) {
        break label191;
      }
      localObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label160;
      }
      ((JumpAction)localObject).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).gender == 1)
      {
        localObject = "2";
        break;
      }
      localObject = "0";
      break;
      label160:
      QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.jdField_a_of_type_JavaLangString);
      continue;
      label191:
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.10
 * JD-Core Version:    0.7.0.1
 */