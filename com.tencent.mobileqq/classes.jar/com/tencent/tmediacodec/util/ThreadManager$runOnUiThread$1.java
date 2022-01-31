package com.tencent.tmediacodec.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class ThreadManager$runOnUiThread$1
  extends Lambda
  implements Function0<Unit>
{
  ThreadManager$runOnUiThread$1(Runnable paramRunnable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$runnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ThreadManager.runOnUiThread.1
 * JD-Core Version:    0.7.0.1
 */