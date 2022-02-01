package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$46
  implements View.OnLongClickListener
{
  TroopSettingActivity$46(TroopSettingActivity paramTroopSettingActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "setTroopUinTextViewClickListener onLongClick");
    }
    TroopSettingActivity.x(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.46
 * JD-Core Version:    0.7.0.1
 */