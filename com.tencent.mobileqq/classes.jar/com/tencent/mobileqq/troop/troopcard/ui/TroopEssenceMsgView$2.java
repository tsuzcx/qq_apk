package com.tencent.mobileqq.troop.troopcard.ui;

import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;

class TroopEssenceMsgView$2
  implements Runnable
{
  TroopEssenceMsgView$2(TroopEssenceMsgView paramTroopEssenceMsgView, TextView paramTextView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    Layout localLayout = this.a.getLayout();
    if (localLayout != null)
    {
      int i = localLayout.getLineCount();
      if ((i > 0) && (localLayout.getEllipsisCount(i - 1) > 0)) {
        this.b.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopEssenceMsgView.2
 * JD-Core Version:    0.7.0.1
 */