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
    Object localObject2 = this.context;
    if (localObject2 != null) {
      ((RenderContext)localObject2).makeCurrent();
    }
    CMSampleBuffer localCMSampleBuffer = this.decoderTrack.seekTo((CMTime)???, true, false);
    if (localCMSampleBuffer.getTextureInfo() != null)
    {
      ??? = this.context;
      this.filter.setRenderForScreen(false);
      this.filter.setRendererWidth(((RenderContext)???).width());
      this.filter.setRendererHeight(((RenderContext)???).height());
      localObject2 = this.seekSampleBuffer;
      if (localObject2 != null) {
        ??? = ((CMSampleBuffer)localObject2).getTextureInfo();
      } else {
        ??? = this.texturePool.popTexture(3553, ((RenderContext)???).width(), ((RenderContext)???).height());
      }
      this.filter.setDesTextureInfo((TextureInfo)???);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decoder:==========|=|========= ");
      ((StringBuilder)localObject2).append(localCMSampleBuffer.getTime());
      ((StringBuilder)localObject2).append("  ");
      ((StringBuilder)localObject2).append(localCMSampleBuffer.isNewFrame());
      ((StringBuilder)localObject2).append("  ");
      Logger.d("SegmentDecoderThread", ((StringBuilder)localObject2).toString());
      this.filter.clearBufferBuffer(-16777216);
      this.filter.applyFilter(localCMSampleBuffer.getTextureInfo(), localCMSampleBuffer.getTextureInfo().getTextureMatrix());
      CMTime localCMTime = localCMSampleBuffer.getTime();
      localObject2 = localCMTime;
      if (this.cachedVideoDecoderTrack.revert) {
        localObject2 = this.decoderTrack.getDuration().sub(localCMTime);
      }
      this.seekSampleBuffer = new CMSampleBuffer((CMTime)localObject2, (TextureInfo)???, localCMSampleBuffer.isNewFrame());
    }
    if (paramDecoderFrameMsg.finishWait != null) {
      synchronized (paramDecoderFrameMsg.finishWait)
      {
        paramDecoderFrameMsg.finishWait.countDown();
        return;
      }
    }
  }
  
  private void decoder(DecoderSegmentMsg paramDecoderSegmentMsg)
  {
    synchronized (this.cachedVideoDecoderTrack.nextFrameDecoderLock)
    {
      this.cancel = false;
      CacheSegment localCacheSegment = paramDecoderSegmentMsg.segment;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("decoder:------------------- ");
      ((StringBuilder)???).append(paramDecoderSegmentMsg.segment.segmentTimeRange.getStart());
      ((StringBuilder)???).append("  -  ");
      ((StringBuilder)???).append(paramDecoderSegmentMsg.segment.segmentTimeRange.getEnd());
      Logger.d("SegmentDecoderThread", ((StringBuilder)???).toString());
      Object localObject5 = localCacheSegment.segmentTimeRange.getStart();
      ??? = localCacheSegment.segmentTimeRange.getEnd();
      Object localObject2 = localCacheSegment.segmentTimeRange.getDuration();
      Object localObject3 = ???;
      if (((CMTime)???).bigThan(this.decoderTrack.getDuration()))
      {
        localObject3 = this.decoderTrack.getDuration();
        localObject2 = ((CMTime)localObject3).sub((CMTime)localObject5);
      }
      ??? = new CMTimeRange((CMTime)localObject5, localCacheSegment.segmentTimeRange.getDuration());
      if (this.cachedVideoDecoderTrack.revert)
      {
        localObject3 = this.decoderTrack.getDuration().sub((CMTime)localObject3);
        ??? = localObject3;
        if (((CMTime)localObject3).smallThan(CMTime.CMTimeZero)) {
          ??? = CMTime.CMTimeZero;
        }
        ??? = new CMTimeRange((CMTime)???, (CMTime)localObject2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decoder2:------------------- ");
      ((StringBuilder)localObject2).append(((CMTimeRange)???).getStart());
      ((StringBuilder)localObject2).append("  -  ");
      ((StringBuilder)localObject2).append(((CMTimeRange)???).getEnd());
      Logger.d("SegmentDecoderThread", ((StringBuilder)localObject2).toString());
      if ((((CMTimeRange)???).getStart() != CMTime.CMTimeInvalid) && (this.cachedVideoDecoderTrack != null) && (this.context != null))
      {
        this.context.makeCurrent();
        this.decoderTrack.seekTo(((CMTimeRange)???).getStart(), false, false);
        localObject2 = this.decoderTrack.readSample(((CMTimeRange)???).getStart());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("decoder: readFirst ");
        ((StringBuilder)localObject3).append(((CMSampleBuffer)localObject2).getTime());
        ((StringBuilder)localObject3).append(" cancel = ");
        ((StringBuilder)localObject3).append(this.cancel);
        ((StringBuilder)localObject3).append("  - ");
        ((StringBuilder)localObject3).append(((CMTimeRange)???).getEnd());
        Logger.d("SegmentDecoderThread", ((StringBuilder)localObject3).toString());
        while ((!((CMSampleBuffer)localObject2).getTime().smallThan(CMTime.CMTimeZero)) && (!this.cancel) && (((CMSampleBuffer)localObject2).getTime().smallThan(((CMTimeRange)???).getEnd())))
        {
          localObject3 = new CacheFrame();
          ((CacheFrame)localObject3).texturePool = this.texturePool;
          ((CacheFrame)localObject3).frameTime = ((CMSampleBuffer)localObject2).getTime();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("decoder:==================== frame.frameTime = ");
          ((StringBuilder)localObject5).append(((CacheFrame)localObject3).frameTime);
          ((StringBuilder)localObject5).append("  ");
          ((StringBuilder)localObject5).append(((CMSampleBuffer)localObject2).getTextureInfo());
          Logger.d("SegmentDecoderThread", ((StringBuilder)localObject5).toString());
          if (this.cachedVideoDecoderTrack.revert) {
            ((CacheFrame)localObject3).frameTime = this.decoderTrack.getDuration().sub(((CMSampleBuffer)localObject2).getTime());
          }
          ((CacheFrame)localObject3).realFrameTime = ((CMSampleBuffer)localObject2).getTime();
          if (((CMSampleBuffer)localObject2).getTextureInfo() != null)
          {
            localObject5 = this.context;
            this.filter.setRenderForScreen(false);
            this.filter.setRendererWidth(((RenderContext)localObject5).width());
            this.filter.setRendererHeight(((RenderContext)localObject5).height());
            ((RenderContext)localObject5).makeCurrent();
            localObject5 = this.texturePool.popTexture(3553, ((RenderContext)localObject5).width(), ((RenderContext)localObject5).height());
            this.filter.setDesTextureInfo((TextureInfo)localObject5);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decoder:==================== ");
            localStringBuilder.append(((CMSampleBuffer)localObject2).getTime());
            localStringBuilder.append("  ");
            localStringBuilder.append(((CMSampleBuffer)localObject2).isNewFrame());
            localStringBuilder.append("  ");
            localStringBuilder.append(((CacheFrame)localObject3).frameTime);
            Logger.d("SegmentDecoderThread", localStringBuilder.toString());
            this.filter.clearBufferBuffer(-16777216);
            this.filter.applyFilter(((CMSampleBuffer)localObject2).getTextureInfo(), ((CMSampleBuffer)localObject2).getTextureInfo().getTextureMatrix());
            ((CacheFrame)localObject3).sampleBuffer = new CMSampleBuffer(((CacheFrame)localObject3).frameTime, (TextureInfo)localObject5, ((CMSampleBuffer)localObject2).isNewFrame());
            localCacheSegment.pushFrame((CacheFrame)localObject3);
          }
          if (!((CacheFrame)localObject3).realFrameTime.add(this.cachedVideoDecoderTrack.getFrameDuration()).smallThan(((CMTimeRange)???).getEnd())) {
            break;
          }
          localObject2 = this.decoderTrack.readSample();
        }
      }
      if (paramDecoderSegmentMsg.callbackObject != null) {
        synchronized (paramDecoderSegmentMsg.callbackObject)
        {
          paramDecoderSegmentMsg.callbackObject.setFinish(true);
          paramDecoderSegmentMsg.callbackObject.notifyAll();
          return;
        }
      }
      return;
    }
    for (;;)
    {
      throw paramDecoderSegmentMsg;
    }
  }
  
  private void quit()
  {
    CMSampleBuffer localCMSampleBuffer = this.seekSampleBuffer;
    if ((localCMSampleBuffer != null) && (localCMSampleBuffer.getTextureInfo() != null)) {
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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 1000) {
            quit();
          }
        }
        else {
          decoder((DecoderFrameMsg)paramMessage.obj);
        }
      }
      else {
        decoder((DecoderSegmentMsg)paramMessage.obj);
      }
    }
    else {
      startDecoder();
    }
    return false;
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