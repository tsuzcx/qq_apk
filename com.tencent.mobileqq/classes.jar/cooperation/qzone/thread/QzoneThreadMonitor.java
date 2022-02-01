package cooperation.qzone.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class QzoneThreadMonitor
{
  private static final int MAX_CHECK_THREAD_TIME = 10;
  private static final int MSG_CHECK_THREAD = 1;
  private static final String TAG = "QzoneThreadMonitor";
  private static final long THREAD_CHECK_INTERVAL_NORMAL = 500L;
  private static final long THREAD_CHECK_INTERVAL_REAL_TIME = 250L;
  private static final long THREAD_CHECK_THRESHOLD_NORMAL = 2000L;
  private static final long THREAD_CHECK_THRESHOLD_REAL_TIME = 500L;
  private static final long THREAD_DELAY_WARN_THRESHOLD = 2000L;
  private static final long THREAD_DELAY_WARN_THRESHOLD_REAL_TIME = 500L;
  public static boolean enableMonitor;
  private static QzoneThreadMonitor instance;
  private Printer handlerDumpPrinter = new QzoneThreadMonitor.2(this);
  private ConcurrentHashMap<String, QzoneThreadMonitor.MessageInfo> id2Msg = new ConcurrentHashMap(8, 0.75F, 2);
  private Handler monitorHandler;
  private List<String> realTimeThreadNames = Arrays.asList(new String[] { "RealTime_HandlerThread" });
  private List<String> slowThreadNames = Arrays.asList(new String[] { "Report_HandlerThread" });
  private HashMap<String, PriorityBlockingQueue<QzoneThreadMonitor.MessageInfo>> thread2Msg = new HashMap();
  
  private QzoneThreadMonitor()
  {
    HandlerThread localHandlerThread = new HandlerThread("qzone_thread_monitor_debug");
    localHandlerThread.start();
    this.monitorHandler = new QzoneThreadMonitor.1(this, localHandlerThread.getLooper());
  }
  
  private static String buildStackTraceString(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfStackTraceElement != null) && (paramArrayOfStackTraceElement.length > 0))
    {
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(paramString);
        localStringBuilder.append(localStackTraceElement.toString());
        localStringBuilder.append('\n');
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static QzoneThreadMonitor getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new QzoneThreadMonitor();
        }
      }
      finally {}
    }
    return instance;
  }
  
  void beginHandle(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      return;
    }
    if (paramBaseHandler != null) {
      if (paramMessage == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramBaseHandler = paramBaseHandler.getLooper().getThread().getName();
        if (!QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(paramBaseHandler)) {
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(paramMessage.hashCode()));
        ((StringBuilder)localObject).append(paramMessage.getWhen());
        String str = ((StringBuilder)localObject).toString();
        localObject = (QzoneThreadMonitor.MessageInfo)this.id2Msg.get(str);
        if (localObject == null)
        {
          QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage info missing. id=", str });
          return;
        }
        ((QzoneThreadMonitor.MessageInfo)localObject).actualHandleTime = paramLong;
        long l2 = paramLong - ((QzoneThreadMonitor.MessageInfo)localObject).expectedHandleTime;
        int i = ((QzoneThreadMonitor.MessageInfo)localObject).type;
        long l1 = 500L;
        if (i != 3)
        {
          if (((QzoneThreadMonitor.MessageInfo)localObject).type != 1) {
            break label431;
          }
          paramLong = 2000L;
          if (l2 > paramLong)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(" delay=");
            str = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMessage.what);
            localStringBuilder.append(" msg.target=");
            QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[begin handle] ", paramBaseHandler, " id=", str, Long.valueOf(l2), " what=", localStringBuilder.toString(), ((QzoneThreadMonitor.MessageInfo)localObject).target, " msg.callback=", ((QzoneThreadMonitor.MessageInfo)localObject).callback });
          }
        }
        paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(paramBaseHandler);
        if (paramMessage == null) {
          return;
        }
        paramBaseHandler = (QzoneThreadMonitor.MessageInfo)paramMessage.peek();
        if ((paramBaseHandler != null) && (paramBaseHandler.expectedHandleTime < ((QzoneThreadMonitor.MessageInfo)localObject).expectedHandleTime))
        {
          paramMessage.poll();
          paramBaseHandler = (QzoneThreadMonitor.MessageInfo)paramMessage.peek();
          continue;
        }
        if (((QzoneThreadMonitor.MessageInfo)localObject).type != 3)
        {
          paramBaseHandler = Message.obtain(this.monitorHandler, 1, 0, 0, localObject);
          paramMessage = this.monitorHandler;
          paramLong = l1;
          if (((QzoneThreadMonitor.MessageInfo)localObject).type == 1) {
            paramLong = 2000L;
          }
          paramMessage.sendMessageDelayed(paramBaseHandler, paramLong);
          return;
        }
      }
      catch (Exception paramBaseHandler)
      {
        QLog.w("QzoneThreadMonitor", 1, "beginHandle exception:", paramBaseHandler);
      }
      return;
      label431:
      paramLong = 500L;
    }
  }
  
  public void dump(BaseHandler paramBaseHandler)
  {
    if (!enableMonitor) {
      return;
    }
    if ((paramBaseHandler != null) && (QLog.isDevelopLevel()))
    {
      QLog.d("QzoneThreadMonitor", 4, "======================================================================================");
      paramBaseHandler.dump(this.handlerDumpPrinter, "|| ");
      QLog.d("QzoneThreadMonitor", 4, "======================================================================================");
    }
  }
  
  void enqueue(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      return;
    }
    if (paramBaseHandler != null) {
      if (paramMessage == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        String str1 = paramBaseHandler.getLooper().getThread().getName();
        if (!QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(str1)) {
          return;
        }
        paramBaseHandler = new StringBuilder();
        paramBaseHandler.append(String.valueOf(paramMessage.hashCode()));
        paramBaseHandler.append(paramLong);
        String str2 = paramBaseHandler.toString();
        paramBaseHandler = paramMessage.getTarget();
        if (paramBaseHandler == null) {
          paramBaseHandler = "null";
        } else {
          paramBaseHandler = paramMessage.getTarget().toString();
        }
        if (paramMessage.getCallback() == null) {
          localObject = "null";
        } else {
          localObject = paramMessage.getCallback().toString();
        }
        if (this.realTimeThreadNames.contains(str1))
        {
          i = 2;
        }
        else
        {
          if (!this.slowThreadNames.contains(str1)) {
            break label255;
          }
          i = 3;
        }
        Object localObject = new QzoneThreadMonitor.MessageInfo(this, str2, str1, paramMessage.what, paramBaseHandler, (String)localObject, paramLong, i);
        this.id2Msg.put(str2, localObject);
        paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(str1);
        paramBaseHandler = paramMessage;
        if (paramMessage == null)
        {
          paramBaseHandler = new PriorityBlockingQueue();
          this.thread2Msg.put(str1, paramBaseHandler);
        }
        paramBaseHandler.put(localObject);
        return;
      }
      catch (Exception paramBaseHandler)
      {
        QLog.w("QzoneThreadMonitor", 1, "enqueue exception:", paramBaseHandler);
      }
      return;
      label255:
      int i = 1;
    }
  }
  
  void finishHandle(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      return;
    }
    if (paramBaseHandler != null) {
      if (paramMessage == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramBaseHandler = paramBaseHandler.getLooper().getThread().getName();
        if (!QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(paramBaseHandler)) {
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(paramMessage.hashCode()));
        ((StringBuilder)localObject).append(paramMessage.getWhen());
        String str = ((StringBuilder)localObject).toString();
        localObject = (QzoneThreadMonitor.MessageInfo)this.id2Msg.remove(str);
        if (localObject == null)
        {
          QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage info missing. id=", str });
          return;
        }
        this.monitorHandler.removeMessages(1, localObject);
        ((QzoneThreadMonitor.MessageInfo)localObject).finishTime = paramLong;
        long l = paramLong - ((QzoneThreadMonitor.MessageInfo)localObject).actualHandleTime;
        if (((QzoneThreadMonitor.MessageInfo)localObject).type != 3)
        {
          if (((QzoneThreadMonitor.MessageInfo)localObject).type != 1) {
            break label350;
          }
          paramLong = 2000L;
          if (l > paramLong)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(" cost=");
            str = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMessage.what);
            localStringBuilder.append(" msg.target=");
            QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[finish handle] ", paramBaseHandler, " id=", str, Long.valueOf(l), " what=", localStringBuilder.toString(), ((QzoneThreadMonitor.MessageInfo)localObject).target, " msg.callback=", ((QzoneThreadMonitor.MessageInfo)localObject).callback });
          }
        }
        paramBaseHandler = (PriorityBlockingQueue)this.thread2Msg.get(paramBaseHandler);
        if (paramBaseHandler == null) {
          return;
        }
        paramBaseHandler.remove(localObject);
        return;
      }
      catch (Exception paramBaseHandler)
      {
        QLog.w("QzoneThreadMonitor", 1, "finishHandle exception:", paramBaseHandler);
      }
      return;
      label350:
      paramLong = 500L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor
 * JD-Core Version:    0.7.0.1
 */