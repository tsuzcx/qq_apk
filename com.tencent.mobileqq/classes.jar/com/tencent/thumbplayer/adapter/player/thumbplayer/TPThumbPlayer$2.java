package com.tencent.thumbplayer.adapter.player.thumbplayer;

import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;

class TPThumbPlayer$2
  implements ITPNativePlayerAudioFrameCallback
{
  TPThumbPlayer$2(TPThumbPlayer paramTPThumbPlayer) {}
  
  public void onAudioFrame(TPAudioFrame paramTPAudioFrame, int paramInt)
  {
    paramTPAudioFrame = TPThumbPlayerUtils.convert2TPAudioFrameBuffer(paramTPAudioFrame);
    TPThumbPlayer.access$200(this.this$0).onAudioPcmOut(paramTPAudioFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.2
 * JD-Core Version:    0.7.0.1
 */