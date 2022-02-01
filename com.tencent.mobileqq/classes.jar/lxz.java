import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class lxz
  implements ServiceConnection
{
  lxz(lxx paramlxx) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_Lws = lwt.a(paramIBinder);
    if ((this.a.jdField_a_of_type_Lws != null) && (this.a.jdField_a_of_type_Lxy != null)) {
      this.a.jdField_a_of_type_Lxy.a(this.a);
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
    this.a.jdField_a_of_type_Lws = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxz
 * JD-Core Version:    0.7.0.1
 */