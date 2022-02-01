package cooperation.groupvideo.api.impl;

import android.os.RemoteException;
import com.tencent.av.gvideo.IGVServiceForQQ;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoProxyService;
import cooperation.groupvideo.GroupVideoHelper;
import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

public class GroupVideoWrapperImpl
  implements IGroupVideoWrapper
{
  public static final String TAG = "GroupVideoRemoteManager";
  AppInterface mApp;
  IGVServiceForQQ mGvProxy = null;
  IGroupVideoWrapper.OnGVideoReadyListener mOnReadyListener = null;
  GroupVideoWrapperImpl.QavServiceConnection mSerConn = new GroupVideoWrapperImpl.QavServiceConnection(this);
  
  public IGVServiceForQQ getProxy()
  {
    return this.mGvProxy;
  }
  
  public int getPstnUserNumberInMAV(long paramLong, int paramInt)
  {
    IGVServiceForQQ localIGVServiceForQQ = this.mGvProxy;
    if (localIGVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
      return 0;
    }
    try
    {
      paramInt = localIGVServiceForQQ.a(paramLong, paramInt);
      return paramInt;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
      }
    }
    return 0;
  }
  
  public void init(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public void initialize(IGroupVideoWrapper.OnGVideoReadyListener paramOnGVideoReadyListener)
  {
    this.mOnReadyListener = paramOnGVideoReadyListener;
    if (this.mGvProxy == null) {
      GroupVideoHelper.a(this.mApp, GVideoProxyService.class, this.mSerConn, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void onUpdateTroopList()
  {
    IGVServiceForQQ localIGVServiceForQQ = this.mGvProxy;
    if (localIGVServiceForQQ != null) {
      try
      {
        localIGVServiceForQQ.a();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  public void processS2C(byte[] paramArrayOfByte)
  {
    IGVServiceForQQ localIGVServiceForQQ = this.mGvProxy;
    if (localIGVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
      return;
    }
    try
    {
      localIGVServiceForQQ.a(paramArrayOfByte);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
      }
    }
  }
  
  public void uninitialize()
  {
    GroupVideoHelper.a(this.mApp, this.mSerConn);
    this.mGvProxy = null;
    this.mOnReadyListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.api.impl.GroupVideoWrapperImpl
 * JD-Core Version:    0.7.0.1
 */