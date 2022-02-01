package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.util.Utils;

class TroopEssenceMsgView$3
  implements Runnable
{
  TroopEssenceMsgView$3(TroopEssenceMsgView paramTroopEssenceMsgView, View paramView, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.a.getMeasuredHeight() >= Utils.a(108.0F, this.this$0.getResources())) {
      this.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopEssenceMsgView.3
 * JD-Core Version:    0.7.0.1
 */