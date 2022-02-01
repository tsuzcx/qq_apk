package com.tencent.videocut.utils.thread;

import android.os.Process;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/utils/thread/PriorityThreadFactory$newThread$1", "Ljava/lang/Thread;", "run", "", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class PriorityThreadFactory$newThread$1
  extends Thread
{
  PriorityThreadFactory$newThread$1(Runnable paramRunnable1, Runnable paramRunnable2, String paramString)
  {
    super(paramString, str);
  }
  
  public void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.a(this.this$0));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.PriorityThreadFactory.newThread.1
 * JD-Core Version:    0.7.0.1
 */