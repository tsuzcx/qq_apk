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
    switch (paramMessage.what)
    {
    default: 
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
    Object localObject = QzoneThreadMonitor.access$100(QzoneHandlerThreadFactory.getHandlerThreadLooper(localMessageInfo.threadName).getThread().getStackTrace(), localMessageInfo.threadName + " id=" + localMessageInfo.id + ": ");
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[stack] ", localMessageInfo.threadName, " id=", localMessageInfo.id, " what=", Integer.valueOf(localMessageInfo.what), " msg.target=", localMessageInfo.target, " msg.callback=", localMessageInfo.callback });
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { localObject });
    paramMessage = Message.obtain(QzoneThreadMonitor.access$200(this.this$0), 1, paramMessage.arg1 + 1, 0, localMessageInfo);
    localObject = QzoneThreadMonitor.access$200(this.this$0);
    if (localMessageInfo.type == 1) {}
    for (long l = 500L;; l = 250L)
    {
      ((Handler)localObject).sendMessageDelayed(paramMessage, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor.1
 * JD-Core Version:    0.7.0.1
 */