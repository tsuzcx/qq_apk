import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class lyb
  implements ServiceConnection
{
  lyb(lxz paramlxz) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_Lwu = lwv.a(paramIBinder);
    if ((this.a.jdField_a_of_type_Lwu != null) && (this.a.jdField_a_of_type_Lya != null)) {
      this.a.jdField_a_of_type_Lya.a(this.a);
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
    this.a.jdField_a_of_type_Lwu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyb
 * JD-Core Version:    0.7.0.1
 */