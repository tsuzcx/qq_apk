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
    if (MultiVoiceFloatingWindowModule.b(this.this$0.a.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizMutil_voiceMultiVoiceFloatingWindowModule))
    {
      if (!FloatWindowModule.canBackgroundStart(this.this$0.a.jdField_a_of_type_AndroidContentContext)) {
        ThreadCenter.postUITask((ThreadCenter.HandlerKeyable)this.this$0.a.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizMutil_voiceMultiVoiceFloatingWindowModule, MultiVoiceFloatingWindowModule.a(this.this$0.a.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizMutil_voiceMultiVoiceFloatingWindowModule));
      }
    }
    else {
      ThreadCenter.postDelayedUITask((ThreadCenter.HandlerKeyable)this.this$0.a.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizMutil_voiceMultiVoiceFloatingWindowModule, MultiVoiceFloatingWindowModule.b(this.this$0.a.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizMutil_voiceMultiVoiceFloatingWindowModule), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1.1.1
 * JD-Core Version:    0.7.0.1
 */