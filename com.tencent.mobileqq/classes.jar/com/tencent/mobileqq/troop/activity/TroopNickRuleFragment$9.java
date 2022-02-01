package com.tencent.mobileqq.troop.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopNickRuleFragment$9
  implements TextView.OnEditorActionListener
{
  TroopNickRuleFragment$9(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt != 6) && (paramInt != 2))
    {
      bool = false;
    }
    else
    {
      this.a.a(-1.0F, -1.0F);
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.9
 * JD-Core Version:    0.7.0.1
 */