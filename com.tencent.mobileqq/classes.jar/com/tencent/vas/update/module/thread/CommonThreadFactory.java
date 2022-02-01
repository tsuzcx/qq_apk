package com.tencent.vas.update.module.thread;

import android.text.TextUtils;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
  private static final String TAG = "VasUpdate_ThreadFactory";
  private final ThreadGroup mGroup = new ThreadGroup("vas_update_system");
  private final String mNamePrefix;
  private final AtomicInteger mTheadNumber = new AtomicInteger(1);
  
  public CommonThreadFactory(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("pool-");
    localStringBuilder1.append(POOL_NUMBER.getAndIncrement());
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
    this.mNamePrefix = localStringBuilder1.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Object localObject = this.mGroup;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mNamePrefix);
    localStringBuilder.append(this.mTheadNumber.getAndIncrement());
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
    ((IVasLog)localObject).a("VasUpdate_ThreadFactory", localStringBuilder.toString());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.thread.CommonThreadFactory
 * JD-Core Version:    0.7.0.1
 */