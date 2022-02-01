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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel;
      NearbyProfileEditPanel.a((NearbyProfileEditPanel)localObject, ((NearbyProfileEditPanel)localObject).c, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h = paramInt2;
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.g = paramInt2;
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.f = paramInt2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
    {
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0), this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1), this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.3
 * JD-Core Version:    0.7.0.1
 */