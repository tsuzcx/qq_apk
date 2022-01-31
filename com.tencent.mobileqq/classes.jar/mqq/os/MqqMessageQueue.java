package mqq.os;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.tencent.qphone.base.util.QLog;

public class MqqMessageQueue
  implements Handler.Callback, MessageQueue.IdleHandler
{
  private static boolean DEBUG_QUEUE = false;
  private static final int MSG_HOOK = 1000;
  private static final int MSG_IDLE_TIMEOUT = 1001;
  private static final String TAG = "MqqMessage.Queue";
  private static MqqMessageQueue sSubMainQueue;
  private volatile boolean hookReqeusted;
  private volatile boolean idleHandlerAttached;
  Handler mHandler = new Handler(paramLooper, this)
  {
    public String toString()
    {
      return "MessageQueueHandler";
    }
  };
  Printer mLogging;
  MqqMessage mMessages;
  long msgCount = 0L;
  long totalCost = 0L;
  
  private MqqMessageQueue(Looper paramLooper) {}
  
  private void cancelHookReq()
  {
    this.mHandler.removeMessages(1000);
    this.hookReqeusted = false;
  }
  
  private boolean dequeue(boolean paramBoolean)
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, "enter dequeue, idle = " + paramBoolean);
    }
    MqqMessage localMqqMessage = next();
    if (localMqqMessage != null) {}
    for (String str = localMqqMessage.toString();; str = "null")
    {
      if (localMqqMessage != null) {}
      try
      {
        StringBuilder localStringBuilder;
        if (this.mLogging != null)
        {
          localStringBuilder = new StringBuilder(256);
          localStringBuilder.append(">>>>> Dispatching to ");
          localStringBuilder.append(localMqqMessage.target);
          localStringBuilder.append(" ");
          localStringBuilder.append(localMqqMessage.wrappedMsg.getCallback());
          localStringBuilder.append(": ");
          localStringBuilder.append(localMqqMessage.wrappedMsg.what);
          this.mLogging.println(localStringBuilder.toString());
        }
        long l = SystemClock.uptimeMillis();
        localMqqMessage.target.dispatchMessage(localMqqMessage.wrappedMsg);
        this.totalCost += SystemClock.uptimeMillis() - l;
        this.msgCount += 1L;
        if (this.mLogging != null)
        {
          localStringBuilder = new StringBuilder(256);
          localStringBuilder.append("<<<<< Finished to ");
          localStringBuilder.append(localMqqMessage.target);
          localStringBuilder.append(" ");
          localStringBuilder.append(localMqqMessage.wrappedMsg.getCallback());
          this.mLogging.println(localStringBuilder.toString());
        }
        localMqqMessage.recycle();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          throwException(localThrowable);
        }
        if ((!DEBUG_QUEUE) || (!QLog.isColorLevel())) {
          break label420;
        }
        QLog.d("MqqMessage.Queue", 2, "dequeue, msg = null");
      }
      if ((DEBUG_QUEUE) && (this.msgCount % 100L == 0L) && (QLog.isColorLevel())) {
        QLog.d("MqqMessage.Queue", 2, new Object[] { "dequeue|", Long.valueOf(this.msgCount), "|", Long.valueOf(this.totalCost) });
      }
      if (localMqqMessage == null) {
        break;
      }
      if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
        QLog.d("MqqMessage.Queue", 2, new Object[] { "dequeue, msg = ", str });
      }
      return true;
    }
    label420:
    return false;
  }
  
  public static MqqMessageQueue getSubMainThreadQueue()
  {
    try
    {
      if (sSubMainQueue == null) {
        sSubMainQueue = new MqqMessageQueue(Looper.getMainLooper());
      }
      MqqMessageQueue localMqqMessageQueue = sSubMainQueue;
      return localMqqMessageQueue;
    }
    finally {}
  }
  
  private final void onQueueIdleTimeout()
  {
    if (dequeue(false)) {
      this.mHandler.sendEmptyMessage(1001);
    }
  }
  
  private void printDeletionLog(MqqMessage paramMqqMessage)
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, "removeMsg: " + paramMqqMessage.toString());
    }
  }
  
  private void reqHookIdleHandler()
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, new Object[] { "reqHook, attached = ", Boolean.valueOf(this.idleHandlerAttached), ", requested = ", Boolean.valueOf(this.hookReqeusted) });
    }
    if ((!this.idleHandlerAttached) && (!this.hookReqeusted))
    {
      this.hookReqeusted = true;
      this.mHandler.sendEmptyMessage(1000);
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
  }
  
  private void throwException(final Throwable paramThrowable)
  {
    new Thread()
    {
      public void run()
      {
        throw new RuntimeException("queueIdle encounter business crash. " + Log.getStackTraceString(paramThrowable));
      }
    }.start();
  }
  
  boolean enqueueMessage(MqqMessage paramMqqMessage, long paramLong)
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, "enqueueMessage: " + paramMqqMessage.toString());
    }
    for (;;)
    {
      MqqMessage localMqqMessage1;
      MqqMessage localMqqMessage2;
      try
      {
        paramMqqMessage.when = paramLong;
        localMqqMessage1 = this.mMessages;
        if ((localMqqMessage1 != null) && (paramLong != 0L) && (paramLong >= localMqqMessage1.when)) {
          break label145;
        }
        paramMqqMessage.next = localMqqMessage1;
        this.mMessages = paramMqqMessage;
        reqHookIdleHandler();
        return true;
      }
      finally {}
      if ((localMqqMessage1 != null) && (localMqqMessage1.when <= paramLong))
      {
        localMqqMessage2 = localMqqMessage1;
        localMqqMessage1 = localMqqMessage1.next;
      }
      else
      {
        paramMqqMessage.next = localMqqMessage2.next;
        localMqqMessage2.next = paramMqqMessage;
        continue;
        label145:
        localMqqMessage2 = null;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, new Object[] { "handleMessage, what = ", Integer.valueOf(paramMessage.what), ", attached = ", Boolean.valueOf(this.idleHandlerAttached) });
    }
    if (paramMessage.what == 1000)
    {
      if (!this.idleHandlerAttached)
      {
        cancelHookReq();
        this.idleHandlerAttached = true;
        this.mHandler.getLooper().getQueue().addIdleHandler(this);
      }
      this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
    }
    while (paramMessage.what != 1001) {
      return true;
    }
    onQueueIdleTimeout();
    return true;
  }
  
  final MqqMessage next()
  {
    for (;;)
    {
      try
      {
        long l1 = SystemClock.uptimeMillis();
        MqqMessage localMqqMessage = this.mMessages;
        if (localMqqMessage != null)
        {
          long l2 = localMqqMessage.when;
          if (l1 >= l2)
          {
            this.mMessages = localMqqMessage.next;
            localMqqMessage.next = null;
            return localMqqMessage;
          }
          int i = (int)Math.min(l2 - l1, 2147483647L);
          this.mHandler.removeMessages(1000);
          this.mHandler.sendEmptyMessageDelayed(1000, i);
          return null;
        }
      }
      finally {}
    }
  }
  
  public boolean queueIdle()
  {
    this.mHandler.removeMessages(1001);
    boolean bool = dequeue(true);
    if (bool)
    {
      this.mHandler.sendEmptyMessage(1000);
      return bool;
    }
    this.idleHandlerAttached = false;
    return bool;
  }
  
  void removeCallbacksAndMessages(MqqHandler paramMqqHandler, Object paramObject)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.mMessages;
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((MqqMessage)localObject1).target == paramMqqHandler) {
            if (paramObject != null)
            {
              localObject2 = localObject1;
              if (((MqqMessage)localObject1).wrappedMsg.obj != paramObject) {}
            }
            else
            {
              localObject2 = ((MqqMessage)localObject1).next;
              this.mMessages = ((MqqMessage)localObject2);
              printDeletionLog((MqqMessage)localObject1);
              ((MqqMessage)localObject1).recycle();
              localObject1 = localObject2;
              continue;
            }
          }
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((MqqMessage)localObject2).next;
        if ((localObject1 != null) && (((MqqMessage)localObject1).target == paramMqqHandler) && ((paramObject == null) || (((MqqMessage)localObject1).wrappedMsg.obj == paramObject)))
        {
          MqqMessage localMqqMessage = ((MqqMessage)localObject1).next;
          printDeletionLog((MqqMessage)localObject1);
          ((MqqMessage)localObject1).recycle();
          ((MqqMessage)localObject2).next = localMqqMessage;
        }
        else
        {
          localObject2 = localObject1;
        }
      }
      finally {}
    }
  }
  
  final void removeMessages(MqqHandler paramMqqHandler, Runnable paramRunnable, Object paramObject)
  {
    if (paramRunnable == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.mMessages;
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((MqqMessage)localObject1).target == paramMqqHandler)
          {
            localObject2 = localObject1;
            if (((MqqMessage)localObject1).wrappedMsg.getCallback() == paramRunnable) {
              if (paramObject != null)
              {
                localObject2 = localObject1;
                if (((MqqMessage)localObject1).wrappedMsg.obj != paramObject) {}
              }
              else
              {
                localObject2 = ((MqqMessage)localObject1).next;
                this.mMessages = ((MqqMessage)localObject2);
                printDeletionLog((MqqMessage)localObject1);
                ((MqqMessage)localObject1).recycle();
                localObject1 = localObject2;
                continue;
              }
            }
          }
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((MqqMessage)localObject2).next;
        if ((localObject1 != null) && (((MqqMessage)localObject1).target == paramMqqHandler) && (((MqqMessage)localObject1).wrappedMsg.getCallback() == paramRunnable) && ((paramObject == null) || (((MqqMessage)localObject1).wrappedMsg.obj == paramObject)))
        {
          MqqMessage localMqqMessage = ((MqqMessage)localObject1).next;
          printDeletionLog((MqqMessage)localObject1);
          ((MqqMessage)localObject1).recycle();
          ((MqqMessage)localObject2).next = localMqqMessage;
        }
        else
        {
          localObject2 = localObject1;
        }
      }
      finally {}
    }
  }
  
  boolean removeMessages(MqqHandler paramMqqHandler, int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool2;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = this.mMessages;
        boolean bool1 = false;
        bool2 = bool1;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          bool2 = bool1;
          localObject2 = localObject1;
          if (((MqqMessage)localObject1).target == paramMqqHandler)
          {
            bool2 = bool1;
            localObject2 = localObject1;
            if (((MqqMessage)localObject1).wrappedMsg.what == paramInt) {
              if (paramObject != null)
              {
                bool2 = bool1;
                localObject2 = localObject1;
                if (((MqqMessage)localObject1).wrappedMsg.obj != paramObject) {}
              }
              else
              {
                if (!paramBoolean) {
                  return true;
                }
                bool1 = true;
                localObject2 = ((MqqMessage)localObject1).next;
                this.mMessages = ((MqqMessage)localObject2);
                printDeletionLog((MqqMessage)localObject1);
                ((MqqMessage)localObject1).recycle();
                localObject1 = localObject2;
                continue;
                bool2 = true;
                MqqMessage localMqqMessage = ((MqqMessage)localObject1).next;
                printDeletionLog((MqqMessage)localObject1);
                ((MqqMessage)localObject1).recycle();
                ((MqqMessage)localObject2).next = localMqqMessage;
              }
            }
          }
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((MqqMessage)localObject2).next;
        if ((localObject1 != null) && (((MqqMessage)localObject1).target == paramMqqHandler) && (((MqqMessage)localObject1).wrappedMsg.what == paramInt) && ((paramObject == null) || (((MqqMessage)localObject1).wrappedMsg.obj == paramObject)))
        {
          if (paramBoolean) {
            continue;
          }
          return true;
        }
      }
      finally {}
      Object localObject2 = localObject1;
    }
    return bool2;
  }
  
  public void setDetailLogging(boolean paramBoolean)
  {
    DEBUG_QUEUE = paramBoolean;
    MqqMessage.DEBUG_MESSAGE = paramBoolean;
  }
  
  public void setMessageLogging(Printer paramPrinter)
  {
    this.mLogging = paramPrinter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.os.MqqMessageQueue
 * JD-Core Version:    0.7.0.1
 */