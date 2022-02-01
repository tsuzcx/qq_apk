package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VideoDecoder
  implements IVideoDecoder
{
  private static final int MAX_WAIT_TIME = 1000;
  public final String TAG = "VideoDecoder@" + Integer.toHexString(hashCode());
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private CMSampleState currentDecoderState = new CMSampleState();
  private CMSampleState currentStartState = new CMSampleState();
  private CMTime duration = CMTime.CMTimeZero;
  @Nullable
  private AssetExtractor extractor;
  private boolean extractorDone = false;
  private long frameDurationUs = 33333L;
  boolean isReleased = false;
  boolean lastFrameValid = false;
  private int lastOutputBufferIndex = -1;
  private long mLastVideoQueueTime = 0L;
  private long mTimeOffset = 10000000L;
  private final MediaCodecWrapper mediaCodecWrapper = new MediaCodecWrapper(this);
  private MediaFormat mediaFormat;
  private AssetExtractor mirrorExtractor;
  private Surface outputSurface;
  private CMTime pFrameTime = new CMTime(20L, 600);
  private ArrayList<VideoDecoder.PendingFrame> pendingFrames = new ArrayList();
  private CMTime preReadTime = CMTime.CMTimeInvalid;
  private boolean readSampleFinish = false;
  private final String sourcePath;
  private boolean started = false;
  private CMTimeRange timeRange;
  private int trackIndex = -1;
  
  public VideoDecoder(IVideoDecoder.Params paramParams)
  {
    this(paramParams.filePath, paramParams.outputSurface);
  }
  
  public VideoDecoder(String paramString, Surface paramSurface)
  {
    this.sourcePath = paramString;
    Logger.d(this.TAG, "VideoDecoder() called with: sourcePath = [" + paramString + "], outputSurface = [" + paramSurface + "]");
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      throw new RuntimeException("文件不存在：path = " + paramString);
    }
    if (paramSurface != null) {
      this.outputSurface = paramSurface;
    }
    long l = System.currentTimeMillis();
    this.extractor = initExtractor(paramString);
    if (this.extractor == null) {
      return;
    }
    createMirrorExtractor();
    this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
    this.duration = new CMTime((float)this.extractor.getDuration() * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
    if (this.mediaFormat.containsKey("frame-rate"))
    {
      int i = this.mediaFormat.getInteger("frame-rate");
      this.pFrameTime = new CMTime(600 / i, 600);
      this.frameDurationUs = (1000000 / i);
    }
    if (this.mediaCodecWrapper.decoderConfigure(this.mediaFormat, paramSurface))
    {
      this.mediaCodecWrapper.startDecoder(paramSurface, this.mediaFormat);
      Logger.d(this.TAG, "create VideoDecoder end " + (System.currentTimeMillis() - l));
      return;
    }
    throw new IllegalStateException("decoderConfigure failed!");
  }
  
  private void clearDecoder()
  {
    Logger.d(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.mediaCodecWrapper.flushDecoder();
      this.pendingFrames.clear();
      this.currentDecoderState = new CMSampleState();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void createMirrorExtractor()
  {
    ThreadPool.execute(new VideoDecoder.1(this));
  }
  
  private void doReadFrames(VideoDecoder.SampleTime paramSampleTime, CMTime paramCMTime, boolean paramBoolean)
  {
    Logger.v(this.TAG, "doReadFrames() called with: sampleTime = [" + paramSampleTime + "], targetTime = [" + paramCMTime + "], justCache = [" + paramBoolean + "]");
    if ((this.pendingFrames.size() == 0) && (this.extractorDone)) {
      Logger.i(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
    }
    int i = 0;
    for (;;)
    {
      int n;
      if ((this.pendingFrames.size() > 0) || (!this.extractorDone))
      {
        if (!this.extractorDone) {
          readFromExtractor();
        }
        n = this.mediaCodecWrapper.dequeueOutputBuffer(this.bufferInfo);
        if ((this.bufferInfo.flags & 0x4) != 0)
        {
          if ((this.bufferInfo.size > 0) && (n >= 0) && (this.pendingFrames.size() > 0))
          {
            this.pendingFrames.remove(0);
            this.mediaCodecWrapper.releaseOutputBuffer(n, true);
          }
          Logger.i(this.TAG, "doReadFrames:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-1L));
        }
      }
      label774:
      label930:
      label936:
      label951:
      for (;;)
      {
        return;
        if ((n < 0) || (this.pendingFrames.size() <= 0))
        {
          if (n >= 0)
          {
            Logger.w(this.TAG, "doReadFrames:[failed] pendingFrames.size() == " + this.pendingFrames.size());
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
          }
          i += 1;
          if (i > 1000)
          {
            Logger.e(this.TAG, "doReadFrames: [timeout] ");
            VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-4L));
          }
        }
        else
        {
          for (;;)
          {
            if ((!this.extractorDone) || (VideoDecoder.SampleTime.access$500(paramSampleTime) >= 0L) || (paramBoolean)) {
              break label951;
            }
            Logger.i(this.TAG, "doReadFrames: extractorDone && sampleTime.timeUs < 0, sampleTime = " + paramSampleTime);
            VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-1L));
            return;
            if (this.bufferInfo.size <= 0)
            {
              this.mediaCodecWrapper.releaseOutputBuffer(n, false);
              Logger.e(this.TAG, "doReadFrames:[failed] bufferInfo.size == " + this.bufferInfo.size);
              VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
              break;
            }
            VideoDecoder.PendingFrame localPendingFrame = (VideoDecoder.PendingFrame)this.pendingFrames.remove(0);
            VideoDecoder.SampleTime.access$502(paramSampleTime, this.bufferInfo.presentationTimeUs - VideoDecoder.PendingFrame.access$600(localPendingFrame));
            VideoDecoder.SampleTime.access$402(paramSampleTime, new CMSampleState(new CMTime((float)VideoDecoder.SampleTime.access$500(paramSampleTime) * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L))));
            if ((this.pendingFrames.isEmpty()) && (this.extractorDone)) {}
            for (int j = 1;; j = 0)
            {
              if ((j != 0) || (VideoDecoder.PendingFrame.access$700(localPendingFrame).getTimeUs() <= VideoDecoder.SampleTime.access$500(paramSampleTime) + this.frameDurationUs / 2L)) {
                break label592;
              }
              this.mediaCodecWrapper.releaseOutputBuffer(n, false);
              Logger.v(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
              VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
              break;
            }
            label592:
            if ((this.outputSurface == null) || (paramBoolean))
            {
              this.lastOutputBufferIndex = n;
              paramCMTime = this.mediaCodecWrapper.getOnputBuffer(n);
              if (paramCMTime != null)
              {
                paramCMTime.position(this.bufferInfo.offset);
                paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
                VideoDecoder.SampleTime.access$800(paramSampleTime);
              }
              else
              {
                this.mediaCodecWrapper.releaseOutputBuffer(n, false);
                Logger.e(this.TAG, "doReadFrames:[error] " + this.bufferInfo.size + " byteBuffer==null");
                VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-3L));
              }
            }
            else
            {
              if (j != 0) {
                VideoDecoder.SampleTime.access$402(paramSampleTime, new CMSampleState(this.duration));
              }
              int k;
              if (paramCMTime.getTimeUs() - VideoDecoder.SampleTime.access$400(paramSampleTime).getTime().getTimeUs() <= this.frameDurationUs / 2L)
              {
                k = 1;
                if (paramCMTime.getTimeUs() < this.duration.getTimeUs()) {
                  break label930;
                }
              }
              for (int m = 1;; m = 0)
              {
                if ((k != 0) || (m != 0) || (j != 0)) {
                  break label936;
                }
                this.mediaCodecWrapper.releaseOutputBuffer(n, false);
                Logger.v(this.TAG, "doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == " + (paramCMTime.getTimeUs() - VideoDecoder.SampleTime.access$400(paramSampleTime).getTime().getTimeUs()) + " targetTime = " + paramCMTime + "  duration = " + this.duration + " pendingFrames.size() = " + this.pendingFrames.size() + " extractorDone = " + this.extractorDone);
                VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
                break;
                k = 0;
                break label774;
              }
              this.mediaCodecWrapper.releaseOutputBuffer(n, true);
              VideoDecoder.SampleTime.access$800(paramSampleTime);
            }
          }
        }
      }
    }
  }
  
  private CMSampleState doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((paramCMTime.bigThan(this.timeRange.getDuration())) && (!paramBoolean))
        {
          Logger.i(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + paramCMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache is" + true);
          paramCMTime = CMSampleState.fromError(-1L);
          return paramCMTime;
        }
        if ((this.extractorDone) && (this.pendingFrames.size() == 0) && (this.timeRange.containsTime(paramCMTime)) && (!this.readSampleFinish))
        {
          Logger.w(this.TAG, "error state , and will go correct it ! ");
          seekTo(paramCMTime);
        }
        this.preReadTime = CMTime.CMTimeInvalid;
        Object localObject;
        if ((!this.started) || (this.trackIndex == -1))
        {
          paramCMTime = this.TAG;
          localObject = new StringBuilder().append("doReadSample:[unStart]  !started || trackIndex == -1 ");
          if (!this.started)
          {
            paramBoolean = true;
            localObject = ((StringBuilder)localObject).append(paramBoolean).append(" - ");
            if (this.trackIndex != -1) {
              break label359;
            }
            paramBoolean = bool;
            Logger.e(paramCMTime, paramBoolean);
            paramCMTime = CMSampleState.fromError(-100L);
          }
        }
        else
        {
          releaseOutputBuffer();
          localObject = new VideoDecoder.SampleTime(this, null);
          VideoDecoder.SampleTime.access$402((VideoDecoder.SampleTime)localObject, CMSampleState.fromError(-2L));
          VideoDecoder.SampleTime.access$502((VideoDecoder.SampleTime)localObject, -2L);
          try
          {
            doReadFrames((VideoDecoder.SampleTime)localObject, paramCMTime, paramBoolean);
            Logger.v(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + VideoDecoder.SampleTime.access$500((VideoDecoder.SampleTime)localObject) + "  " + VideoDecoder.SampleTime.access$400((VideoDecoder.SampleTime)localObject));
            paramCMTime = VideoDecoder.SampleTime.access$400((VideoDecoder.SampleTime)localObject);
          }
          catch (Exception paramCMTime)
          {
            paramCMTime = onReadFramesException(paramCMTime);
          }
          continue;
        }
        paramBoolean = false;
      }
      finally {}
      continue;
      label359:
      paramBoolean = false;
    }
  }
  
  private boolean hasPreReadAndFirstFrameSeek(CMTime paramCMTime)
  {
    return (paramCMTime == CMTime.CMTimeZero) && (this.preReadTime != CMTime.CMTimeInvalid) && (this.lastOutputBufferIndex != -1) && (!this.currentDecoderState.isInvalid());
  }
  
  private AssetExtractor initExtractor(String paramString)
  {
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setDataSource(paramString);
    while (localAssetExtractor.getSampleTrackIndex() != -1) {
      localAssetExtractor.unselectTrack(localAssetExtractor.getSampleTrackIndex());
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex(localAssetExtractor, "video/");
    if (this.trackIndex == -1)
    {
      this.outputSurface = null;
      return null;
    }
    localAssetExtractor.selectTrack(this.trackIndex);
    return localAssetExtractor;
  }
  
  private boolean moreCloseCurrentThenSeek(CMTime paramCMTime)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mirrorExtractor != null)
    {
      long l1 = this.currentDecoderState.getTime().getTimeUs();
      this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 2);
      if (this.mirrorExtractor.getSampleTime() > paramCMTime.getTimeUs()) {
        this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 0);
      }
      long l2 = this.mirrorExtractor.getSampleTime();
      bool1 = bool2;
      if (l2 <= l1)
      {
        bool1 = bool2;
        if (this.currentDecoderState.getTime().getTimeUs() >= l2)
        {
          bool1 = bool2;
          if (this.currentDecoderState.getTime().getTimeUs() < paramCMTime.getTimeUs() + this.pFrameTime.getTimeUs())
          {
            bool1 = bool2;
            if (l1 <= paramCMTime.getTimeUs()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  @NonNull
  private CMSampleState onReadFramesException(Exception paramException)
  {
    Logger.e(this.TAG, "onReadFramesException: ", paramException);
    if (Build.VERSION.SDK_INT < 21) {
      return CMSampleState.fromError(-3L);
    }
    if (!(paramException instanceof MediaCodec.CodecException)) {
      return CMSampleState.fromError(-3L);
    }
    if (((MediaCodec.CodecException)paramException).isRecoverable())
    {
      releaseOutputBuffer();
      this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartState.getTime().getTimeUs();
      long l2 = this.timeRange.getStartUs();
      if (this.extractor != null) {
        this.extractor.seekTo(l1 - l2, 0);
      }
      for (;;)
      {
        this.extractorDone = false;
        return CMSampleState.fromError(-3L);
        Logger.e(this.TAG, "onReadFramesException: extractor is null", new RuntimeException("堆栈"));
      }
    }
    if (((MediaCodec.CodecException)paramException).isTransient()) {
      Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    return CMSampleState.fromError(-3L);
  }
  
  private void preReadSample()
  {
    try
    {
      this.lastFrameValid = false;
      this.currentDecoderState = doReadSample(CMTime.CMTimeInvalid, true);
      if (!this.currentDecoderState.getTime().smallThan(CMTime.CMTimeZero)) {
        this.currentDecoderState = this.currentStartState;
      }
      this.preReadTime = this.currentDecoderState.getTime();
      Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
      return;
    }
    finally {}
  }
  
  private void readFromExtractor()
  {
    for (;;)
    {
      try
      {
        if (this.extractor == null)
        {
          Logger.e(this.TAG, "readFromExtractor: extractor is null", new RuntimeException("堆栈"));
          return;
        }
        long l = this.extractor.getSampleTime();
        if ((l >= this.timeRange.getEndUs()) || (this.extractor.getSampleTrackIndex() == -1) || (l == -1L))
        {
          if (l >= this.timeRange.getEndUs()) {
            readSampleData();
          }
          int i = this.mediaCodecWrapper.dequeueInputBuffer();
          if (i >= 0)
          {
            this.mediaCodecWrapper.queueInputBuffer(i, 0, 0, 0L, 4);
            this.extractorDone = true;
          }
        }
        else
        {
          readSampleData();
        }
      }
      finally {}
    }
  }
  
  private void readSampleData()
  {
    if (this.extractor == null) {
      Logger.e(this.TAG, "readSampleData: extractor is null", new RuntimeException("堆栈"));
    }
    long l;
    int i;
    do
    {
      return;
      l = this.extractor.getSampleTime();
      i = this.mediaCodecWrapper.dequeueInputBuffer();
    } while (i < 0);
    Object localObject = this.mediaCodecWrapper.getInputBuffer(i);
    int j = this.extractor.readSampleData((ByteBuffer)localObject, 0);
    if (j >= 0)
    {
      this.mLastVideoQueueTime = (l - this.timeRange.getStartUs() + this.mTimeOffset);
      this.mediaCodecWrapper.queueInputBuffer(i, 0, j, this.mLastVideoQueueTime, 0);
      localObject = new VideoDecoder.PendingFrame(null);
      VideoDecoder.PendingFrame.access$602((VideoDecoder.PendingFrame)localObject, this.mTimeOffset);
      VideoDecoder.PendingFrame.access$702((VideoDecoder.PendingFrame)localObject, this.currentStartState.getTime());
      this.pendingFrames.add(localObject);
    }
    this.extractor.advance();
  }
  
  private CMSampleState renderCacheBuffer()
  {
    Logger.v(this.TAG, "renderCacheBuffer: cache hit - " + this.currentDecoderState);
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if (this.currentDecoderState.getTime().bigThan(this.timeRange.getEnd()))
      {
        this.currentDecoderState = CMSampleState.fromError(-1L);
        this.pendingFrames.clear();
        this.extractorDone = true;
      }
      CMSampleState localCMSampleState = this.currentDecoderState;
      return localCMSampleState;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "renderCacheBuffer: ", localException);
    }
    return CMSampleState.fromError(-2L);
  }
  
  /* Error */
  private void seekExtractorTo(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   6: ifnonnull +26 -> 32
    //   9: aload_0
    //   10: getfield 89	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   13: ldc_w 633
    //   16: new 190	java/lang/RuntimeException
    //   19: dup
    //   20: ldc_w 559
    //   23: invokespecial 193	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   26: invokestatic 539	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   36: lload_1
    //   37: iconst_2
    //   38: invokevirtual 530	com/tencent/tav/extractor/AssetExtractor:seekTo	(JI)V
    //   41: aload_0
    //   42: getfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   45: invokevirtual 533	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   48: lload_1
    //   49: lcmp
    //   50: ifle +12 -> 62
    //   53: aload_0
    //   54: getfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: lload_1
    //   58: iconst_0
    //   59: invokevirtual 530	com/tencent/tav/extractor/AssetExtractor:seekTo	(JI)V
    //   62: aload_0
    //   63: invokespecial 635	com/tencent/tav/decoder/VideoDecoder:clearDecoder	()V
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 150	com/tencent/tav/decoder/VideoDecoder:mLastVideoQueueTime	J
    //   71: ldc2_w 145
    //   74: ladd
    //   75: putfield 148	com/tencent/tav/decoder/VideoDecoder:mTimeOffset	J
    //   78: goto -49 -> 29
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	VideoDecoder
    //   0	86	1	paramLong	long
    //   81	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	81	finally
    //   32	62	81	finally
    //   62	78	81	finally
  }
  
  protected void finalize()
  {
    super.finalize();
    release(false);
  }
  
  public String getSourcePath()
  {
    if (this.extractor == null) {
      return null;
    }
    return this.extractor.getSourcePath();
  }
  
  public TextureInfo getTextureInfo()
  {
    return null;
  }
  
  /* Error */
  public boolean hasTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/tav/decoder/VideoDecoder:trackIndex	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_m1
    //   9: if_icmpeq +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VideoDecoder
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public boolean isLastFrameValid()
  {
    return this.lastFrameValid;
  }
  
  public boolean isStarted()
  {
    return this.started;
  }
  
  public Surface outputSurface()
  {
    try
    {
      Surface localSurface = this.outputSurface;
      return localSurface;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMSampleState readSample(CMTime paramCMTime)
  {
    int k = 0;
    for (;;)
    {
      try
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("readSample: ").append(paramCMTime).append(", currentDecoderTime = ").append(this.currentDecoderState).append(",  extractor.getSampleTime() = ");
        if (this.extractor != null)
        {
          localObject = Long.valueOf(this.extractor.getSampleTime());
          Logger.v(str, localObject + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
          this.lastFrameValid = false;
          if ((outputSurface() == null) || (this.lastOutputBufferIndex == -1)) {
            break label428;
          }
          i = 1;
          if (!this.currentDecoderState.getTime().smallThan(paramCMTime)) {
            break label423;
          }
          j = k;
          if (this.extractorDone)
          {
            j = k;
            if (this.pendingFrames.isEmpty()) {
              break label423;
            }
          }
          if ((i != 0) && (j != 0))
          {
            paramCMTime = renderCacheBuffer();
            return paramCMTime;
          }
        }
        else
        {
          localObject = "null";
          continue;
        }
        Object localObject = doReadSample(paramCMTime, false);
        if ((!this.currentDecoderState.isInvalid()) && (((CMSampleState)localObject).getTime().bigThan(this.timeRange.getDuration())))
        {
          this.currentDecoderState = CMSampleState.fromError(-1L);
          this.pendingFrames.clear();
          this.extractorDone = true;
          Logger.v(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentDecoderState);
          this.readSampleFinish = true;
          paramCMTime = this.currentDecoderState;
          continue;
        }
        this.currentDecoderState = ((CMSampleState)localObject);
        if ((this.currentDecoderState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentDecoderState.getTime().smallThan(this.duration))) {
          clearDecoder();
        }
        Logger.v(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + paramCMTime + "  -  " + this.currentDecoderState);
        paramCMTime = (CMTime)localObject;
        continue;
        int j = 1;
      }
      finally {}
      label423:
      continue;
      label428:
      int i = 0;
    }
  }
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 89	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   18: new 66	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 683
    //   28: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 327	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +22 -> 64
    //   45: aload_0
    //   46: getfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: getfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   56: invokevirtual 686	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 206	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   64: aload_0
    //   65: getfield 276	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   68: ifnull +15 -> 83
    //   71: aload_0
    //   72: getfield 276	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   75: invokevirtual 686	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 276	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 140	com/tencent/tav/decoder/VideoDecoder:started	Z
    //   88: aload_0
    //   89: iconst_1
    //   90: putfield 138	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   93: aload_0
    //   94: getfield 116	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   97: invokevirtual 688	com/tencent/tav/decoder/MediaCodecWrapper:release	()V
    //   100: aload_0
    //   101: getfield 89	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   104: new 66	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 690
    //   114: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_1
    //   118: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   121: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 327	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: goto -116 -> 11
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	VideoDecoder
    //   0	135	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   130	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	130	finally
    //   14	41	130	finally
    //   45	64	130	finally
    //   64	83	130	finally
    //   83	127	130	finally
  }
  
  void releaseOutputBuffer()
  {
    if (this.lastOutputBufferIndex != -1) {}
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void seekTo(CMTime paramCMTime)
  {
    try
    {
      seekTo(paramCMTime, true);
      return;
    }
    finally
    {
      paramCMTime = finally;
      throw paramCMTime;
    }
  }
  
  public void seekTo(CMTime paramCMTime, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Logger.v(this.TAG, "seekTo: " + paramCMTime + "  - " + this + "  " + this.currentStartState + "  " + this.currentDecoderState);
        if ((!this.started) || (this.trackIndex == -1))
        {
          Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
          return;
        }
        Object localObject = paramCMTime;
        if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
          localObject = CMTime.CMTimeZero;
        }
        paramCMTime = this.timeRange.getStart().add((CMTime)localObject);
        if (((!paramBoolean) || (!moreCloseCurrentThenSeek((CMTime)localObject))) && (!((CMTime)localObject).equalsTo(this.currentDecoderState.getTime())) && (!hasPreReadAndFirstFrameSeek((CMTime)localObject)))
        {
          this.currentStartState = new CMSampleState((CMTime)localObject);
          seekExtractorTo(paramCMTime.getTimeUs());
          this.extractorDone = false;
          localObject = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("seekTo: finish - ").append(this.currentStartState).append("  ");
          if (this.extractor != null)
          {
            paramCMTime = Long.valueOf(this.extractor.getSampleTime());
            Logger.v((String)localObject, paramCMTime);
          }
          else
          {
            paramCMTime = "null";
          }
        }
      }
      finally {}
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      start(paramCMTimeRange, CMTime.CMTimeZero);
      return;
    }
    finally
    {
      paramCMTimeRange = finally;
      throw paramCMTimeRange;
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    for (;;)
    {
      try
      {
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          return;
        }
        clearDecoder();
        if (paramCMTimeRange == null)
        {
          this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
          this.extractorDone = false;
          this.started = true;
          if (paramCMTime.getTimeUs() >= 0L)
          {
            seekTo(paramCMTime, false);
            preReadSample();
          }
        }
        else
        {
          this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */