package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayTribePanel$8
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$8(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.j)) {}
    for (localObject = "1";; localObject = "2")
    {
      localIntent.putExtra("url", (String)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_focus", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.8
 * JD-Core Version:    0.7.0.1
 */