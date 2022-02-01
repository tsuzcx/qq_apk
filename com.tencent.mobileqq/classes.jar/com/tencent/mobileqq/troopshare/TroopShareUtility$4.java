package com.tencent.mobileqq.troopshare;

import android.view.View;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopShareUtility$4
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.c) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("OnClick.chooseLinkType: ");
      paramView.append(paramInt);
      QLog.i("TroopShareUtility", 2, paramView.toString());
    }
    paramView = this.a;
    paramView.c = true;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        paramView.b(false);
        paramView = this.a;
        paramView.jdField_a_of_type_Int = -1;
        paramView.jdField_b_of_type_Int = -1;
        if ((paramView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
        }
      }
      else
      {
        paramView.b(true);
        paramView = this.a;
        paramView.jdField_b_of_type_Int = 0;
        TroopShareUtility.b(paramView);
      }
    }
    else
    {
      paramView.b(true);
      paramView = this.a;
      paramView.jdField_b_of_type_Int = 1;
      TroopShareUtility.b(paramView);
    }
    this.a.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.4
 * JD-Core Version:    0.7.0.1
 */