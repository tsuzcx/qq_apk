package com.tencent.mobileqq.troop.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class TroopNickRuleFragment$9
  implements TextView.OnEditorActionListener
{
  TroopNickRuleFragment$9(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 2))
    {
      this.a.a(-1.0F, -1.0F);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.9
 * JD-Core Version:    0.7.0.1
 */