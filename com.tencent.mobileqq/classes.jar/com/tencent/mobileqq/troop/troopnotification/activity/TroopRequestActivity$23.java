package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopRequestActivity$23
  implements ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver
{
  TroopRequestActivity$23(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    try
    {
      paramBundle = paramBundle.getByteArray("structMsg");
      new structmsg.StructMsg().mergeFrom(paramBundle);
      TroopRequestActivity.a(this.a, 1);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label37:
      break label37;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.TroopRequestActivity", 2, "structMsg merge error");
    }
    this.a.h();
    paramBundle = this.a;
    QQToast.makeText(paramBundle, paramBundle.getString(2131895157), 0).show(this.a.getTitleBarHeight());
    return;
    this.a.h();
    paramBundle = this.a;
    QQToast.makeText(paramBundle, paramBundle.getString(2131895157), 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.23
 * JD-Core Version:    0.7.0.1
 */