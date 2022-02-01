package com.tencent.qcircle.weseevideo.composition;

import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.model.TAVSticker;

class VideoRenderChainManager$3
  implements ITAVRenderContextDataSource
{
  VideoRenderChainManager$3(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (VideoRenderChainManager.access$000(this.this$0) != null) {
      return VideoRenderChainManager.access$000(this.this$0).shouldRenderSticker(paramTAVSticker, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.3
 * JD-Core Version:    0.7.0.1
 */