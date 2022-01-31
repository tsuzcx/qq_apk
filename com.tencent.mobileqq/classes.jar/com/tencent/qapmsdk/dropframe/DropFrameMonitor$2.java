package com.tencent.qapmsdk.dropframe;

import android.os.Handler;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.logger.Logger;

class DropFrameMonitor$2
  implements Choreographer.FrameCallback
{
  DropFrameMonitor$2(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void doFrame(long paramLong)
  {
    if ((DropFrameMonitor.access$200(this.this$0) == null) || (!PluginController.INSTANCE.canCollect(PluginCombination.dropFramePlugin.plugin))) {
      return;
    }
    try
    {
      DropFrameMonitor.access$200(this.this$0).postFrameCallback(DropFrameMonitor.access$300(this.this$0));
      if ((paramLong < DropFrameMonitor.access$400(this.this$0)) || (DropFrameMonitor.access$400(this.this$0) == 0L))
      {
        DropFrameMonitor.access$402(this.this$0, paramLong);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", localThrowable);
      }
      long l = DropFrameMonitor.access$400(this.this$0);
      DropFrameMonitor.access$402(this.this$0, paramLong);
      Message localMessage = DropFrameMonitor.access$500(this.this$0).obtainMessage();
      localMessage.what = 1;
      localMessage.obj = Long.valueOf(paramLong - l);
      DropFrameMonitor.access$500(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor.2
 * JD-Core Version:    0.7.0.1
 */