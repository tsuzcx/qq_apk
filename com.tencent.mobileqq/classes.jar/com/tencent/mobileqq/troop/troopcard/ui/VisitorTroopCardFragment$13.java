package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$13
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$13(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a.getActionMenuItem(paramInt);
    if (paramView == null) {
      return;
    }
    paramInt = paramView.action;
    if (paramInt != 7)
    {
      if (paramInt == 8) {
        VisitorTroopCardFragment.a(this.b, true, true);
      }
    }
    else {
      VisitorTroopCardFragment.a(this.b, true, false);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.13
 * JD-Core Version:    0.7.0.1
 */