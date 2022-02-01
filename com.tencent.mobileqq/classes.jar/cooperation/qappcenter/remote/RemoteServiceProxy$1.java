package cooperation.qappcenter.remote;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class RemoteServiceProxy$1
  implements ServiceConnection
{
  RemoteServiceProxy$1(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + paramComponentName + ",mActionListener:" + RemoteServiceProxy.a(this.a));
    }
    this.a.a = IServiceHandler.Stub.a(paramIBinder);
    if (RemoteServiceProxy.a(this.a) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.a = RemoteServiceProxy.a(this.a);
      this.a.b(paramComponentName);
    }
    this.a.a();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName + ",mActionListener:" + RemoteServiceProxy.a(this.a));
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */