package com.tencent.mobileqq.qrscan.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qrscan.IToolProcStart.Callback;
import com.tencent.qphone.base.util.QLog;

class PreCallUpToolProc$1
  extends BroadcastReceiver
{
  PreCallUpToolProc$1(PreCallUpToolProc paramPreCallUpToolProc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if (("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(paramContext)) && (TextUtils.equals(paramIntent.getStringExtra("from"), PreCallUpToolProc.a(this.a))))
    {
      if (PreCallUpToolProc.b(this.a) != null) {
        PreCallUpToolProc.b(this.a).removeMessages(108);
      }
      if (PreCallUpToolProc.c(this.a) != null) {
        PreCallUpToolProc.c(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.PreCallUpToolProc.1
 * JD-Core Version:    0.7.0.1
 */