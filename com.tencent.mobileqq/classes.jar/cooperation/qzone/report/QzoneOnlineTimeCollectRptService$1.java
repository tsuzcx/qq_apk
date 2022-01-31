package cooperation.qzone.report;

import axmv;
import bhli;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QzoneOnlineTimeCollectRptService$1
  implements Runnable
{
  public QzoneOnlineTimeCollectRptService$1(bhli parambhli) {}
  
  public void run()
  {
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "beginTrace isForeground:" + bhli.a(this.this$0));
    if (!bhli.a(this.this$0)) {}
    try
    {
      this.this$0.a = Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      bhli.a(this.this$0, QzoneConfig.getInstance().getConfig("ClientReport", "OnlineLocalSaveFrequency", 10000));
      this.this$0.b();
      if (!axmv.c())
      {
        bhli.a(this.this$0);
        bhli.a(this.this$0, true);
        LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", true);
        if (bhli.a(this.this$0) != 0) {
          ThreadManager.getSubThreadHandler().post(bhli.a(this.this$0));
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneOnlineTimeCollectRptService", 2, "beginTrace:" + localException.toString());
        continue;
        QLog.w("QzoneOnlineTimeCollectRptService", 1, "qzone is SimpleUI not to get updateTime");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService.1
 * JD-Core Version:    0.7.0.1
 */