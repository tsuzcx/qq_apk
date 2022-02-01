package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.util.Utils;

class TroopEssenceMsgView$3
  implements Runnable
{
  TroopEssenceMsgView$3(TroopEssenceMsgView paramTroopEssenceMsgView, View paramView, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() >= Utils.a(108.0F, this.this$0.getResources())) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopEssenceMsgView.3
 * JD-Core Version:    0.7.0.1
 */