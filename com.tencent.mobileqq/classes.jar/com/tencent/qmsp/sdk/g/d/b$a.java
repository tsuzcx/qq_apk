package com.tencent.qmsp.sdk.g.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;

class b$a
  implements ServiceConnection
{
  c a;
  
  b$a(b paramb1, b paramb2, c paramc)
  {
    this.a = paramc;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      b.a(this.b, a.a.a(paramIBinder));
      new d(b.a(this.b), this.a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
    finally {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    b.a(this.b, null);
    b.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.b.a
 * JD-Core Version:    0.7.0.1
 */