package cooperation.qqcircle.report.outbox;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.db.util.Singleton;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleReportOutboxTaskManager
{
  private static int DEFAULT_MAX_PARALLEL_TASK_COUNT = 10;
  public static final String TAG = "QCircleReportOutboxTaskManager";
  private static final Singleton<QCircleReportOutboxTaskManager, Void> sSingleton = new QCircleReportOutboxTaskManager.1();
  private volatile boolean hasRunningTask = false;
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
  
  private void reportReportOutboxResendFinalSuccess(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramQCircleReportOutboxTask.getResultCode());
    ((StringBuilder)localObject1).append("");
    localObject1 = QCircleReportHelper.newEntry("ret_code", ((StringBuilder)localObject1).toString());
    FeedCloudCommon.Entry localEntry = QCircleReportHelper.newEntry("url", paramQCircleReportOutboxTask.getResultMsg());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramQCircleReportOutboxTask.mCmdName);
    ((StringBuilder)localObject2).append("");
    localObject2 = QCircleReportHelper.newEntry("refer", ((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramQCircleReportOutboxTask.getRetryNum());
    ((StringBuilder)localObject3).append("");
    localObject3 = QCircleReportHelper.newEntry("count", ((StringBuilder)localObject3).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
    localStringBuilder.append("_");
    localStringBuilder.append(paramQCircleReportOutboxTask.getResultCode());
    localStringBuilder.append("_");
    localStringBuilder.append(paramQCircleReportOutboxTask.getResultMsg());
    localStringBuilder.append("_state=");
    localStringBuilder.append(paramQCircleReportOutboxTask.getState());
    QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event_final", Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, localEntry, localObject2, localObject3, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public boolean addTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if ((paramQCircleReportOutboxTask != null) && (!this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addTask id:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
      QLog.i("QCircleReportOutboxTaskManager", 1, localStringBuilder.toString());
      this.mTaskList.add(paramQCircleReportOutboxTask);
      this.mCacheManager.saveTask(paramQCircleReportOutboxTask);
      return true;
    }
    QLog.w("QCircleReportOutboxTaskManager", 1, "addTask error");
    return false;
  }
  
  public boolean completeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask, boolean paramBoolean)
  {
    if ((paramQCircleReportOutboxTask != null) && (this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      if (paramBoolean)
      {
        paramQCircleReportOutboxTask.setState(3);
        this.mTaskList.remove(paramQCircleReportOutboxTask);
        this.mCacheManager.removeTask(paramQCircleReportOutboxTask);
        reportReportOutboxResendFinalSuccess(paramQCircleReportOutboxTask);
      }
      else
      {
        paramQCircleReportOutboxTask.setState(2);
        this.mCacheManager.updateTask(paramQCircleReportOutboxTask);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("completeTask id:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
      localStringBuilder.append(", succeed:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", resultCode:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getResultCode());
      localStringBuilder.append(", resultMsg:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getResultMsg());
      QLog.i("QCircleReportOutboxTaskManager", 1, localStringBuilder.toString());
      return true;
    }
    QLog.w("QCircleReportOutboxTaskManager", 1, "completeTask error");
    return false;
  }
  
  public boolean containTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    return this.mTaskList.contains(paramQCircleReportOutboxTask);
  }
  
  public int getRunningTaskCount()
  {
    boolean bool = this.mTaskList.isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    Iterator localIterator = this.mTaskList.iterator();
    while (localIterator.hasNext())
    {
      QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
      if ((localQCircleReportOutboxTask != null) && (localQCircleReportOutboxTask.getState() == 1)) {
        if (System.currentTimeMillis() - localQCircleReportOutboxTask.getTime() < 60000L)
        {
          i += 1;
        }
        else
        {
          localQCircleReportOutboxTask.setState(2);
          localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskManager", "getRunningTaskCount resend timeout!", true);
        }
      }
    }
    return i;
  }
  
  public QCircleReportOutboxTask getTaskByCacheKey(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.mTaskList.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (QCircleReportOutboxTask)localIterator.next();
    } while (!paramString.equals(((QCircleReportOutboxTask)localObject1).getCacheKey()));
    return localObject1;
  }
  
  public int getTaskCount()
  {
    return this.mTaskList.size();
  }
  
  public CopyOnWriteArrayList<QCircleReportOutboxTask> getTaskList()
  {
    return (CopyOnWriteArrayList)this.mTaskList.clone();
  }
  
  public boolean hasRunningTask()
  {
    return this.hasRunningTask;
  }
  
  public boolean removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if ((paramQCircleReportOutboxTask != null) && (this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      paramQCircleReportOutboxTask.setState(4);
      paramQCircleReportOutboxTask.onRemove();
      this.mTaskList.remove(paramQCircleReportOutboxTask);
      this.mCacheManager.removeTask(paramQCircleReportOutboxTask);
      return true;
    }
    QLog.w("QCircleReportOutboxTaskManager", 1, "removeTask error");
    return false;
  }
  
  public void reset()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reset total size:");
    ((StringBuilder)localObject).append(this.mTaskList.size());
    QLog.i("QCircleReportOutboxTaskManager", 1, ((StringBuilder)localObject).toString());
    if (this.mTaskList.size() > 0)
    {
      localObject = this.mTaskList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)((Iterator)localObject).next();
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
    boolean bool2 = this.mTaskList.isEmpty();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = this.mCacheManager.restoreTasks();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
        localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskManager", "restore");
        if (localQCircleReportOutboxTask.getState() != 1) {
          localQCircleReportOutboxTask.onRestore();
        }
      }
      this.mTaskList.clear();
      this.mTaskList.addAll((Collection)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("restore total size:");
    ((StringBuilder)localObject).append(this.mTaskList.size());
    QLog.i("QCircleReportOutboxTaskManager", 1, ((StringBuilder)localObject).toString());
    if (this.mTaskList.size() > 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean resumeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if ((paramQCircleReportOutboxTask != null) && (this.mTaskList.contains(paramQCircleReportOutboxTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeTask id:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getTaskId());
      localStringBuilder.append(", current state:");
      localStringBuilder.append(paramQCircleReportOutboxTask.getState());
      QLog.i("QCircleReportOutboxTaskManager", 1, localStringBuilder.toString());
      paramQCircleReportOutboxTask.onResume();
      return true;
    }
    QLog.w("QCircleReportOutboxTaskManager", 1, "resumeTask error");
    return false;
  }
  
  public boolean runTask()
  {
    int i = getRunningTaskCount();
    boolean bool2 = AppNetConnInfo.isNetSupport();
    boolean bool3 = false;
    boolean bool1 = true;
    if (!bool2)
    {
      if (i <= 0) {
        bool1 = false;
      }
      this.hasRunningTask = bool1;
      return false;
    }
    int k = QCircleConfigHelper.a("qqcircle", "qqcircle_max_parallel_task_count", Integer.valueOf(DEFAULT_MAX_PARALLEL_TASK_COUNT)).intValue();
    int j;
    if (i <= k)
    {
      Iterator localIterator = this.mTaskList.iterator();
      bool2 = false;
      do
      {
        QCircleReportOutboxTask localQCircleReportOutboxTask;
        do
        {
          j = i;
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localQCircleReportOutboxTask = (QCircleReportOutboxTask)localIterator.next();
        } while (localQCircleReportOutboxTask == null);
        j = i;
        bool1 = bool2;
        if (localQCircleReportOutboxTask.getState() == 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("runTask id:");
          localStringBuilder.append(localQCircleReportOutboxTask.getTaskId());
          QLog.i("QCircleReportOutboxTaskManager", 1, localStringBuilder.toString());
          j = i + 1;
          localQCircleReportOutboxTask.setState(1);
          localQCircleReportOutboxTask.resend();
          bool1 = true;
        }
        i = j;
        bool2 = bool1;
      } while (j != k);
    }
    else
    {
      bool1 = false;
      j = i;
    }
    bool2 = bool3;
    if (j > 0) {
      bool2 = true;
    }
    this.hasRunningTask = bool2;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskManager
 * JD-Core Version:    0.7.0.1
 */