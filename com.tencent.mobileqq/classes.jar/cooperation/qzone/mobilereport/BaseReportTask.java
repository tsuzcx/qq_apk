package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseReportTask
{
  private static final String TAG = "BaseReportTask";
  private final AtomicBoolean mIsTaskWait = new AtomicBoolean(false);
  private final HashMap<ReportKey, ArrayList<ItemInfo>> mReportMap = new HashMap();
  
  abstract void doMobileReport(HashMap<ReportKey, ArrayList<ItemInfo>> paramHashMap);
  
  protected void reportByKey(ReportKey paramReportKey, ItemInfo paramItemInfo)
  {
    do
    {
      synchronized (this.mReportMap)
      {
        ArrayList localArrayList2 = (ArrayList)this.mReportMap.get(paramReportKey);
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null) {
          localArrayList1 = new ArrayList();
        }
        localArrayList1.add(paramItemInfo);
        this.mReportMap.put(paramReportKey, localArrayList1);
        if (this.mIsTaskWait.compareAndSet(false, true))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("BaseReportTask", 4, "start report!!!");
          }
          ThreadManager.post(new BaseReportTask.1(this), 2, null, true);
          return;
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("BaseReportTask", 4, "wait to report...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.mobilereport.BaseReportTask
 * JD-Core Version:    0.7.0.1
 */