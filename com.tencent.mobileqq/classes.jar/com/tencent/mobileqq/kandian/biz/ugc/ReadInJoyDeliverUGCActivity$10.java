package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyDeliverUGCActivity$10
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyDeliverUGCActivity$10(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.a)) {
      return;
    }
    ReadInJoyDeliverUGCActivity.b(this.a, true);
    paramView = this.a;
    paramView.a = paramView.b;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ReadInJoyDeliverUGCActivity.d(this.a);
        RIJDeliverUGCReportUtil.d();
      }
    }
    else
    {
      ReadInJoyDeliverUGCActivity.c(this.a);
      RIJDeliverUGCReportUtil.c();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008239", "0X8008239", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
    }
    ReadInJoyDeliverUGCActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.10
 * JD-Core Version:    0.7.0.1
 */