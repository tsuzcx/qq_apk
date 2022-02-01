package cooperation.qlink;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QlinkServiceProxy$1
  implements ServiceConnection
{
  QlinkServiceProxy$1(QlinkServiceProxy paramQlinkServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceConnected service:");
    localStringBuilder.append(paramComponentName);
    QLog.d("QlinkServiceProxy", 1, localStringBuilder.toString());
    QlinkServiceProxy.a(this.a, IQlinkService.Stub.a(paramIBinder));
    QlinkServiceProxy.a(this.a, false);
    QlinkServiceProxy.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceDisconnected ");
    localStringBuilder.append(paramComponentName);
    QLog.d("QlinkServiceProxy", 1, localStringBuilder.toString());
    try
    {
      QlinkServiceProxy.a(this.a).getApplication().unbindService(QlinkServiceProxy.a(this.a));
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
    QlinkServiceProxy.a(this.a, null);
    QlinkServiceProxy.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */