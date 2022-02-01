package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;

class VisitorTroopCardFragment$4
  implements LongClickCopyAction.ICopyListener
{
  VisitorTroopCardFragment$4(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onCopyContent(String paramString)
  {
    TroopReportor.a("grpProfile", "grpProfile_clk", "grpNumber_copy", 0, 0, new String[] { this.a.a.troopUin });
  }
  
  public void onShowCopyMenu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.4
 * JD-Core Version:    0.7.0.1
 */