package com.tencent.mobileqq.troop.troopcard.ui;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;

class VisitorTroopCardFragment$8
  extends ViewPager.SimpleOnPageChangeListener
{
  VisitorTroopCardFragment$8(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    if (this.a.W != null)
    {
      String str1;
      if (VisitorTroopCardFragment.g(this.a)) {
        str1 = "grpData_admin";
      } else {
        str1 = "grpData_visitor";
      }
      String str3 = this.a.W.troopUin;
      String str2;
      if (VisitorTroopCardFragment.g(this.a)) {
        str2 = TroopReportor.a(this.a.W);
      } else {
        str2 = "1";
      }
      TroopReportor.a("Grp_set_new", str1, "slide_head", 0, 0, new String[] { str3, str2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.8
 * JD-Core Version:    0.7.0.1
 */