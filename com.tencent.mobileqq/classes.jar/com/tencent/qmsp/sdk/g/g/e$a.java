package com.tencent.qmsp.sdk.g.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class e$a
  implements ServiceConnection
{
  e$a(e parame) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    this.a.a = d.a.a(paramIBinder);
    synchronized (this.a.d)
    {
      this.a.d.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.e.a
 * JD-Core Version:    0.7.0.1
 */