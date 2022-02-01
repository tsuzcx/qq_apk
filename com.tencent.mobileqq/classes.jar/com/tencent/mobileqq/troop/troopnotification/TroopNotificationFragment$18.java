package com.tencent.mobileqq.troop.troopnotification;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotificationFragment$18
  implements ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver
{
  TroopNotificationFragment$18(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    try
    {
      paramBundle = paramBundle.getByteArray("structMsg");
      structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
      localStructMsg.mergeFrom(paramBundle);
      TroopNotificationFragment.a(this.a, 1, localStructMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label40:
      break label40;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopNotificationFragment", 2, "structMsg merge error");
    }
    if (TroopNotificationFragment.a(this.a) != null)
    {
      TroopNotificationFragment.a(this.a).dismiss();
      QQToast.a(this.a.a, this.a.a.getString(2131719868), 0).b(this.a.a());
      return;
      if (TroopNotificationFragment.a(this.a) != null)
      {
        TroopNotificationFragment.a(this.a).dismiss();
        QQToast.a(this.a.a, this.a.a.getString(2131719868), 0).b(this.a.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.18
 * JD-Core Version:    0.7.0.1
 */