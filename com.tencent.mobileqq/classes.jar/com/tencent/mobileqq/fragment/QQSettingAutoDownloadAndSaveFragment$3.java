package com.tencent.mobileqq.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class QQSettingAutoDownloadAndSaveFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  QQSettingAutoDownloadAndSaveFragment$3(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      localObject = (ConfigHandler)QQSettingAutoDownloadAndSaveFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      ((ConfigHandler)localObject).d();
      ConfigHandler.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label138;
      }
      if (UpgradeController.a().a() != 4) {
        UpgradeController.a().a();
      }
      ReportController.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((ConfigHandler)localObject).a(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label138:
      UpgradeController.a().b();
      ReportController.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment.3
 * JD-Core Version:    0.7.0.1
 */