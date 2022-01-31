package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class PluginRemoteProcessor$WrappedServiceConnection
  implements ServiceConnection
{
  private int mBinderType;
  private Context mContext;
  private ServiceConnection mWrappedConnection;
  
  public PluginRemoteProcessor$WrappedServiceConnection(PluginRemoteProcessor paramPluginRemoteProcessor, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
  {
    this.mWrappedConnection = paramServiceConnection;
    this.mContext = paramContext;
    this.mBinderType = paramInt;
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    do
    {
      try
      {
        this.mContext.getApplicationContext().unbindService(this);
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "onServiceConnected, " + this);
        }
        this.mWrappedConnection.onServiceConnected(???, paramIBinder);
      }
      catch (Exception localException)
      {
        synchronized (PluginRemoteProcessor.access$400(this.this$0))
        {
          do
          {
            paramIBinder = (WrappedServiceConnection)PluginRemoteProcessor.access$400(this.this$0).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("plugin_tag", 2, "continue process");
            }
            PluginRemoteProcessor.access$500(this.this$0, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("plugin_tag", 2, "unbindService, " + this);
        }
      }
      PluginRemoteProcessor.access$602(this.this$0, false);
    } while (!QLog.isColorLevel());
    QLog.i("plugin_tag", 2, "queue empty");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected, " + this);
    }
    this.mWrappedConnection.onServiceDisconnected(paramComponentName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor.WrappedServiceConnection
 * JD-Core Version:    0.7.0.1
 */