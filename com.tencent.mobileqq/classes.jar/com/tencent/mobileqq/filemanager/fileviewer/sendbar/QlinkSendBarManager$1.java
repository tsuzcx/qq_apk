package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QlinkSendBarManager$1
  implements View.OnClickListener
{
  QlinkSendBarManager$1(QlinkSendBarManager paramQlinkSendBarManager) {}
  
  public void onClick(View paramView)
  {
    if (QlinkSendBarManager.a(this.a))
    {
      long l = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      ReportController.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", 4, 0, localStringBuilder.toString(), "0", "", "");
      if ((1 == QlinkSendBarManager.b(this.a)) && (!QlinkSendBarManager.c(this.a))) {
        FMDialogUtil.a(QlinkSendBarManager.d(this.a), 2131896349, 2131896348, new QlinkSendBarManager.1.1(this));
      } else {
        QlinkSendBarManager.e(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.QlinkSendBarManager.1
 * JD-Core Version:    0.7.0.1
 */