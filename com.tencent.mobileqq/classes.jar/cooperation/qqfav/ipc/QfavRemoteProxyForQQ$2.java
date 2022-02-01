package cooperation.qqfav.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class QfavRemoteProxyForQQ$2
  implements ServiceConnection
{
  QfavRemoteProxyForQQ$2(QfavRemoteProxyForQQ paramQfavRemoteProxyForQQ) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.d = IQfavRemoteProxyInterface.Stub.a(paramIBinder);
    if (this.a.d != null)
    {
      paramComponentName = new QfavRemoteProxyForQQ.2.1(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = this.a;
    paramComponentName.d = null;
    paramComponentName.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2
 * JD-Core Version:    0.7.0.1
 */