package com.tencent.mobileqq.troop.troopnotification.activity;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.relation.api.ISafetyReportTempService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$10
  implements ActionSheet.OnButtonClickListener
{
  TroopRequestActivity$10(TroopRequestActivity paramTroopRequestActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {}
    }
    for (;;)
    {
      try
      {
        paramInt = this.b.W.msg.group_msg_type.get();
        if (paramInt == 1) {
          break label203;
        }
        if (paramInt == 2) {
          break label210;
        }
      }
      catch (Exception paramView)
      {
        long l;
        ISafetyReportTempService localISafetyReportTempService;
        paramView.printStackTrace();
        break label155;
      }
      l = this.b.W.msg.group_code.get();
      paramView = TroopRequestActivity.a(this.b).getCurrentAccountUin();
      localISafetyReportTempService = (ISafetyReportTempService)TroopRequestActivity.a(this.b).getRuntimeService(ISafetyReportTempService.class, "");
      if (localISafetyReportTempService != null)
      {
        localISafetyReportTempService.safetyReport(this.b, this.b.ac, String.valueOf(l), paramView, paramInt, null);
        break label155;
        QQToast.makeText(this.b, 2131917585, 0).show(this.b.getTitleBarHeight());
      }
      label155:
      ReportController.b(TroopRequestActivity.a(this.b), "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, this.b.c, this.b.ad, "", "");
      this.a.dismiss();
      return;
      label203:
      paramInt = 20011;
      continue;
      label210:
      paramInt = 20009;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.10
 * JD-Core Version:    0.7.0.1
 */