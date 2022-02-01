package com.tencent.qapmsdk.dropframe;

import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;

class DropFrameMonitor$2
  implements Handler.Callback
{
  DropFrameMonitor$2(DropFrameMonitor paramDropFrameMonitor) {}
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = ((Long)paramMessage.obj).longValue();
      int j = (int)((l - DropFrameMonitor.access$100(this.this$0)) / DropFrameMonitor.access$100(this.this$0));
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = DropFrameMonitor.access$200(this.this$0, i);
      paramMessage = DropFrameMonitor.access$300(this.this$0).dropIntervals;
      paramMessage[j] += 1L;
      paramMessage = DropFrameMonitor.access$300(this.this$0);
      paramMessage.dropCount += i;
      paramMessage = DropFrameMonitor.access$300(this.this$0);
      paramMessage.duration += (float)l;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor.2
 * JD-Core Version:    0.7.0.1
 */