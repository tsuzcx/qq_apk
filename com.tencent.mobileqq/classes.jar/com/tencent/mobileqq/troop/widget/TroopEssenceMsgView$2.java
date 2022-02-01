package com.tencent.mobileqq.troop.widget;

import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;

class TroopEssenceMsgView$2
  implements Runnable
{
  TroopEssenceMsgView$2(TroopEssenceMsgView paramTroopEssenceMsgView, TextView paramTextView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    Layout localLayout = this.jdField_a_of_type_AndroidWidgetTextView.getLayout();
    if (localLayout != null)
    {
      int i = localLayout.getLineCount();
      if ((i > 0) && (localLayout.getEllipsisCount(i - 1) > 0)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopEssenceMsgView.2
 * JD-Core Version:    0.7.0.1
 */