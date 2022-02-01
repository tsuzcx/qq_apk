package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/event/MultiVoicePageEvent;", "onChanged"}, k=3, mv={1, 1, 16})
final class MultiVoiceFloatingWindowModule$multiVoicePageObserver$1<T>
  implements Observer<MultiVoicePageEvent>
{
  MultiVoiceFloatingWindowModule$multiVoicePageObserver$1(MultiVoiceFloatingWindowModule paramMultiVoiceFloatingWindowModule) {}
  
  public final void a(@Nullable MultiVoicePageEvent paramMultiVoicePageEvent)
  {
    if ((paramMultiVoicePageEvent != null) && (paramMultiVoicePageEvent.a == 1))
    {
      MultiVoiceFloatingWindowModule.d(this.a, false);
      return;
    }
    if ((paramMultiVoicePageEvent != null) && (paramMultiVoicePageEvent.a == 0))
    {
      MultiVoiceFloatingWindowModule.c(this.a, true);
      MultiVoiceFloatingWindowModule.p(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.multiVoicePageObserver.1
 * JD-Core Version:    0.7.0.1
 */