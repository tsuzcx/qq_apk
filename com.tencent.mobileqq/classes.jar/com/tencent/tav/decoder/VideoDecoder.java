package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VideoDecoder
  implements IVideoDecoder
{
  private static final int MAX_WAIT_TIME = 1000;
  public final String TAG = "VideoDecoder@" + Integer.toHexString(hashCode());
  private List<Long> allFrameTime = new ArrayList();
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private CMTime currentDecoderTime = CMTime.CMTimeInvalid;
  private CMTime currentStartTime = CMTime.CMTimeInvalid;
  private CMTime duration = CMTime.CMTimeZero;
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
  private ByteBuffer outputBuffer = null;
  private Surface outputSurface;
  private CMTime pFrameTime = new CMTime(20L, 600);
  private ArrayList<VideoDecoder.PendingFrame> pendingFrames = new ArrayList();
  private CMTime preReadTime = CMTime.CMTimeInvalid;
  private boolean started = false;
  private CMTimeRange timeRange;
  private int trackIndex = -1;
  
  public VideoDecoder(String paramString)
  {
    this(paramString, null);
  }
  
  public VideoDecoder(String paramString, Surface paramSurface)
  {
    Logger.i(this.TAG, "create VideoDecoder start", new Object[0]);
    if (paramSurface != null) {
      this.outputSurface = paramSurface;
    }
    long l = System.currentTimeMillis();
    if (!initExtractor(paramString)) {
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
      Logger.i(this.TAG, "create VideoDecoder end " + (System.currentTimeMillis() - l), new Object[0]);
      return;
    }
    throw new IllegalStateException("decoderConfigure failed!");
  }
  
  private void clearDecoder()
  {
    Logger.i(this.TAG, "clearDecoder " + getSourcePath(), new Object[0]);
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.mediaCodecWrapper.flushDecoder();
      this.pendingFrames.clear();
      this.currentDecoderTime = CMTime.CMTimeInvalid;
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
    new VideoDecoder.1(this).start();
  }
  
  private void doReadFrames(VideoDecoder.SampleTime paramSampleTime, CMTime paramCMTime, boolean paramBoolean)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d(this.TAG, "doReadFrames() called with: sampleTime = [" + paramSampleTime + "], targetTime = [" + paramCMTime + "], justCache = [" + paramBoolean + "]");
    }
    if ((this.pendingFrames.size() == 0) && (this.extractorDone)) {
      Logger.e(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
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
          Logger.e(this.TAG, "doReadFrames:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FINISH);
        }
      }
      label910:
      label916:
      label931:
      for (;;)
      {
        return;
        if ((n < 0) || (this.pendingFrames.size() <= 0))
        {
          if (n >= 0)
          {
            Logger.e(this.TAG, "doReadFrames:[failed] pendingFrames.size() == " + this.pendingFrames.size());
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
          }
          i += 1;
          if (i > 1000)
          {
            Logger.e(this.TAG, "doReadFrames: [timeout] ");
            VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_TIMEOUT);
          }
        }
        else
        {
          for (;;)
          {
            if ((!this.extractorDone) || (VideoDecoder.SampleTime.access$600(paramSampleTime) >= 0L) || (paramBoolean)) {
              break label931;
            }
            Logger.e(this.TAG, "doReadFrames: extractorDone && sampleTime.timeUs < 0, sampleTime = " + paramSampleTime);
            VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FINISH);
            return;
            if (this.bufferInfo.size <= 0)
            {
              this.mediaCodecWrapper.releaseOutputBuffer(n, false);
              Logger.e(this.TAG, "doReadFrames:[failed] bufferInfo.size == " + this.bufferInfo.size);
              VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
              break;
            }
            VideoDecoder.PendingFrame localPendingFrame = (VideoDecoder.PendingFrame)this.pendingFrames.remove(0);
            VideoDecoder.SampleTime.access$602(paramSampleTime, this.bufferInfo.presentationTimeUs - VideoDecoder.PendingFrame.access$700(localPendingFrame));
            VideoDecoder.SampleTime.access$502(paramSampleTime, new CMTime((float)VideoDecoder.SampleTime.access$600(paramSampleTime) * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L)));
            if ((this.pendingFrames.isEmpty()) && (this.extractorDone)) {}
            for (int j = 1;; j = 0)
            {
              if ((j != 0) || (VideoDecoder.PendingFrame.access$800(localPendingFrame).getTimeUs() <= VideoDecoder.SampleTime.access$600(paramSampleTime) + this.frameDurationUs / 2L)) {
                break label580;
              }
              this.mediaCodecWrapper.releaseOutputBuffer(n, false);
              if (Logger.LOG_VERBOSE) {
                Logger.e(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
              }
              VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
              break;
            }
            label580:
            if ((this.outputSurface == null) || (paramBoolean))
            {
              this.lastOutputBufferIndex = n;
              paramCMTime = this.mediaCodecWrapper.getOnputBuffer(n);
              if (paramCMTime != null)
              {
                paramCMTime.position(this.bufferInfo.offset);
                paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
                this.outputBuffer = paramCMTime;
                VideoDecoder.SampleTime.access$900(paramSampleTime);
              }
              else
              {
                this.mediaCodecWrapper.releaseOutputBuffer(n, false);
                Logger.e(this.TAG, "doReadFrames:[error] " + this.bufferInfo.size + " byteBuffer==null");
                VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_ERROR);
              }
            }
            else
            {
              if (j != 0) {
                VideoDecoder.SampleTime.access$502(paramSampleTime, this.duration);
              }
              int k;
              if (paramCMTime.getTimeUs() - VideoDecoder.SampleTime.access$500(paramSampleTime).getTimeUs() <= this.frameDurationUs / 2L)
              {
                k = 1;
                label754:
                if (paramCMTime.getTimeUs() < this.duration.getTimeUs()) {
                  break label910;
                }
              }
              for (int m = 1;; m = 0)
              {
                if ((k != 0) || (m != 0) || (j != 0)) {
                  break label916;
                }
                this.mediaCodecWrapper.releaseOutputBuffer(n, false);
                if (Logger.LOG_VERBOSE) {
                  Logger.e(this.TAG, "doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == " + (paramCMTime.getTimeUs() - VideoDecoder.SampleTime.access$500(paramSampleTime).getTimeUs()) + " targetTime = " + paramCMTime + "  duration = " + this.duration + " pendingFrames.size() = " + this.pendingFrames.size() + " extractorDone = " + this.extractorDone);
                }
                VideoDecoder.SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
                break;
                k = 0;
                break label754;
              }
              this.mediaCodecWrapper.releaseOutputBuffer(n, true);
              VideoDecoder.SampleTime.access$900(paramSampleTime);
            }
          }
        }
      }
    }
  }
  
  private CMTime doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((paramCMTime.bigThan(this.timeRange.getDuration())) && (!paramBoolean))
        {
          Logger.e(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + paramCMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache is" + true);
          paramCMTime = SAMPLE_TIME_FINISH;
          return paramCMTime;
        }
        if ((this.extractorDone) && (this.pendingFrames.size() == 0) && (this.timeRange.containsTime(paramCMTime)))
        {
          Logger.e(this.TAG, "error state , and will go correct it ! ");
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
              break label356;
            }
            paramBoolean = bool;
            Logger.e(paramCMTime, paramBoolean);
            paramCMTime = SAMPLE_TIME_UNSTART;
          }
        }
        else
        {
          releaseOutputBuffer();
          localObject = new VideoDecoder.SampleTime(this, null);
          VideoDecoder.SampleTime.access$502((VideoDecoder.SampleTime)localObject, SAMPLE_TIME_FAILED);
          VideoDecoder.SampleTime.access$602((VideoDecoder.SampleTime)localObject, SAMPLE_TIME_FAILED.value);
          try
          {
            doReadFrames((VideoDecoder.SampleTime)localObject, paramCMTime, paramBoolean);
            if (Logger.LOG_VERBOSE) {
              Logger.i(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + VideoDecoder.SampleTime.access$600((VideoDecoder.SampleTime)localObject) + "  " + VideoDecoder.SampleTime.access$500((VideoDecoder.SampleTime)localObject), new Object[0]);
            }
            paramCMTime = VideoDecoder.SampleTime.access$500((VideoDecoder.SampleTime)localObject);
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
      label356:
      paramBoolean = false;
    }
  }
  
  private boolean hasPreReadAndFirstFrameSeek(CMTime paramCMTime)
  {
    return (paramCMTime == CMTime.CMTimeZero) && (this.preReadTime != CMTime.CMTimeInvalid) && (this.lastOutputBufferIndex != -1) && (this.currentDecoderTime != CMTime.CMTimeInvalid);
  }
  
  private boolean initExtractor(String paramString)
  {
    this.extractor = new AssetExtractor();
    this.extractor.setDataSource(paramString);
    while (this.extractor.getSampleTrackIndex() != -1) {
      this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "video/");
    if (this.trackIndex == -1)
    {
      this.outputSurface = null;
      this.outputBuffer = null;
      return false;
    }
    this.extractor.selectTrack(this.trackIndex);
    return true;
  }
  
  private boolean moreCloseCurrentThenSeek(CMTime paramCMTime)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mirrorExtractor != null)
    {
      long l1 = this.extractor.getSampleTime();
      this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 2);
      if (this.mirrorExtractor.getSampleTime() > paramCMTime.getTimeUs()) {
        this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 0);
      }
      long l2 = this.mirrorExtractor.getSampleTime();
      bool1 = bool2;
      if (l2 <= l1)
      {
        bool1 = bool2;
        if (this.currentDecoderTime.getTimeUs() >= l2)
        {
          bool1 = bool2;
          if (this.currentDecoderTime.getTimeUs() < paramCMTime.getTimeUs() + this.pFrameTime.getTimeUs())
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
  private CMTime onReadFramesException(Exception paramException)
  {
    Logger.e(this.TAG, "onReadFramesException: ", paramException);
    if (Build.VERSION.SDK_INT < 21) {
      return SAMPLE_TIME_ERROR;
    }
    if (!(paramException instanceof MediaCodec.CodecException)) {
      return SAMPLE_TIME_ERROR;
    }
    if (((MediaCodec.CodecException)paramException).isRecoverable())
    {
      releaseOutputBuffer();
      this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartTime.getTimeUs();
      long l2 = this.timeRange.getStartUs();
      this.extractor.seekTo(l1 - l2, 0);
      this.extractorDone = false;
      return SAMPLE_TIME_ERROR;
    }
    if (((MediaCodec.CodecException)paramException).isTransient()) {
      Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    return SAMPLE_TIME_ERROR;
  }
  
  private void preReadSample()
  {
    try
    {
      this.lastFrameValid = false;
      this.currentDecoderTime = doReadSample(CMTime.CMTimeInvalid, true);
      if ((CMTime.CMTimeInvalid.smallThan(CMTime.CMTimeZero)) && (!this.currentDecoderTime.smallThan(CMTime.CMTimeZero))) {
        this.currentDecoderTime = this.currentStartTime;
      }
      this.preReadTime = this.currentDecoderTime;
      Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex, new Object[0]);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void readFromExtractor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 174	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   6: invokevirtual 496	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   9: lstore_2
    //   10: lload_2
    //   11: aload_0
    //   12: getfield 235	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   15: invokevirtual 543	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   18: lcmp
    //   19: ifge +22 -> 41
    //   22: aload_0
    //   23: getfield 174	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   26: invokevirtual 477	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   29: iconst_m1
    //   30: if_icmpeq +11 -> 41
    //   33: lload_2
    //   34: ldc2_w 544
    //   37: lcmp
    //   38: ifne +51 -> 89
    //   41: lload_2
    //   42: aload_0
    //   43: getfield 235	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   46: invokevirtual 543	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   49: lcmp
    //   50: iflt +7 -> 57
    //   53: aload_0
    //   54: invokespecial 548	com/tencent/tav/decoder/VideoDecoder:readSampleData	()V
    //   57: aload_0
    //   58: getfield 110	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   61: invokevirtual 551	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   64: istore_1
    //   65: iload_1
    //   66: iflt +20 -> 86
    //   69: aload_0
    //   70: getfield 110	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   73: iload_1
    //   74: iconst_0
    //   75: iconst_0
    //   76: lconst_0
    //   77: iconst_4
    //   78: invokevirtual 555	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 149	com/tencent/tav/decoder/VideoDecoder:extractorDone	Z
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: aload_0
    //   90: invokespecial 548	com/tencent/tav/decoder/VideoDecoder:readSampleData	()V
    //   93: goto -7 -> 86
    //   96: astore 4
    //   98: aload_0
    //   99: monitorexit
    //   100: aload 4
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	VideoDecoder
    //   64	10	1	i	int
    //   9	33	2	l	long
    //   96	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	96	finally
    //   41	57	96	finally
    //   57	65	96	finally
    //   69	86	96	finally
    //   89	93	96	finally
  }
  
  private void readSampleData()
  {
    long l = this.extractor.getSampleTime();
    int i = this.mediaCodecWrapper.dequeueInputBuffer();
    if (i >= 0)
    {
      Object localObject = this.mediaCodecWrapper.getInputBuffer(i);
      int j = this.extractor.readSampleData((ByteBuffer)localObject, 0);
      if (j >= 0)
      {
        this.mLastVideoQueueTime = (l - this.timeRange.getStartUs() + this.mTimeOffset);
        this.mediaCodecWrapper.queueInputBuffer(i, 0, j, this.mLastVideoQueueTime, 0);
        localObject = new VideoDecoder.PendingFrame(null);
        VideoDecoder.PendingFrame.access$702((VideoDecoder.PendingFrame)localObject, this.mTimeOffset);
        VideoDecoder.PendingFrame.access$802((VideoDecoder.PendingFrame)localObject, this.currentStartTime);
        this.pendingFrames.add(localObject);
      }
      this.extractor.advance();
    }
  }
  
  private CMTime renderCacheBuffer()
  {
    if (Logger.LOG_VERBOSE) {
      Logger.e(this.TAG, "renderCacheBuffer: cache hit - " + this.currentDecoderTime);
    }
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if (this.currentDecoderTime.bigThan(this.timeRange.getEnd()))
      {
        this.currentDecoderTime = SAMPLE_TIME_FINISH;
        this.pendingFrames.clear();
        this.extractorDone = true;
      }
      CMTime localCMTime = this.currentDecoderTime;
      return localCMTime;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, localException);
    }
    return SAMPLE_TIME_FAILED;
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      return;
    }
    finally {}
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
    //   3: getfield 103	com/tencent/tav/decoder/VideoDecoder:trackIndex	I
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
  
  public void init(String paramString, CGSize paramCGSize, IDecoderTrack.SurfaceCreator paramSurfaceCreator) {}
  
  public boolean isLastFrameValid()
  {
    return this.lastFrameValid;
  }
  
  public boolean isStarted()
  {
    return this.started;
  }
  
  public CMTime nextFrameTime(CMTime paramCMTime)
  {
    long l1 = paramCMTime.getTimeUs();
    paramCMTime = this.allFrameTime.iterator();
    while (paramCMTime.hasNext())
    {
      long l2 = ((Long)paramCMTime.next()).longValue();
      if (l1 < l2) {
        return new CMTime((float)l2 / 1000.0F / 1000.0F);
      }
    }
    return this.currentDecoderTime.add(this.pFrameTime);
  }
  
  public ByteBuffer outputBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this.outputBuffer;
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
  
  public CMTime readSample()
  {
    try
    {
      CMTime localCMTime = readSample(CMTime.CMTimeInvalid);
      return localCMTime;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime readSample(CMTime paramCMTime)
  {
    int k = 0;
    label410:
    for (;;)
    {
      try
      {
        if (Logger.LOG_VERBOSE) {
          Logger.d(this.TAG, "readSample: " + paramCMTime + ", currentDecoderTime = " + this.currentDecoderTime + ",  extractor.getSampleTime() = " + this.extractor.getSampleTime() + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
        }
        this.lastFrameValid = false;
        int i;
        int j;
        Object localObject;
        if ((outputSurface() != null) && (this.lastOutputBufferIndex != -1))
        {
          i = 1;
          if (!this.currentDecoderTime.smallThan(paramCMTime)) {
            break label410;
          }
          j = k;
          if (this.extractorDone)
          {
            j = k;
            if (this.pendingFrames.isEmpty()) {
              break label410;
            }
          }
          if ((i != 0) && (j != 0))
          {
            localObject = renderCacheBuffer();
            return localObject;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        CMTime localCMTime = doReadSample(paramCMTime, false);
        if ((this.currentDecoderTime != CMTime.CMTimeInvalid) && (localCMTime.bigThan(this.timeRange.getDuration())))
        {
          this.currentDecoderTime = SAMPLE_TIME_FINISH;
          this.pendingFrames.clear();
          this.extractorDone = true;
          if (Logger.LOG_VERBOSE) {
            Logger.i(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentDecoderTime, new Object[0]);
          }
          localObject = this.currentDecoderTime;
        }
        else
        {
          this.currentDecoderTime = localCMTime;
          if ((this.currentDecoderTime == SAMPLE_TIME_FINISH) || (this.currentDecoderTime == SAMPLE_TIME_TIMEOUT) || (!this.currentDecoderTime.smallThan(this.duration))) {
            clearDecoder();
          }
          localObject = localCMTime;
          if (Logger.LOG_VERBOSE)
          {
            Logger.i(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + paramCMTime + "  -  " + this.currentDecoderTime, new Object[0]);
            localObject = localCMTime;
            continue;
            j = 1;
          }
        }
      }
      finally {}
    }
  }
  
  public void release() {}
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 133	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 83	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   18: new 60	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 657
    //   28: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 289	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 174	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 660	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 174	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: getfield 243	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 243	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   68: invokevirtual 660	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 243	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 135	com/tencent/tav/decoder/VideoDecoder:started	Z
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 133	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   86: aload_0
    //   87: getfield 110	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   90: invokevirtual 662	com/tencent/tav/decoder/MediaCodecWrapper:release	()V
    //   93: aload_0
    //   94: getfield 83	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   97: new 60	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 664
    //   107: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_1
    //   111: invokevirtual 289	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: goto -109 -> 11
    //   123: astore_3
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_3
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	VideoDecoder
    //   0	128	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   123	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	123	finally
    //   14	41	123	finally
    //   45	57	123	finally
    //   57	76	123	finally
    //   76	120	123	finally
  }
  
  void releaseOutputBuffer()
  {
    if (this.lastOutputBufferIndex != -1) {}
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
      this.outputBuffer = null;
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
  
  /* Error */
  public void seekTo(CMTime paramCMTime, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   6: new 60	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 669
    //   16: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc_w 671
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc_w 465
    //   36: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 147	com/tencent/tav/decoder/VideoDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   43: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc_w 465
    //   49: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 122	com/tencent/tav/decoder/VideoDecoder:currentDecoderTime	Lcom/tencent/tav/coremedia/CMTime;
    //   56: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokestatic 157	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 135	com/tencent/tav/decoder/VideoDecoder:started	Z
    //   73: ifeq +11 -> 84
    //   76: aload_0
    //   77: getfield 103	com/tencent/tav/decoder/VideoDecoder:trackIndex	I
    //   80: iconst_m1
    //   81: if_icmpne +16 -> 97
    //   84: aload_0
    //   85: getfield 83	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   88: ldc_w 673
    //   91: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: aload_1
    //   98: astore_3
    //   99: aload_1
    //   100: getstatic 92	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   103: invokevirtual 534	com/tencent/tav/coremedia/CMTime:smallThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   106: ifeq +7 -> 113
    //   109: getstatic 92	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 235	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   117: invokevirtual 676	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   120: aload_3
    //   121: invokevirtual 632	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   124: astore_1
    //   125: iload_2
    //   126: ifeq +11 -> 137
    //   129: aload_0
    //   130: aload_3
    //   131: invokespecial 678	com/tencent/tav/decoder/VideoDecoder:moreCloseCurrentThenSeek	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   134: ifne -40 -> 94
    //   137: aload_3
    //   138: aload_0
    //   139: getfield 122	com/tencent/tav/decoder/VideoDecoder:currentDecoderTime	Lcom/tencent/tav/coremedia/CMTime;
    //   142: invokevirtual 681	com/tencent/tav/coremedia/CMTime:equalsTo	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   145: ifne -51 -> 94
    //   148: aload_0
    //   149: aload_3
    //   150: invokespecial 683	com/tencent/tav/decoder/VideoDecoder:hasPreReadAndFirstFrameSeek	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   153: ifne -59 -> 94
    //   156: aload_0
    //   157: aload_3
    //   158: putfield 147	com/tencent/tav/decoder/VideoDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual 375	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   166: invokespecial 685	com/tencent/tav/decoder/VideoDecoder:seekExtractorTo	(J)V
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 149	com/tencent/tav/decoder/VideoDecoder:extractorDone	Z
    //   174: aload_0
    //   175: getfield 83	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   178: new 60	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 687
    //   188: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: getfield 147	com/tencent/tav/decoder/VideoDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   195: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: ldc_w 465
    //   201: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: getfield 174	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   208: invokevirtual 496	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   211: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 157	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: goto -130 -> 94
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	VideoDecoder
    //   0	232	1	paramCMTime	CMTime
    //   0	232	2	paramBoolean	boolean
    //   98	60	3	localCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	84	227	finally
    //   84	94	227	finally
    //   99	113	227	finally
    //   113	125	227	finally
    //   129	137	227	finally
    //   137	224	227	finally
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
        Logger.i(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]", new Object[0]);
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
  
  public void switchFrame() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */