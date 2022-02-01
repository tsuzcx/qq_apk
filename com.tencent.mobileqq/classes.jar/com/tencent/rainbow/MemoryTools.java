package com.tencent.rainbow;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.rainbow.common.TaskThreadPool;
import java.util.concurrent.atomic.AtomicBoolean;

public class MemoryTools
{
  public static final String TAG = "MemoryTools";
  private int mLastMemorySize = 0;
  private final MemoryTools.MemoryQueryRunnable mMemoryRunnable = new MemoryTools.MemoryQueryRunnable(this);
  private final AtomicBoolean mNeedCanceled = new AtomicBoolean(false);
  
  public void cancelMemoryQuery()
  {
    this.mNeedCanceled.compareAndSet(false, true);
  }
  
  public long getApplicationMemory()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return Debug.getPss();
    }
    long l = 0L;
    try
    {
      Context localContext = RainbowPlugin.sContext;
      if (localContext != null)
      {
        int i = ((android.app.ActivityManager)localContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0].getTotalPss();
        l = i;
      }
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public void startMemoryQuery(MemoryInfoCallback paramMemoryInfoCallback)
  {
    this.mNeedCanceled.compareAndSet(true, false);
    this.mMemoryRunnable.a(paramMemoryInfoCallback);
    TaskThreadPool.getInstance().execute(this.mMemoryRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rainbow.MemoryTools
 * JD-Core Version:    0.7.0.1
 */