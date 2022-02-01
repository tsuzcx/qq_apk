package com.tencent.mobileqq.settings.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.setting.ArkAppListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PermissionPrivacyFragment$2
  implements View.OnClickListener
{
  PermissionPrivacyFragment$2(PermissionPrivacyFragment paramPermissionPrivacyFragment, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B85E", "0X800B85E", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment.getBaseActivity(), ArkAppListActivity.class);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    localIntent.putExtra("intent_extra_authority_app_list", (String[])localArrayList.toArray(new String[localArrayList.size()]));
    this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPermissionPrivacyFragment.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.2
 * JD-Core Version:    0.7.0.1
 */