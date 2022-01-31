import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class lxs
  implements ServiceConnection
{
  lxs(lxq paramlxq) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_Lwl = lwm.a(paramIBinder);
    if ((this.a.jdField_a_of_type_Lwl != null) && (this.a.jdField_a_of_type_Lxr != null)) {
      this.a.jdField_a_of_type_Lxr.a(this.a);
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
    this.a.jdField_a_of_type_Lwl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lxs
 * JD-Core Version:    0.7.0.1
 */