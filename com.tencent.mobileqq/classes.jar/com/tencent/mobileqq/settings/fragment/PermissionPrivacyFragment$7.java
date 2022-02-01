package com.tencent.mobileqq.settings.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class PermissionPrivacyFragment$7
  implements View.OnClickListener
{
  PermissionPrivacyFragment$7(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131442491: 
      ReportController.b(null, "dc00898", "", "", "0X800B855", "0X800B855", 0, 0, "", "0", "0", "");
      localObject = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
      PermissionPrivacyFragment.a(this.a, (Intent)localObject);
      this.a.startActivity((Intent)localObject);
      break;
    case 2131442485: 
      localObject = PermissionPrivacyFragment.b(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PermissionPrivacyFragment.d(this.a));
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800B857", "0X800B857", 0, 0, localStringBuilder.toString(), "", "", "");
      PublicFragmentActivity.a(this.a, ShieldFriendsListFragment.class, 1);
      break;
    case 2131442483: 
      ReportController.b(PermissionPrivacyFragment.b(this.a), "CliOper", "", "", "0X800B857", "0X800B85A", 0, 0, "", "", "", "");
      new Intent().putExtra("from", PrivacyShowSettingFragment.class);
      PublicFragmentActivity.a(this.a.getBaseActivity(), PrivacyShowSettingFragment.class);
      break;
    case 2131442482: 
      ReportController.b(PermissionPrivacyFragment.b(this.a), "CliOper", "", "", "0X800B857", "0X800B859", 0, 0, "", "", "", "");
      new Intent().putExtra("from", PrivacyPermissionSettingFragment.class);
      PublicFragmentActivity.a(this.a.getBaseActivity(), PrivacyPermissionSettingFragment.class);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.7
 * JD-Core Version:    0.7.0.1
 */