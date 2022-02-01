package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.cmshow.crossengine.CEEngineContext;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FrameRecorderPlugin$startRecord$1
  implements Runnable
{
  FrameRecorderPlugin$startRecord$1(FrameRecorderPlugin paramFrameRecorderPlugin) {}
  
  public final void run()
  {
    IRecordFrameListener localIRecordFrameListener = this.this$0.e().f().b();
    if (localIRecordFrameListener != null) {
      localIRecordFrameListener.a(0.0666667F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.FrameRecorderPlugin.startRecord.1
 * JD-Core Version:    0.7.0.1
 */