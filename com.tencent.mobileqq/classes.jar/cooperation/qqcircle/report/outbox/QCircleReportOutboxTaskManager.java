package cooperation.qqcircle.report.outbox;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.Singleton;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleReportOutboxTaskManager
{
  private static int DEFAULT_MAX_PARALLEL_TASK_COUNT = 10;
  public static final String TAG = "QCircleReportOutboxTaskManager";
  private static final Singleton<QCircleReportOutboxTaskManager, Void> sSingleton = new QCircleReportOutboxTaskManager.1();
  private volatile boolean hasRunningTask;
  private QCircleReportOutboxTaskCacheManager mCacheManager;
  private CopyOnWriteArrayList<QCircleReportOutboxTask> mTaskList = new CopyOnWriteArrayList();
  
  private QCircleReportOutboxTaskManager()
  {
    QLog.d("QCircleReportOutboxTaskManager", 1, "new instance");
    this.mCacheManager = new QCircleReportOutboxTaskCacheManager("QCircleSendTaskManager_outbox_queue");
  }
  
  public static QCircleReportOutboxTaskManager getInstance()
  {
    return (QCircleReportOutboxTaskManager)sSingleton.get(null);
  }
  
  public boolean addTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if ((paramQCircleReportOutboxTask == null) || (this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      QLog.w("QCircleReportOutboxTaskManager", 1, "addTask error");
      return false;
    }
    QLog.i("QCircleReportOutboxTaskManager", 1, "addTask id:" + paramQCircleReportOutboxTask.getTaskId());
    this.mTaskList.add(paramQCircleReportOutboxTask);
    this.mCacheManager.saveTask(paramQCircleReportOutboxTask);
    return true;
  }
  
  public boolean completeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask, boolean paramBoolean)
  {
    if ((paramQCircleReportOutboxTask == null) || (!this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      QLog.w("QCircleReportOutboxTaskManager", 1, "completeTask error");
      return false;
    }
    if (paramBoolean)
    {
      paramQCircleReportOutboxTask.setState(3);
      this.mTaskList.remove(paramQCircleReportOutboxTask);
      this.mCacheManager.removeTask(paramQCircleReportOutboxTask);
    }
    for (;;)
    {
      QLog.i("QCircleReportOutboxTaskManager", 1, "completeTask id:" + paramQCircleReportOutboxTask.getTaskId() + ", succeed:" + paramBoolean + ", resultCode:" + paramQCircleReportOutboxTask.getResultCode() + ", resultMsg:" + paramQCircleReportOutboxTask.getResultMsg());
      return true;
      paramQCircleReportOutboxTask.setState(2);
      this.mCacheManager.updateTask(paramQCircleReportOutboxTask);
    }
  }
  
  public boolean containTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    return this.mTaskList.contains(paramQCircleReportOutboxTask);
  }
  
  public int getRunningTaskCount()
  {
    if (this.mTaskList.isEmpty()) {
      return 0;
    }
    Iterator localIterator = this.mTaskList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
      if (localQCircleReportOutboxTask != null)
      {
        if (localQCircleReportOutboxTask.getState() == 1) {
          if (System.currentTimeMillis() - localQCircleReportOutboxTask.getTime() < 60000L) {
            i += 1;
          }
        }
        for (;;)
        {
          break;
          localQCircleReportOutboxTask.setState(2);
          localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskManager", "getRunningTaskCount resend timeout!", true);
        }
      }
    }
    return i;
  }
  
  public QCircleReportOutboxTask getTaskByCacheKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.mTaskList.iterator();
    QCircleReportOutboxTask localQCircleReportOutboxTask;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
    } while (!paramString.equals(localQCircleReportOutboxTask.getCacheKey()));
    for (paramString = localQCircleReportOutboxTask;; paramString = null) {
      return paramString;
    }
  }
  
  public int getTaskCount()
  {
    return this.mTaskList.size();
  }
  
  public CopyOnWriteArrayList<QCircleReportOutboxTask> getTaskList()
  {
    return this.mTaskList;
  }
  
  public boolean hasRunningTask()
  {
    return this.hasRunningTask;
  }
  
  public boolean removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if ((paramQCircleReportOutboxTask == null) || (!this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      QLog.w("QCircleReportOutboxTaskManager", 1, "removeTask error");
      return false;
    }
    paramQCircleReportOutboxTask.setState(4);
    paramQCircleReportOutboxTask.onRemove();
    this.mTaskList.remove(paramQCircleReportOutboxTask);
    this.mCacheManager.removeTask(paramQCircleReportOutboxTask);
    return true;
  }
  
  public void reset()
  {
    QLog.i("QCircleReportOutboxTaskManager", 1, "reset total size:" + this.mTaskList.size());
    if (this.mTaskList.size() > 0)
    {
      Iterator localIterator = this.mTaskList.iterator();
      while (localIterator.hasNext())
      {
        QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
        if (localQCircleReportOutboxTask != null) {
          localQCircleReportOutboxTask.clear();
        }
      }
    }
    this.mTaskList.clear();
    this.mCacheManager.release();
    sSingleton.release();
  }
  
  public boolean restore()
  {
    if (!this.mTaskList.isEmpty()) {
      return false;
    }
    ArrayList localArrayList = this.mCacheManager.restoreTasks();
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
        localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskManager", "restore");
        if (localQCircleReportOutboxTask.getState() != 1) {
          localQCircleReportOutboxTask.onRestore();
        }
      }
      this.mTaskList.clear();
      this.mTaskList.addAll(localArrayList);
    }
    QLog.i("QCircleReportOutboxTaskManager", 1, "restore total size:" + this.mTaskList.size());
    if (this.mTaskList.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean resumeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if ((paramQCircleReportOutboxTask == null) || (!this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      QLog.w("QCircleReportOutboxTaskManager", 1, "resumeTask error");
      return false;
    }
    QLog.i("QCircleReportOutboxTaskManager", 1, "resumeTask id:" + paramQCircleReportOutboxTask.getTaskId() + ", current state:" + paramQCircleReportOutboxTask.getState());
    paramQCircleReportOutboxTask.onResume();
    return true;
  }
  
  public boolean runTask()
  {
    boolean bool2 = true;
    int i = getRunningTaskCount();
    boolean bool1;
    if (!NetworkState.isNetSupport())
    {
      if (i > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        this.hasRunningTask = bool1;
        return false;
      }
    }
    int j = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_max_parallel_task_count", DEFAULT_MAX_PARALLEL_TASK_COUNT);
    if (i <= j)
    {
      Iterator localIterator = this.mTaskList.iterator();
      bool1 = false;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
          if (localQCircleReportOutboxTask != null) {
            if (localQCircleReportOutboxTask.getState() == 2)
            {
              QLog.i("QCircleReportOutboxTaskManager", 1, "runTask id:" + localQCircleReportOutboxTask.getTaskId());
              localQCircleReportOutboxTask.setState(1);
              localQCircleReportOutboxTask.resend();
              i += 1;
              bool1 = true;
              label147:
              if (i != j) {
                break;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i > 0) {}
      for (;;)
      {
        this.hasRunningTask = bool2;
        return bool1;
        break;
        bool2 = false;
      }
      break label147;
      continue;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskManager
 * JD-Core Version:    0.7.0.1
 */