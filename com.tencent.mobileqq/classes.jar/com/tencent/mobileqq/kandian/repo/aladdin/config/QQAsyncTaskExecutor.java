package com.tencent.mobileqq.kandian.repo.aladdin.config;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class QQAsyncTaskExecutor
  implements AsyncTaskExecutor
{
  public static final QQAsyncTaskExecutor a = new QQAsyncTaskExecutor();
  private volatile Handler b = null;
  
  public void execute(Runnable paramRunnable)
  {
    if (this.b == null) {
      try
      {
        Object localObject = this.b;
        if (localObject == null) {
          try
          {
            localObject = ThreadManagerV2.newFreeHandlerThread("readinjoy-common-aladdin-load", 0);
            ((HandlerThread)localObject).start();
            this.b = new Handler(((HandlerThread)localObject).getLooper());
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            QLog.e("QQAsyncTaskExecutor", 2, localOutOfMemoryError, new Object[0]);
            this.b = new Handler(ThreadManagerV2.getFileThreadLooper());
          }
        }
      }
      finally {}
    }
    this.b.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.config.QQAsyncTaskExecutor
 * JD-Core Version:    0.7.0.1
 */