package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class NearbyProfileEditTribePanel$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localActionSheet.addButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694413));
    }
    localActionSheet.addButton(HardCodeUtil.a(2131707354));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localActionSheet.addButton(HardCodeUtil.a(2131707327), 3);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new NearbyProfileEditTribePanel.5.1(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.5
 * JD-Core Version:    0.7.0.1
 */