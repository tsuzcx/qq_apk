package com.tencent.vas.update.module.thread;

import android.text.TextUtils;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonThreadFactory
  implements ThreadFactory
{
  private static final String TAG = "VasUpdate_ThreadFactory";
  public static final AtomicInteger poolNumber = new AtomicInteger(1);
  public final ThreadGroup group = new ThreadGroup("vas_update_system");
  public final String namePrefix;
  public final AtomicInteger threadNumber = new AtomicInteger(1);
  
  public CommonThreadFactory(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("pool-").append(poolNumber.getAndIncrement());
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "-" + paramString)
    {
      this.namePrefix = (paramString + "-thread-");
      return;
    }
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 1) {
      paramRunnable.setPriority(1);
    }
    VasUpdateWrapper.getLog().d("VasUpdate_ThreadFactory", "new thread: " + paramRunnable.getName() + ", id: " + paramRunnable.getId() + " is created.");
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.thread.CommonThreadFactory
 * JD-Core Version:    0.7.0.1
 */