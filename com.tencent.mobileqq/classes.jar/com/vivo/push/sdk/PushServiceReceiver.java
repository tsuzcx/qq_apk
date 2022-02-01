package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.o;

public class PushServiceReceiver
  extends BroadcastReceiver
{
  private static HandlerThread a;
  private static Handler b;
  private static PushServiceReceiver.a c = new PushServiceReceiver.a();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = ContextDelegate.getContext(paramContext);
    paramIntent = paramIntent.getAction();
    if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent)) || ("android.intent.action.ACTION_POWER_CONNECTED".equals(paramIntent)) || ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(paramIntent)))
    {
      if (a == null)
      {
        localObject = new HandlerThread("PushServiceReceiver");
        a = (HandlerThread)localObject;
        ((HandlerThread)localObject).start();
        b = new Handler(a.getLooper());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append(": start PushSerevice for by ");
      ((StringBuilder)localObject).append(paramIntent);
      ((StringBuilder)localObject).append("  ; handler : ");
      ((StringBuilder)localObject).append(b);
      o.d("PushServiceReceiver", ((StringBuilder)localObject).toString());
      PushServiceReceiver.a.a(c, paramContext, paramIntent);
      b.removeCallbacks(c);
      b.postDelayed(c, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.PushServiceReceiver
 * JD-Core Version:    0.7.0.1
 */