package com.tencent.mobileqq.settings.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermissionPrivacyFragment$7
  implements View.OnClickListener
{
  PermissionPrivacyFragment$7(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(null, "dc00898", "", "", "0X800B855", "0X800B855", 0, 0, "", "0", "0", "");
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      PermissionPrivacyFragment.a(this.a, localIntent);
      this.a.startActivity(localIntent);
      continue;
      ReportController.b(PermissionPrivacyFragment.a(this.a), "CliOper", "", "", "0X800B857", "0X800B857", 0, 0, PermissionPrivacyFragment.a(this.a) + "", "", "", "");
      PublicFragmentActivity.a(this.a, ShieldFriendsListFragment.class, 1);
      continue;
      ReportController.b(PermissionPrivacyFragment.a(this.a), "CliOper", "", "", "0X800B857", "0X800B859", 0, 0, "", "", "", "");
      new Intent().putExtra("from", PrivacyPermissionSettingFragment.class);
      PublicFragmentActivity.a(this.a.getActivity(), PrivacyPermissionSettingFragment.class);
      continue;
      ReportController.b(PermissionPrivacyFragment.a(this.a), "CliOper", "", "", "0X800B857", "0X800B85A", 0, 0, "", "", "", "");
      new Intent().putExtra("from", PrivacyShowSettingFragment.class);
      PublicFragmentActivity.a(this.a.getActivity(), PrivacyShowSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.7
 * JD-Core Version:    0.7.0.1
 */