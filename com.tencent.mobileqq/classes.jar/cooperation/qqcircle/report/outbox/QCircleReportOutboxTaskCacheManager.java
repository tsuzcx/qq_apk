package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.DbCacheManager;
import com.tencent.mobileqq.qcircle.api.db.DbCacheService;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleReportOutboxTaskCacheManager
{
  private static final String TAG = "QCircleReportOutboxTaskCacheManager";
  private String mCacheName = "sender_queue";
  private final QCircleReportOutboxTaskCacheManager.CacheHolder mSenderQueueCache = new QCircleReportOutboxTaskCacheManager.CacheHolder();
  private final String whereClause = "cache_key";
  
  public QCircleReportOutboxTaskCacheManager()
  {
    this("sender_queue");
  }
  
  public QCircleReportOutboxTaskCacheManager(String paramString)
  {
    this.mCacheName = paramString;
  }
  
  private void ensureCacheHolder(QCircleReportOutboxTaskCacheManager.CacheHolder paramCacheHolder)
  {
    if (paramCacheHolder == null) {}
    long l;
    do
    {
      return;
      l = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    } while ((l == paramCacheHolder.uin) && (paramCacheHolder.cache != null) && (!paramCacheHolder.cache.isClosed()));
    paramCacheHolder.uin = l;
    paramCacheHolder.cache = DbCacheService.getInstance().getCacheManager(QCircleReportOutboxTaskCacheData.class, l, this.mCacheName);
  }
  
  public void release()
  {
    this.mSenderQueueCache.cache.close();
    this.mSenderQueueCache.cache = null;
  }
  
  public void removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    RFLog.i("QCircleReportOutboxTaskCacheManager", RFLog.USR, "removeTask id:" + paramQCircleReportOutboxTask.getTaskId());
    ensureCacheHolder(this.mSenderQueueCache);
    this.mSenderQueueCache.cache.deleteData("cache_key=?", new String[] { paramQCircleReportOutboxTask.getCacheKey() });
  }
  
  public ArrayList<QCircleReportOutboxTask> restoreTasks()
  {
    ensureCacheHolder(this.mSenderQueueCache);
    ArrayList localArrayList1 = this.mSenderQueueCache.cache.queryData();
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1.size() > 0)
    {
      int i = 0;
      if (i < localArrayList1.size())
      {
        QCircleReportOutboxTaskCacheData localQCircleReportOutboxTaskCacheData = (QCircleReportOutboxTaskCacheData)localArrayList1.get(i);
        QCircleReportOutboxTask localQCircleReportOutboxTask;
        if ((localQCircleReportOutboxTaskCacheData != null) && (localQCircleReportOutboxTaskCacheData.getQueueTask() != null))
        {
          localQCircleReportOutboxTask = localQCircleReportOutboxTaskCacheData.getQueueTask();
          if (localQCircleReportOutboxTask.isNullTask()) {
            break label114;
          }
          localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskCacheManager", "restoreTask");
          localQCircleReportOutboxTask.setState(2);
          localArrayList2.add(localQCircleReportOutboxTaskCacheData.getQueueTask());
        }
        for (;;)
        {
          i += 1;
          break;
          label114:
          removeTask(localQCircleReportOutboxTask);
          RFLog.w("QCircleReportOutboxTaskCacheManager", RFLog.USR, "remove null task, id:" + localQCircleReportOutboxTask.getTaskId());
        }
      }
    }
    return localArrayList2;
  }
  
  public void saveTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (!paramQCircleReportOutboxTask.isNullTask())
    {
      RFLog.i("QCircleReportOutboxTaskCacheManager", RFLog.USR, "saveTask id:" + paramQCircleReportOutboxTask.getTaskId());
      ensureCacheHolder(this.mSenderQueueCache);
      this.mSenderQueueCache.cache.saveData(new QCircleReportOutboxTaskCacheData(paramQCircleReportOutboxTask), 1);
      return;
    }
    RFLog.w("QCircleReportOutboxTaskCacheManager", RFLog.USR, "save null task, id:" + paramQCircleReportOutboxTask.getTaskId());
  }
  
  public void updateTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    ensureCacheHolder(this.mSenderQueueCache);
    this.mSenderQueueCache.cache.updateData(new QCircleReportOutboxTaskCacheData(paramQCircleReportOutboxTask), "cache_key='" + paramQCircleReportOutboxTask.getCacheKey() + "'");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheManager
 * JD-Core Version:    0.7.0.1
 */