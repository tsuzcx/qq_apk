package com.tencent.mobileqq.troopshare;

import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
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
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "OnClick.chooseLinkType: " + paramInt);
    }
    this.a.c = true;
    switch (paramInt)
    {
    default: 
      this.a.b(false);
      this.a.jdField_a_of_type_Int = -1;
      this.a.jdField_b_of_type_Int = -1;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.a.b(true);
      this.a.jdField_b_of_type_Int = 1;
      TroopShareUtility.b(this.a);
      continue;
      this.a.b(true);
      this.a.jdField_b_of_type_Int = 0;
      TroopShareUtility.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.4
 * JD-Core Version:    0.7.0.1
 */