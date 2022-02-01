package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopSettingActivity$16
  implements ActionSheet.OnButtonClickListener
{
  TroopSettingActivity$16(TroopSettingActivity paramTroopSettingActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    if (this.b.n == null)
    {
      paramView = this.b;
      paramView.n = new QQProgressNotifier(paramView);
    }
    paramView = (ITroopMngHandler)TroopSettingActivity.a(this.b).getBusinessHandler(TroopMngHandler.class.getName());
    if ((NetworkUtil.isNetSupport(TroopSettingActivity.a(this.b).getApp().getApplicationContext())) && (paramView != null))
    {
      this.b.n.b(0, 2131889064, 0);
      paramView.a(this.b.i.troopUin);
    }
    else if (paramView != null)
    {
      this.b.n.b(2, 2131892157, 1500);
    }
    else
    {
      this.b.n.b(2, 2131889057, 1500);
    }
    ReportController.b(TroopSettingActivity.a(this.b), "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */