package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class e
  extends BroadcastReceiver
{
  e(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    d.b(this.a).post(new f(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.e
 * JD-Core Version:    0.7.0.1
 */