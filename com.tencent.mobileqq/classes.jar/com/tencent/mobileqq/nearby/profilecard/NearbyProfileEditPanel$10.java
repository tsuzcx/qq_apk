package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class NearbyProfileEditPanel$10
  implements View.OnClickListener
{
  NearbyProfileEditPanel$10(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() >= NearbyProfileCardConstants.a)
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694404), 0).a();
      return;
    }
    NearbyProfileEditPanel.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.10
 * JD-Core Version:    0.7.0.1
 */