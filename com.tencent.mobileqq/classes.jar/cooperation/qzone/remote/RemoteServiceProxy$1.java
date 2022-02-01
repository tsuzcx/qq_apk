package cooperation.qzone.remote;

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
      localStringBuilder.append(RemoteServiceProxy.access$000(this.this$0));
      QLog.d("RemoteServiceProxy", 2, localStringBuilder.toString());
    }
    this.this$0.serviceHandler = IServiceHandler.Stub.asInterface(paramIBinder);
    if (RemoteServiceProxy.access$000(this.this$0) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.actionListener = RemoteServiceProxy.access$000(this.this$0);
      this.this$0.sendMsg(paramComponentName);
    }
    this.this$0.onBaseServiceConnected();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onServiceDisconnected ");
      localStringBuilder.append(paramComponentName);
      localStringBuilder.append(",mActionListener:");
      localStringBuilder.append(RemoteServiceProxy.access$000(this.this$0));
      QLog.d("RemoteServiceProxy", 2, localStringBuilder.toString());
    }
    this.this$0.serviceHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.RemoteServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */