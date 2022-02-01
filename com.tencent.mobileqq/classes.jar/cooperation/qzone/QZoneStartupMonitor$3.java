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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("path:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",非监控文件：");
        localStringBuilder.append("qzone_startup_monitor");
        QLog.w("QZoneStartupMonitor", 2, localStringBuilder.toString());
      }
      return;
    }
    paramInt &= 0xFFF;
    if (paramInt != 256)
    {
      if (paramInt != 512) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneStartupMonitor", 2, "启动成功，清理超时，并校验odex和上报");
      }
      QZoneStartupMonitor.access$600(this.this$0).removeMessages(1);
      paramString = QZoneStartupMonitor.access$200(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
      if (paramString != null) {
        paramInt = ((Integer)paramString.first).intValue();
      } else {
        paramInt = 0;
      }
      QZoneStartupMonitor.access$102(this.this$0, true);
      paramString = this.this$0;
      QZoneStartupMonitor.access$300(paramString, paramInt, QZoneStartupMonitor.access$100(paramString), LocalMultiProcConfig.getInt("key_recovery_count", 0));
      LocalMultiProcConfig.putInt("key_recovery_count", 0);
      return;
    }
    paramInt = QzoneConfig.getInstance().getConfig("QZoneSetting", "startupFailTimeout", 60000);
    QZoneStartupMonitor.access$102(this.this$0, false);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("如果");
      paramString.append(paramInt);
      paramString.append("ms 后，未收到启动成功的消息，则认为启动失败");
      QLog.d("QZoneStartupMonitor", 2, paramString.toString());
    }
    QZoneStartupMonitor.access$600(this.this$0).sendEmptyMessageDelayed(1, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.3
 * JD-Core Version:    0.7.0.1
 */