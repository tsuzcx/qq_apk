package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class BlackScreenMonitor$checkBlackScreen$1
  implements Runnable
{
  BlackScreenMonitor$checkBlackScreen$1(BlackScreenMonitor paramBlackScreenMonitor, int[] paramArrayOfInt, long paramLong) {}
  
  public final void run()
  {
    int[] arrayOfInt = this.$bitmapBuffer;
    int k = 0;
    int m = arrayOfInt[0];
    int n = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int j = 1;
      if (i >= n) {
        break;
      }
      if (arrayOfInt[i] != m) {
        j = 0;
      }
      if (j == 0)
      {
        i = k;
        break label61;
      }
      i += 1;
    }
    i = 1;
    label61:
    if (i != 0)
    {
      BlackScreenMonitor.access$getLastBlackTimeHolder$p(this.this$0).setValue(Long.valueOf(this.$now));
      return;
    }
    BlackScreenMonitor.access$getLastBlackTimeHolder$p(this.this$0).setValue(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.BlackScreenMonitor.checkBlackScreen.1
 * JD-Core Version:    0.7.0.1
 */