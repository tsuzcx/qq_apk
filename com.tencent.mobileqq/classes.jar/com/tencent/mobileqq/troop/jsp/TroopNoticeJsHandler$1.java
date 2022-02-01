package com.tencent.mobileqq.troop.jsp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class TroopNoticeJsHandler$1
  extends BroadcastReceiver
{
  TroopNoticeJsHandler$1(TroopNoticeJsHandler paramTroopNoticeJsHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.a.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.1
 * JD-Core Version:    0.7.0.1
 */