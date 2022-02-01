package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

class KidModeAdvanceSettingFragment$9
  implements DialogInterface.OnClickListener
{
  KidModeAdvanceSettingFragment$9(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment.getBaseActivity()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment.getBaseActivity(), 1, 2131694475, 1).a();
      KidModeAdvanceSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment).setEnabled(true);
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment;
      KidModeAdvanceSettingFragment.a(paramDialogInterface, KidModeAdvanceSettingFragment.a(paramDialogInterface), false, KidModeAdvanceSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment));
      return;
    }
    KidModeAdvanceSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment, this.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */