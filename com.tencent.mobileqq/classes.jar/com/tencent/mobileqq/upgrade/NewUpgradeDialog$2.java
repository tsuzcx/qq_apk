package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class NewUpgradeDialog$2
  implements View.OnClickListener
{
  NewUpgradeDialog$2(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void onClick(View paramView)
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.e(), 2, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, NewUpgradeDialog.e(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    int i;
    if (NewUpgradeDialog.e() == 2) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.2
 * JD-Core Version:    0.7.0.1
 */