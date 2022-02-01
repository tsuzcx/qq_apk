package com.tencent.rainbow;

import android.util.Log;
import com.tencent.rainbow.common.TaskThreadPool;
import java.util.concurrent.atomic.AtomicBoolean;

class MemoryTools$MemoryQueryRunnable
  implements Runnable
{
  private MemoryInfoCallback a;
  
  MemoryTools$MemoryQueryRunnable(MemoryTools paramMemoryTools) {}
  
  public void a(MemoryInfoCallback paramMemoryInfoCallback)
  {
    this.a = paramMemoryInfoCallback;
  }
  
  public void run()
  {
    if (MemoryTools.access$000(this.this$0).get())
    {
      Log.d("MemoryTools", "MemoryQueryRunnable cancel");
      return;
    }
    int i = (int)(this.this$0.getApplicationMemory() / 1024L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("memory size: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" last memory size: ");
    localStringBuilder.append(MemoryTools.access$100(this.this$0));
    Log.d("MemoryTools", localStringBuilder.toString());
    if ((i != MemoryTools.access$100(this.this$0)) && (this.a != null))
    {
      MemoryTools.access$102(this.this$0, i);
      this.a.onGetMemoryInfo(i);
    }
    try
    {
      Thread.sleep(2000L);
      TaskThreadPool.getInstance().execute(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rainbow.MemoryTools.MemoryQueryRunnable
 * JD-Core Version:    0.7.0.1
 */