package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$13
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$13(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getActionMenuItem(paramInt);
    if (paramView == null) {
      return;
    }
    paramInt = paramView.action;
    if (paramInt != 7)
    {
      if (paramInt == 8) {
        VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment, true, true);
      }
    }
    else {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment, true, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.13
 * JD-Core Version:    0.7.0.1
 */