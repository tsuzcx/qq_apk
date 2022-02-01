package com.tencent.open.agent;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenSelectPermissionFragment$PermissionAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  OpenSelectPermissionFragment$PermissionAdapter$1(OpenSelectPermissionFragment.PermissionAdapter paramPermissionAdapter, CardContainer.Permission paramPermission) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer$Permission.b = paramBoolean;
    this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter.notifyDataSetChanged();
    String str1 = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter.a.getActivity().getIntent().getStringExtra("appName");
    String str2 = this.jdField_a_of_type_ComTencentOpenAgentCardContainer$Permission.a;
    OpenSDKAppInterface localOpenSDKAppInterface = OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$PermissionAdapter.a);
    if (paramBoolean) {}
    for (;;)
    {
      AuthorityUtil.a(localOpenSDKAppInterface, "0X800B936", i, new String[] { "", "", str1, str2 });
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.PermissionAdapter.1
 * JD-Core Version:    0.7.0.1
 */