package com.tencent.mobileqq.unifiedebug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$4
  extends BroadcastReceiver
{
  SnapshotService$4(SnapshotService paramSnapshotService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("id", -1L);
    int i = paramIntent.getIntExtra("action", -1);
    if ((l == 0L) && (i == 1) && (SnapshotService.a(this.a) > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i(SnapshotService.b(), 2, "receive broadcast: destroy snapshot service");
      }
      SnapshotService.a(false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.4
 * JD-Core Version:    0.7.0.1
 */