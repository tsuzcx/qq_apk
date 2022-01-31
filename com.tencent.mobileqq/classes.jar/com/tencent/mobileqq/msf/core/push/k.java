package com.tencent.mobileqq.msf.core.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class k
  extends BroadcastReceiver
{
  k(f paramf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      QLog.d("PCActivePush", 1, "onReceive action: " + paramContext);
    } while (!"com.tencent.mobileqq.broadcast.pcactiveQQ".equals(paramContext));
    paramContext = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("retryIndex", 1);
    f.a(this.a).compareAndSet(false, true);
    f.a(this.a, paramContext, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.k
 * JD-Core Version:    0.7.0.1
 */