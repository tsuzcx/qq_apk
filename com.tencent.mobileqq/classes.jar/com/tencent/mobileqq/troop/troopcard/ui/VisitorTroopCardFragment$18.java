package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$18
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$18(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.n(this.b) == null)
    {
      paramView = this.b;
      VisitorTroopCardFragment.a(paramView, new QQProgressNotifier(paramView.getActivity()));
    }
    if (NetworkUtil.isNetSupport(this.b.getActivity()))
    {
      paramView = (ITroopMngHandler)this.b.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
      if (paramView != null)
      {
        if ((VisitorTroopCardFragment.o(this.b) & 0x1) == 0)
        {
          VisitorTroopCardFragment localVisitorTroopCardFragment = this.b;
          VisitorTroopCardFragment.a(localVisitorTroopCardFragment, VisitorTroopCardFragment.o(localVisitorTroopCardFragment) | 0x1);
          paramView.b(this.b.W.troopUin);
        }
        VisitorTroopCardFragment.n(this.b).b(0, 2131889068, 1000);
      }
      else
      {
        VisitorTroopCardFragment.n(this.b).b(2, 2131889057, 1500);
      }
    }
    else
    {
      VisitorTroopCardFragment.n(this.b).b(2, 2131892157, 1500);
    }
    VisitorTroopCardReport.a(21, new Object());
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.18
 * JD-Core Version:    0.7.0.1
 */