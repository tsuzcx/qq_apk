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
    this.a.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = IQfavRemoteProxyInterface.Stub.a(paramIBinder);
    if (this.a.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null)
    {
      paramComponentName = new QfavRemoteProxyForQQ.2.1(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = null;
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2
 * JD-Core Version:    0.7.0.1
 */