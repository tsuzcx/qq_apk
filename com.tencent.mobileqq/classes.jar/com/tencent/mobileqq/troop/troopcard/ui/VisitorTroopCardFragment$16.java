package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$16
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$16(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a.getActionMenuItem(paramInt);
    if (paramView == null) {
      return;
    }
    paramInt = paramView.action;
    if (paramInt != 9)
    {
      if (paramInt == 12)
      {
        paramView = TroopInfoActivity.a(this.b.W.troopUin, 5);
        ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(this.b.getActivity(), paramView);
        TroopReportor.a("grpProfile", "grpProfile_clk", "search_upgrade_actionsheet_click_set", 0, 0, new String[] { this.b.W.troopUin });
      }
    }
    else {
      VisitorTroopCardFragment.m(this.b);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.16
 * JD-Core Version:    0.7.0.1
 */