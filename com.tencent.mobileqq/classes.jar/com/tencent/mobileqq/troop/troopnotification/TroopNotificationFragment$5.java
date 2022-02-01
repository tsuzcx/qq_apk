package com.tencent.mobileqq.troop.troopnotification;

import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class TroopNotificationFragment$5
  extends MqqHandler
{
  TroopNotificationFragment$5(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 108) {
      switch (i)
      {
      default: 
        return;
      case 1019: 
        this.a.g();
        this.a.b();
        return;
      case 1017: 
        if (TroopNotificationFragment.a(this.a) != null)
        {
          TroopNotificationFragment.a(this.a).c(2131718766);
          TroopNotificationFragment.a(this.a).show();
          return;
        }
        break;
      case 1015: 
        paramMessage = paramMessage.obj;
      }
    }
    try
    {
      this.a.a((List)paramMessage);
    }
    catch (Exception paramMessage)
    {
      label129:
      break label129;
    }
    QLog.e("TroopNotificationFragment", 1, "handleRecommendData wrong");
    TroopNotificationFragment.e(this.a);
    return;
    this.a.b();
    return;
    TroopNotificationFragment.d(this.a);
    return;
    if (TroopNotificationFragment.a(this.a) != null)
    {
      TroopNotificationFragment.a(this.a).c(2131718766);
      TroopNotificationFragment.a(this.a).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.5
 * JD-Core Version:    0.7.0.1
 */