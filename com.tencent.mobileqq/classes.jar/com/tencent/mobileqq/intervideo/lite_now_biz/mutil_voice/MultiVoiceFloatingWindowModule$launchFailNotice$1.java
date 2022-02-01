package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.livesdk.roomengine.RoomEngine;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MultiVoiceFloatingWindowModule$launchFailNotice$1
  implements Runnable
{
  MultiVoiceFloatingWindowModule$launchFailNotice$1(MultiVoiceFloatingWindowModule paramMultiVoiceFloatingWindowModule) {}
  
  public final void run()
  {
    if (!MultiVoiceFloatingWindowModule.e(this.this$0)) {
      ((ToastInterface)this.this$0.getRoomEngine().getService(ToastInterface.class)).showToast("正在返回直播间，请耐心等待", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.launchFailNotice.1
 * JD-Core Version:    0.7.0.1
 */