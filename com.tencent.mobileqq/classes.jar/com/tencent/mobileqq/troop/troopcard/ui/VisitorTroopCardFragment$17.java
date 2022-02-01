package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$17
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$17(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.n(this.b) == null)
    {
      paramView = this.b;
      VisitorTroopCardFragment.a(paramView, new QQProgressNotifier(paramView.getActivity()));
    }
    paramView = (ITroopMngHandler)this.b.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
    if ((NetworkUtil.isNetSupport(this.b.al.getApp().getApplicationContext())) && (paramView != null))
    {
      VisitorTroopCardFragment.n(this.b).b(0, 2131889064, 0);
      paramView.a(this.b.W.troopUin);
    }
    else if (paramView != null)
    {
      VisitorTroopCardFragment.n(this.b).b(2, 2131892157, 1500);
    }
    else
    {
      VisitorTroopCardFragment.n(this.b).b(2, 2131889057, 1500);
    }
    ReportController.b(this.b.al, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.17
 * JD-Core Version:    0.7.0.1
 */