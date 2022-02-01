package com.tencent.mobileqq.nearby.profilecard;

import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$6
  implements ViewPager.OnPageChangeListener
{
  NearbyProfileDisplayPanel$6(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onPageSelected", new Object[] { Integer.valueOf(paramInt) });
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    Object localObject1 = this.a.jdField_a_of_type_AndroidxFragmentAppFragmentManager;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("android:switcher:2131381005:");
    ((StringBuilder)localObject2).append(paramInt);
    localObject1 = (NearbyBaseFragment)((FragmentManager)localObject1).findFragmentByTag(((StringBuilder)localObject2).toString());
    if (localObject1 != null) {
      ((NearbyBaseFragment)localObject1).aR_();
    }
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode;
    localObject1 = "1";
    if (i == 2) {
      if (paramInt == 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ReportTask localReportTask = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(String.valueOf(NearbyProfileDisplayPanel.a(this.a).tinyId));
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
        localReportTask.a(new String[] { localObject2 }).a();
      }
    }
    if (paramInt == 0)
    {
      localObject2 = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
        localObject1 = "2";
      }
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
    }
    localObject2 = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(String.valueOf(NearbyProfileDisplayPanel.a(this.a).tinyId));
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
      localObject1 = "2";
    }
    ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.6
 * JD-Core Version:    0.7.0.1
 */