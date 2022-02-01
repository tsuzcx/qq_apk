package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class NearbyProfileEditPanel$7
  implements View.OnClickListener
{
  NearbyProfileEditPanel$7(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localActionSheet.addButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694413));
    }
    localActionSheet.addButton(HardCodeUtil.a(2131707299));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localActionSheet.addButton(HardCodeUtil.a(2131707382), 3);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new NearbyProfileEditPanel.7.1(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.7
 * JD-Core Version:    0.7.0.1
 */