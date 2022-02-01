package cooperation.qzone.thread;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseHandler
  extends Handler
{
  static ThreadLocal<Integer> InitalPriority = new BaseHandler.2();
  private static final String TAG = "BaseHandler";
  private static final long Time_Lv1 = 20L;
  private static final long Time_Lv2 = 100L;
  private static final long Time_Lv3 = 500L;
  static volatile boolean isBusy;
  static ThreadLocal<Boolean> isRegulated = new BaseHandler.3();
  static AtomicInteger regulalteCount = new AtomicInteger(0);
  static Runnable regultorPriority = new BaseHandler.4();
  static Runnable resetPriority = new BaseHandler.5();
  private Handler.Callback mCallbackEx;
  
  public BaseHandler() {}
  
  public BaseHandler(Looper paramLooper)
  {
    super(paramLooper);
    if (Looper.getMainLooper() != paramLooper) {
      paramLooper.setMessageLogging(new BaseHandler.1(this));
    }
  }
  
  public BaseHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
    this.mCallbackEx = paramCallback;
  }
  
  private void checkBusyState()
  {
    if ((isBusy) && (!((Boolean)isRegulated.get()).booleanValue()))
    {
      regultorPriority.run();
      return;
    }
    if ((!isBusy) && (((Boolean)isRegulated.get()).booleanValue())) {
      resetPriority.run();
    }
  }
  
  private void doAfterWord()
  {
    checkBusyState();
  }
  
  private void doBeforWork()
  {
    checkBusyState();
  }
  
  private static int getRegulatePriority(String paramString)
  {
    if ("Business_HandlerThread".equals(paramString)) {
      return -1;
    }
    return 10;
  }
  
  public static void markBusyState()
  {
    QLog.i("BaseHandler", 2, "markBusyState");
    isBusy = true;
  }
  
  private static boolean needRegulated()
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "threadRegulateEnable", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    return Looper.getMainLooper() != Looper.myLooper();
  }
  
  private void printDispatchInfo(long paramLong, Message paramMessage)
  {
    Object localObject2 = " Message What:";
    Object localObject1 = localObject2;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append(" Message What:");
      localObject1 = localObject2;
      localStringBuilder.append(paramMessage.what);
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      if (paramMessage.getCallback() != null)
      {
        localObject1 = localObject2;
        localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append((String)localObject2);
        localObject1 = localObject2;
        localStringBuilder.append(" Runnable-");
        localObject1 = localObject2;
        localStringBuilder.append(paramMessage.getCallback().getClass().toString());
        localObject1 = localObject2;
        paramMessage = localStringBuilder.toString();
      }
      else
      {
        localObject1 = localObject2;
        if (this.mCallbackEx != null)
        {
          localObject1 = localObject2;
          paramMessage = new StringBuilder();
          localObject1 = localObject2;
          paramMessage.append((String)localObject2);
          localObject1 = localObject2;
          paramMessage.append(" Callback-");
          localObject1 = localObject2;
          paramMessage.append(this.mCallbackEx.getClass().toString());
          localObject1 = localObject2;
          paramMessage = paramMessage.toString();
        }
        else
        {
          localObject1 = localObject2;
          paramMessage = new StringBuilder();
          localObject1 = localObject2;
          paramMessage.append((String)localObject2);
          localObject1 = localObject2;
          paramMessage.append(" handleMessage-");
          localObject1 = localObject2;
          paramMessage.append(getClass().toString());
          localObject1 = localObject2;
          paramMessage = paramMessage.toString();
        }
      }
    }
    catch (Exception paramMessage)
    {
      QLog.w("BaseHandler", 1, "printDispatchInfo", paramMessage);
      paramMessage = (Message)localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DispatchMessage-");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    ((StringBuilder)localObject1).append(":");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (paramLong > 500L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("ms ");
      ((StringBuilder)localObject2).append(paramMessage);
      QLog.e("BaseHandler", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (paramLong > 100L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("ms ");
      ((StringBuilder)localObject2).append(paramMessage);
      QLog.w("BaseHandler", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (paramLong > 20L)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("ms ");
        ((StringBuilder)localObject2).append(paramMessage);
        QLog.i("BaseHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("ms ");
      ((StringBuilder)localObject2).append(paramMessage);
      QLog.d("BaseHandler", 4, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void printSendInfo(long paramLong, Message paramMessage)
  {
    Object localObject2 = " Message What:";
    Object localObject1 = localObject2;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = localObject2;
      localStringBuilder.append(" Message What:");
      localObject1 = localObject2;
      localStringBuilder.append(paramMessage.what);
      localObject1 = localObject2;
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      if (paramMessage.getCallback() != null)
      {
        localObject1 = localObject2;
        localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append((String)localObject2);
        localObject1 = localObject2;
        localStringBuilder.append(" Runnable-");
        localObject1 = localObject2;
        localStringBuilder.append(paramMessage.getCallback().getClass().toString());
        localObject1 = localObject2;
        paramMessage = localStringBuilder.toString();
      }
      else
      {
        localObject1 = localObject2;
        if (this.mCallbackEx != null)
        {
          localObject1 = localObject2;
          paramMessage = new StringBuilder();
          localObject1 = localObject2;
          paramMessage.append((String)localObject2);
          localObject1 = localObject2;
          paramMessage.append(" Callback-");
          localObject1 = localObject2;
          paramMessage.append(this.mCallbackEx.getClass().toString());
          localObject1 = localObject2;
          paramMessage = paramMessage.toString();
        }
        else
        {
          localObject1 = localObject2;
          paramMessage = new StringBuilder();
          localObject1 = localObject2;
          paramMessage.append((String)localObject2);
          localObject1 = localObject2;
          paramMessage.append(" handleMessage-");
          localObject1 = localObject2;
          paramMessage.append(getClass().toString());
          localObject1 = localObject2;
          paramMessage = paramMessage.toString();
        }
      }
    }
    catch (Exception paramMessage)
    {
      QLog.w("BaseHandler", 1, "printSendInfo", paramMessage);
      paramMessage = (Message)localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" SendMessage-");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    ((StringBuilder)localObject1).append(":");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (paramLong > 500L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("ms ");
      ((StringBuilder)localObject2).append(paramMessage);
      QLog.e("BaseHandler", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (paramLong > 100L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("ms ");
      ((StringBuilder)localObject2).append(paramMessage);
      QLog.w("BaseHandler", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (paramLong > 20L)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("ms ");
        ((StringBuilder)localObject2).append(paramMessage);
        QLog.i("BaseHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("ms ");
      ((StringBuilder)localObject2).append(paramMessage);
      QLog.d("BaseHandler", 4, ((StringBuilder)localObject2).toString());
    }
  }
  
  private static boolean setThreadPrioriry(int paramInt)
  {
    if ((paramInt >= -19) && (paramInt <= 19))
    {
      Process.setThreadPriority(paramInt);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setThreadPrioriry priority :");
      localStringBuilder.append(paramInt);
      QLog.i("BaseHandler", 1, localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setThreadPrioriry priority 非法:");
    localStringBuilder.append(paramInt);
    QLog.w("BaseHandler", 1, localStringBuilder.toString());
    return false;
  }
  
  public static void unMarkBusyState()
  {
    QLog.i("BaseHandler", 2, "unMarkBusyState");
    isBusy = false;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    long l = SystemClock.uptimeMillis();
    QzoneThreadMonitor.getInstance().beginHandle(this, paramMessage, l);
    super.dispatchMessage(paramMessage);
    l = SystemClock.uptimeMillis();
    QzoneThreadMonitor.getInstance().finishHandle(this, paramMessage, l);
  }
  
  public Handler.Callback getCallbackEx()
  {
    return this.mCallbackEx;
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    QzoneThreadMonitor.getInstance().enqueue(this, paramMessage, paramLong);
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.thread.BaseHandler
 * JD-Core Version:    0.7.0.1
 */