package com.tencent.mobileqq.troop.troopCard;

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
    switch (paramView.action)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, true, false);
      continue;
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.13
 * JD-Core Version:    0.7.0.1
 */