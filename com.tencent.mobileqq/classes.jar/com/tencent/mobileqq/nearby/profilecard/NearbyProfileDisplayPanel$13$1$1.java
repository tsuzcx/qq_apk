package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class NearbyProfileDisplayPanel$13$1$1
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$13$1$1(NearbyProfileDisplayPanel.13.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(NearbyProfileDisplayPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0).strGodJumpUrl))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject1 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a, QQBrowserActivity.class);
    Object localObject2 = new StringBuilder().append(NearbyProfileDisplayPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0).strGodJumpUrl).append("&gender=");
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      i = 0;
      label98:
      ((Intent)localObject1).putExtra("url", i);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.startActivity((Intent)localObject1);
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.app;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.e != 2) {
        break label215;
      }
    }
    label215:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "rank_list", "clk_icon", 0, 0, (String)localObject1, "", "", "");
      break;
      i = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.shGender + 1;
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13.1.1
 * JD-Core Version:    0.7.0.1
 */