import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class ldg
  implements ServiceConnection
{
  ldg(ldf paramldf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ldf.a(), 2, "AVServiceForQQ onServiceConnected");
    }
    this.a.a = lwt.a(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ldf.a(), 2, "AVServiceForQQ onServiceDisconnected");
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldg
 * JD-Core Version:    0.7.0.1
 */