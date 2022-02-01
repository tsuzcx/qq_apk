package cooperation.qzone.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

class QzoneThreadMonitor$1
  extends Handler
{
  QzoneThreadMonitor$1(QzoneThreadMonitor paramQzoneThreadMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    QzoneThreadMonitor.MessageInfo localMessageInfo = (QzoneThreadMonitor.MessageInfo)paramMessage.obj;
    if (!QzoneThreadMonitor.access$000(this.this$0).containsKey(localMessageInfo.id))
    {
      QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage has been canceled. id=", localMessageInfo.id });
      return;
    }
    if (paramMessage.arg1 >= 10)
    {
      QZLog.w("QzoneThreadMonitor", 1, new Object[] { "stack check for too many times. id=", localMessageInfo.id });
      return;
    }
    Object localObject = QzoneHandlerThreadFactory.getHandlerThreadLooper(localMessageInfo.threadName).getThread().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localMessageInfo.threadName);
    localStringBuilder.append(" id=");
    localStringBuilder.append(localMessageInfo.id);
    localStringBuilder.append(": ");
    localObject = QzoneThreadMonitor.access$100((StackTraceElement[])localObject, localStringBuilder.toString());
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[stack] ", localMessageInfo.threadName, " id=", localMessageInfo.id, " what=", Integer.valueOf(localMessageInfo.what), " msg.target=", localMessageInfo.target, " msg.callback=", localMessageInfo.callback });
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { localObject });
    paramMessage = Message.obtain(QzoneThreadMonitor.access$200(this.this$0), 1, paramMessage.arg1 + 1, 0, localMessageInfo);
    localObject = QzoneThreadMonitor.access$200(this.this$0);
    long l;
    if (localMessageInfo.type == 1) {
      l = 500L;
    } else {
      l = 250L;
    }
    ((Handler)localObject).sendMessageDelayed(paramMessage, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor.1
 * JD-Core Version:    0.7.0.1
 */