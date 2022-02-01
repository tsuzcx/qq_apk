package com.tencent.weseevideo.composition;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;

class VideoRenderChainManager$1
  implements ITAVRenderContextDataSource
{
  VideoRenderChainManager$1(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
    int i;
    if (localCMTimeRange == null) {
      i = 1;
    }
    while ((i != 0) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode()))
    {
      return true;
      CMTime localCMTime = new CMTime(paramLong, 1000);
      if (((localCMTimeRange.getStart().smallThan(localCMTime)) || (localCMTimeRange.getStart().equalsTo(localCMTime))) && ((localCMTimeRange.getEnd().bigThan(localCMTime)) || (localCMTimeRange.getEnd().equalsTo(localCMTime)))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager.1
 * JD-Core Version:    0.7.0.1
 */