package com.tencent.thumbplayer.adapter.player.thumbplayer;

import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;

class TPThumbPlayer$4
  implements ITPNativePlayerSubtitleFrameCallback
{
  TPThumbPlayer$4(TPThumbPlayer paramTPThumbPlayer) {}
  
  public void onSubtitleFrame(TPSubtitleFrame paramTPSubtitleFrame, int paramInt)
  {
    paramTPSubtitleFrame = TPThumbPlayerUtils.convert2TPSubtitleFrameBuffer(paramTPSubtitleFrame);
    TPThumbPlayer.access$200(this.this$0).onSubtitleFrameOut(paramTPSubtitleFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.4
 * JD-Core Version:    0.7.0.1
 */