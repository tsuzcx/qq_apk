package com.tencent.mobileqq.kandian.biz.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJMsgReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;

class ReadinjoySocialMsgTips$1
  implements View.OnClickListener
{
  ReadinjoySocialMsgTips$1(ReadinjoySocialMsgTips paramReadinjoySocialMsgTips) {}
  
  public void onClick(View paramView)
  {
    if (ReadinjoySocialMsgTips.a(this.a) != null) {
      ReadinjoySocialMsgTips.a(this.a).onClick(paramView);
    }
    paramView = new RIJTransMergeKanDianReport.ReportR5Builder();
    paramView.addSessionId().addKandianMode().addKandianModeNew().addFolderStatus().addOS().addVersion();
    paramView.addStringNotThrow("message_reddot_style", RIJMsgBoxUtils.b());
    try
    {
      paramView.addType(Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0));
      label78:
      paramView = paramView.build();
      paramView = RIJMsgReport.a.a(paramView);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", paramView, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgTips.1
 * JD-Core Version:    0.7.0.1
 */