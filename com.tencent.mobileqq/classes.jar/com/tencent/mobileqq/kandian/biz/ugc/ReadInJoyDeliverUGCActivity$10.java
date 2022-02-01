package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyDeliverUGCActivity$10
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyDeliverUGCActivity$10(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (ReadInJoyDeliverUGCActivity.h(this.a)) {
      return;
    }
    ReadInJoyDeliverUGCActivity.b(this.a, true);
    paramView = this.a;
    paramView.p = paramView.q;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ReadInJoyDeliverUGCActivity.j(this.a);
        RIJDeliverUGCReportUtil.d();
      }
    }
    else
    {
      ReadInJoyDeliverUGCActivity.i(this.a);
      RIJDeliverUGCReportUtil.c();
      PublicAccountReportUtils.a(null, "", "0X8008239", "0X8008239", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
    }
    ReadInJoyDeliverUGCActivity.k(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.10
 * JD-Core Version:    0.7.0.1
 */