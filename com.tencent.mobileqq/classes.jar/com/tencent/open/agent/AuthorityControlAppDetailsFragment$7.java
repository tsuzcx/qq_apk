package com.tencent.open.agent;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthorityControlAppDetailsFragment$7
  implements CompoundButton.OnCheckedChangeListener
{
  AuthorityControlAppDetailsFragment$7(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment, AuthorityControlAppDetailsFragment.AuthPermission paramAuthPermission) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onCheckedChanged name=", this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment$AuthPermission.jdField_a_of_type_JavaLangString, ", isChecked=", Boolean.valueOf(paramBoolean) });
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment$AuthPermission.jdField_a_of_type_Boolean = paramBoolean;
    String str1;
    String str2;
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i = 2;
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment, i, this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment$AuthPermission.jdField_a_of_type_Int);
      str1 = AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).b();
      str2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment$AuthPermission.jdField_a_of_type_JavaLangString;
      localQQAppInterface = AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment);
      if (!paramBoolean) {
        break label148;
      }
    }
    label148:
    for (int i = 1;; i = 0)
    {
      AuthorityUtil.a(localQQAppInterface, "0X800B930", i, new String[] { "", "", str1, str2 });
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 3;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.7
 * JD-Core Version:    0.7.0.1
 */