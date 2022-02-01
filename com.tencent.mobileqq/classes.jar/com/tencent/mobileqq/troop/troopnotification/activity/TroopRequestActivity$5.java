package com.tencent.mobileqq.troop.troopnotification.activity;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver;

class TroopRequestActivity$5
  implements ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver
{
  TroopRequestActivity$5(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.a.j.setText(paramString);
      this.a.b.setVisibility(0);
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.5
 * JD-Core Version:    0.7.0.1
 */