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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onServiceConnected service:");
      localStringBuilder.append(paramComponentName);
      localStringBuilder.append(",mActionListener:");
      localStringBuilder.append(RemoteServiceProxy.a(this.a));
      QLog.d("RemoteServiceProxy", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onServiceDisconnected ");
      localStringBuilder.append(paramComponentName);
      localStringBuilder.append(",mActionListener:");
      localStringBuilder.append(RemoteServiceProxy.a(this.a));
      QLog.d("RemoteServiceProxy", 2, localStringBuilder.toString());
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */