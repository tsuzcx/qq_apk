package com.tencent.mobileqq.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AutoSaveUtils;
import mqq.app.AppRuntime;

class QQSettingAutoDownloadAndSaveFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  QQSettingAutoDownloadAndSaveFragment$4(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    AutoSaveUtils.a(true, paramBoolean);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramBoolean) {}
    for (;;)
    {
      ReportController.b(null, "CliOper", "", str, "0X800A6E3", "0X800A6E3", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment.4
 * JD-Core Version:    0.7.0.1
 */