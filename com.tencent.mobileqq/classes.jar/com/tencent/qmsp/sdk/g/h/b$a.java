package com.tencent.qmsp.sdk.g.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qmsp.sdk.base.c;

class b$a
  implements ServiceConnection
{
  b$a(b paramb) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.d = a.a.a(paramIBinder);
      if (this.a.a != null) {
        this.a.a.a(this.a);
      }
      paramComponentName = new StringBuilder();
      paramComponentName.append(b.f);
      paramComponentName.append(" Service onServiceConnected");
      c.c(paramComponentName.toString());
      return;
    }
    finally {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.d = null;
    paramComponentName = new StringBuilder();
    paramComponentName.append(b.f);
    paramComponentName.append(" Service onServiceDisconnected");
    c.c(paramComponentName.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.h.b.a
 * JD-Core Version:    0.7.0.1
 */