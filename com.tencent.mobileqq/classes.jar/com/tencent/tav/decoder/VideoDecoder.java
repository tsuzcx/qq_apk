package com.tencent.tav.decoder;

import android.media.MediaCodec;
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
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class VideoDecoder
  implements IVideoDecoder
{
  private static final int MAX_WAIT_TIME = 1000;
  public final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private CMSampleState currentDecoderState;
  private CMSampleState currentStartState;
  private CMTime duration;
  private final HashMap<String, Object> extraInfo;
  @Nullable
  private AssetExtractor extractor;
  private boolean extractorDone;
  private long frameDurationUs;
  boolean isReleased;
  boolean lastFrameValid;
  private int lastOutputBufferIndex;
  private long mLastVideoQueueTime;
  private long mTimeOffset;
  private final MediaCodecWrapper mediaCodecWrapper;
  private MediaFormat mediaFormat;
  private AssetExtractor mirrorExtractor;
  private Surface outputSurface;
  private CMTime pFrameTime;
  @NotNull
  private final IVideoDecoder.Params params;
  private ArrayList<VideoDecoder.PendingFrame> pendingFrames;
  private CMTime preReadTime;
  private boolean readSampleFinish;
  private final String sourcePath;
  private boolean started;
  private CMTimeRange timeRange;
  private int trackIndex;
  
  public VideoDecoder(IVideoDecoder.Params paramParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoDecoder@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.frameDurationUs = 33333L;
    this.duration = CMTime.CMTimeZero;
    this.pFrameTime = new CMTime(20L, 600);
    this.trackIndex = -1;
    this.mediaCodecWrapper = new MediaCodecWrapper(this);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.currentDecoderState = new CMSampleState();
    this.preReadTime = CMTime.CMTimeInvalid;
    this.pendingFrames = new ArrayList();
    this.isReleased = false;
    this.started = false;
    this.lastFrameValid = false;
    this.lastOutputBufferIndex = -1;
    this.mTimeOffset = 10000000L;
    this.mLastVideoQueueTime = 0L;
    this.currentStartState = new CMSampleState();
    this.extractorDone = false;
    this.readSampleFinish = false;
    this.params = paramParams;
    this.sourcePath = paramParams.filePath;
    this.extraInfo = paramParams.extraInfo;
    this.outputSurface = paramParams.outputSurface;
    paramParams = this.TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoDecoder() called with: sourcePath = [");
    localStringBuilder.append(this.sourcePath);
    localStringBuilder.append("], outputSurface = [");
    localStringBuilder.append(this.outputSurface);
    localStringBuilder.append("]");
    Logger.d(paramParams, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(this.sourcePath)) && (new File(this.sourcePath).exists()))
    {
      long l = System.currentTimeMillis();
      this.extractor = initExtractor(this.sourcePath);
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
      if (this.mediaCodecWrapper.decoderConfigure(this.mediaFormat, this.outputSurface))
      {
        this.mediaCodecWrapper.startDecoder(this.outputSurface, this.mediaFormat);
        paramParams = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("create VideoDecoder end ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        Logger.d(paramParams, localStringBuilder.toString());
        return;
      }
      throw new IllegalStateException("decoderConfigure failed!");
    }
    paramParams = new StringBuilder();
    paramParams.append("文件不存在：path = ");
    paramParams.append(this.sourcePath);
    throw new RuntimeException(paramParams.toString());
  }
  
  @NotNull
  private CMSampleState buildSampleStateError(Exception paramException)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sourcePath:");
    ((StringBuilder)localObject1).append(this.sourcePath);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (this.extraInfo != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(";decodeInfo:");
      ((StringBuilder)localObject1).append(this.extraInfo.get("extra_info_key_decode_info"));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    Object localObject3;
    if (this.mediaCodecWrapper.getMediaCodec() != null)
    {
      localObject2 = localObject1;
      StringBuilder localStringBuilder;
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          localObject2 = this.mediaCodecWrapper.getMediaCodec().getInputFormat();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(";inputFormat=");
          localStringBuilder.append(((MediaFormat)localObject2).toString());
          localObject2 = localStringBuilder.toString();
        }
        catch (Exception localException2)
        {
          Logger.e(this.TAG, "buildSampleStateError: ", localException2);
          localObject3 = localObject1;
        }
      }
      try
      {
        localObject1 = this.mediaCodecWrapper.getMediaCodec().getOutputFormat();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject3);
        localStringBuilder.append(";outputFormat=");
        localStringBuilder.append(((MediaFormat)localObject1).toString());
        localObject1 = localStringBuilder.toString();
        localObject3 = localObject1;
      }
      catch (Exception localException1)
      {
        Logger.e(this.TAG, "buildSampleStateError: ", localException1);
      }
    }
    return CMSampleState.fromError(-3L, localObject3, paramException);
  }
  
  private void clearDecoder()
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDecoder ");
    localStringBuilder.append(getSourcePath());
    Logger.d(str, localStringBuilder.toString());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone))
    {
      try
      {
        this.mediaCodecWrapper.flushDecoder();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.pendingFrames.clear();
    }
    this.currentDecoderState = new CMSampleState();
  }
  
  private void createMirrorExtractor()
  {
    ThreadPool.execute(new VideoDecoder.1(this));
  }
  
  private void doFixCropSize()
  {
    MediaFormat localMediaFormat = this.mediaCodecWrapper.getMediaCodec().getOutputFormat();
    if (localMediaFormat != null)
    {
      if (this.params.videoTexture == null) {
        return;
      }
      int i;
      int j;
      int k;
      if (localMediaFormat.containsKey("width"))
      {
        i = localMediaFormat.getInteger("width");
        if ((localMediaFormat.containsKey("crop-left")) && (localMediaFormat.containsKey("crop-right")))
        {
          j = localMediaFormat.getInteger("crop-right");
          k = localMediaFormat.getInteger("crop-left");
          this.params.videoTexture.scaleX = ((j + 1 - k) * 1.0F / i);
        }
      }
      if (localMediaFormat.containsKey("height"))
      {
        i = localMediaFormat.getInteger("height");
        if ((localMediaFormat.containsKey("crop-top")) && (localMediaFormat.containsKey("crop-bottom")))
        {
          j = localMediaFormat.getInteger("crop-bottom");
          k = localMediaFormat.getInteger("crop-top");
          this.params.videoTexture.scaleY = ((j + 1 - k) * 1.0F / i);
        }
      }
    }
  }
  
  private void doReadFrames(VideoDecoder.SampleTime paramSampleTime, CMTime paramCMTime, boolean paramBoolean)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doReadFrames() called with: sampleTime = [");
    localStringBuilder.append(paramSampleTime);
    localStringBuilder.append("], targetTime = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], justCache = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.v((String)localObject, localStringBuilder.toString());
    if ((this.pendingFrames.size() == 0) && (this.extractorDone)) {
      Logger.i(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
    }
    int i = 0;
    while ((this.pendingFrames.size() > 0) || (!this.extractorDone))
    {
      if (!this.extractorDone) {
        readFromExtractor();
      }
      int n = this.mediaCodecWrapper.dequeueOutputBuffer(this.bufferInfo);
      tryFixCropSize();
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        if ((this.bufferInfo.size > 0) && (n >= 0) && (this.pendingFrames.size() > 0))
        {
          this.pendingFrames.remove(0);
          this.mediaCodecWrapper.releaseOutputBuffer(n, true);
        }
        Logger.i(this.TAG, "doReadFrames:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
        VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-1L));
        return;
      }
      int j;
      if ((n >= 0) && (this.pendingFrames.size() > 0))
      {
        if (this.bufferInfo.size <= 0)
        {
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReadFrames:[failed] bufferInfo.size == ");
          localStringBuilder.append(this.bufferInfo.size);
          Logger.e((String)localObject, localStringBuilder.toString());
          VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
        }
        else
        {
          localObject = (VideoDecoder.PendingFrame)this.pendingFrames.remove(0);
          VideoDecoder.SampleTime.access$502(paramSampleTime, this.bufferInfo.presentationTimeUs - VideoDecoder.PendingFrame.access$600((VideoDecoder.PendingFrame)localObject));
          VideoDecoder.SampleTime.access$402(paramSampleTime, new CMSampleState(new CMTime((float)VideoDecoder.SampleTime.access$500(paramSampleTime) * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L))));
          if ((this.pendingFrames.isEmpty()) && (this.extractorDone)) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j == 0) && (VideoDecoder.PendingFrame.access$700((VideoDecoder.PendingFrame)localObject).getTimeUs() > VideoDecoder.SampleTime.access$500(paramSampleTime) + this.frameDurationUs / 2L))
          {
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            Logger.v(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
            VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
          }
          else if ((this.outputSurface != null) && (!paramBoolean))
          {
            if (j != 0) {
              VideoDecoder.SampleTime.access$402(paramSampleTime, new CMSampleState(this.duration));
            }
            int k;
            if (paramCMTime.getTimeUs() - VideoDecoder.SampleTime.access$400(paramSampleTime).getTime().getTimeUs() <= this.frameDurationUs / 2L) {
              k = 1;
            } else {
              k = 0;
            }
            int m;
            if (paramCMTime.getTimeUs() >= this.duration.getTimeUs()) {
              m = 1;
            } else {
              m = 0;
            }
            if ((k == 0) && (m == 0) && (j == 0))
            {
              this.mediaCodecWrapper.releaseOutputBuffer(n, false);
              localObject = this.TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == ");
              localStringBuilder.append(paramCMTime.getTimeUs() - VideoDecoder.SampleTime.access$400(paramSampleTime).getTime().getTimeUs());
              localStringBuilder.append(" targetTime = ");
              localStringBuilder.append(paramCMTime);
              localStringBuilder.append("  duration = ");
              localStringBuilder.append(this.duration);
              localStringBuilder.append(" pendingFrames.size() = ");
              localStringBuilder.append(this.pendingFrames.size());
              localStringBuilder.append(" extractorDone = ");
              localStringBuilder.append(this.extractorDone);
              Logger.v((String)localObject, localStringBuilder.toString());
              VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
            }
            else
            {
              this.mediaCodecWrapper.releaseOutputBuffer(n, true);
              VideoDecoder.SampleTime.access$800(paramSampleTime);
            }
          }
          else
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
              paramCMTime = this.TAG;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("doReadFrames:[error] ");
              ((StringBuilder)localObject).append(this.bufferInfo.size);
              ((StringBuilder)localObject).append(" byteBuffer==null");
              Logger.e(paramCMTime, ((StringBuilder)localObject).toString());
              VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-3L));
            }
          }
        }
      }
      else
      {
        if (n >= 0)
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReadFrames:[failed] pendingFrames.size() == ");
          localStringBuilder.append(this.pendingFrames.size());
          Logger.w((String)localObject, localStringBuilder.toString());
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-2L));
        }
        j = i + 1;
        i = j;
        if (j > 1000)
        {
          Logger.e(this.TAG, "doReadFrames: [timeout] ");
          VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-4L));
        }
      }
    }
    if ((this.extractorDone) && (VideoDecoder.SampleTime.access$500(paramSampleTime) < 0L) && (!paramBoolean))
    {
      paramCMTime = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReadFrames: extractorDone && sampleTime.timeUs < 0, sampleTime = ");
      ((StringBuilder)localObject).append(paramSampleTime);
      Logger.i(paramCMTime, ((StringBuilder)localObject).toString());
      VideoDecoder.SampleTime.access$402(paramSampleTime, CMSampleState.fromError(-1L));
    }
  }
  
  private CMSampleState doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool2 = paramCMTime.bigThan(this.timeRange.getDuration());
        boolean bool1 = true;
        StringBuilder localStringBuilder;
        if ((bool2) && (!paramBoolean))
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is");
          localStringBuilder.append(paramCMTime.bigThan(this.timeRange.getDuration()));
          localStringBuilder.append("&& !justCache is");
          localStringBuilder.append(true);
          Logger.i((String)localObject, localStringBuilder.toString());
          paramCMTime = CMSampleState.fromError(-1L);
          return paramCMTime;
        }
        if ((this.extractorDone) && (this.pendingFrames.size() == 0) && (this.timeRange.containsTime(paramCMTime)) && (!this.readSampleFinish))
        {
          Logger.w(this.TAG, "error state , and will go correct it ! ");
          seekTo(paramCMTime);
        }
        this.preReadTime = CMTime.CMTimeInvalid;
        if ((this.started) && (this.trackIndex != -1))
        {
          releaseOutputBuffer();
          localObject = new VideoDecoder.SampleTime(this, null);
          VideoDecoder.SampleTime.access$402((VideoDecoder.SampleTime)localObject, CMSampleState.fromError(-2L));
          VideoDecoder.SampleTime.access$502((VideoDecoder.SampleTime)localObject, -2L);
          try
          {
            doReadFrames((VideoDecoder.SampleTime)localObject, paramCMTime, paramBoolean);
            paramCMTime = this.TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doReadSample:[success] ");
            localStringBuilder.append(this.extractorDone);
            localStringBuilder.append(" ");
            localStringBuilder.append(VideoDecoder.SampleTime.access$500((VideoDecoder.SampleTime)localObject));
            localStringBuilder.append("  ");
            localStringBuilder.append(VideoDecoder.SampleTime.access$400((VideoDecoder.SampleTime)localObject));
            Logger.v(paramCMTime, localStringBuilder.toString());
            paramCMTime = VideoDecoder.SampleTime.access$400((VideoDecoder.SampleTime)localObject);
            return paramCMTime;
          }
          catch (Exception paramCMTime)
          {
            paramCMTime = onReadFramesException(paramCMTime);
            return paramCMTime;
          }
        }
        paramCMTime = this.TAG;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReadSample:[unStart]  !started || trackIndex == -1 ");
        if (!this.started)
        {
          paramBoolean = true;
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(" - ");
          if (this.trackIndex != -1) {
            break label427;
          }
          paramBoolean = bool1;
          ((StringBuilder)localObject).append(paramBoolean);
          Logger.e(paramCMTime, ((StringBuilder)localObject).toString());
          paramCMTime = CMSampleState.fromError(-100L);
          return paramCMTime;
        }
      }
      finally {}
      paramBoolean = false;
      continue;
      label427:
      paramBoolean = false;
    }
  }
  
  private boolean hasPreReadAndFirstFrameSeek(CMTime paramCMTime)
  {
    return (paramCMTime == CMTime.CMTimeZero) && (this.preReadTime != CMTime.CMTimeInvalid) && (this.lastOutputBufferIndex != -1) && (!this.currentDecoderState.isInvalid());
  }
  
  private AssetExtractor initExtractor(String paramString)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initExtractor() called with: sourcePath = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = new AssetExtractor();
    ((AssetExtractor)localObject).setDataSource(paramString);
    while (((AssetExtractor)localObject).getSampleTrackIndex() != -1) {
      ((AssetExtractor)localObject).unselectTrack(((AssetExtractor)localObject).getSampleTrackIndex());
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex((AssetExtractor)localObject, "video/");
    int i = this.trackIndex;
    if (i == -1)
    {
      this.outputSurface = null;
      return null;
    }
    ((AssetExtractor)localObject).selectTrack(i);
    Logger.d(this.TAG, "initExtractor() end");
    return localObject;
  }
  
  private boolean moreCloseCurrentThenSeek(CMTime paramCMTime)
  {
    AssetExtractor localAssetExtractor = this.mirrorExtractor;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAssetExtractor != null)
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
      return buildSampleStateError(paramException);
    }
    if (!(paramException instanceof MediaCodec.CodecException)) {
      return buildSampleStateError(paramException);
    }
    MediaCodec.CodecException localCodecException = (MediaCodec.CodecException)paramException;
    if (localCodecException.isRecoverable())
    {
      releaseOutputBuffer();
      this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartState.getTime().getTimeUs();
      long l2 = this.timeRange.getStartUs();
      paramException = this.extractor;
      if (paramException != null) {
        paramException.seekTo(l1 - l2, 0);
      } else {
        Logger.e(this.TAG, "onReadFramesException: extractor is null", new RuntimeException("堆栈"));
      }
      this.extractorDone = false;
      return CMSampleState.fromError(-3L);
    }
    if (localCodecException.isTransient()) {
      Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    return buildSampleStateError(paramException);
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
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preReadSample: ");
      localStringBuilder.append(getSourcePath());
      localStringBuilder.append(" preReadTime = ");
      localStringBuilder.append(this.preReadTime);
      localStringBuilder.append(", lastOutputBufferIndex = ");
      localStringBuilder.append(this.lastOutputBufferIndex);
      Logger.i(str, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  private void readFromExtractor()
  {
    try
    {
      if (this.extractor == null)
      {
        Logger.e(this.TAG, "readFromExtractor: extractor is null", new RuntimeException("堆栈"));
        return;
      }
      long l = this.extractor.getSampleTime();
      if ((l < this.timeRange.getEndUs()) && (this.extractor.getSampleTrackIndex() != -1) && (l != -1L))
      {
        readSampleData();
      }
      else
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
      return;
    }
    finally {}
  }
  
  private void readSampleData()
  {
    Object localObject = this.extractor;
    if (localObject == null)
    {
      Logger.e(this.TAG, "readSampleData: extractor is null", new RuntimeException("堆栈"));
      return;
    }
    long l = ((AssetExtractor)localObject).getSampleTime();
    int i = this.mediaCodecWrapper.dequeueInputBuffer();
    if (i >= 0)
    {
      localObject = this.mediaCodecWrapper.getInputBuffer(i);
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
  }
  
  private CMSampleState renderCacheBuffer()
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("renderCacheBuffer: cache hit - ");
    localStringBuilder.append(this.currentDecoderState);
    Logger.v((String)localObject, localStringBuilder.toString());
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
      localObject = this.currentDecoderState;
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "renderCacheBuffer: ", localException);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sourcePath:");
      localStringBuilder.append(this.sourcePath);
      return CMSampleState.fromError(-2L, localStringBuilder.toString(), localException);
    }
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      if (this.extractor == null)
      {
        Logger.e(this.TAG, "seekExtractorTo: extractor == null", new RuntimeException("堆栈"));
        return;
      }
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
  
  private void tryFixCropSize()
  {
    try
    {
      doFixCropSize();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "tryFixCropSize: ", localException);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    release(false);
  }
  
  public String getSourcePath()
  {
    AssetExtractor localAssetExtractor = this.extractor;
    if (localAssetExtractor == null) {
      return null;
    }
    return localAssetExtractor.getSourcePath();
  }
  
  public TextureInfo getTextureInfo()
  {
    return null;
  }
  
  public boolean hasTrack()
  {
    try
    {
      int i = this.trackIndex;
      boolean bool;
      if (i != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    for (;;)
    {
      try
      {
        localObject2 = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("readSample: ");
        localStringBuilder.append(paramCMTime);
        localStringBuilder.append(", currentDecoderTime = ");
        localStringBuilder.append(this.currentDecoderState);
        localStringBuilder.append(",  extractor.getSampleTime() = ");
        if (this.extractor == null) {
          break label488;
        }
        localObject1 = Long.valueOf(this.extractor.getSampleTime());
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", lastOutputBufferIndex = ");
        localStringBuilder.append(this.lastOutputBufferIndex);
        Logger.v((String)localObject2, localStringBuilder.toString());
        this.lastFrameValid = false;
        if ((outputSurface() == null) || (this.lastOutputBufferIndex == -1)) {
          break label496;
        }
        i = 1;
        if (!this.currentDecoderState.getTime().smallThan(paramCMTime)) {
          break label506;
        }
        if ((!this.extractorDone) || (!this.pendingFrames.isEmpty())) {
          break label501;
        }
      }
      finally {}
      if ((i != 0) && (j != 0))
      {
        paramCMTime = renderCacheBuffer();
        return paramCMTime;
      }
      Object localObject1 = doReadSample(paramCMTime, false);
      if ((!this.currentDecoderState.isInvalid()) && (((CMSampleState)localObject1).getTime().bigThan(this.timeRange.getDuration())))
      {
        this.currentDecoderState = CMSampleState.fromError(-1L);
        this.pendingFrames.clear();
        this.extractorDone = true;
        localObject1 = this.TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("readSample: finish ");
        ((StringBuilder)localObject2).append(paramCMTime);
        ((StringBuilder)localObject2).append("  -  ");
        ((StringBuilder)localObject2).append(this.currentDecoderState);
        Logger.v((String)localObject1, ((StringBuilder)localObject2).toString());
        this.readSampleFinish = true;
        paramCMTime = this.currentDecoderState;
        return paramCMTime;
      }
      this.currentDecoderState = ((CMSampleState)localObject1);
      if ((this.currentDecoderState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentDecoderState.getTime().smallThan(this.duration))) {
        clearDecoder();
      }
      Object localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readSample: finish flag = ");
      localStringBuilder.append(this.lastFrameValid);
      localStringBuilder.append(" - ");
      localStringBuilder.append(this.extractorDone);
      localStringBuilder.append(", time = ");
      localStringBuilder.append(paramCMTime);
      localStringBuilder.append("  -  ");
      localStringBuilder.append(this.currentDecoderState);
      Logger.v((String)localObject2, localStringBuilder.toString());
      return localObject1;
      label488:
      localObject1 = "null";
      continue;
      label496:
      int i = 0;
      continue;
      label501:
      int j = 0;
      continue;
      label506:
      j = 1;
    }
  }
  
  public void release(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.isReleased;
      if (bool) {
        return;
      }
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release:start ");
      localStringBuilder.append(paramBoolean);
      Logger.i(str, localStringBuilder.toString());
      if ((paramBoolean) && (this.extractor != null))
      {
        this.extractor.dispose();
        this.extractor = null;
      }
      if (this.mirrorExtractor != null)
      {
        this.mirrorExtractor.dispose();
        this.mirrorExtractor = null;
      }
      this.started = false;
      this.isReleased = true;
      this.mediaCodecWrapper.release();
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("release:end ");
      localStringBuilder.append(paramBoolean);
      Logger.i(str, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  void releaseOutputBuffer()
  {
    int i = this.lastOutputBufferIndex;
    if (i != -1)
    {
      try
      {
        this.mediaCodecWrapper.releaseOutputBuffer(i, false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.lastOutputBufferIndex = -1;
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
        Object localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seekTo: ");
        localStringBuilder.append(paramCMTime);
        localStringBuilder.append("  - ");
        localStringBuilder.append(this);
        localStringBuilder.append("  ");
        localStringBuilder.append(this.currentStartState);
        localStringBuilder.append("  ");
        localStringBuilder.append(this.currentDecoderState);
        Logger.v((String)localObject, localStringBuilder.toString());
        if ((this.started) && (this.trackIndex != -1))
        {
          localObject = paramCMTime;
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
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("seekTo: finish - ");
            localStringBuilder.append(this.currentStartState);
            localStringBuilder.append("  ");
            if (this.extractor == null) {
              break label306;
            }
            paramCMTime = Long.valueOf(this.extractor.getSampleTime());
            localStringBuilder.append(paramCMTime);
            Logger.v((String)localObject, localStringBuilder.toString());
          }
        }
        else
        {
          Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
          return;
        }
      }
      finally {}
      label306:
      paramCMTime = "null";
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
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start:");
      localStringBuilder.append(getSourcePath());
      localStringBuilder.append(" [timeRange ");
      localStringBuilder.append(paramCMTimeRange);
      localStringBuilder.append("] [start ");
      localStringBuilder.append(paramCMTime);
      localStringBuilder.append("]");
      Logger.d(str, localStringBuilder.toString());
      if (this.trackIndex == -1)
      {
        Logger.e(this.TAG, "start: trackIndex == -1");
        return;
      }
      clearDecoder();
      if (paramCMTimeRange == null) {
        this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
      } else {
        this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
      }
      this.extractorDone = false;
      this.started = true;
      if (paramCMTime.getTimeUs() >= 0L)
      {
        seekTo(paramCMTime, false);
        preReadSample();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */