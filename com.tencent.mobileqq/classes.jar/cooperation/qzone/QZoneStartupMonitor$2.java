package cooperation.qzone;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.CaughtQZonePluginException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZoneExceptionReport;

class QZoneStartupMonitor$2
  extends Handler
{
  QZoneStartupMonitor$2(QZoneStartupMonitor paramQZoneStartupMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 1;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      break;
    }
    do
    {
      return;
    } while (QZoneStartupMonitor.access$100(this.this$0));
    if (QzonePluginProxyActivity.isQzoneExist())
    {
      QLog.i("QZoneStartupMonitor", 1, "超时，但是qzone 进程存在");
      return;
    }
    QLog.e("QZoneStartupMonitor", 1, "启动超时认为启动失败，校验odex，并上报");
    paramMessage = QZoneStartupMonitor.access$200(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
    int i;
    if (paramMessage != null)
    {
      i = ((Integer)paramMessage.first).intValue();
      paramMessage = (Throwable)paramMessage.second;
    }
    for (;;)
    {
      int k = LocalMultiProcConfig.getInt("key_recovery_count", 0);
      QZoneStartupMonitor.access$300(this.this$0, i, QZoneStartupMonitor.access$100(this.this$0), k);
      StringBuilder localStringBuilder = new StringBuilder("qzone进程启动失败,elf valid errorcode: ").append(i).append(",recoveryCount:").append(k);
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "exception_report_rdm", 0) == 1) {}
      for (;;)
      {
        if (j != 0) {
          QZoneExceptionReport.doReport(new CaughtQZonePluginException("start failed. " + paramMessage.getMessage()), localStringBuilder.toString());
        }
        if (i == 0) {
          break;
        }
        ThreadManager.postImmediately(new QZoneStartupMonitor.2.1(this, k), null, false);
        return;
        j = 0;
      }
      paramMessage = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.2
 * JD-Core Version:    0.7.0.1
 */