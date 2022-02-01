package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$14
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$14(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a.getActionMenuItem(paramInt);
    if (paramView == null) {
      return;
    }
    switch (paramView.action)
    {
    default: 
      break;
    case 11: 
      VisitorTroopCardFragment.k(this.b);
      break;
    case 10: 
      TroopReportor.a("grpProfile", "grpProfile_clk", "more_tipoff_click", 0, 0, new String[] { this.b.W.troopUin });
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).doReportTroop(this.b.getQBaseActivity(), this.b.W, this.b.al);
      break;
    case 9: 
      TroopReportor.a("grpProfile", "grpProfile_clk", "more_share_click", 0, 0, new String[] { this.b.W.troopUin });
      VisitorTroopCardFragment.l(this.b);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.14
 * JD-Core Version:    0.7.0.1
 */