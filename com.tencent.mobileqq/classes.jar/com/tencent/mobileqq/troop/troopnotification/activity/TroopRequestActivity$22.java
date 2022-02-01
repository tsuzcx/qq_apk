package com.tencent.mobileqq.troop.troopnotification.activity;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class TroopRequestActivity$22
  extends StrangerObserver
{
  TroopRequestActivity$22(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.makeText(this.a.getApplicationContext(), 2, this.a.getApplicationContext().getResources().getString(2131916694), 0).show();
      this.a.F.setVisibility(8);
      return;
    }
    QQToast.makeText(this.a.getApplicationContext(), 1, this.a.getApplicationContext().getResources().getString(2131916691), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.22
 * JD-Core Version:    0.7.0.1
 */