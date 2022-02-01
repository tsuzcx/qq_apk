package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PermissionPrivacyFragment$4$1
  implements Runnable
{
  PermissionPrivacyFragment$4$1(PermissionPrivacyFragment.4 param4, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment$4.this$0.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(HardCodeUtil.a(2131701082));
      localFormSimpleItem.setRightText(localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment$4.this$0.e.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.4.1
 * JD-Core Version:    0.7.0.1
 */