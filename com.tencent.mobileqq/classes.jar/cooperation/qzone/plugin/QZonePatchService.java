package cooperation.qzone.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import bhkj;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QZonePatchService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "QZonePatchService onBind");
    }
    return bhkj.a().a();
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "QZonePatchService onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "QZonePatchService onDestroy");
    }
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "QZonePatchService onRebind");
    }
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "QZonePatchService onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePatchService
 * JD-Core Version:    0.7.0.1
 */