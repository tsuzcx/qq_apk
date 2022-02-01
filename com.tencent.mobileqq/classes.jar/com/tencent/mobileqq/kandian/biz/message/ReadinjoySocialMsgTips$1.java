package com.tencent.mobileqq.kandian.biz.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJMsgReport;

class ReadinjoySocialMsgTips$1
  implements View.OnClickListener
{
  ReadinjoySocialMsgTips$1(ReadinjoySocialMsgTips paramReadinjoySocialMsgTips) {}
  
  public void onClick(View paramView)
  {
    if (ReadinjoySocialMsgTips.a(this.a) != null) {
      ReadinjoySocialMsgTips.a(this.a).onClick(paramView);
    }
    paramView = ReadinjoySocialMsgTips.b(this.a);
    PublicAccountReportUtils.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", RIJMsgReport.a.a(paramView), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgTips.1
 * JD-Core Version:    0.7.0.1
 */