import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.qphone.base.util.QLog;

public class joe
  implements ServiceConnection
{
  public joe(QavWrapper paramQavWrapper) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = IAVServiceForQQ.Stub.a(paramIBinder);
    if ((this.a.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) && (this.a.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener != null)) {
      this.a.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener.a(this.a);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QavWrapper", 2, "mQavProxy == null or mOnReadyListener == null");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service disconnected!");
    }
    this.a.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joe
 * JD-Core Version:    0.7.0.1
 */