package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/MultiVoiceFloatingWindowModule$onCreate$1$1$invokePlayerContainer$clickListener$1$runnable$1"}, k=3, mv={1, 1, 16})
final class MultiVoiceFloatingWindowModule$onCreate$$inlined$apply$lambda$1$1$1
  implements Runnable
{
  MultiVoiceFloatingWindowModule$onCreate$$inlined$apply$lambda$1$1$1(MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1.1 param1) {}
  
  public final void run()
  {
    if (MultiVoiceFloatingWindowModule.e(this.this$0.a.b))
    {
      if (!FloatWindowModule.canBackgroundStart(this.this$0.a.c)) {
        ThreadCenter.postUITask((ThreadCenter.HandlerKeyable)this.this$0.a.b, MultiVoiceFloatingWindowModule.f(this.this$0.a.b));
      }
    }
    else {
      ThreadCenter.postDelayedUITask((ThreadCenter.HandlerKeyable)this.this$0.a.b, MultiVoiceFloatingWindowModule.g(this.this$0.a.b), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1.1.1
 * JD-Core Version:    0.7.0.1
 */