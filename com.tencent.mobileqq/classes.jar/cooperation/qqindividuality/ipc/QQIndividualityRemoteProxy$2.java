package cooperation.qqindividuality.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class QQIndividualityRemoteProxy$2
  implements ServiceConnection
{
  QQIndividualityRemoteProxy$2(QQIndividualityRemoteProxy paramQQIndividualityRemoteProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_CooperationQqindividualityIpcIQQIndividualityRemoteProxyInterface = IQQIndividualityRemoteProxyInterface.Stub.a(paramIBinder);
    if (this.a.jdField_a_of_type_CooperationQqindividualityIpcIQQIndividualityRemoteProxyInterface != null)
    {
      paramComponentName = new QQIndividualityRemoteProxy.2.1(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = this.a;
    paramComponentName.jdField_a_of_type_CooperationQqindividualityIpcIQQIndividualityRemoteProxyInterface = null;
    paramComponentName.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2
 * JD-Core Version:    0.7.0.1
 */