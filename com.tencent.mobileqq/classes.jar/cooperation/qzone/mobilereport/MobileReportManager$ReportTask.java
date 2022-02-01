package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import bcvn;
import bmoq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

class MobileReportManager$ReportTask
{
  private final AtomicBoolean mIsTaskWait = new AtomicBoolean(false);
  private final HashMap<MobileReportManager.ReportKey, ArrayList<ItemInfo>> mReportMap = new HashMap();
  
  protected void doMobileReport(HashMap<MobileReportManager.ReportKey, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      MobileReportManager.UserActionReportBuilder localUserActionReportBuilder = new MobileReportManager.UserActionReportBuilder(null);
      localUserActionReportBuilder.setReportKey((MobileReportManager.ReportKey)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localUserActionReportBuilder.addItemInfo((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localUserActionReportBuilder.build());
    }
    bcvn.a(localAppRuntime, new MobileReportManager.UserCommReportBuilder(null).setUin(localAppRuntime.getLongAccountUin()).setNetwork_type(bmoq.c()).build(), localArrayList);
  }
  
  protected void reportByKey(MobileReportManager.ReportKey paramReportKey, ItemInfo paramItemInfo)
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
            QLog.d("MobileReport.Manager", 4, "start report!!!");
          }
          ThreadManager.post(new MobileReportManager.ReportTask.1(this), 2, null, true);
          return;
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MobileReport.Manager", 4, "wait to report...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.ReportTask
 * JD-Core Version:    0.7.0.1
 */