package com.tencent.mobileqq.settings.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrivacyShowSettingFragment$13
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    String str = IndividuationUrlHelper.a("gameIconSetupH5Url");
    Intent localIntent = new Intent(this.a.a.getApp(), QQBrowserActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.b(this.a.a.getApp(), str, -1L, localIntent, false, -1);
    ReportController.b(this.a.a, "CliOper", "", "", "Setting_tab", "0X8009C07", 0, 0, "", "", "", "");
    ReportController.b(this.a.a, "dc00898", "", "", "0X800B865", "0X800B865", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.13
 * JD-Core Version:    0.7.0.1
 */