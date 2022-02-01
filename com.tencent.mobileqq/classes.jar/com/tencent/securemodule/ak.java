package com.tencent.securemodule;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.securemodule.service.IControlService;
import com.tencent.securemodule.ui.TransparentActivity;

public class ak
  implements ServiceConnection
{
  public ak(TransparentActivity paramTransparentActivity) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    TransparentActivity.a(this.a, (IControlService)paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    TransparentActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.ak
 * JD-Core Version:    0.7.0.1
 */