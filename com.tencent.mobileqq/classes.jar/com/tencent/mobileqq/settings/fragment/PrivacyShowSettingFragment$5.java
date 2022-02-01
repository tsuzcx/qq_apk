package com.tencent.mobileqq.settings.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrivacyShowSettingFragment$5
  implements View.OnClickListener
{
  PrivacyShowSettingFragment$5(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.a, "dc00898", "", "", "0X800B868", "0X800B868", 0, 0, "", "", "", "");
    VipUtils.VipIconUtils.a(this.a.a, this.a.getActivity(), "setting");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */