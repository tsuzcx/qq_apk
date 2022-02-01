package com.tencent.timi.game.trtc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoom;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoomManager;

class TRTCMultipeVoiceRoomTestActivity$4
  implements View.OnClickListener
{
  TRTCMultipeVoiceRoomTestActivity$4(TRTCMultipeVoiceRoomTestActivity paramTRTCMultipeVoiceRoomTestActivity) {}
  
  public void onClick(View paramView)
  {
    if (TRTCMultipeVoiceRoomTestActivity.c(this.a).a(TRTCMultipeVoiceRoomTestActivity.a(this.a)).g()) {
      TRTCMultipeVoiceRoomTestActivity.c(this.a).f(TRTCMultipeVoiceRoomTestActivity.a(this.a));
    } else {
      TRTCMultipeVoiceRoomTestActivity.c(this.a).g(TRTCMultipeVoiceRoomTestActivity.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.4
 * JD-Core Version:    0.7.0.1
 */