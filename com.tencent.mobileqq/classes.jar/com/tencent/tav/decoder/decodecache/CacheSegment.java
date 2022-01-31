package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.ITexturePool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CacheSegment
{
  public volatile List<CacheFrame> cacheFrameList = new ArrayList();
  public volatile CMTimeRange segmentTimeRange = null;
  
  CacheSegment(CMTimeRange paramCMTimeRange)
  {
    this.segmentTimeRange = paramCMTimeRange;
  }
  
  private boolean isCacheFrameUsable(CacheFrame paramCacheFrame)
  {
    return (paramCacheFrame.sampleBuffer != null) && (paramCacheFrame.sampleBuffer.getTextureInfo() != null);
  }
  
  public void clear()
  {
    Iterator localIterator = this.cacheFrameList.iterator();
    while (localIterator.hasNext())
    {
      CacheFrame localCacheFrame = (CacheFrame)localIterator.next();
      if (isCacheFrameUsable(localCacheFrame))
      {
        localCacheFrame.texturePool.pushTexture(localCacheFrame.sampleBuffer.getTextureInfo());
        localCacheFrame.sampleBuffer = null;
      }
    }
    this.cacheFrameList.clear();
  }
  
  CMTime getLastFrameTime()
  {
    if (this.cacheFrameList.size() > 0) {
      return ((CacheFrame)this.cacheFrameList.get(this.cacheFrameList.size() - 1)).frameTime;
    }
    return this.segmentTimeRange.getEnd();
  }
  
  CacheFrame popFrame(CMTime paramCMTime)
  {
    if (this.cacheFrameList.size() > 0)
    {
      CacheFrame localCacheFrame = (CacheFrame)this.cacheFrameList.get(0);
      if (!localCacheFrame.frameTime.smallThan(paramCMTime)) {
        return (CacheFrame)this.cacheFrameList.get(0);
      }
      if (isCacheFrameUsable(localCacheFrame))
      {
        if (localCacheFrame.texturePool != null) {
          break label95;
        }
        localCacheFrame.sampleBuffer.getTextureInfo().release();
      }
      for (;;)
      {
        localCacheFrame.sampleBuffer = null;
        this.cacheFrameList.remove(0);
        break;
        label95:
        localCacheFrame.texturePool.pushTexture(localCacheFrame.sampleBuffer.getTextureInfo());
      }
    }
    return null;
  }
  
  void pushFrame(CacheFrame paramCacheFrame)
  {
    int i = 0;
    while (i < this.cacheFrameList.size())
    {
      if (((CacheFrame)this.cacheFrameList.get(i)).frameTime.bigThan(paramCacheFrame.frameTime))
      {
        this.cacheFrameList.add(i, paramCacheFrame);
        return;
      }
      i += 1;
    }
    this.cacheFrameList.add(paramCacheFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CacheSegment
 * JD-Core Version:    0.7.0.1
 */