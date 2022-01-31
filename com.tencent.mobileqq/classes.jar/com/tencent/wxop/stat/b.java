package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.wxop.stat.common.e;

class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (a.a(this.a) != null) {
      a.a(this.a).a(new c(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.b
 * JD-Core Version:    0.7.0.1
 */