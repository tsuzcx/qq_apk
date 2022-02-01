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
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment.getActivity()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment.getActivity(), 1, 2131694510, 1).a();
      KidModeAdvanceSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment).setEnabled(true);
      KidModeAdvanceSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment, KidModeAdvanceSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment), false, KidModeAdvanceSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment));
      return;
    }
    KidModeAdvanceSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeAdvanceSettingFragment, this.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */