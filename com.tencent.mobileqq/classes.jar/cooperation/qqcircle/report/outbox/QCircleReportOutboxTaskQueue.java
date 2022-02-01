package cooperation.qqcircle.report.outbox;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import bizw;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.Singleton;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleReportOutboxTaskQueue
  extends SimpleTaskQueue
  implements Handler.Callback, NetworkState.NetworkStateListener
{
  private static int MAX_TASK_RETRY_COUNT = 3;
  private static final int MSG_ADD_TASK = 1;
  private static final int MSG_COMPLETE_TASK = 5;
  private static final int MSG_REMOVE_TASK = 3;
  private static final int MSG_RESET_TASK = 6;
  private static final int MSG_RESTORE_TASK = 4;
  private static final int MSG_RESUME_TASK = 2;
  private static final long ONE_DAY = 86400000L;
  public static final String TAG = "QCircleReportOutboxTaskQueue";
  private static final long TIME_OFFSET = TimeZone.getTimeZone("GMT+8").getRawOffset();
  private static final Singleton<QCircleReportOutboxTaskQueue, Void> sSingleton = new QCircleReportOutboxTaskQueue.1();
  private Runnable checkRetry = new QCircleReportOutboxTaskQueue.2(this);
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  
  private QCircleReportOutboxTaskQueue()
  {
    QLog.d("QCircleReportOutboxTaskQueue", 1, "new instance");
    this.mHandlerThread = new HandlerThread("qqcircle_report_outbox", 10);
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    NetworkState.addListener(this);
  }
  
  private void addTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (paramQCircleReportOutboxTask == null) {
      return;
    }
    paramQCircleReportOutboxTask.setTime(System.currentTimeMillis());
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramQCircleReportOutboxTask;
    this.mHandler.sendMessage(localMessage);
  }
  
  public static SimpleTaskQueue getInstance()
  {
    if (QzoneConfig.getQQCircleReportOutboxSwitchOpen()) {
      return (SimpleTaskQueue)sSingleton.get(null);
    }
    return new SimpleTaskQueue();
  }
  
  private int getRunningTaskCount()
  {
    return QCircleReportOutboxTaskManager.getInstance().getRunningTaskCount();
  }
  
  private boolean isTheSameDay(long paramLong)
  {
    return (System.currentTimeMillis() + TIME_OFFSET) / 86400000L == paramLong / 86400000L;
  }
  
  private boolean needRetry(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (paramQCircleReportOutboxTask == null) {}
    do
    {
      return false;
      MAX_TASK_RETRY_COUNT = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_max_retry_count", MAX_TASK_RETRY_COUNT);
    } while ((paramQCircleReportOutboxTask.getState() != 2) || (!resultCodeCanRetry(paramQCircleReportOutboxTask.getResultCode())) || (paramQCircleReportOutboxTask.getRetryNum() >= MAX_TASK_RETRY_COUNT));
    return true;
  }
  
  private void onAddTask(Message paramMessage)
  {
    paramMessage = (QCircleReportOutboxTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    paramMessage.printTaskInfo("QCircleReportOutboxTaskQueue", "onAddTask");
    QCircleReportOutboxTaskManager.getInstance().addTask(paramMessage);
    runTask();
  }
  
  private void onCompleteTask(Message paramMessage)
  {
    boolean bool = true;
    QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)paramMessage.obj;
    if (localQCircleReportOutboxTask == null) {
      return;
    }
    localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskQueue", "onCompleteTask");
    QCircleReportOutboxTaskManager localQCircleReportOutboxTaskManager = QCircleReportOutboxTaskManager.getInstance();
    if (paramMessage.arg1 == 1) {}
    for (;;)
    {
      localQCircleReportOutboxTaskManager.completeTask(localQCircleReportOutboxTask, bool);
      runTask();
      return;
      bool = false;
    }
  }
  
  private void onRemoveTask(Message paramMessage)
  {
    paramMessage = (QCircleReportOutboxTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    paramMessage.printTaskInfo("QCircleReportOutboxTaskQueue", "onRemoveTask", true);
    QCircleReportOutboxTaskManager.getInstance().removeTask(paramMessage);
    runTask();
  }
  
  private void onResetTask()
  {
    QLog.i("QCircleReportOutboxTaskQueue", 1, "onResetTask task size:" + getTaskCount());
    QCircleReportOutboxTaskManager.getInstance().reset();
    release();
  }
  
  private void onRestore()
  {
    if (QCircleReportOutboxTaskManager.getInstance().restore())
    {
      this.mHandler.removeCallbacks(this.checkRetry);
      this.mHandler.postDelayed(this.checkRetry, 3000L);
    }
    QLog.i("QCircleReportOutboxTaskQueue", 1, "onRestore taskList size:" + getTaskCount());
  }
  
  private void onResumeTask(Message paramMessage)
  {
    paramMessage = (QCircleReportOutboxTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    paramMessage.printTaskInfo("QCircleReportOutboxTaskQueue", "onResumeTask");
    QCircleReportOutboxTaskManager.getInstance().resumeTask(paramMessage);
    runTask();
  }
  
  private void release()
  {
    QLog.i("QCircleReportOutboxTaskQueue", 1, "release uin:" + bizw.a().a());
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    this.mHandler = null;
    sSingleton.release();
  }
  
  private boolean resultCodeCanRetry(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private boolean runTask()
  {
    return QCircleReportOutboxTaskManager.getInstance().runTask();
  }
  
  public void addPausedTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (paramQCircleReportOutboxTask == null) {
      return;
    }
    paramQCircleReportOutboxTask.setState(2);
    addTask(paramQCircleReportOutboxTask);
  }
  
  public void completeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask, boolean paramBoolean)
  {
    int i = 1;
    if (paramQCircleReportOutboxTask == null)
    {
      QLog.i("QCircleReportOutboxTaskQueue", 1, "completeTask null");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.arg1 = i;
      localMessage.obj = paramQCircleReportOutboxTask;
      this.mHandler.sendMessage(localMessage);
      return;
      i = 0;
    }
  }
  
  public boolean containTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    return QCircleReportOutboxTaskManager.getInstance().containTask(paramQCircleReportOutboxTask);
  }
  
  public CopyOnWriteArrayList<QCircleReportOutboxTask> getFailTaskList()
  {
    Object localObject = getTaskList();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)((Iterator)localObject).next();
      if ((localQCircleReportOutboxTask != null) && (localQCircleReportOutboxTask.getState() == 2)) {
        localCopyOnWriteArrayList.add(localQCircleReportOutboxTask);
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  public QCircleReportOutboxTask getTaskByCacheKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return QCircleReportOutboxTaskManager.getInstance().getTaskByCacheKey(paramString);
  }
  
  public int getTaskCount()
  {
    return QCircleReportOutboxTaskManager.getInstance().getTaskCount();
  }
  
  public CopyOnWriteArrayList<QCircleReportOutboxTask> getTaskList()
  {
    long l = System.currentTimeMillis();
    CopyOnWriteArrayList localCopyOnWriteArrayList = QCircleReportOutboxTaskManager.getInstance().getTaskList();
    QLog.d("QCircleReportOutboxTaskQueue", 1, "getTaskList timeCost:" + (System.currentTimeMillis() - l));
    return localCopyOnWriteArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      onAddTask(paramMessage);
      continue;
      onResumeTask(paramMessage);
      continue;
      onRemoveTask(paramMessage);
      continue;
      onRestore();
      continue;
      onCompleteTask(paramMessage);
      continue;
      onResetTask();
    }
  }
  
  public boolean hasRunningTask()
  {
    return QCircleReportOutboxTaskManager.getInstance().hasRunningTask();
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mHandler != null))
    {
      this.mHandler.removeCallbacks(this.checkRetry);
      this.mHandler.postDelayed(this.checkRetry, 10000L);
    }
  }
  
  public boolean removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    boolean bool = true;
    if (paramQCircleReportOutboxTask == null) {
      return false;
    }
    paramQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskQueue", "removeTask", true);
    if (containTask(paramQCircleReportOutboxTask)) {
      if (paramQCircleReportOutboxTask.getState() != 2) {}
    }
    for (;;)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      localMessage.obj = paramQCircleReportOutboxTask;
      this.mHandler.sendMessage(localMessage);
      return bool;
      QLog.d("QCircleReportOutboxTaskQueue", 1, "removeTask id:" + paramQCircleReportOutboxTask.getTaskId() + ",unexpect state:" + paramQCircleReportOutboxTask.getState());
      bool = false;
    }
  }
  
  public void resetTaskList()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void restore()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void resumeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    if (paramQCircleReportOutboxTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramQCircleReportOutboxTask;
    this.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue
 * JD-Core Version:    0.7.0.1
 */