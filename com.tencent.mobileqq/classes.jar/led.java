import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class led
  implements ServiceConnection
{
  led(lec paramlec) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(lec.a(), 2, "AVServiceForQQ onServiceConnected");
    }
    this.a.a = lwm.a(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d(lec.a(), 2, "AVServiceForQQ onServiceDisconnected");
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     led
 * JD-Core Version:    0.7.0.1
 */