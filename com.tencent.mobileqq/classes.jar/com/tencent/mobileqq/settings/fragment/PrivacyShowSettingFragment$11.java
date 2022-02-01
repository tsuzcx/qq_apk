package com.tencent.mobileqq.settings.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrivacyShowSettingFragment$11
  implements View.OnClickListener
{
  PrivacyShowSettingFragment$11(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void onClick(View paramView)
  {
    VasUtil.a().getGameCardManager().gotoKingIconSetWeb(this.a.getActivity());
    ReportController.b(this.a.a, "CliOper", "", "", "Setting_tab", "0X8009C07", 0, 0, "", "", "", "");
    ReportController.b(this.a.a, "dc00898", "", "", "0X800B865", "0X800B865", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */