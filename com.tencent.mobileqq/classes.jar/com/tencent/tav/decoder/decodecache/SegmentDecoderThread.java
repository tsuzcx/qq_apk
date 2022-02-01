package com.tencent.tav.decoder.decodecache;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.TexturePool;
import com.tencent.tav.decoder.logger.Logger;
import java.util.concurrent.CountDownLatch;

class SegmentDecoderThread
  implements Handler.Callback
{
  private static final int MSG_DECODER_FRAME = 3;
  private static final int MSG_DECODER_SEGMENT = 2;
  private static final int MSG_QUIT = 1000;
  private static final int MSG_START = 1;
  private static final String TAG = "SegmentDecoderThread";
  private CachedVideoDecoderTrack cachedVideoDecoderTrack;
  boolean cancel = false;
  RenderContext context;
  private Handler decoderHandler;
  private HandlerThread decoderThread;
  IDecoderTrack decoderTrack;
  private CopyFilter filter;
  CMSampleBuffer seekSampleBuffer;
  private volatile boolean started = false;
  ITexturePool texturePool;
  
  SegmentDecoderThread(CachedVideoDecoderTrack paramCachedVideoDecoderTrack, IDecoderTrack paramIDecoderTrack)
  {
    this.cachedVideoDecoderTrack = paramCachedVideoDecoderTrack;
    this.decoderTrack = paramIDecoderTrack;
    this.texturePool = new TexturePool();
  }
  
  private void decoder(DecoderFrameMsg paramDecoderFrameMsg)
  {
    ??? = paramDecoderFrameMsg.time;
    if (this.cachedVideoDecoderTrack.revert) {
      ??? = this.decoderTrack.getDuration().sub(paramDecoderFrameMsg.time);
    }
    if (this.context != null) {
      this.context.makeCurrent();
    }
    CMSampleBuffer localCMSampleBuffer = this.decoderTrack.seekTo((CMTime)???, true, false);
    if (localCMSampleBuffer.getTextureInfo() != null)
    {
      ??? = this.context;
      this.filter.setRenderForScreen(false);
      this.filter.setRendererWidth(((RenderContext)???).width());
      this.filter.setRendererHeight(((RenderContext)???).height());
      if (this.seekSampleBuffer == null) {
        break label279;
      }
      ??? = this.seekSampleBuffer.getTextureInfo();
    }
    for (;;)
    {
      this.filter.setDesTextureInfo((TextureInfo)???);
      Logger.e("SegmentDecoderThread", "decoder:==========|=|========= " + localCMSampleBuffer.getTime() + "  " + localCMSampleBuffer.isNewFrame() + "  ");
      this.filter.clearBufferBuffer(-16777216);
      this.filter.applyFilter(localCMSampleBuffer.getTextureInfo(), localCMSampleBuffer.getTextureInfo().getTextureMatrix());
      CMTime localCMTime2 = localCMSampleBuffer.getTime();
      CMTime localCMTime1 = localCMTime2;
      if (this.cachedVideoDecoderTrack.revert) {
        localCMTime1 = this.decoderTrack.getDuration().sub(localCMTime2);
      }
      this.seekSampleBuffer = new CMSampleBuffer(localCMTime1, (TextureInfo)???, localCMSampleBuffer.isNewFrame());
      if (paramDecoderFrameMsg.finishWait != null) {}
      synchronized (paramDecoderFrameMsg.finishWait)
      {
        paramDecoderFrameMsg.finishWait.countDown();
        return;
        label279:
        ??? = this.texturePool.popTexture(3553, ((RenderContext)???).width(), ((RenderContext)???).height());
      }
    }
  }
  
  private void decoder(DecoderSegmentMsg paramDecoderSegmentMsg)
  {
    label778:
    label784:
    for (;;)
    {
      Object localObject3;
      synchronized (this.cachedVideoDecoderTrack.nextFrameDecoderLock)
      {
        this.cancel = false;
        CacheSegment localCacheSegment = paramDecoderSegmentMsg.segment;
        Logger.e("SegmentDecoderThread", "decoder:------------------- " + paramDecoderSegmentMsg.segment.segmentTimeRange.getStart() + "  -  " + paramDecoderSegmentMsg.segment.segmentTimeRange.getEnd());
        localObject3 = localCacheSegment.segmentTimeRange.getStart();
        Object localObject2 = localCacheSegment.segmentTimeRange.getEnd();
        ??? = localCacheSegment.segmentTimeRange.getDuration();
        if (!((CMTime)localObject2).bigThan(this.decoderTrack.getDuration())) {
          break label784;
        }
        localObject2 = this.decoderTrack.getDuration();
        ??? = ((CMTime)localObject2).sub((CMTime)localObject3);
        localObject3 = new CMTimeRange((CMTime)localObject3, localCacheSegment.segmentTimeRange.getDuration());
        if (!this.cachedVideoDecoderTrack.revert) {
          break label778;
        }
        localObject3 = this.decoderTrack.getDuration().sub((CMTime)localObject2);
        localObject2 = localObject3;
        if (((CMTime)localObject3).smallThan(CMTime.CMTimeZero)) {
          localObject2 = CMTime.CMTimeZero;
        }
        ??? = new CMTimeRange((CMTime)localObject2, (CMTime)???);
        Logger.e("SegmentDecoderThread", "decoder2:------------------- " + ((CMTimeRange)???).getStart() + "  -  " + ((CMTimeRange)???).getEnd());
        if ((((CMTimeRange)???).getStart() != CMTime.CMTimeInvalid) && (this.cachedVideoDecoderTrack != null) && (this.context != null))
        {
          this.context.makeCurrent();
          this.decoderTrack.seekTo(((CMTimeRange)???).getStart(), false, false);
          localObject2 = this.decoderTrack.readSample(((CMTimeRange)???).getStart());
          Logger.e("SegmentDecoderThread", "decoder: readFirst " + ((CMSampleBuffer)localObject2).getTime() + " cancel = " + this.cancel + "  - " + ((CMTimeRange)???).getEnd());
          if ((!((CMSampleBuffer)localObject2).getTime().smallThan(CMTime.CMTimeZero)) && (!this.cancel) && (((CMSampleBuffer)localObject2).getTime().smallThan(((CMTimeRange)???).getEnd())))
          {
            localObject3 = new CacheFrame();
            ((CacheFrame)localObject3).texturePool = this.texturePool;
            ((CacheFrame)localObject3).frameTime = ((CMSampleBuffer)localObject2).getTime();
            Logger.e("SegmentDecoderThread", "decoder:==================== frame.frameTime = " + ((CacheFrame)localObject3).frameTime + "  " + ((CMSampleBuffer)localObject2).getTextureInfo());
            if (this.cachedVideoDecoderTrack.revert) {
              ((CacheFrame)localObject3).frameTime = this.decoderTrack.getDuration().sub(((CMSampleBuffer)localObject2).getTime());
            }
            ((CacheFrame)localObject3).realFrameTime = ((CMSampleBuffer)localObject2).getTime();
            if (((CMSampleBuffer)localObject2).getTextureInfo() != null)
            {
              Object localObject5 = this.context;
              this.filter.setRenderForScreen(false);
              this.filter.setRendererWidth(((RenderContext)localObject5).width());
              this.filter.setRendererHeight(((RenderContext)localObject5).height());
              ((RenderContext)localObject5).makeCurrent();
              localObject5 = this.texturePool.popTexture(3553, ((RenderContext)localObject5).width(), ((RenderContext)localObject5).height());
              this.filter.setDesTextureInfo((TextureInfo)localObject5);
              Logger.e("SegmentDecoderThread", "decoder:==================== " + ((CMSampleBuffer)localObject2).getTime() + "  " + ((CMSampleBuffer)localObject2).isNewFrame() + "  " + ((CacheFrame)localObject3).frameTime);
              this.filter.clearBufferBuffer(-16777216);
              this.filter.applyFilter(((CMSampleBuffer)localObject2).getTextureInfo(), ((CMSampleBuffer)localObject2).getTextureInfo().getTextureMatrix());
              ((CacheFrame)localObject3).sampleBuffer = new CMSampleBuffer(((CacheFrame)localObject3).frameTime, (TextureInfo)localObject5, ((CMSampleBuffer)localObject2).isNewFrame());
              localCacheSegment.pushFrame((CacheFrame)localObject3);
            }
            if (((CacheFrame)localObject3).realFrameTime.add(this.cachedVideoDecoderTrack.getFrameDuration()).smallThan(((CMTimeRange)???).getEnd()))
            {
              localObject2 = this.decoderTrack.readSample();
              continue;
            }
          }
        }
        if (paramDecoderSegmentMsg.callbackObject == null) {}
      }
      synchronized (paramDecoderSegmentMsg.callbackObject)
      {
        paramDecoderSegmentMsg.callbackObject.setFinish(true);
        paramDecoderSegmentMsg.callbackObject.notifyAll();
        return;
        paramDecoderSegmentMsg = finally;
        throw paramDecoderSegmentMsg;
      }
      ??? = localObject3;
    }
  }
  
  private void quit()
  {
    if ((this.seekSampleBuffer != null) && (this.seekSampleBuffer.getTextureInfo() != null)) {
      this.seekSampleBuffer.getTextureInfo().release();
    }
    this.filter.release();
    this.decoderTrack.release();
    this.texturePool.release();
    this.context.release();
    this.decoderHandler.removeCallbacksAndMessages(null);
    this.decoderThread.quit();
  }
  
  private void start()
  {
    this.decoderThread = new HandlerThread("SegmentDecoder");
    this.decoderThread.start();
    this.decoderHandler = new Handler(this.decoderThread.getLooper(), this);
  }
  
  private void startDecoder()
  {
    this.context = new RenderContext(this.cachedVideoDecoderTrack.renderContext.width(), this.cachedVideoDecoderTrack.renderContext.height(), null, this.cachedVideoDecoderTrack.renderContext.eglContext());
    this.decoderTrack.start(this.context, this.cachedVideoDecoderTrack.validTimeRange);
    this.started = true;
    this.context.makeCurrent();
    this.filter = new CopyFilter();
  }
  
  void decoderSegment(CMTime paramCMTime, CountDownLatch paramCountDownLatch)
  {
    this.cancel = true;
    this.decoderHandler.removeCallbacksAndMessages(null);
    this.decoderHandler.obtainMessage(3, new DecoderFrameMsg(paramCMTime, paramCountDownLatch)).sendToTarget();
  }
  
  void decoderSegment(CacheSegment paramCacheSegment, RequestStatus paramRequestStatus)
  {
    this.cancel = true;
    this.decoderHandler.removeCallbacksAndMessages(null);
    this.decoderHandler.obtainMessage(2, new DecoderSegmentMsg(paramCacheSegment, paramRequestStatus)).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      startDecoder();
      continue;
      decoder((DecoderSegmentMsg)paramMessage.obj);
      continue;
      decoder((DecoderFrameMsg)paramMessage.obj);
      continue;
      quit();
    }
  }
  
  void release()
  {
    this.cancel = true;
    if (this.decoderThread != null)
    {
      this.decoderHandler.removeCallbacksAndMessages(null);
      this.decoderHandler.sendEmptyMessage(1000);
    }
  }
  
  void startForReady()
  {
    start();
    this.decoderHandler.sendEmptyMessage(1);
    while (!this.started) {
      try
      {
        Thread.sleep(1L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.SegmentDecoderThread
 * JD-Core Version:    0.7.0.1
 */