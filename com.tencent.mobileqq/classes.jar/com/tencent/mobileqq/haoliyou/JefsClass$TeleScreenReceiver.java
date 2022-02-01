package com.tencent.mobileqq.haoliyou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class JefsClass$TeleScreenReceiver
  extends BroadcastReceiver
{
  private JefsClass$TeleScreenReceiver(JefsClass paramJefsClass) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!MobileQQ.processName.equals(paramIntent.getStringExtra("key_process_id")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "is not current process");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "start");
    }
    if ("com.tencent.mobileqq.telescreen.action_run".equals(paramIntent.getAction()))
    {
      JefsClass.a(this.a, paramIntent.getIntExtra("key_id", 0), paramIntent.getIntExtra("key_callback_id", 0));
      return;
    }
    if ("com.tencent.mobileqq.telescreen.action_remove".equals(paramIntent.getAction())) {
      JefsClass.b(this.a, paramIntent.getIntExtra("key_id", 0), paramIntent.getIntExtra("key_callback_id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.TeleScreenReceiver
 * JD-Core Version:    0.7.0.1
 */