import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.AVLog;
import com.tencent.av.app.QQServiceProxy;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoNotifyCenter;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.qphone.base.util.QLog;

public class jfm
  implements ServiceConnection
{
  public jfm(QQServiceProxy paramQQServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.w("QQServiceProxy", 1, "QQServiceForAV onServiceConnected, name[" + paramComponentName + "]");
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = IQQServiceForAV.Stub.a(paramIBinder);
    try
    {
      this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub, "video_process_cookie");
      if (this.a.b) {
        this.a.e();
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10) });
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        try
        {
          this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.asBinder().linkToDeath(new jfn(this), 0);
          return;
        }
        catch (Exception paramComponentName)
        {
          AVLog.e("QQServiceProxy", "QQServiceForAV onServiceConnected Exception msg = " + paramComponentName.getMessage());
        }
        paramComponentName = paramComponentName;
        AVLog.e("QQServiceProxy", "QQServiceForAV onServiceConnected Exception msg = " + paramComponentName.getMessage());
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected");
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(11) });
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().deleteObservers();
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        QLog.e("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected RemoteException", paramComponentName);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfm
 * JD-Core Version:    0.7.0.1
 */