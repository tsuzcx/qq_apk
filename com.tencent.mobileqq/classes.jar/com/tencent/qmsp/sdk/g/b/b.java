package com.tencent.qmsp.sdk.g.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
  implements ServiceConnection
{
  public boolean a = false;
  public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append("onServiceConnected ");
      paramComponentName.append(System.currentTimeMillis());
      Log.d("PPSSerivceConnection", paramComponentName.toString());
      this.b.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName)
    {
      label42:
      break label42;
    }
    paramComponentName = new StringBuilder();
    paramComponentName.append("onServiceConnected InterruptedException ");
    paramComponentName.append(System.currentTimeMillis());
    Log.w("PPSSerivceConnection", paramComponentName.toString());
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = new StringBuilder();
    paramComponentName.append("onServiceDisconnected ");
    paramComponentName.append(System.currentTimeMillis());
    Log.d("PPSSerivceConnection", paramComponentName.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.b
 * JD-Core Version:    0.7.0.1
 */