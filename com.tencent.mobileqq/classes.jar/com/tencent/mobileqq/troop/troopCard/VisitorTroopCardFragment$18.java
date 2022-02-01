package com.tencent.mobileqq.troop.troopCard;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$18
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$18(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) == null) {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity()));
    }
    if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity()))
    {
      paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (paramView != null)
      {
        if ((VisitorTroopCardFragment.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) & 0x1) == 0)
        {
          VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, VisitorTroopCardFragment.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) | 0x1);
          paramView.k(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(0, 2131692170, 1000);
      }
    }
    for (;;)
    {
      VisitorTroopCardReport.a(21, new Object());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(2, 2131692165, 1500);
      continue;
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(2, 2131694510, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.18
 * JD-Core Version:    0.7.0.1
 */