package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$12
  extends TroopObserver
{
  TroopRequestActivity$12(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.c == null) {
      return;
    }
    try
    {
      this.a.c = this.a.c.trim();
      long l = Long.parseLong(this.a.c);
      if (paramLong == l) {
        break label62;
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      label48:
      break label48;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_10_Ret=>NumberFormatException");
    }
    label62:
    this.a.h();
    if (!paramBoolean) {
      return;
    }
    if (paramTroopInfo != null) {
      ThreadManager.post(new TroopRequestActivity.12.1(this, paramTroopInfo), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.12
 * JD-Core Version:    0.7.0.1
 */