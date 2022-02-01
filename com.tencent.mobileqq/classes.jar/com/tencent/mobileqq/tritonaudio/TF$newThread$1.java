package com.tencent.mobileqq.tritonaudio;

import android.os.Process;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TF$newThread$1
  implements Runnable
{
  TF$newThread$1(TF paramTF, Runnable paramRunnable) {}
  
  public final void run()
  {
    Process.setThreadPriority(TF.access$getPriority$p(this.this$0));
    this.$runnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.TF.newThread.1
 * JD-Core Version:    0.7.0.1
 */