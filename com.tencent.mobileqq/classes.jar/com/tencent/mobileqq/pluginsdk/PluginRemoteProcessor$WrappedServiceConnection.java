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
    try
    {
      this.mContext.getApplicationContext().unbindService(this);
    }
    catch (Exception localException)
    {
      label14:
      StringBuilder localStringBuilder;
      break label14;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unbindService, ");
      localStringBuilder.append(this);
      QLog.i("plugin_tag", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceConnected, ");
      localStringBuilder.append(this);
      QLog.i("plugin_tag", 2, localStringBuilder.toString());
    }
    this.mWrappedConnection.onServiceConnected(???, paramIBinder);
    synchronized (PluginRemoteProcessor.access$400(this.this$0))
    {
      paramIBinder = (WrappedServiceConnection)PluginRemoteProcessor.access$400(this.this$0).poll();
      if (paramIBinder != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("plugin_tag", 2, "continue process");
        }
        PluginRemoteProcessor.access$500(this.this$0, paramIBinder, 300);
        return;
      }
      PluginRemoteProcessor.access$602(this.this$0, false);
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "queue empty");
      }
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceDisconnected, ");
      localStringBuilder.append(this);
      QLog.i("plugin_tag", 2, localStringBuilder.toString());
    }
    this.mWrappedConnection.onServiceDisconnected(paramComponentName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor.WrappedServiceConnection
 * JD-Core Version:    0.7.0.1
 */