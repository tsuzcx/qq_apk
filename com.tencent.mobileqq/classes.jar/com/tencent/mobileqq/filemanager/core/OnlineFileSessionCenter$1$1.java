package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionCenter$1$1
  extends BroadcastReceiver
{
  OnlineFileSessionCenter$1$1(OnlineFileSessionCenter.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals("com.tencent.mobileqq.intent.logout")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "OLfilesession[] logout.....!");
        }
        this.a.this$0.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1.1
 * JD-Core Version:    0.7.0.1
 */