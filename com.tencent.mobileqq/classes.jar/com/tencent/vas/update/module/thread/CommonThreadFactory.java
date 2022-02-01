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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("pool-");
    localStringBuilder1.append(poolNumber.getAndIncrement());
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("-");
      localStringBuilder2.append(paramString);
      paramString = localStringBuilder2.toString();
    }
    localStringBuilder1.append(paramString);
    localStringBuilder1.append("-thread-");
    this.namePrefix = localStringBuilder1.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Object localObject = this.group;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.namePrefix);
    localStringBuilder.append(this.threadNumber.getAndIncrement());
    paramRunnable = new Thread((ThreadGroup)localObject, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 1) {
      paramRunnable.setPriority(1);
    }
    localObject = VasUpdateWrapper.getLog();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("new thread: ");
    localStringBuilder.append(paramRunnable.getName());
    localStringBuilder.append(", id: ");
    localStringBuilder.append(paramRunnable.getId());
    localStringBuilder.append(" is created.");
    ((IVasLog)localObject).d("VasUpdate_ThreadFactory", localStringBuilder.toString());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.thread.CommonThreadFactory
 * JD-Core Version:    0.7.0.1
 */