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
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.access$3000(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).getLayoutParams()).leftMargin = ((int)(this.jdField_a_of_type_Int + ChooseInterestTagActivity.access$3100(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a) * 7.0F));
      ChooseInterestTagActivity.access$3000(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).requestLayout();
    }
    if (ChooseInterestTagActivity.access$600(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).setVisibility(8);
      if (ChooseInterestTagActivity.access$3200(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.access$3000(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).getLayoutParams();
        localLayoutParams.height = 1;
        int i;
        if (ChooseInterestTagActivity.access$100(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a))
        {
          double d = ChooseInterestTagActivity.access$3100(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a) * 7.0F;
          Double.isNaN(d);
          i = (int)(d + 0.5D);
        }
        else
        {
          i = 0;
        }
        localLayoutParams.topMargin = i;
        localLayoutParams.bottomMargin = i;
        ChooseInterestTagActivity.access$3000(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity$9.a).setLayoutParams(localLayoutParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.9.1
 * JD-Core Version:    0.7.0.1
 */