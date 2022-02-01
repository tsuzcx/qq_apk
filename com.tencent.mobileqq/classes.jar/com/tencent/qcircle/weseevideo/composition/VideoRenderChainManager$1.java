package com.tencent.qcircle.weseevideo.composition;

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
    if (localCMTimeRange == null) {}
    CMTime localCMTime;
    do
    {
      i = 1;
      break;
      localCMTime = new CMTime(paramLong, 1000);
    } while (((localCMTimeRange.getStart().smallThan(localCMTime)) || (localCMTimeRange.getStart().equalsTo(localCMTime))) && ((localCMTimeRange.getEnd().bigThan(localCMTime)) || (localCMTimeRange.getEnd().equalsTo(localCMTime))));
    int i = 0;
    return (i != 0) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.1
 * JD-Core Version:    0.7.0.1
 */