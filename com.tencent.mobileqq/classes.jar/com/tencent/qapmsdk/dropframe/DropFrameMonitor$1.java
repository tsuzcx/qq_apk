package com.tencent.qapmsdk.dropframe;

import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;

class DropFrameMonitor$1
  implements Handler.Callback
{
  DropFrameMonitor$1(DropFrameMonitor paramDropFrameMonitor) {}
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = ((Long)paramMessage.obj).longValue();
      int j = (int)(l / 16666667L) - 1;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = DropFrameMonitor.access$000(this.this$0, i);
      paramMessage = DropFrameMonitor.access$100(this.this$0).dropIntervals;
      paramMessage[j] += 1L;
      paramMessage = DropFrameMonitor.access$100(this.this$0);
      paramMessage.dropCount = (i + paramMessage.dropCount);
      paramMessage = DropFrameMonitor.access$100(this.this$0);
      float f = paramMessage.duration;
      paramMessage.duration = ((float)l + f);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor.1
 * JD-Core Version:    0.7.0.1
 */