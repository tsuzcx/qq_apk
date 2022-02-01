package com.tencent.mobileqq.upgrade;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewUpgradeDialog$3
  implements View.OnClickListener
{
  NewUpgradeDialog$3(NewUpgradeDialog paramNewUpgradeDialog, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 2, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, NewUpgradeDialog.a(), 2, 200));
    if (NewUpgradeDialog.a() == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog, 0);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      DownloadManager.a().b(NewUpgradeDialog.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog));
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog.dismiss();
    }
    NewUpgradeDialog.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeDialog, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.3
 * JD-Core Version:    0.7.0.1
 */