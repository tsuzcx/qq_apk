import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.app.AVServiceProxy;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.qphone.base.util.QLog;

public class jeb
  implements ServiceConnection
{
  public jeb(AVServiceProxy paramAVServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AVServiceProxy.a(), 2, "AVServiceForQQ onServiceConnected");
    }
    this.a.a = IAVServiceForQQ.Stub.a(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AVServiceProxy.a(), 2, "AVServiceForQQ onServiceDisconnected");
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jeb
 * JD-Core Version:    0.7.0.1
 */