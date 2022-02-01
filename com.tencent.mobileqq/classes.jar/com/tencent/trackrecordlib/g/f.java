package com.tencent.trackrecordlib.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public class f
{
  private static final String a = f.class.getSimpleName();
  private static BroadcastReceiver b;
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    b = new f.a(null);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramContext.registerReceiver(b, localIntentFilter);
  }
  
  public static void b(Context paramContext)
  {
    if ((paramContext != null) && (b != null)) {
      paramContext.unregisterReceiver(b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.f
 * JD-Core Version:    0.7.0.1
 */