package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class NotifyAndRecAdapter$4$1
  implements BusinessObserver
{
  NotifyAndRecAdapter$4$1(NotifyAndRecAdapter.4 param4) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopAdapter", 4, "delRecommendTroop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.4.1
 * JD-Core Version:    0.7.0.1
 */