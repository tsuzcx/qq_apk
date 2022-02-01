package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayPanel$2
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$2(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel, 1);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a.a).a();
    }
    for (;;)
    {
      NearbyProfileDisplayPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b)
      {
        NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel, 2);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel, 3);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.2
 * JD-Core Version:    0.7.0.1
 */