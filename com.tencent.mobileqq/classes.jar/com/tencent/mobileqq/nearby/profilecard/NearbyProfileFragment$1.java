package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportTask;

class NearbyProfileFragment$1
  implements View.OnClickListener
{
  NearbyProfileFragment$1(NearbyProfileFragment paramNearbyProfileFragment, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.startActivity(paramView);
    ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_click");
    paramView = new StringBuilder();
    paramView.append("");
    paramView.append(NearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment).gender + 1);
    String str1 = paramView.toString();
    paramView = new StringBuilder();
    paramView.append("");
    paramView.append(this.jdField_a_of_type_Int);
    String str2 = paramView.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.mMode == 3) {
      paramView = "2";
    } else {
      paramView = "1";
    }
    localReportTask.a(new String[] { "", str1, str2, paramView }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.1
 * JD-Core Version:    0.7.0.1
 */