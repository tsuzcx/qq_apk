package cooperation.qzone.plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class QZoneConnectProcessor$WrappedServiceConnection
  implements ServiceConnection
{
  private Context mContext;
  private ServiceConnection mWrappedConnection;
  
  public QZoneConnectProcessor$WrappedServiceConnection(QZoneConnectProcessor paramQZoneConnectProcessor, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
  {
    this.mWrappedConnection = paramServiceConnection;
    this.mContext = paramContext;
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    do
    {
      try
      {
        this.mContext.getApplicationContext().unbindService(this);
        if (QLog.isColorLevel()) {
          QLog.i("QZonePluginManger", 2, "onServiceConnected, " + this);
        }
        this.mWrappedConnection.onServiceConnected(???, paramIBinder);
      }
      catch (Exception localException)
      {
        synchronized (QZoneConnectProcessor.access$300(this.this$0))
        {
          do
          {
            paramIBinder = (WrappedServiceConnection)QZoneConnectProcessor.access$300(this.this$0).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZonePluginManger", 2, "continue process");
            }
            QZoneConnectProcessor.access$400(this.this$0, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("QZonePluginManger", 2, "unbindService, " + this);
        }
      }
      QZoneConnectProcessor.access$502(this.this$0, false);
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "queue empty");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceDisconnected, " + this);
    }
    this.mWrappedConnection.onServiceDisconnected(paramComponentName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneConnectProcessor.WrappedServiceConnection
 * JD-Core Version:    0.7.0.1
 */