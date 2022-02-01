package com.tencent.mobileqq.troop.troopnotification.ui;

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
        this.a.i();
        this.a.h();
        return;
      case 1017: 
        if (TroopNotificationFragment.j(this.a) != null)
        {
          TroopNotificationFragment.j(this.a).c(2131916272);
          TroopNotificationFragment.j(this.a).show();
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
    TroopNotificationFragment.i(this.a);
    return;
    this.a.c();
    return;
    TroopNotificationFragment.h(this.a);
    return;
    if (TroopNotificationFragment.j(this.a) != null)
    {
      TroopNotificationFragment.j(this.a).c(2131916272);
      TroopNotificationFragment.j(this.a).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.5
 * JD-Core Version:    0.7.0.1
 */