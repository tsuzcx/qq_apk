package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

class TroopSettingActivity$13
  implements View.OnLayoutChangeListener
{
  private boolean b;
  
  TroopSettingActivity$13(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!this.b)
    {
      Looper.myQueue().addIdleHandler(new TroopSettingActivity.13.1(this));
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */