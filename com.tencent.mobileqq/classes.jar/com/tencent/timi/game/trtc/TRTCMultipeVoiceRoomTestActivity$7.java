package com.tencent.timi.game.trtc;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.ITrtcCheckResult;

class TRTCMultipeVoiceRoomTestActivity$7
  implements TimiGameQQTrtcUtil.ITrtcCheckResult
{
  TRTCMultipeVoiceRoomTestActivity$7(TRTCMultipeVoiceRoomTestActivity paramTRTCMultipeVoiceRoomTestActivity) {}
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new TRTCMultipeVoiceRoomTestActivity.7.1(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TRTCMultipeVoiceRoomTestActivity.7.2(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.7
 * JD-Core Version:    0.7.0.1
 */