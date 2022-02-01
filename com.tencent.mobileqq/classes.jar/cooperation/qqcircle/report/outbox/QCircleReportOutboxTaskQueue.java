package cooperation.qqcircle.report.outbox;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.db.util.Singleton;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
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
  private Runnable excuteRetry = new QCircleReportOutboxTaskQueue.3(this);
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
    if (QCircleConfigHelper.av()) {
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
    boolean bool2 = false;
    if (paramQCircleReportOutboxTask == null) {
      return false;
    }
    MAX_TASK_RETRY_COUNT = QCircleConfigHelper.a("qqcircle", "qqcircle_max_retry_count", Integer.valueOf(MAX_TASK_RETRY_COUNT)).intValue();
    boolean bool1 = bool2;
    if (paramQCircleReportOutboxTask.getState() == 2)
    {
      bool1 = bool2;
      if (resultCodeCanRetry(paramQCircleReportOutboxTask.getResultCode()))
      {
        bool1 = bool2;
        if (paramQCircleReportOutboxTask.getRetryNum() < MAX_TASK_RETRY_COUNT) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    QCircleReportOutboxTask localQCircleReportOutboxTask = (QCircleReportOutboxTask)paramMessage.obj;
    if (localQCircleReportOutboxTask == null) {
      return;
    }
    localQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskQueue", "onCompleteTask");
    QCircleReportOutboxTaskManager localQCircleReportOutboxTaskManager = QCircleReportOutboxTaskManager.getInstance();
    int i = paramMessage.arg1;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localQCircleReportOutboxTaskManager.completeTask(localQCircleReportOutboxTask, bool);
    runTask();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResetTask task size:");
    localStringBuilder.append(getTaskCount());
    QLog.i("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRestore taskList size:");
    localStringBuilder.append(getTaskCount());
    QLog.i("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release uin:");
    localStringBuilder.append(QCircleHostStubUtil.getCurrentAccount());
    QLog.i("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    this.mHandler = null;
    sSingleton.release();
  }
  
  private void reportOutboxResendFinalFailed(QCircleReportOutboxTask paramQCircleReportOutboxTask)
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
  
  private boolean resultCodeCanRetry(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private void resumeOutboxTasks()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = getTaskList();
    if (localCopyOnWriteArrayList != null)
    {
      int j = localCopyOnWriteArrayList.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkRetry taskList size:");
      ((StringBuilder)localObject).append(j);
      QLog.i("QCircleReportOutboxTaskQueue", 1, ((StringBuilder)localObject).toString());
      int i = 0;
      while (i < j)
      {
        localObject = (QCircleReportOutboxTask)localCopyOnWriteArrayList.get(i);
        ((QCircleReportOutboxTask)localObject).printTaskInfo("QCircleReportOutboxTaskQueue", "checkRetry");
        if (((QCircleReportOutboxTask)localObject).getState() != 1)
        {
          StringBuilder localStringBuilder;
          if (needRetry((QCircleReportOutboxTask)localObject))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("retryTask id:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getTaskId());
            localStringBuilder.append(" ,state:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getState());
            localStringBuilder.append(" ,cmd:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).mCmdName);
            localStringBuilder.append(" ,curRetryNum:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getRetryNum());
            QLog.d("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
            resumeTask((QCircleReportOutboxTask)localObject);
          }
          else
          {
            reportOutboxResendFinalFailed((QCircleReportOutboxTask)localObject);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeTask id:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getTaskId());
            localStringBuilder.append(" ,state:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getState());
            localStringBuilder.append(" ,cmd:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).mCmdName);
            localStringBuilder.append(" ,curRetryNum:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getRetryNum());
            localStringBuilder.append(" ,resultCode:");
            localStringBuilder.append(((QCircleReportOutboxTask)localObject).getResultCode());
            QLog.d("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
            removeTask((QCircleReportOutboxTask)localObject);
          }
        }
        i += 1;
      }
    }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTaskList timeCost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.d("QCircleReportOutboxTaskQueue", 1, localStringBuilder.toString());
    return localCopyOnWriteArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 6: 
      onResetTask();
      break;
    case 5: 
      onCompleteTask(paramMessage);
      break;
    case 4: 
      onRestore();
      break;
    case 3: 
      onRemoveTask(paramMessage);
      break;
    case 2: 
      onResumeTask(paramMessage);
      break;
    case 1: 
      onAddTask(paramMessage);
    }
    return false;
  }
  
  public boolean hasRunningTask()
  {
    return QCircleReportOutboxTaskManager.getInstance().hasRunningTask();
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Handler localHandler = this.mHandler;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.checkRetry);
        this.mHandler.postDelayed(this.checkRetry, 10000L);
      }
    }
  }
  
  public boolean removeTask(QCircleReportOutboxTask paramQCircleReportOutboxTask)
  {
    boolean bool2 = false;
    if (paramQCircleReportOutboxTask == null) {
      return false;
    }
    paramQCircleReportOutboxTask.printTaskInfo("QCircleReportOutboxTaskQueue", "removeTask", true);
    boolean bool1 = bool2;
    if (containTask(paramQCircleReportOutboxTask)) {
      if (paramQCircleReportOutboxTask.getState() == 2)
      {
        bool1 = true;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeTask id:");
        ((StringBuilder)localObject).append(paramQCircleReportOutboxTask.getTaskId());
        ((StringBuilder)localObject).append(",unexpect state:");
        ((StringBuilder)localObject).append(paramQCircleReportOutboxTask.getState());
        QLog.d("QCircleReportOutboxTaskQueue", 1, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = 3;
    ((Message)localObject).obj = paramQCircleReportOutboxTask;
    this.mHandler.sendMessage((Message)localObject);
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue
 * JD-Core Version:    0.7.0.1
 */