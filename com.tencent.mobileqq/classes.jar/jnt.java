import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jnt
  implements ServiceConnection
{
  public jnt(QQServiceForAV paramQQServiceForAV) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn onServiceConnected name=" + paramComponentName + ", service=" + paramIBinder);
    QQServiceForAV.a(this.a, true);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn onServiceDisconnected name=" + paramComponentName);
    QQServiceForAV.a(this.a, false);
    try
    {
      BaseApplicationImpl.getContext().unbindService(this);
      return;
    }
    catch (Throwable paramComponentName)
    {
      QLog.e("QQServiceForAV", 1, "onServiceDisconnected unbindService exception:" + paramComponentName, paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jnt
 * JD-Core Version:    0.7.0.1
 */