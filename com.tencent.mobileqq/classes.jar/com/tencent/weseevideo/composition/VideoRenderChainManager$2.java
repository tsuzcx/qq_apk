package com.tencent.weseevideo.composition;

import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.weseevideo.editor.sticker.WsPicStickerContext;

class VideoRenderChainManager$2
  implements ITAVRenderContextDataSource
{
  VideoRenderChainManager$2(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if ((WsPicStickerContext.isBlurSticker(paramTAVSticker)) && (paramTAVSticker.getMode() != TAVStickerMode.ACTIVE)) {
      return true;
    }
    if (VideoRenderChainManager.access$000(this.a) != null) {
      return VideoRenderChainManager.access$000(this.a).shouldRenderSticker(paramTAVSticker, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager.2
 * JD-Core Version:    0.7.0.1
 */