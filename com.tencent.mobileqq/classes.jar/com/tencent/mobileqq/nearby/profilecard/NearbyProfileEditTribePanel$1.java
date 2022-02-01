package com.tencent.mobileqq.nearby.profilecard;

import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.widget.ActionSheet;

class NearbyProfileEditTribePanel$1
  implements IphonePickerView.IphonePickListener
{
  NearbyProfileEditTribePanel$1(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      NearbyProfileEditTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.b, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.b.setTag(Byte.valueOf((byte)paramInt1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.b.setText(NearbyProfileEditTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel).getText(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.1
 * JD-Core Version:    0.7.0.1
 */