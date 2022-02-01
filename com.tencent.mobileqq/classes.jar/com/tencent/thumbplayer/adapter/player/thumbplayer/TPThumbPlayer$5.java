package com.tencent.thumbplayer.adapter.player.thumbplayer;

import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;

class TPThumbPlayer$5
  implements ITPNativePlayerPostProcessFrameCallback
{
  TPThumbPlayer$5(TPThumbPlayer paramTPThumbPlayer) {}
  
  public TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame paramTPPostProcessFrame, int paramInt)
  {
    TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = TPThumbPlayerUtils.convert2TPPostProcessFrameBuffer(paramTPPostProcessFrame);
    localTPPostProcessFrameBuffer.eventFlag = paramInt;
    if (paramTPPostProcessFrame.mediaType == 0) {
      return TPThumbPlayerUtils.convert2TPPostProcessFrame(TPThumbPlayer.access$200(this.this$0).onVideoProcessFrameOut(localTPPostProcessFrameBuffer));
    }
    if (paramTPPostProcessFrame.mediaType == 1) {
      return TPThumbPlayerUtils.convert2TPPostProcessFrame(TPThumbPlayer.access$200(this.this$0).onAudioProcessFrameOut(localTPPostProcessFrameBuffer));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.5
 * JD-Core Version:    0.7.0.1
 */