package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.DbCacheManager;
import com.tencent.mobileqq.qcircle.api.db.DbCacheService;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.ArrayList;

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
    if (paramCacheHolder == null) {
      return;
    }
    long l = QCircleHostStubUtil.getCurrentAccountLongUin();
    if ((l != paramCacheHolder.uin) || (paramCacheHolder.cache == null) || (paramCacheHolder.cache.isClosed()))
    {
      paramCacheHolder.uin = l;
      paramCacheHolder.cache = DbCacheService.a().a(QCircleReportOutboxTaskCacheData.class, l, this.mCacheName);
    }
  }
  
  public void release()
  {
    this.mSenderQueueCache.cache.close();
    this.mSenderQueueCache.cache = null;
  }
  
  public void removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeTask id:");
    localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
    RFLog.i("QCircleReportOutboxTaskCacheManager", i, localStringBuilder.toString());
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
      while (i < localArrayList1.size())
      {
        Object localObject = (QCircleReportOutboxTaskCacheData)localArrayList1.get(i);
        if ((localObject != null) && (((QCircleReportOutboxTaskCacheData)localObject).getQueueTask() != null))
        {
          QCircleReportOutboxTask localQCircleReportOutboxTask = ((QCircleReportOutboxTaskCacheData)localObject).getQueueTask();
          if (!localQCircleReportOutboxTask.isNullTask())
          {
            localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskCacheManager", "restoreTask");
            localQCircleReportOutboxTask.setState(2);
            localArrayList2.add(((QCircleReportOutboxTaskCacheData)localObject).getQueueTask());
          }
          else
          {
            removeTask(localQCircleReportOutboxTask);
            int j = RFLog.USR;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("remove null task, id:");
            ((StringBuilder)localObject).append(localQCircleReportOutboxTask.getTaskId());
            RFLog.w("QCircleReportOutboxTaskCacheManager", j, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
    }
    return localArrayList2;
  }
  
  public void saveTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (!paramQCircleReportOutboxTask.isNullTask())
    {
      i = RFLog.USR;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveTask id:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
      RFLog.i("QCircleReportOutboxTaskCacheManager", i, localStringBuilder.toString());
      ensureCacheHolder(this.mSenderQueueCache);
      this.mSenderQueueCache.cache.saveData(new QCircleReportOutboxTaskCacheData(paramQCircleReportOutboxTask), 1);
      return;
    }
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("save null task, id:");
    localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
    RFLog.w("QCircleReportOutboxTaskCacheManager", i, localStringBuilder.toString());
  }
  
  public void updateTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    ensureCacheHolder(this.mSenderQueueCache);
    DbCacheManager localDbCacheManager = this.mSenderQueueCache.cache;
    QCircleReportOutboxTaskCacheData localQCircleReportOutboxTaskCacheData = new QCircleReportOutboxTaskCacheData(paramQCircleReportOutboxTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cache_key='");
    localStringBuilder.append(paramQCircleReportOutboxTask.getCacheKey());
    localStringBuilder.append("'");
    localDbCacheManager.a(localQCircleReportOutboxTaskCacheData, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheManager
 * JD-Core Version:    0.7.0.1
 */