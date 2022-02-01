package com.tencent.mobileqq.troop.troopsetting.activity;

import android.widget.TextView;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService.OnGetTroopMemberNameCallback;

class TroopSettingActivity$ListAdapter$1
  implements ITroopMemberNameService.OnGetTroopMemberNameCallback
{
  TroopSettingActivity$ListAdapter$1(TroopSettingActivity.ListAdapter paramListAdapter, TroopSettingActivity.ViewHolder paramViewHolder, String paramString, TextView paramTextView) {}
  
  public void a(String paramString)
  {
    this.d.a.runOnUiThread(new TroopSettingActivity.ListAdapter.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.ListAdapter.1
 * JD-Core Version:    0.7.0.1
 */