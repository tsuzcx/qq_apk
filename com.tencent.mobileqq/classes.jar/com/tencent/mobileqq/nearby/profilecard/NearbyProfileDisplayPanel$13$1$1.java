package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class NearbyProfileDisplayPanel$13$1$1
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$13$1$1(NearbyProfileDisplayPanel.13.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(NearbyProfileDisplayPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0).strGodJumpUrl)) {
      return;
    }
    paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a, QQBrowserActivity.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(NearbyProfileDisplayPanel.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0).strGodJumpUrl);
    ((StringBuilder)localObject).append("&gender=");
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      i = 0;
    } else {
      i = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.shGender + 1;
    }
    ((StringBuilder)localObject).append(i);
    paramView.putExtra("url", ((StringBuilder)localObject).toString());
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.startActivity(paramView);
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.app;
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.mMode == 2) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "rank_list", "clk_icon", 0, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13.1.1
 * JD-Core Version:    0.7.0.1
 */