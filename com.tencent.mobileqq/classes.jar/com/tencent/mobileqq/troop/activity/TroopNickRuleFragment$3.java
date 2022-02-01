package com.tencent.mobileqq.troop.activity;

import android.view.View;

class TroopNickRuleFragment$3
  implements PresetWordsListAdapter.OnItemEventListener
{
  TroopNickRuleFragment$3(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void a(View paramView, int paramInt, PresetWordsListAdapter.ViewHolder paramViewHolder)
  {
    if (paramView.getTag() == TroopNickRuleFragment.e)
    {
      this.a.a(paramInt);
      return;
    }
    if (paramView.getTag() == TroopNickRuleFragment.f) {
      this.a.a(paramViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.3
 * JD-Core Version:    0.7.0.1
 */