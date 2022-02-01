package com.tencent.timi.game.trtc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoomManager;

class TRTCMultipeVoiceRoomTestActivity$1
  implements View.OnClickListener
{
  TRTCMultipeVoiceRoomTestActivity$1(TRTCMultipeVoiceRoomTestActivity paramTRTCMultipeVoiceRoomTestActivity) {}
  
  public void onClick(View paramView)
  {
    TRTCMultipeVoiceRoomTestActivity.c(this.a).a(TRTCMultipeVoiceRoomTestActivity.a(this.a), TRTCMultipeVoiceRoomTestActivity.b(this.a), 3, new TRTCMultipeVoiceRoomTestActivity.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.1
 * JD-Core Version:    0.7.0.1
 */