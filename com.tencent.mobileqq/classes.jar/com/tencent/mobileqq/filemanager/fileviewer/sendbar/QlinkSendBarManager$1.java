package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QlinkSendBarManager$1
  implements View.OnClickListener
{
  QlinkSendBarManager$1(QlinkSendBarManager paramQlinkSendBarManager) {}
  
  public void onClick(View paramView)
  {
    if (!QlinkSendBarManager.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = FMDataCache.b();
      ReportController.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", 4, 0, "" + l, "0", "", "");
      if ((1 == QlinkSendBarManager.a(this.a)) && (!QlinkSendBarManager.b(this.a))) {
        FMDialogUtil.a(QlinkSendBarManager.a(this.a), 2131698360, 2131698359, new QlinkSendBarManager.1.1(this));
      } else {
        QlinkSendBarManager.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.QlinkSendBarManager.1
 * JD-Core Version:    0.7.0.1
 */