package cooperation.qzone;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtQZonePluginException;
import com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;

class QZoneStartupMonitor$2
  extends Handler
{
  QZoneStartupMonitor$2(QZoneStartupMonitor paramQZoneStartupMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    int j = 1;
    if (i != 1) {
      return;
    }
    if (!QZoneStartupMonitor.access$100(this.this$0))
    {
      if (QzonePluginProxyActivityProxyImpl.isQzoneExist())
      {
        QLog.i("QZoneStartupMonitor", 1, "超时，但是qzone 进程存在");
        return;
      }
      QLog.e("QZoneStartupMonitor", 1, "启动超时认为启动失败，校验odex，并上报");
      paramMessage = QZoneStartupMonitor.access$200(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
      if (paramMessage != null)
      {
        i = ((Integer)paramMessage.first).intValue();
        paramMessage = (Throwable)paramMessage.second;
      }
      else
      {
        paramMessage = null;
        i = 0;
      }
      int k = LocalMultiProcConfig.getInt("key_recovery_count", 0);
      Object localObject = this.this$0;
      QZoneStartupMonitor.access$300((QZoneStartupMonitor)localObject, i, QZoneStartupMonitor.access$100((QZoneStartupMonitor)localObject), k);
      localObject = new StringBuilder("qzone进程启动失败,elf valid errorcode: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",recoveryCount:");
      ((StringBuilder)localObject).append(k);
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "exception_report_rdm", 0) != 1) {
        j = 0;
      }
      if (j != 0)
      {
        IQzoneExceptionReport localIQzoneExceptionReport = (IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start failed. ");
        localStringBuilder.append(paramMessage.getMessage());
        localIQzoneExceptionReport.doReport(new CaughtQZonePluginException(localStringBuilder.toString()), ((StringBuilder)localObject).toString());
      }
      if (i != 0) {
        ThreadManager.postImmediately(new QZoneStartupMonitor.2.1(this, k), null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.2
 * JD-Core Version:    0.7.0.1
 */