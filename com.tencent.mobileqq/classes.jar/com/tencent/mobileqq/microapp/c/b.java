package com.tencent.mobileqq.microapp.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bdnn;

final class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (bdnn.a(paramIntent.getAction())) {}
    while (a.a(this.a) == null) {
      return;
    }
    a.a(this.a).a(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.c.b
 * JD-Core Version:    0.7.0.1
 */