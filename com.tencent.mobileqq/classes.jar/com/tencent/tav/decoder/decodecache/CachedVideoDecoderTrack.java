package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CachedVideoDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "CachedVideoTrack";
  private CacheSegment currentFrameSegment;
  private CMTime lastSampleTime = CMTime.CMTimeInvalid;
  final Object nextFrameDecoderLock = new Object();
  private CacheSegment nextFrameSegment;
  RenderContext renderContext;
  boolean revert;
  private SegmentDecoderThread segmentDecoder;
  private int segmentSize = 60;
  CMTimeRange validTimeRange;
  
  public CachedVideoDecoderTrack(IDecoderTrack paramIDecoderTrack, boolean paramBoolean)
  {
    this.revert = paramBoolean;
    this.segmentDecoder = new SegmentDecoderThread(this, paramIDecoderTrack);
  }
  
  private void clearCurrentFrameSegment()
  {
    if (this.currentFrameSegment != null)
    {
      this.currentFrameSegment.clear();
      this.currentFrameSegment = null;
    }
  }
  
  private CMSampleBuffer decoderFrame(CMTime paramCMTime)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.segmentDecoder.decoderSegment(paramCMTime, localCountDownLatch);
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      return this.segmentDecoder.seekSampleBuffer;
    }
    catch (InterruptedException paramCMTime)
    {
      for (;;)
      {
        paramCMTime.printStackTrace();
      }
    }
  }
  
  private CMSampleBuffer decoderSegment(CMTime arg1)
  {
    Object localObject3 = new RequestStatus();
    Object localObject4;
    boolean bool;
    if ((this.nextFrameSegment != null) && (this.nextFrameSegment.segmentTimeRange != null) && (this.nextFrameSegment.segmentTimeRange.containsTime(???)))
    {
      synchronized (this.nextFrameDecoderLock)
      {
        clearCurrentFrameSegment();
        this.currentFrameSegment = new CacheSegment(this.nextFrameSegment.segmentTimeRange);
        localObject4 = this.nextFrameSegment.cacheFrameList.iterator();
        if (((Iterator)localObject4).hasNext())
        {
          CacheFrame localCacheFrame = (CacheFrame)((Iterator)localObject4).next();
          this.currentFrameSegment.pushFrame(localCacheFrame);
        }
      }
      localObject4 = this.currentFrameSegment.popFrame(???);
      if (localObject4 != null)
      {
        ??? = new StringBuilder().append("readSample: hint nextFrameSegment ");
        if ((((CacheFrame)localObject4).sampleBuffer == null) || (((CacheFrame)localObject4).sampleBuffer.getTextureInfo() == null)) {
          break label753;
        }
        bool = true;
        localObject3 = ???.append(bool).append("  ");
        if (((CacheFrame)localObject4).sampleBuffer == null) {
          break label758;
        }
      }
    }
    label753:
    label758:
    for (??? = Boolean.valueOf(((CacheFrame)localObject4).sampleBuffer.isNewFrame());; ??? = "null")
    {
      Logger.e("CachedVideoTrack", ??? + " time = " + ((CacheFrame)localObject4).realFrameTime + "  " + ((CacheFrame)localObject4).frameTime);
      this.nextFrameSegment = new CacheSegment(new CMTimeRange(this.currentFrameSegment.getLastFrameTime(), getFrameDuration().multi(this.segmentSize)));
      this.segmentDecoder.decoderSegment(this.nextFrameSegment, null);
      this.lastSampleTime = ((CacheFrame)localObject4).frameTime;
      ??? = ((CacheFrame)localObject4).sampleBuffer;
      return ???;
      Logger.e("CachedVideoTrack", "readSample: hint nextFrameSegment frame == null " + this.nextFrameSegment.cacheFrameList.size() + "  " + this.currentFrameSegment.cacheFrameList.size());
      this.segmentDecoder.cancel = true;
      for (;;)
      {
        synchronized (this.nextFrameDecoderLock)
        {
          if (this.nextFrameSegment != null) {
            this.nextFrameSegment.clear();
          }
          this.nextFrameSegment = new CacheSegment(new CMTimeRange(???, getFrameDuration().multi(this.segmentSize)));
          this.segmentDecoder.decoderSegment(this.nextFrameSegment, (RequestStatus)localObject3);
        }
        try
        {
          if (!((RequestStatus)localObject3).getFinish()) {
            localObject3.wait(10000L);
          }
          if (this.nextFrameSegment.cacheFrameList.size() == 0)
          {
            return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
            localObject4 = new StringBuilder().append("readSample: hint nextFrameSegment --- ");
            if (this.nextFrameSegment == null) {}
            for (??? = "";; ??? = this.nextFrameSegment.segmentTimeRange)
            {
              Logger.e("CachedVideoTrack", ??? + "  " + ???);
              break;
            }
            ??? = finally;
            throw ???;
          }
        }
        catch (InterruptedException ???)
        {
          for (;;)
          {
            ???.printStackTrace();
          }
        }
        finally {}
      }
      clearCurrentFrameSegment();
      this.currentFrameSegment = new CacheSegment(this.nextFrameSegment.segmentTimeRange);
      ??? = this.nextFrameSegment.cacheFrameList.iterator();
      while (???.hasNext())
      {
        ??? = (CacheFrame)???.next();
        this.currentFrameSegment.pushFrame((CacheFrame)???);
      }
      synchronized (this.nextFrameDecoderLock)
      {
        this.nextFrameSegment = new CacheSegment(new CMTimeRange(this.currentFrameSegment.getLastFrameTime(), getFrameDuration().multi(this.segmentSize)));
        this.segmentDecoder.decoderSegment(this.nextFrameSegment, null);
        if ((this.currentFrameSegment != null) && (this.currentFrameSegment.cacheFrameList.size() > 0))
        {
          ??? = (CacheFrame)this.currentFrameSegment.cacheFrameList.get(0);
          this.lastSampleTime = ???.frameTime;
          return ???.sampleBuffer;
        }
      }
      return null;
      bool = false;
      break;
    }
  }
  
  public void asyncReadNextSample(CMTime paramCMTime) {}
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    this.segmentDecoder.decoderTrack.clipRangeAndClearRange(paramCMTimeRange);
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    return this.segmentDecoder.decoderTrack.getDuration();
  }
  
  public CMTime getFrameDuration()
  {
    return this.segmentDecoder.decoderTrack.getFrameDuration();
  }
  
  public int getFrameRate()
  {
    return this.segmentDecoder.decoderTrack.getFrameRate();
  }
  
  public int getTrackId()
  {
    return this.segmentDecoder.decoderTrack.getTrackId();
  }
  
  public CMSampleBuffer readSample()
  {
    if (this.lastSampleTime == CMTime.CMTimeInvalid) {
      return readSample(CMTime.CMTimeZero);
    }
    if (this.lastSampleTime.smallThan(CMTime.CMTimeZero)) {
      return new CMSampleBuffer(this.lastSampleTime);
    }
    return readSample(this.lastSampleTime.add(getFrameDuration()));
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
      return readSample();
    }
    Logger.e("CachedVideoTrack", "readSample: targetTime = " + paramCMTime);
    if (this.currentFrameSegment != null)
    {
      localObject = this.currentFrameSegment.popFrame(paramCMTime);
      if (localObject != null)
      {
        this.lastSampleTime = ((CacheFrame)localObject).frameTime;
        paramCMTime = new StringBuilder().append("readSample: hint currentSegment ");
        boolean bool;
        StringBuilder localStringBuilder;
        if ((((CacheFrame)localObject).sampleBuffer != null) && (((CacheFrame)localObject).sampleBuffer.getTextureInfo() != null))
        {
          bool = true;
          localStringBuilder = paramCMTime.append(bool).append("  ");
          if (((CacheFrame)localObject).sampleBuffer == null) {
            break label179;
          }
        }
        label179:
        for (paramCMTime = Boolean.valueOf(((CacheFrame)localObject).sampleBuffer.isNewFrame());; paramCMTime = "null")
        {
          Logger.e("CachedVideoTrack", paramCMTime + " time = " + ((CacheFrame)localObject).realFrameTime + "  " + ((CacheFrame)localObject).frameTime);
          return ((CacheFrame)localObject).sampleBuffer;
          bool = false;
          break;
        }
      }
    }
    if (!paramCMTime.smallThan(getDuration()))
    {
      this.lastSampleTime = IDecoder.SAMPLE_TIME_FINISH;
      return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    Object localObject = decoderSegment(paramCMTime);
    if (localObject != null)
    {
      Logger.e("CachedVideoTrack", "readSample: hint currentSegment - " + ((CMSampleBuffer)localObject).getTime());
      return localObject;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      this.lastSampleTime = IDecoder.SAMPLE_TIME_FINISH;
      return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    this.lastSampleTime = IDecoder.SAMPLE_TIME_ERROR;
    return new CMSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
  }
  
  public void release()
  {
    if (this.currentFrameSegment != null) {
      this.currentFrameSegment.clear();
    }
    if (this.nextFrameSegment != null) {
      this.nextFrameSegment.clear();
    }
    synchronized (this.nextFrameDecoderLock)
    {
      if (this.segmentDecoder != null)
      {
        this.segmentDecoder.release();
        this.segmentDecoder = null;
      }
      return;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    CMSampleBuffer localCMSampleBuffer = null;
    Logger.e("CachedVideoTrack", "seekTo: PlayerThreadMain " + paramCMTime);
    int i;
    if (paramCMTime.bigThan(getFrameDuration()))
    {
      this.lastSampleTime = paramCMTime.sub(getFrameDuration());
      if (this.currentFrameSegment != null)
      {
        this.currentFrameSegment.clear();
        this.currentFrameSegment = null;
      }
      if (this.nextFrameSegment != null)
      {
        this.nextFrameSegment.clear();
        this.nextFrameSegment = null;
      }
      if (paramBoolean1)
      {
        long l = paramCMTime.getTimeUs() / getFrameDuration().getTimeUs();
        if (paramCMTime.getTimeUs() % getFrameDuration().getTimeUs() <= 0L) {
          break label184;
        }
        i = 1;
        label127:
        localCMSampleBuffer = decoderFrame(new CMTime((float)((l + i) * getFrameDuration().getTimeUs()) / 1000000.0F));
        if (localCMSampleBuffer != null) {
          break label190;
        }
      }
    }
    label184:
    label190:
    for (paramCMTime = IDecoder.SAMPLE_TIME_FINISH;; paramCMTime = localCMSampleBuffer.getTime())
    {
      this.lastSampleTime = paramCMTime;
      return localCMSampleBuffer;
      this.lastSampleTime = paramCMTime;
      break;
      i = 0;
      break label127;
    }
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.segmentDecoder.decoderTrack.setDecodeType(paramDecodeType);
  }
  
  public void setFrameRate(int paramInt)
  {
    this.segmentDecoder.decoderTrack.setFrameRate(paramInt);
  }
  
  public void setMaxFrameCacheSize(int paramInt)
  {
    if (paramInt > 0)
    {
      this.segmentSize = paramInt;
      if (this.segmentDecoder != null) {
        this.segmentDecoder.texturePool.setMaxCacheLength(paramInt);
      }
    }
  }
  
  public void setRevert(boolean paramBoolean)
  {
    this.revert = paramBoolean;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    this.segmentDecoder.decoderTrack.setTrackSegments(paramList);
  }
  
  public void setVolume(float paramFloat)
  {
    this.segmentDecoder.decoderTrack.setVolume(paramFloat);
  }
  
  public void start()
  {
    start(null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    start(paramSurfaceCreator, null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    this.validTimeRange = paramCMTimeRange;
    this.renderContext = ((RenderContext)paramSurfaceCreator);
    this.segmentDecoder.startForReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */