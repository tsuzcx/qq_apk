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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateIntimateRelationshipFriendCount number:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.i("PermissionPrivacyFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment$5.this$0.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(HardCodeUtil.a(2131701082));
      ((FormSimpleItem)localObject).setRightText(localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment$5.this$0.i.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.5.1
 * JD-Core Version:    0.7.0.1
 */