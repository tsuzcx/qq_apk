package com.tencent.mobileqq.nearby.profilecard;

import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.widget.ActionSheet;

class NearbyProfileEditPanel$5
  implements IphonePickerView.IphonePickListener
{
  int jdField_a_of_type_Int = -1;
  
  NearbyProfileEditPanel$5(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h.setTag(Byte.valueOf((byte)(this.b + 1)));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h.setText(NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getText(0, this.b));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
      {
        NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h, false);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h.setTag(Byte.valueOf((byte)(this.jdField_a_of_type_Int + 1)));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h.setText(NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getText(0, this.jdField_a_of_type_Int));
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.5
 * JD-Core Version:    0.7.0.1
 */