package cooperation.qzone.thread;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import bmhw;
import bmhx;
import bmhy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseHandler
  extends Handler
{
  static ThreadLocal<Integer> InitalPriority = new bmhx();
  private static final String TAG = "BaseHandler";
  private static final long Time_Lv1 = 20L;
  private static final long Time_Lv2 = 100L;
  private static final long Time_Lv3 = 500L;
  public static volatile boolean isBusy;
  public static ThreadLocal<Boolean> isRegulated = new bmhy();
  static AtomicInteger regulalteCount = new AtomicInteger(0);
  static Runnable regultorPriority = new BaseHandler.4();
  static Runnable resetPriority = new BaseHandler.5();
  private Handler.Callback mCallbackEx;
  
  public BaseHandler() {}
  
  public BaseHandler(Looper paramLooper)
  {
    super(paramLooper);
    if (Looper.getMainLooper() != paramLooper) {
      paramLooper.setMessageLogging(new bmhw(this));
    }
  }
  
  public BaseHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
    this.mCallbackEx = paramCallback;
  }
  
  private void checkBusyState()
  {
    if ((isBusy) && (!((Boolean)isRegulated.get()).booleanValue())) {
      regultorPriority.run();
    }
    while ((isBusy) || (!((Boolean)isRegulated.get()).booleanValue())) {
      return;
    }
    resetPriority.run();
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
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "threadRegulateEnable", 1) == 1)
    {
      i = 1;
      if (i != 0) {
        break label28;
      }
    }
    label28:
    while (Looper.getMainLooper() == Looper.myLooper())
    {
      return false;
      i = 0;
      break;
    }
    return true;
  }
  
  private void printDispatchInfo(long paramLong, Message paramMessage)
  {
    Object localObject = " Message What:";
    for (;;)
    {
      try
      {
        str = " Message What:" + paramMessage.what;
        localObject = str;
        if (paramMessage.getCallback() == null) {
          continue;
        }
        localObject = str;
        paramMessage = str + " Runnable-" + paramMessage.getCallback().getClass().toString();
      }
      catch (Exception localException)
      {
        String str;
        paramMessage = (Message)localObject;
        QLog.w("BaseHandler", 1, "printDispatchInfo", localException);
        continue;
        if (paramLong <= 100L) {
          continue;
        }
        QLog.w("BaseHandler", 1, (String)localObject + paramLong + "ms " + paramMessage);
        return;
        if (paramLong <= 20L) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("BaseHandler", 2, (String)localObject + paramLong + "ms " + paramMessage);
        return;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("BaseHandler", 4, (String)localObject + paramLong + "ms " + paramMessage);
      }
      localObject = "DispatchMessage-" + Thread.currentThread().getName() + ":";
      if (paramLong <= 500L) {
        continue;
      }
      QLog.e("BaseHandler", 1, (String)localObject + paramLong + "ms " + paramMessage);
      return;
      localObject = str;
      if (this.mCallbackEx != null)
      {
        localObject = str;
        paramMessage = str + " Callback-" + this.mCallbackEx.getClass().toString();
      }
      else
      {
        localObject = str;
        paramMessage = str + " handleMessage-" + getClass().toString();
      }
    }
  }
  
  private void printSendInfo(long paramLong, Message paramMessage)
  {
    Object localObject = " Message What:";
    for (;;)
    {
      try
      {
        str = " Message What:" + paramMessage.what;
        localObject = str;
        if (paramMessage.getCallback() == null) {
          continue;
        }
        localObject = str;
        paramMessage = str + " Runnable-" + paramMessage.getCallback().getClass().toString();
      }
      catch (Exception localException)
      {
        String str;
        paramMessage = (Message)localObject;
        QLog.w("BaseHandler", 1, "printSendInfo", localException);
        continue;
        if (paramLong <= 100L) {
          continue;
        }
        QLog.w("BaseHandler", 1, (String)localObject + paramLong + "ms " + paramMessage);
        return;
        if (paramLong <= 20L) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("BaseHandler", 2, (String)localObject + paramLong + "ms " + paramMessage);
        return;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("BaseHandler", 4, (String)localObject + paramLong + "ms " + paramMessage);
      }
      localObject = " SendMessage-" + Thread.currentThread().getName() + ":";
      if (paramLong <= 500L) {
        continue;
      }
      QLog.e("BaseHandler", 1, (String)localObject + paramLong + "ms " + paramMessage);
      return;
      localObject = str;
      if (this.mCallbackEx != null)
      {
        localObject = str;
        paramMessage = str + " Callback-" + this.mCallbackEx.getClass().toString();
      }
      else
      {
        localObject = str;
        paramMessage = str + " handleMessage-" + getClass().toString();
      }
    }
  }
  
  private static boolean setThreadPrioriry(int paramInt)
  {
    if ((paramInt >= -19) && (paramInt <= 19))
    {
      Process.setThreadPriority(paramInt);
      QLog.i("BaseHandler", 1, "setThreadPrioriry priority :" + paramInt);
      return true;
    }
    QLog.w("BaseHandler", 1, "setThreadPrioriry priority 非法:" + paramInt);
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