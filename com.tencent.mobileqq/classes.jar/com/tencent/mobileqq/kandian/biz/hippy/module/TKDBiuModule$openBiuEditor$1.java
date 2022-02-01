package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDBiuModule$openBiuEditor$1
  implements Runnable
{
  TKDBiuModule$openBiuEditor$1(TKDBiuModule paramTKDBiuModule, Activity paramActivity, String paramString1, long paramLong, String paramString2) {}
  
  public final void run()
  {
    ITKDHippyEventDispatcher localITKDHippyEventDispatcher = TKDBiuModule.access$getHippyEventDispatcher$p(this.this$0);
    if (localITKDHippyEventDispatcher != null) {
      localITKDHippyEventDispatcher.biuComment((ParamsFetcher)new TKDBiuModule.openBiuEditor.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDBiuModule.openBiuEditor.1
 * JD-Core Version:    0.7.0.1
 */