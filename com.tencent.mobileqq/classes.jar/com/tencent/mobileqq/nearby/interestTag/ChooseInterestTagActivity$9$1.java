package com.tencent.mobileqq.nearby.interestTag;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

class ChooseInterestTagActivity$9$1
  implements Runnable
{
  ChooseInterestTagActivity$9$1(ChooseInterestTagActivity.9 param9, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int >= 0)
    {
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).getLayoutParams()).leftMargin = ((int)(this.jdField_a_of_type_Int + ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a) * 7.0F));
      ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).requestLayout();
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).setVisibility(8);
      if (ChooseInterestTagActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).getLayoutParams();
        localLayoutParams.height = 1;
        if (!ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a)) {
          break label183;
        }
      }
    }
    label183:
    for (int i = (int)(ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a) * 7.0F + 0.5D);; i = 0)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).setLayoutParams(localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.9.1
 * JD-Core Version:    0.7.0.1
 */