package cooperation.groupvideo.api.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.gvideo.IGVServiceForQQ.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

class GroupVideoWrapperImpl$QavServiceConnection
  implements ServiceConnection
{
  GroupVideoWrapperImpl$QavServiceConnection(GroupVideoWrapperImpl paramGroupVideoWrapperImpl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "Qav Service connected!");
    }
    this.a.mGvProxy = IGVServiceForQQ.Stub.a(paramIBinder);
    if ((this.a.mGvProxy != null) && (this.a.mOnReadyListener != null))
    {
      this.a.mOnReadyListener.a(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null or mOnReadyListener == null");
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "Qav Service disconnected!");
    }
    this.a.mGvProxy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.api.impl.GroupVideoWrapperImpl.QavServiceConnection
 * JD-Core Version:    0.7.0.1
 */