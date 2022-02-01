package com.tencent.mobileqq.troop.troopnotification.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopRequestActivity$9
  implements ActionSheet.OnButtonClickListener
{
  TroopRequestActivity$9(TroopRequestActivity paramTroopRequestActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        TroopRequestActivity.b(this.b);
      } else {
        QQToast.makeText(this.b, 2131917585, 0).show(this.b.getTitleBarHeight());
      }
      ReportController.b(TroopRequestActivity.a(this.b), "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, this.b.c, this.b.ad, "", "");
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.9
 * JD-Core Version:    0.7.0.1
 */