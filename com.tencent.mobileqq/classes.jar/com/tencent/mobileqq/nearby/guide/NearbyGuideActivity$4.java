package com.tencent.mobileqq.nearby.guide;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyGuideActivity$4
  implements ActionSheet.OnButtonClickListener
{
  NearbyGuideActivity$4(NearbyGuideActivity paramNearbyGuideActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity.a);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.4
 * JD-Core Version:    0.7.0.1
 */