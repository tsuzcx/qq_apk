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
    int k = 0;
    int m = this.$bitmapBuffer[0];
    int[] arrayOfInt = this.$bitmapBuffer;
    int n = arrayOfInt.length;
    int i = 0;
    int j;
    if (i < n) {
      if (arrayOfInt[i] == m)
      {
        j = 1;
        label40:
        if (j != 0) {
          break label73;
        }
      }
    }
    for (i = k;; i = 1)
    {
      if (i == 0) {
        break label85;
      }
      BlackScreenMonitor.access$getLastBlackTimeHolder$p(this.this$0).setValue(Long.valueOf(this.$now));
      return;
      j = 0;
      break label40;
      label73:
      i += 1;
      break;
    }
    label85:
    BlackScreenMonitor.access$getLastBlackTimeHolder$p(this.this$0).setValue(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.BlackScreenMonitor.checkBlackScreen.1
 * JD-Core Version:    0.7.0.1
 */