package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

class NearbyProfileEditPanel$3
  implements IphonePickerView.IphonePickListener
{
  NearbyProfileEditPanel$3(NearbyProfileEditPanel paramNearbyProfileEditPanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.c, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        if ((paramInt1 == 0) || (paramInt1 == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0), this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1), this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.f = paramInt2;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.g = paramInt2;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.3
 * JD-Core Version:    0.7.0.1
 */