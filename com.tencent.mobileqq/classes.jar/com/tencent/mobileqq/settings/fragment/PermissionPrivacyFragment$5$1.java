package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermissionPrivacyFragment$5$1
  implements Runnable
{
  PermissionPrivacyFragment$5$1(PermissionPrivacyFragment.5 param5, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPrivacyFragment", 2, "updateIntimateRelationshipFriendCount number:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment$5.this$0.i.setRightText(this.jdField_a_of_type_Int + HardCodeUtil.a(2131700939));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment$5.this$0.i.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.5.1
 * JD-Core Version:    0.7.0.1
 */