package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.widget.ExpandableTextView.OnExpandStateListener;
import com.tencent.mobileqq.utils.TroopReportor;

class VisitorTroopCardFragment$5
  implements ExpandableTextView.OnExpandStateListener
{
  VisitorTroopCardFragment$5(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(TextView paramTextView, View paramView, boolean paramBoolean)
  {
    paramView.setVisibility(8);
    if (paramBoolean) {
      TroopReportor.a("grpProfile", "grpProfile_clk", "grpInfo_click", 0, 0, new String[] { this.a.W.troopUin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.5
 * JD-Core Version:    0.7.0.1
 */