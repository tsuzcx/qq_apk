package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKManager;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  private static final String TAG = "HWVideoDecoder.DecodeRunnable";
  private ArrayList<HWVideoDecoder.timeStampPair> arrTimeStampPairs = new ArrayList();
  private final DecodeConfig currentDecodeConfig;
  private final HWDecodeListener decodeListener;
  long decodeProgressUs = 0L;
  private MediaCodec decoder;
  private final DecodeConfig dirtyDecodeConfig;
  private long endFrameSampleTime = 0L;
  private MediaExtractor extractor;
  private final String filePath;
  MediaCodec.BufferInfo info;
  ByteBuffer[] inputBuffers;
  private boolean inputDone = false;
  boolean interruptedFlag = false;
  public boolean isDebug = false;
  private long lastFramePresentationTimeUs = 0L;
  private long lastFrameSampleTimeUs = 0L;
  private Logger logger;
  private final AtomicLong mNextToTaskUs = new AtomicLong(-1L);
  private PKManager mPKManager;
  public int mRotation = 0;
  private long mSeekTarget = 0L;
  private String mTag = "HWVideoDecoder.DecodeRunnable";
  ByteBuffer[] outputBuffers;
  private boolean outputDone = false;
  private volatile AtomicBoolean pauseFlag = new AtomicBoolean(false);
  private final Object pauseLock = new Object();
  private int prolongFrameCount = 0;
  private final AtomicLong seekToTaskUs = new AtomicLong(-1L);
  private Object seekingFlag;
  long startMs = System.currentTimeMillis();
  private Surface surface;
  public final long videoDurationMs;
  
  public HWVideoDecoder$DecodeRunnable(String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HWVideoDecoder.DecodeRunnable.");
    ((StringBuilder)localObject).append(hashCode());
    this.mTag = ((StringBuilder)localObject).toString();
    this.logger = SdkContext.getInstance().getLogger();
    localObject = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create DecodeRunnable filePath: ");
    localStringBuilder.append(paramString);
    ((Logger)localObject).i("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
    this.surface = paramSurface;
    if (paramHWDecodeListener == null) {
      paramHWDecodeListener = new HWVideoDecoder.EmptyHWDecodeListener();
    }
    this.decodeListener = paramHWDecodeListener;
    this.filePath = paramString;
    this.videoDurationMs = VideoUtil.getDurationOfVideo(paramString);
    this.seekingFlag = paramObject;
    this.dirtyDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.videoDurationMs);
    this.currentDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.videoDurationMs);
    this.isDebug = new File(HWVideoDecoder.debugDecodeFilePath).exists();
  }
  
  private boolean dequeueDataFromCodec(boolean paramBoolean)
  {
    int i = this.decoder.dequeueOutputBuffer(this.info, 10000L);
    Object localObject2;
    StringBuilder localStringBuilder;
    int j;
    Object localObject1;
    if (i != -3) {
      if (i != -2) {
        if (i != -1)
        {
          if ((this.info.flags & 0x4) != 0)
          {
            if (this.logger.isEnable())
            {
              Logger localLogger1 = this.logger;
              localObject2 = this.mTag;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("output EOS ");
              localStringBuilder.append(this.pauseFlag.get());
              localLogger1.d((String)localObject2, localStringBuilder.toString());
            }
            this.outputDone = true;
            this.decodeProgressUs = 9223372036854775807L;
          }
          else
          {
            this.decodeProgressUs = this.info.presentationTimeUs;
          }
          if ((!this.currentDecodeConfig.noSleep) && (paramBoolean) && (!this.pauseFlag.get()) && (this.mSeekTarget == -1L)) {
            while (this.info.presentationTimeUs / 1000L > System.currentTimeMillis() - this.startMs) {
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException1)
              {
                if (this.logger.isEnable()) {
                  this.logger.e(this.mTag, "Thread.sleep error, ", localInterruptedException1);
                }
                this.interruptedFlag = true;
              }
            }
          }
          if ((this.currentDecodeConfig.noSleep) && (this.currentDecodeConfig.syncDecode) && (this.mPKManager != null))
          {
            Logger localLogger2 = this.logger;
            localObject2 = PKFilter.TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("this is ");
            localStringBuilder.append(hashCode());
            localStringBuilder.append(" current = ");
            localStringBuilder.append(this.info.presentationTimeUs / 1000L);
            localStringBuilder.append(", sync decoder=");
            localStringBuilder.append(this.mPKManager.getSyncDecodeTimeUs() / 1000L);
            localLogger2.d((String)localObject2, localStringBuilder.toString());
            while (this.info.presentationTimeUs > this.mPKManager.getSyncDecodeTimeUs()) {
              try
              {
                Thread.sleep(5L);
              }
              catch (InterruptedException localInterruptedException2)
              {
                if (this.logger.isEnable()) {
                  this.logger.e(this.mTag, "Thread.sleep error, ", localInterruptedException2);
                }
                this.interruptedFlag = true;
              }
            }
          }
          j = 0;
          if ((paramBoolean) && (this.info.size != 0)) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          if ((this.pauseFlag.get()) && (!isCloseSeekTarget(this.lastFrameSampleTimeUs, this.mSeekTarget)) && (!this.outputDone))
          {
            if ((this.logger.isEnable()) && (this.isDebug))
            {
              localObject1 = this.logger;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("seek, doRender = ");
              ((StringBuilder)localObject2).append(paramBoolean);
              ((StringBuilder)localObject2).append(" ; output sampleTime = ");
              ((StringBuilder)localObject2).append(this.info.presentationTimeUs);
              ((Logger)localObject1).d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject2).toString());
            }
            this.decoder.releaseOutputBuffer(i, false);
            return true;
          }
          if (this.mSeekTarget >= 0L) {
            this.startMs = (System.currentTimeMillis() - this.info.presentationTimeUs / 1000L);
          }
          seekFinishNotify();
          this.mSeekTarget = -1L;
          if ((this.logger.isEnable()) && (this.isDebug))
          {
            localObject1 = this.logger;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doRender = ");
            ((StringBuilder)localObject2).append(paramBoolean);
            ((StringBuilder)localObject2).append(" ; output sampleTime = ");
            ((StringBuilder)localObject2).append(this.info.presentationTimeUs);
            ((Logger)localObject1).d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject2).toString());
          }
          this.decoder.releaseOutputBuffer(i, paramBoolean);
          if (!paramBoolean) {
            break label1206;
          }
        }
      }
    }
    for (;;)
    {
      long l1;
      long l3;
      try
      {
        if (this.currentDecodeConfig.speedType != 0)
        {
          if ((this.arrTimeStampPairs == null) || (this.arrTimeStampPairs.size() <= 0)) {
            break label1245;
          }
          l1 = ((HWVideoDecoder.timeStampPair)this.arrTimeStampPairs.get(0)).orgSampleTime;
          l2 = Math.abs(((HWVideoDecoder.timeStampPair)this.arrTimeStampPairs.get(0)).presentTime - this.info.presentationTimeUs);
          i = 0;
          if (i >= this.arrTimeStampPairs.size()) {
            break label1224;
          }
          localObject1 = (HWVideoDecoder.timeStampPair)this.arrTimeStampPairs.get(i);
          if (((HWVideoDecoder.timeStampPair)localObject1).presentTime == this.info.presentationTimeUs)
          {
            l2 = ((HWVideoDecoder.timeStampPair)localObject1).orgSampleTime;
            this.arrTimeStampPairs.remove(i);
            if ((!this.logger.isEnable()) || (!this.isDebug)) {
              break label1208;
            }
            localObject1 = this.logger;
            localObject2 = this.mTag;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("size : ");
            localStringBuilder.append(this.arrTimeStampPairs.size());
            localStringBuilder.append("  remove ");
            localStringBuilder.append(l2);
            ((Logger)localObject1).d((String)localObject2, localStringBuilder.toString());
            break label1208;
          }
          long l4 = Math.abs(((HWVideoDecoder.timeStampPair)localObject1).presentTime - this.info.presentationTimeUs);
          l3 = l2;
          if (l4 >= l2) {
            break label1213;
          }
          l1 = ((HWVideoDecoder.timeStampPair)localObject1).orgSampleTime;
          l3 = l4;
          break label1213;
        }
        l1 = this.info.presentationTimeUs;
        this.decodeListener.onDecodeFrame(this.info.presentationTimeUs * 1000L, l1 * 1000L);
        return true;
      }
      catch (InterruptedException localInterruptedException3)
      {
        this.logger.e(this.mTag, "arrTimeStamp error, ", localInterruptedException3);
        this.interruptedFlag = true;
        return true;
      }
      if (this.logger.isEnable())
      {
        this.logger.d(this.mTag, "dequeueOutputBuffer timed out!");
        return true;
        if (this.logger.isEnable())
        {
          Logger localLogger3 = this.logger;
          localObject2 = this.mTag;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("New format ");
          localStringBuilder.append(this.decoder.getOutputFormat());
          localLogger3.d((String)localObject2, localStringBuilder.toString());
          return true;
          if (this.logger.isEnable()) {
            this.logger.d(this.mTag, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.decoder.getOutputBuffers();
        }
      }
      label1206:
      return true;
      label1208:
      i = 1;
      break label1231;
      label1213:
      i += 1;
      long l2 = l3;
      continue;
      label1224:
      l2 = -1L;
      i = j;
      label1231:
      if (i != 0)
      {
        l1 = l2;
        continue;
        label1245:
        l1 = -1L;
      }
    }
  }
  
  private long getEndFrameSampleTime()
  {
    this.extractor.seekTo((this.videoDurationMs - 1L) * 1000L, 2);
    long l = this.extractor.getSampleTime();
    String str = PKFilter.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getEndFrameSampleTime and durationMS=");
    localStringBuilder.append(this.videoDurationMs);
    localStringBuilder.append(" and result=");
    localStringBuilder.append(l);
    SLog.d(str, localStringBuilder.toString());
    this.extractor.seekTo(0L, 1);
    return l;
  }
  
  private long getPresentationTime(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return paramLong1 + paramLong2;
            }
            return paramLong1 - paramLong2;
          }
          paramLong2 *= 4L;
        }
      }
    }
    for (;;)
    {
      return paramLong1 + paramLong2;
      paramLong2 = (int)((float)paramLong2 / 1.5F);
      continue;
      Long.signum(paramLong2);
      paramLong2 *= 2L;
      continue;
      paramLong2 /= 2L;
    }
  }
  
  private boolean init()
  {
    this.extractor = new MediaExtractor();
    try
    {
      this.extractor.setDataSource(this.filePath);
      int i = 0;
      while (i < this.extractor.getTrackCount())
      {
        MediaFormat localMediaFormat = this.extractor.getTrackFormat(i);
        Object localObject = localMediaFormat.getString("mime");
        if (((String)localObject).startsWith("video/"))
        {
          this.extractor.selectTrack(i);
          localMediaFormat.setInteger("rotation-degrees", this.mRotation);
          try
          {
            this.decoder = MediaCodec.createDecoderByType((String)localObject);
            if (this.surface.isValid())
            {
              this.decoder.configure(localMediaFormat, this.surface, null, 0);
              return true;
            }
            throw new RuntimeException("surface is not valid.");
          }
          catch (Throwable localThrowable)
          {
            if (Thread.interrupted())
            {
              this.logger.e(this.mTag, "Thread is interrupted.", localThrowable);
              return false;
            }
            localObject = new RuntimeException(localThrowable);
            this.decodeListener.onDecodeError(1, (Throwable)localObject);
            this.logger.e(this.mTag, "decode configure error", localThrowable);
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private boolean isCloseSeekTarget(long paramLong1, long paramLong2)
  {
    if (this.dirtyDecodeConfig.speedType != 5)
    {
      if (this.lastFrameSampleTimeUs >= this.mSeekTarget) {
        return true;
      }
    }
    else if (this.lastFrameSampleTimeUs <= this.mSeekTarget) {
      return true;
    }
    paramLong1 = paramLong2 - paramLong1;
    return (paramLong1 > -100000L) && (paramLong1 < 100000L);
  }
  
  private void loopInternal(boolean paramBoolean)
  {
    if (!this.inputDone) {
      queueSampleToCodec();
    }
    if (!this.outputDone) {
      dequeueDataFromCodec(paramBoolean);
    }
  }
  
  private boolean queueSampleToCodec()
  {
    int i;
    Object localObject2;
    Object localObject3;
    try
    {
      i = this.decoder.dequeueInputBuffer(10000L);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (this.logger.isEnable())
      {
        localObject2 = this.logger;
        localObject3 = this.mTag;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dequeueInputBuffer =");
        localStringBuilder.append(localIllegalStateException.getMessage());
        ((Logger)localObject2).e((String)localObject3, localStringBuilder.toString());
      }
      i = -1;
    }
    Object localObject1;
    if (i >= 0)
    {
      localObject1 = this.inputBuffers[i];
      if (this.currentDecodeConfig.speedType == 5) {
        this.extractor.seekTo(this.lastFrameSampleTimeUs - 1000L, 0);
      }
      int j = this.extractor.readSampleData((ByteBuffer)localObject1, 0);
      long l3 = this.extractor.getSampleTime();
      long l2 = this.currentDecodeConfig.startTimeMillSecond * 1000L;
      long l4 = this.currentDecodeConfig.endTimeMillSecond * 1000L;
      if ((this.logger.isEnable()) && (this.isDebug))
      {
        localObject1 = this.logger;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("intput sampleTime = ");
        ((StringBuilder)localObject2).append(l3);
        ((Logger)localObject1).d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject2).toString());
      }
      long l1;
      if ((l3 == this.endFrameSampleTime) && (this.currentDecodeConfig.prolongToTime > 0L))
      {
        if (this.prolongFrameCount * 33 * 1000 + l3 > (this.currentDecodeConfig.prolongToTime - 500L) * 1000L)
        {
          if ((this.logger.isEnable()) && (this.isDebug))
          {
            localObject1 = this.logger;
            localObject2 = PKFilter.TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("prolongFrameCount=");
            ((StringBuilder)localObject3).append(this.prolongFrameCount);
            ((StringBuilder)localObject3).append(" finish");
            ((Logger)localObject1).e((String)localObject2, ((StringBuilder)localObject3).toString());
          }
          this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
          this.inputDone = true;
          this.prolongFrameCount = 0;
          return true;
        }
        if ((this.logger.isEnable()) && (this.isDebug))
        {
          localObject1 = this.logger;
          localObject2 = PKFilter.TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("prolongFrameCount=");
          ((StringBuilder)localObject3).append(this.prolongFrameCount);
          ((StringBuilder)localObject3).append(" and we send the same frame to render");
          ((Logger)localObject1).e((String)localObject2, ((StringBuilder)localObject3).toString());
        }
        this.prolongFrameCount += 1;
        l1 = this.prolongFrameCount * 33 * 1000;
        this.decoder.queueInputBuffer(i, 0, j, l1 + l3, 0);
        return true;
      }
      if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4))) {
        if (this.currentDecodeConfig.speedType == 5)
        {
          if (l2 > 0L) {
            l1 = l2;
          } else {
            l1 = 10000L;
          }
          if (l3 < l1) {}
        }
        else
        {
          l1 = this.lastFrameSampleTimeUs;
          this.lastFrameSampleTimeUs = l3;
          this.lastFramePresentationTimeUs = getPresentationTime(this.currentDecodeConfig.speedType, this.lastFramePresentationTimeUs, l3 - l1);
          this.decoder.queueInputBuffer(i, 0, j, this.lastFramePresentationTimeUs, 0);
          this.extractor.advance();
          localObject1 = new HWVideoDecoder.timeStampPair(this.lastFrameSampleTimeUs, this.lastFramePresentationTimeUs);
          if (this.currentDecodeConfig.speedType == 0) {
            break label905;
          }
          localObject2 = this.arrTimeStampPairs;
          if (localObject2 == null) {
            break label905;
          }
          ((ArrayList)localObject2).add(localObject1);
          if ((!this.logger.isEnable()) || (!this.isDebug)) {
            break label905;
          }
          localObject1 = this.logger;
          localObject2 = this.mTag;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("size : ");
          ((StringBuilder)localObject3).append(this.arrTimeStampPairs.size());
          ((StringBuilder)localObject3).append("  add ");
          ((StringBuilder)localObject3).append(this.lastFrameSampleTimeUs);
          ((Logger)localObject1).d((String)localObject2, ((StringBuilder)localObject3).toString());
          return true;
        }
      }
      if (this.logger.isEnable())
      {
        localObject1 = this.logger;
        localObject2 = this.mTag;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=");
        ((StringBuilder)localObject3).append(l3);
        ((StringBuilder)localObject3).append(" endTime=");
        ((StringBuilder)localObject3).append(l4);
        ((StringBuilder)localObject3).append(" startTime=");
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append(" sampleSize=");
        ((StringBuilder)localObject3).append(j);
        ((Logger)localObject1).d((String)localObject2, ((StringBuilder)localObject3).toString());
      }
      this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
      this.inputDone = true;
      label905:
      return true;
    }
    if (this.logger.isEnable())
    {
      localObject1 = this.logger;
      localObject2 = this.mTag;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("queueSampleToCodec inIndex = ");
      ((StringBuilder)localObject3).append(i);
      ((Logger)localObject1).w((String)localObject2, ((StringBuilder)localObject3).toString());
    }
    return false;
  }
  
  private long seekInLoop(long paramLong)
  {
    long l5 = System.currentTimeMillis();
    try
    {
      this.decoder.flush();
    }
    catch (Exception localException)
    {
      this.logger.e("HWVideoDecoder.DecodeRunnable", localException);
    }
    this.extractor.seekTo(paramLong, 0);
    long l4 = this.extractor.getSampleTime();
    long l2 = l4;
    long l3 = paramLong;
    if (l4 == -1L)
    {
      if (this.logger.isEnable()) {
        this.logger.d(this.mTag, "seekInLoop, getSampleTime return -1");
      }
      l2 = l4;
      l3 = paramLong;
      if (this.currentDecodeConfig.speedType == 5)
      {
        long l1 = paramLong;
        for (paramLong = l4;; paramLong = this.extractor.getSampleTime())
        {
          l2 = paramLong;
          l3 = l1;
          if (paramLong != -1L) {
            break;
          }
          l1 -= 1000L;
          this.extractor.seekTo(l1, 0);
        }
      }
    }
    this.decodeListener.onDecodeSeekTo(l2 / 1000L);
    this.startMs = System.currentTimeMillis();
    this.inputDone = false;
    this.outputDone = false;
    this.lastFrameSampleTimeUs = l2;
    if (this.currentDecodeConfig.speedType == 5) {
      this.lastFramePresentationTimeUs = (this.currentDecodeConfig.endTimeMillSecond * 1000L - l2);
    } else {
      this.lastFramePresentationTimeUs = l2;
    }
    if (this.logger.isEnable())
    {
      Logger localLogger = this.logger;
      String str = this.mTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("end seekTo timecost=");
      localStringBuilder.append(System.currentTimeMillis() - l5);
      localStringBuilder.append(" seekTargetTimeUs:");
      localStringBuilder.append(l3);
      localStringBuilder.append(" realStartTime:");
      localStringBuilder.append(l2);
      localLogger.d(str, localStringBuilder.toString());
    }
    return l2;
  }
  
  private boolean start()
  {
    if (this.decoder == null)
    {
      this.logger.e(this.mTag, "Can't find video info!");
      return false;
    }
    this.decodeListener.onDecodeStart();
    try
    {
      this.decoder.start();
      try
      {
        this.inputBuffers = this.decoder.getInputBuffers();
        this.outputBuffers = this.decoder.getOutputBuffers();
        this.info = new MediaCodec.BufferInfo();
        this.startMs = System.currentTimeMillis();
        if (this.currentDecodeConfig.speedType == 5) {
          this.lastFrameSampleTimeUs = (this.currentDecodeConfig.endTimeMillSecond * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        this.decodeListener.onDecodeError(2, localException);
        this.logger.e(this.mTag, "decode start error2", localException);
        return false;
      }
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        this.logger.e(this.mTag, "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      this.decodeListener.onDecodeError(2, localRuntimeException);
      this.logger.e(this.mTag, "decode start error", localThrowable);
    }
  }
  
  public void clearTimeStamp()
  {
    ArrayList localArrayList = this.arrTimeStampPairs;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public long getLastFrameSampleTimeMs()
  {
    return this.lastFrameSampleTimeUs / 1000L;
  }
  
  public long getProgress()
  {
    return this.decodeProgressUs;
  }
  
  public boolean isSeeking()
  {
    return this.mSeekTarget >= 0L;
  }
  
  public void nextTo(long paramLong)
  {
    this.mNextToTaskUs.set(paramLong * 1000L);
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.currentDecodeConfig.copyFrom(this.dirtyDecodeConfig);
    if (!init()) {
      return;
    }
    Logger localLogger;
    String str;
    StringBuilder localStringBuilder;
    if (this.currentDecodeConfig.prolongToTime > 0L)
    {
      this.endFrameSampleTime = getEndFrameSampleTime();
      if (this.logger.isEnable())
      {
        localLogger = this.logger;
        str = this.mTag;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEndFrameSampleTime() = ");
        localStringBuilder.append(this.endFrameSampleTime);
        localLogger.d(str, localStringBuilder.toString());
      }
    }
    if (!start()) {
      return;
    }
    if (this.logger.isEnable())
    {
      localLogger = this.logger;
      str = this.mTag;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode ready time cost=");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      localLogger.d(str, localStringBuilder.toString());
    }
    for (;;)
    {
      if ((Thread.interrupted()) || (this.interruptedFlag)) {
        break label801;
      }
      if ((this.dirtyDecodeConfig.speedType != this.currentDecodeConfig.speedType) && (this.dirtyDecodeConfig.speedType == 5)) {
        this.lastFrameSampleTimeUs = (this.currentDecodeConfig.endTimeMillSecond * 1000L);
      }
      this.currentDecodeConfig.copyFrom(this.dirtyDecodeConfig);
      l1 = this.currentDecodeConfig.startTimeMillSecond * 1000L;
      long l2 = this.currentDecodeConfig.endTimeMillSecond * 1000L;
      long l3 = this.seekToTaskUs.get();
      boolean bool;
      if ((l3 >= 0L) && (l3 >= l1) && (l3 <= l2))
      {
        seekInLoop(l3);
        this.mSeekTarget = l3;
        bool = true;
      }
      else
      {
        bool = false;
      }
      this.seekToTaskUs.compareAndSet(l3, -1L);
      l3 = this.mNextToTaskUs.get();
      if (l3 >= 0L)
      {
        this.mSeekTarget = l3;
        this.mNextToTaskUs.compareAndSet(l3, -1L);
      }
      try
      {
        loopInternal(true);
      }
      catch (Throwable localThrowable)
      {
        if (!Thread.interrupted()) {
          break label759;
        }
      }
      this.logger.e(this.mTag, "Thread is interrupted.", localThrowable);
      if ((this.logger.isEnable()) && (this.isDebug))
      {
        ??? = this.logger;
        str = this.mTag;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode frame, seekInLoop =");
        localStringBuilder.append(bool);
        ((Logger)???).d(str, localStringBuilder.toString());
      }
      if (this.outputDone)
      {
        ??? = this.arrTimeStampPairs;
        if (??? != null) {
          ((ArrayList)???).clear();
        }
        if (this.logger.isEnable()) {
          this.logger.d(this.mTag, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        }
        if (!this.currentDecodeConfig.repeat) {
          break label801;
        }
        if (this.currentDecodeConfig.speedType == 5) {
          l1 = l2;
        }
        seekTo(l1 / 1000L);
        this.decodeListener.onDecodeRepeat();
        if (this.logger.isEnable())
        {
          ??? = this.logger;
          str = this.mTag;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("repeat ");
          localStringBuilder.append(this.pauseFlag.get());
          ((Logger)???).d(str, localStringBuilder.toString());
        }
      }
      if ((this.pauseFlag.get()) && (this.mSeekTarget < 0L) && (this.seekToTaskUs.get() < 0L)) {
        try
        {
          synchronized (this.pauseLock)
          {
            if (!this.interruptedFlag) {
              this.pauseLock.wait();
            }
            this.startMs = (System.currentTimeMillis() - this.info.presentationTimeUs / 1000L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          this.logger.e(this.mTag, "pauseLock lock error, ", localInterruptedException);
          this.interruptedFlag = true;
        }
      }
    }
    label759:
    Object localObject3 = new RuntimeException(localInterruptedException);
    this.decodeListener.onDecodeError(3, (Throwable)localObject3);
    this.logger.e(this.mTag, "decode configure error", localInterruptedException);
    return;
    try
    {
      label801:
      this.decoder.stop();
      this.decoder.release();
      this.extractor.release();
    }
    catch (Exception localException)
    {
      localObject3 = this.logger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decoder stop error ");
      localStringBuilder.append(localException.toString());
      ((Logger)localObject3).e("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
    }
    seekFinishNotify();
    if (this.outputDone)
    {
      this.decodeListener.onDecodeFinish();
      return;
    }
    this.decodeListener.onDecodeCancel();
  }
  
  public void seekFinishNotify()
  {
    if (this.mSeekTarget >= 0L) {
      synchronized (this.seekingFlag)
      {
        this.seekingFlag.notifyAll();
        return;
      }
    }
  }
  
  public void seekTo(long paramLong)
  {
    this.seekToTaskUs.set(paramLong * 1000L);
  }
  
  public void setDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.filePath, paramDecodeConfig.inputFilePath)) {
      this.logger.w("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    setSpeedType(paramDecodeConfig.speedType);
    setPlayRange(paramDecodeConfig.startTimeMillSecond, paramDecodeConfig.endTimeMillSecond);
    setRepeat(paramDecodeConfig.repeat);
    setNoSleep(paramDecodeConfig.noSleep);
    setProlongToTime(paramDecodeConfig.prolongToTime);
    setSyncDecode(paramDecodeConfig.syncDecode);
    this.mRotation = paramDecodeConfig.rotation;
  }
  
  public void setNoSleep(boolean paramBoolean)
  {
    this.dirtyDecodeConfig.noSleep = paramBoolean;
  }
  
  public void setPKManager(PKManager paramPKManager)
  {
    this.mPKManager = paramPKManager;
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 >= paramLong1)
      {
        long l2 = this.videoDurationMs;
        StringBuilder localStringBuilder;
        if (paramLong1 >= l2)
        {
          localObject = this.logger;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setPlayRange ignore, startTimeMs=");
          localStringBuilder.append(paramLong1);
          localStringBuilder.append(", videoDuration=");
          localStringBuilder.append(this.videoDurationMs);
          ((Logger)localObject).e("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
          return;
        }
        long l1 = paramLong2;
        if (paramLong2 > l2) {
          l1 = l2;
        }
        paramLong2 = l1;
        if (l1 == 0L) {
          paramLong2 = this.videoDurationMs;
        }
        if ((paramLong1 == this.dirtyDecodeConfig.startTimeMillSecond) && (paramLong2 == this.dirtyDecodeConfig.endTimeMillSecond))
        {
          localObject = this.logger;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("segment not changed, setPlayRange ignore, startTimeMs=");
          localStringBuilder.append(paramLong1);
          localStringBuilder.append(", endTimeMs=");
          localStringBuilder.append(paramLong2);
          ((Logger)localObject).w("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
          return;
        }
        Object localObject = this.dirtyDecodeConfig;
        ((DecodeConfig)localObject).startTimeMillSecond = paramLong1;
        ((DecodeConfig)localObject).endTimeMillSecond = paramLong2;
        if (((DecodeConfig)localObject).speedType == 5)
        {
          seekTo(paramLong2);
          return;
        }
        seekTo(paramLong1);
        return;
      }
      throw new IllegalArgumentException("end time should not less than start time");
    }
    throw new IllegalArgumentException("both start time and end time should not less than 0");
  }
  
  public void setProlongToTime(long paramLong)
  {
    this.dirtyDecodeConfig.prolongToTime = paramLong;
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.dirtyDecodeConfig.repeat = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.dirtyDecodeConfig.speedType = paramInt;
  }
  
  public void setSyncDecode(boolean paramBoolean)
  {
    this.dirtyDecodeConfig.syncDecode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */