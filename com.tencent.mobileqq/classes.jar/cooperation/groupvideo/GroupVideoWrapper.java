package cooperation.groupvideo;

import alvh;
import android.os.RemoteException;
import com.tencent.av.gvideo.IGVServiceForQQ;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class GroupVideoWrapper
{
  alvh jdField_a_of_type_Alvh = new alvh(this);
  public IGVServiceForQQ a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public GroupVideoWrapper.OnGVideoReadyListener a;
  
  public GroupVideoWrapper(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ = null;
    this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public void a()
  {
    GroupVideoHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Alvh);
    this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ = null;
    this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener = null;
  }
  
  public void a(GroupVideoWrapper.OnGVideoReadyListener paramOnGVideoReadyListener)
  {
    this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener = paramOnGVideoReadyListener;
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      GroupVideoHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, GVideoProxyService.class, this.jdField_a_of_type_Alvh, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GroupVideoWrapper
 * JD-Core Version:    0.7.0.1
 */