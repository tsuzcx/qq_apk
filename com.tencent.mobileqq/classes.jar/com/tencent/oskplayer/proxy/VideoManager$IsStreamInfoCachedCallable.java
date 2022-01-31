package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

class VideoManager$IsStreamInfoCachedCallable
  implements Callable<Boolean>
{
  private SegmentVideoInfo.StreamInfo mStreamInfo;
  
  public VideoManager$IsStreamInfoCachedCallable(VideoManager paramVideoManager, SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    this.mStreamInfo = paramStreamInfo;
  }
  
  public Boolean call()
  {
    Iterator localIterator = this.mStreamInfo.segmentInfos.iterator();
    while (localIterator.hasNext())
    {
      SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)localIterator.next();
      if (!VideoManager.access$000(this.this$0).isCached(localSegmentInfo.url)) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoManager.IsStreamInfoCachedCallable
 * JD-Core Version:    0.7.0.1
 */