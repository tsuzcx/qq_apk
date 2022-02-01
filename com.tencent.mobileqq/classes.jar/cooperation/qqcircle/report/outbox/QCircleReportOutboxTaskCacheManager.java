package cooperation.qqcircle.report.outbox;

import bizw;
import bjmk;
import bjmn;
import com.tencent.qphone.base.util.QLog;
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
    if (paramCacheHolder == null) {}
    long l;
    do
    {
      return;
      l = bizw.a().a();
    } while ((l == paramCacheHolder.uin) && (paramCacheHolder.cache != null) && (!paramCacheHolder.cache.a()));
    paramCacheHolder.uin = l;
    paramCacheHolder.cache = bjmn.a(bizw.a().a()).a(QCircleReportOutboxTaskCacheData.class, l, this.mCacheName);
  }
  
  public void release()
  {
    this.mSenderQueueCache.cache.a();
    this.mSenderQueueCache.cache = null;
  }
  
  public void removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    QLog.i("QCircleReportOutboxTaskCacheManager", 1, "removeTask id:" + paramQCircleReportOutboxTask.getTaskId());
    ensureCacheHolder(this.mSenderQueueCache);
    this.mSenderQueueCache.cache.b("cache_key='" + paramQCircleReportOutboxTask.getCacheKey() + "'");
  }
  
  public ArrayList<QCircleReportOutboxTask> restoreTasks()
  {
    int j = 0;
    ensureCacheHolder(this.mSenderQueueCache);
    int k = this.mSenderQueueCache.cache.a();
    ArrayList localArrayList1 = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      localArrayList1.add((QCircleReportOutboxTaskCacheData)this.mSenderQueueCache.cache.a(i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1.size() > 0)
    {
      i = j;
      if (i < k)
      {
        QCircleReportOutboxTaskCacheData localQCircleReportOutboxTaskCacheData = (QCircleReportOutboxTaskCacheData)localArrayList1.get(i);
        QCircleReportOutboxTask localQCircleReportOutboxTask;
        if ((localQCircleReportOutboxTaskCacheData != null) && (localQCircleReportOutboxTaskCacheData.getQueueTask() != null))
        {
          localQCircleReportOutboxTask = localQCircleReportOutboxTaskCacheData.getQueueTask();
          if (localQCircleReportOutboxTask.isNullTask()) {
            break label161;
          }
          localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskCacheManager", "restoreTask");
          localQCircleReportOutboxTask.setState(2);
          localArrayList2.add(localQCircleReportOutboxTaskCacheData.getQueueTask());
        }
        for (;;)
        {
          i += 1;
          break;
          label161:
          removeTask(localQCircleReportOutboxTask);
          QLog.w("QCircleReportOutboxTaskCacheManager", 1, "remove null task, id:" + localQCircleReportOutboxTask.getTaskId());
        }
      }
    }
    return localArrayList2;
  }
  
  public void saveTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (!paramQCircleReportOutboxTask.isNullTask())
    {
      QLog.i("QCircleReportOutboxTaskCacheManager", 1, "saveTask id:" + paramQCircleReportOutboxTask.getTaskId());
      ensureCacheHolder(this.mSenderQueueCache);
      this.mSenderQueueCache.cache.a(new QCircleReportOutboxTaskCacheData(paramQCircleReportOutboxTask), 1);
      return;
    }
    QLog.w("QCircleReportOutboxTaskCacheManager", 1, "save null task, id:" + paramQCircleReportOutboxTask.getTaskId());
  }
  
  public void updateTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    ensureCacheHolder(this.mSenderQueueCache);
    this.mSenderQueueCache.cache.b(new QCircleReportOutboxTaskCacheData(paramQCircleReportOutboxTask), "cache_key='" + paramQCircleReportOutboxTask.getCacheKey() + "'");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheManager
 * JD-Core Version:    0.7.0.1
 */