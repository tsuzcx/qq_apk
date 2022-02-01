package cooperation.qzone.report;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.statistic.Singleton;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class QzoneReportManager
{
  public static final int BEACON = 2;
  public static final String DEFAULTVALUE = "";
  public static final int HABO = 3;
  public static final int LP = 0;
  public static final int MAX_RUNNING_TASK = 3;
  public static final int MTA = 1;
  public static final int QBOSS = 5;
  public static final String SECONDARY_KEY_REPORT = "report_plog";
  public static final int TTT = 4;
  public static String config;
  public static boolean isConfigInitialize;
  private static final Singleton<QzoneReportManager, Void> sSingleton = new QzoneReportManager.1();
  volatile int mRunningTaskNum = 0;
  ConcurrentLinkedQueue<QzoneReportManager.ProcessRunner> processRunners = new ConcurrentLinkedQueue();
  
  private void addProcessTask(QzoneReportManager.ProcessRunner paramProcessRunner)
  {
    this.processRunners.offer(paramProcessRunner);
    runNext();
  }
  
  public static QzoneReportManager getInstance()
  {
    return (QzoneReportManager)sSingleton.get(null);
  }
  
  static boolean isConfigInitialize()
  {
    return isConfigInitialize;
  }
  
  static boolean isNeedPLog(int paramInt)
  {
    return false;
  }
  
  static boolean isNeedSaveData(int paramInt)
  {
    return false;
  }
  
  private void runNext()
  {
    if (this.mRunningTaskNum < 3)
    {
      QzoneReportManager.ProcessRunner localProcessRunner = (QzoneReportManager.ProcessRunner)this.processRunners.poll();
      if (localProcessRunner != null)
      {
        this.mRunningTaskNum += 1;
        ThreadManager.excute(localProcessRunner, 32, null, true);
      }
    }
  }
  
  public void Beacon_report(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false);
  }
  
  public void Beacon_report(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
  
  public void Beacon_report(String paramString, HashMap<String, String> paramHashMap)
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount()))) {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, true, 0L, 0L, paramHashMap, null, true);
    }
  }
  
  public void Habo_report(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((!isConfigInitialize()) || (isNeedPLog(3)) || (isNeedSaveData(3)))
    {
      QzoneReportManager.DataBuilder localDataBuilder = QzoneReportManager.DataBuilder.obtain();
      localDataBuilder.append("commandId", paramString1);
      localDataBuilder.append("resultCode", paramInt1);
      localDataBuilder.append("detail", paramString2);
      localDataBuilder.append("frequency", paramInt2);
      prepare(3, localDataBuilder.toString());
      localDataBuilder.recycle();
    }
    AccManager.createStatistic(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void post(int paramInt, String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      addProcessTask(new QzoneReportManager.ProcessRunner(this, paramInt, paramString));
      return;
    }
    prepare(paramInt, paramString);
  }
  
  public void prepare(int paramInt, String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QzoneReportManager.2(this, paramInt));
  }
  
  public void printLog() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager
 * JD-Core Version:    0.7.0.1
 */