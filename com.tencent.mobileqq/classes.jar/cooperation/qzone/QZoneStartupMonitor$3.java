package cooperation.qzone;

import android.os.FileObserver;
import android.os.Handler;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class QZoneStartupMonitor$3
  extends FileObserver
{
  QZoneStartupMonitor$3(QZoneStartupMonitor paramQZoneStartupMonitor, String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (!"qzone_startup_monitor".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneStartupMonitor", 2, "path:" + paramString + ",非监控文件：" + "qzone_startup_monitor");
      }
      return;
    }
    switch (paramInt & 0xFFF)
    {
    default: 
      return;
    case 256: 
      paramInt = QzoneConfig.getInstance().getConfig("QZoneSetting", "startupFailTimeout", 60000);
      QZoneStartupMonitor.access$102(this.this$0, false);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneStartupMonitor", 2, "如果" + paramInt + "ms 后，未收到启动成功的消息，则认为启动失败");
      }
      QZoneStartupMonitor.access$600(this.this$0).sendEmptyMessageDelayed(1, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneStartupMonitor", 2, "启动成功，清理超时，并校验odex和上报");
    }
    QZoneStartupMonitor.access$600(this.this$0).removeMessages(1);
    paramString = QZoneStartupMonitor.access$200(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
    if (paramString != null) {}
    for (paramInt = ((Integer)paramString.first).intValue();; paramInt = 0)
    {
      QZoneStartupMonitor.access$102(this.this$0, true);
      QZoneStartupMonitor.access$300(this.this$0, paramInt, QZoneStartupMonitor.access$100(this.this$0), LocalMultiProcConfig.getInt("key_recovery_count", 0));
      LocalMultiProcConfig.putInt("key_recovery_count", 0);
      return;
    }
  }
  
  public void startWatching()
  {
    super.startWatching();
    QLog.i("QZoneStartupMonitor", 1, "startWatching");
  }
  
  public void stopWatching()
  {
    super.stopWatching();
    QLog.i("QZoneStartupMonitor", 1, "stopWatching");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.3
 * JD-Core Version:    0.7.0.1
 */