package com.tencent.thumbplayer.adapter.player.thumbplayer;

import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;

class TPThumbPlayer$3
  implements ITPNativePlayerVideoFrameCallback
{
  TPThumbPlayer$3(TPThumbPlayer paramTPThumbPlayer) {}
  
  public void onVideoFrame(TPVideoFrame paramTPVideoFrame, int paramInt)
  {
    paramTPVideoFrame = TPThumbPlayerUtils.convert2TPVideoFrameBuffer(paramTPVideoFrame);
    TPThumbPlayer.access$200(this.this$0).onVideoFrameOut(paramTPVideoFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.3
 * JD-Core Version:    0.7.0.1
 */