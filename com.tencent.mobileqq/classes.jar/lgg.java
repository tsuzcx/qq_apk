import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class lgg
  implements ServiceConnection
{
  lgg(lgf paramlgf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(lgf.a(), 2, "AVServiceForQQ onServiceConnected");
    }
    this.a.a = lzb.a(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d(lgf.a(), 2, "AVServiceForQQ onServiceDisconnected");
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lgg
 * JD-Core Version:    0.7.0.1
 */