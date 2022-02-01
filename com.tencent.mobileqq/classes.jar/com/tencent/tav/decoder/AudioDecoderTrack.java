package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.factory.IDecoderFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioDecoderTrack
  implements IDecoderTrack
{
  private static String TAG = "AudioDecoderTrack";
  private float _speed = 1.0F;
  private AudioInfo audioInfo = new AudioInfo();
  private AudioMixer audioMixer = new AudioMixer();
  private AudioDecoder currentDecoder;
  private final Object currentDecoderLock = new Object();
  private CMTime currentSegmentStartTime = CMTime.CMTimeZero;
  private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Audio;
  private AudioDecoderTrack.AudioDecoderCreateThread decoderCreateThread = null;
  private final AudioDecoderTrack.DecoderThread decoderThread = new AudioDecoderTrack.DecoderThread(this);
  private CMTime duration = CMTime.CMTimeZero;
  private ByteBuffer emptyAudioBuffer;
  private CMTime frameDuration = new CMTime(92880L, 1000000);
  private int frameRate = 11;
  private boolean isEmptyFrame = false;
  private boolean isReleased = false;
  @NonNull
  private CMSampleState lastSampleState = new CMSampleState();
  private AudioDecoderTrack.DecoderWrapper nextDecoder;
  private final Object nextDecoderLock = new Object();
  private boolean preRead = false;
  private int segmentIndex = -1;
  private ArrayList<DecoderTrackSegment> segments = new ArrayList();
  private boolean started = false;
  private int trackID = -1;
  private float volume = 1.0F;
  
  private IDecoder createDecoder(@NonNull DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    for (;;)
    {
      try
      {
        DecoderAssetTrack localDecoderAssetTrack = paramDecoderTrackSegment.getVideoAsset();
        localObject1 = TAG;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("createDecoder - ");
        ((StringBuilder)???).append(localDecoderAssetTrack.assetPath);
        ((StringBuilder)???).append(" - audio");
        Logger.d((String)localObject1, ((StringBuilder)???).toString());
        localObject1 = null;
        i = 5;
        if ((localObject1 == null) && (i > 0))
        {
          j = i - 1;
          Object localObject3;
          if (this.decoderCreateThread != null)
          {
            i = AudioDecoderTrack.AudioDecoderCreateThread.access$000(this.decoderCreateThread);
            if ((i < this.segments.size()) && (isSameExtractor(((DecoderTrackSegment)this.segments.get(i)).getVideoAsset(), localDecoderAssetTrack))) {
              synchronized (this.nextDecoderLock)
              {
                if ((this.nextDecoder != null) && (isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)) && (this.nextDecoder.decoder != null))
                {
                  paramCMTime = this.nextDecoder.decoder;
                  if (this.segments.get(this.nextDecoder.segmentIndex) != paramDecoderTrackSegment) {
                    paramCMTime.start(paramDecoderTrackSegment.getTimeRange(), paramDecoderTrackSegment.getDecoderStartTime());
                  }
                  this.nextDecoder = null;
                  paramDecoderTrackSegment = TAG;
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("hint decoder - audio  ");
                  ((StringBuilder)localObject1).append(paramCMTime.getSourcePath());
                  Logger.d(paramDecoderTrackSegment, ((StringBuilder)localObject1).toString());
                  return paramCMTime;
                }
              }
            }
          }
          else
          {
            ??? = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("check  decoder - ");
            ((StringBuilder)localObject3).append(localDecoderAssetTrack.assetPath);
            Logger.d((String)???, ((StringBuilder)localObject3).toString());
            if ((this.nextDecoder != null) && (isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)) && (this.nextDecoder.decoder != null)) {
              synchronized (this.nextDecoderLock)
              {
                if ((this.nextDecoder != null) && (this.nextDecoder.extractor == localDecoderAssetTrack) && (this.nextDecoder.decoder != null))
                {
                  paramCMTime = this.nextDecoder.decoder;
                  if (this.segments.get(this.nextDecoder.segmentIndex) != paramDecoderTrackSegment) {
                    paramCMTime.start(paramDecoderTrackSegment.getTimeRange(), paramDecoderTrackSegment.getDecoderStartTime());
                  }
                  paramDecoderTrackSegment = TAG;
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("hint decoder - audio  ");
                  ((StringBuilder)localObject1).append(paramCMTime.getSourcePath());
                  ((StringBuilder)localObject1).append(", segmentIndex: ");
                  ((StringBuilder)localObject1).append(this.segmentIndex);
                  ((StringBuilder)localObject1).append(", nextDecoder.segmentIndex: ");
                  ((StringBuilder)localObject1).append(this.nextDecoder.segmentIndex);
                  Logger.d(paramDecoderTrackSegment, ((StringBuilder)localObject1).toString());
                  this.nextDecoder = null;
                  return paramCMTime;
                }
              }
            }
          }
          ??? = paramDecoderTrackSegment.getTimeRange();
          if (??? == null) {
            return null;
          }
          try
          {
            ??? = newDecoder(localDecoderAssetTrack);
            localObject1 = ???;
            i = j;
            if (??? == null) {
              continue;
            }
            localObject1 = ???;
            ((IAudioDecoder)???).start(paramDecoderTrackSegment.getTimeRange(), paramCMTime);
            localObject1 = ???;
            localObject3 = TAG;
            localObject1 = ???;
            localStringBuilder = new StringBuilder();
            localObject1 = ???;
            localStringBuilder.append("createDecoder new Decoder success - ");
            localObject1 = ???;
            localStringBuilder.append(localDecoderAssetTrack.assetPath);
            localObject1 = ???;
            Logger.d((String)localObject3, localStringBuilder.toString());
            localObject1 = ???;
            i = j;
          }
          catch (Exception localException2)
          {
            localObject3 = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" createDecoder ");
            localStringBuilder.append(localException2.getMessage());
            localStringBuilder.append(localException2);
            Logger.e((String)localObject3, localStringBuilder.toString());
            if (localObject1 == null) {}
          }
        }
      }
      finally
      {
        Object localObject1;
        int i;
        int j;
        continue;
        throw paramDecoderTrackSegment;
        continue;
      }
      try
      {
        try
        {
          ((IAudioDecoder)localObject1).release();
        }
        finally {}
      }
      catch (Exception localException1)
      {
        continue;
      }
      localObject1 = null;
      i = j;
    }
    return localObject1;
  }
  
  private void createNextDecoder(int paramInt)
  {
    try
    {
      if ((this.segments != null) && (this.preRead))
      {
        int i = paramInt + 1;
        int j = this.segments.size();
        if (i >= j) {
          return;
        }
        if (this.decoderCreateThread == null)
        {
          DecoderAssetTrack localDecoderAssetTrack = ((DecoderTrackSegment)this.segments.get(i)).getVideoAsset();
          if (localDecoderAssetTrack != null)
          {
            if (this.nextDecoder != null)
            {
              boolean bool = isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack);
              if (bool) {}
            }
            else
            {
              try
              {
                this.decoderCreateThread = new AudioDecoderTrack.AudioDecoderCreateThread(this, localDecoderAssetTrack, null, i, null);
                this.decoderCreateThread.start();
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
          else if ((this.nextDecoder != null) && (paramInt >= 0) && (paramInt < this.segments.size()) && (this.nextDecoder.segmentIndex != paramInt))
          {
            this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
            this.nextDecoder.segmentIndex = paramInt;
          }
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    try
    {
      if (this.isReleased)
      {
        Logger.e(TAG, "doReadSample: has released");
        paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
        return paramCMTime;
      }
      paramCMTime = CMSampleState.fromError(-1L);
      this.isEmptyFrame = false;
      if (this.segmentIndex == -1)
      {
        Logger.i(TAG, "doReadSample: segmentIndex == -1");
        if (this.lastSampleState.getStateCode() < -1L) {
          paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-100L));
        } else {
          paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
        }
        return paramCMTime;
      }
      CMTime localCMTime;
      Object localObject2;
      for (Object localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);; localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex))
      {
        if (this.currentDecoder == null)
        {
          localCMTime = this.lastSampleState.getTime().add(this.frameDuration);
          if (this.lastSampleState.isInvalid()) {
            localCMTime = CMTime.CMTimeZero;
          }
          if (localCMTime.smallThan(this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject1).getScaledDuration())))
          {
            this.isEmptyFrame = true;
            Logger.v(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
            paramCMTime = new CMSampleBuffer(localCMTime, outputBuffer());
            return paramCMTime;
          }
        }
        else if (this.lastSampleState.getTime().sub(this.currentSegmentStartTime).multi(this._speed).bigThan(((DecoderTrackSegment)localObject1).getScaledDuration().multi(this._speed)))
        {
          paramCMTime = CMSampleState.fromError(-1L);
        }
        else
        {
          paramCMTime = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
        }
        long l = paramCMTime.getStateCode();
        localCMTime = null;
        localObject2 = null;
        if (l != -1L) {
          break;
        }
        localObject1 = ((DecoderTrackSegment)localObject1).getScaledDuration().add(this.currentSegmentStartTime);
        localCMTime = this.lastSampleState.getTime().add(this.frameDuration);
        if (((CMTime)localObject1).bigThan(localCMTime))
        {
          if (this.currentDecoder == null) {
            paramCMTime = getEmptyAudioBuffer();
          } else {
            paramCMTime = this.currentDecoder.outputBuffer();
          }
          Logger.v(TAG, "doReadSample: finish && !end");
          localObject1 = paramCMTime;
          if (paramCMTime == null) {
            localObject1 = getEmptyAudioBuffer();
          }
          paramCMTime = new CMSampleBuffer(localCMTime, (ByteBuffer)localObject1);
          return paramCMTime;
        }
        if (!nextSegment(true))
        {
          Logger.v(TAG, "doReadSample: finish && end && next failed");
          localObject1 = CMSampleState.fromError(-1L);
          if (this.currentDecoder == null) {
            paramCMTime = (CMTime)localObject2;
          } else {
            paramCMTime = this.currentDecoder.outputBuffer();
          }
          paramCMTime = new CMSampleBuffer((CMSampleState)localObject1, paramCMTime);
          return paramCMTime;
        }
      }
      if (paramCMTime.getStateCode() >= 0L)
      {
        localObject2 = paramCMTime.getTime().sub(((DecoderTrackSegment)localObject1).getDecoderStartTime()).divide(this._speed);
        paramCMTime = (CMTime)localObject2;
        if (((CMTime)localObject2).getTimeUs() > ((DecoderTrackSegment)localObject1).getScaledDuration().getTimeUs()) {
          paramCMTime = ((DecoderTrackSegment)localObject1).getScaledDuration();
        }
        localObject1 = new CMSampleState(paramCMTime.add(this.currentSegmentStartTime));
        paramCMTime = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doReadSample: [success] ");
        ((StringBuilder)localObject2).append(localObject1);
        Logger.v(paramCMTime, ((StringBuilder)localObject2).toString());
        if (this.currentDecoder == null) {
          paramCMTime = localCMTime;
        } else {
          paramCMTime = this.currentDecoder.outputBuffer();
        }
        paramCMTime = new CMSampleBuffer((CMSampleState)localObject1, paramCMTime);
        return paramCMTime;
      }
      if ((paramCMTime.getStateCode() != -3L) && (paramCMTime.getStateCode() != -100L))
      {
        paramCMTime = new CMSampleBuffer(this.lastSampleState);
        return paramCMTime;
      }
      paramCMTime = new CMSampleBuffer(paramCMTime);
      return paramCMTime;
    }
    finally {}
    for (;;)
    {
      throw paramCMTime;
    }
  }
  
  private void doReleaseCurrentDecoder()
  {
    AudioDecoder localAudioDecoder = this.currentDecoder;
    if (localAudioDecoder != null)
    {
      if (localAudioDecoder.getSourcePath() == null) {
        return;
      }
      localAudioDecoder = this.currentDecoder;
      this.currentDecoder = null;
      ThreadPool.execute(new AudioDecoderTrack.1(this, localAudioDecoder));
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      CMTime localCMTime2 = ((DecoderTrackSegment)localIterator.next()).getScaledDuration();
      if ((paramCMTime.compare(localCMTime1) >= 0) && (paramCMTime.smallThan(localCMTime1.add(localCMTime2))))
      {
        j = 1;
        break;
      }
      localCMTime1 = localCMTime1.add(localCMTime2);
      i += 1;
    }
    int m = j;
    k = i;
    if (j == 0)
    {
      m = j;
      k = i;
      if (paramCMTime.equalsTo(localCMTime1))
      {
        m = j;
        k = i;
        if (i > 0)
        {
          m = j;
          k = i;
          if (paramBoolean)
          {
            k = i - 1;
            m = 1;
          }
        }
      }
    }
    if (m != 0) {
      return k;
    }
    return -1;
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramInt)
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    return localCMTime;
  }
  
  private static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    return (paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath));
  }
  
  @Nullable
  private IAudioDecoder newDecoder(DecoderAssetTrack paramDecoderAssetTrack)
  {
    IVideoDecoder.Params localParams = new IVideoDecoder.Params();
    localParams.sourceType = paramDecoderAssetTrack.sourceType;
    localParams.filePath = paramDecoderAssetTrack.assetPath;
    return AVDecoderFactory.getInstance().createAudioDecoder(localParams);
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    ??? = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("nextSegment:");
    ((StringBuilder)localObject2).append(paramBoolean);
    Logger.d((String)???, ((StringBuilder)localObject2).toString());
    this.segmentIndex += 1;
    int i = this.segmentIndex;
    int j = this.segments.size();
    boolean bool = false;
    if (i >= j)
    {
      this.segmentIndex = -1;
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
    if (this.lastSampleState.getTime().equalsTo(CMTime.CMTimeZero)) {
      this.lastSampleState = new CMSampleState();
    }
    localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null)
    {
      releaseCurrentDecoder();
      if (paramBoolean) {
        ??? = ((DecoderTrackSegment)this.segments.get(this.segmentIndex)).getDecoderStartTime();
      } else {
        ??? = CMTime.CMTimeInvalid;
      }
      IDecoder localIDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
      synchronized (this.currentDecoderLock)
      {
        this.currentDecoder = ((AudioDecoder)localIDecoder);
        if (this.audioMixer != null) {
          this.audioMixer.release();
        }
        this.audioMixer = new AudioMixer();
        if ((this.currentDecoder != null) && (this.currentDecoder.hasTrack()) && (paramBoolean)) {
          this.currentDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime());
        }
      }
    }
    Logger.d(TAG, "nextSegment: videoAsset is null");
    releaseCurrentDecoder();
    if (localObject3.getScaledDuration().getTimeUs() > 0L) {
      this._speed = ((float)localObject3.getTimeRange().getDurationUs() * 1.0F / (float)localObject3.getScaledDuration().getTimeUs());
    }
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nextSegment:");
    paramBoolean = bool;
    if (this.currentDecoder == null) {
      paramBoolean = true;
    }
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ");
    localStringBuilder.append(this._speed);
    Logger.d((String)???, localStringBuilder.toString());
    return true;
  }
  
  private void releaseCurrentDecoder()
  {
    synchronized (this.currentDecoderLock)
    {
      doReleaseCurrentDecoder();
      return;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    if (AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) == null) {
      synchronized (this.decoderThread)
      {
        if (AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) == null) {
          this.decoderThread.action();
        }
        return;
      }
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange != null) && (paramCMTimeRange.getDurationUs() > 0L))
    {
      if (this.segments.size() == 0) {
        return;
      }
      CMTime localCMTime1 = paramCMTimeRange.getStart();
      CMTime localCMTime2 = paramCMTimeRange.getEnd();
      CMTime localCMTime3 = duration();
      clipRangeAndRemoveRange(paramCMTimeRange);
      if (localCMTime1.getValue() != 0L) {
        this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
      }
      if (localCMTime2.getTimeUs() < localCMTime3.getTimeUs()) {
        this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
      }
    }
  }
  
  public void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange != null) && (paramCMTimeRange.getDurationUs() > 0L))
    {
      if (this.segments.size() == 0) {
        return;
      }
      Object localObject = paramCMTimeRange.getStart();
      CMTime localCMTime1 = paramCMTimeRange.getEnd();
      int k = findSegmentIndexAt((CMTime)localObject, false);
      if (k == -1) {
        return;
      }
      int j = findSegmentIndexAt(localCMTime1, false);
      int i;
      if (j == -1)
      {
        i = this.segments.size() - 1;
      }
      else
      {
        i = j;
        if (getSegmentStartTime(j) == localCMTime1) {
          i = j - 1;
        }
      }
      localCMTime1 = getSegmentStartTime(k);
      CMTime localCMTime2 = getSegmentStartTime(i);
      localObject = (DecoderTrackSegment)this.segments.get(k);
      DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(i);
      localCMTime2 = paramCMTimeRange.getEnd().sub(localCMTime2);
      float f = (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment.getTimeRange().getDurationUs();
      localDecoderTrackSegment.setTimeRange(new CMTimeRange(localDecoderTrackSegment.getTimeRange().getStart(), localCMTime2.divide(f)));
      localDecoderTrackSegment.setScaledDuration(localCMTime2);
      f = (float)((DecoderTrackSegment)localObject).getScaledDuration().getTimeUs() * 1.0F / (float)((DecoderTrackSegment)localObject).getTimeRange().getDurationUs();
      paramCMTimeRange = paramCMTimeRange.getStart().sub(localCMTime1);
      localCMTime1 = paramCMTimeRange.divide(f);
      ((DecoderTrackSegment)localObject).setTimeRange(new CMTimeRange(((DecoderTrackSegment)localObject).getTimeRange().getStart().add(localCMTime1), ((DecoderTrackSegment)localObject).getTimeRange().getDuration().sub(localCMTime1)));
      ((DecoderTrackSegment)localObject).setScaledDuration(((DecoderTrackSegment)localObject).getScaledDuration().sub(paramCMTimeRange));
      j = this.segments.size() - 1;
      while (j >= 0)
      {
        if ((j > i) || (j < k)) {
          this.segments.remove(j);
        }
        j -= 1;
      }
    }
  }
  
  public CMTime duration()
  {
    return getSegmentStartTime(this.segments.size());
  }
  
  public AudioInfo getAudioInfo()
  {
    AudioDecoder localAudioDecoder = this.currentDecoder;
    if (localAudioDecoder != null) {
      return localAudioDecoder.getAudioInfo();
    }
    return this.audioInfo;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleState.getTime();
  }
  
  public CMTime getDuration()
  {
    if (this.duration == CMTime.CMTimeZero)
    {
      CMTime localCMTime = CMTime.CMTimeZero;
      Iterator localIterator = this.segments.iterator();
      while (localIterator.hasNext()) {
        localCMTime = localCMTime.add(((DecoderTrackSegment)localIterator.next()).getScaledDuration());
      }
      this.duration = localCMTime;
    }
    return this.duration;
  }
  
  public ByteBuffer getEmptyAudioBuffer()
  {
    if (this.emptyAudioBuffer == null)
    {
      long l = this.audioInfo.channelCount * this.audioInfo.sampleRate * this.frameDuration.getTimeUs() / 1000000L;
      int j = (int)l;
      this.emptyAudioBuffer = ByteBuffer.allocate(j * 2);
      this.emptyAudioBuffer.order(ByteOrder.LITTLE_ENDIAN);
      short[] arrayOfShort = new short[j];
      int i = 0;
      while (i < l)
      {
        arrayOfShort[i] = 0;
        i += 1;
      }
      this.emptyAudioBuffer.asShortBuffer().put(arrayOfShort, 0, j);
    }
    this.emptyAudioBuffer.position(0);
    return this.emptyAudioBuffer;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public int getTrackId()
  {
    return this.trackID;
  }
  
  public ByteBuffer outputBuffer()
  {
    if (this.isEmptyFrame) {
      return getEmptyAudioBuffer();
    }
    AudioDecoder localAudioDecoder = this.currentDecoder;
    if (localAudioDecoder == null) {
      return null;
    }
    return localAudioDecoder.outputBuffer();
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      if (this.audioMixer.getDestAudioChannelCount() != paramAudioInfo.channelCount)
      {
        this.audioMixer.release();
        this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
      }
      paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      return paramByteBuffer;
    }
    finally {}
  }
  
  public CMSampleBuffer readCurrentSample()
  {
    return null;
  }
  
  public CMSampleBuffer readSample()
  {
    return readSample(CMTime.CMTimeInvalid);
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    ??? = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("readSample: [start]");
    ((StringBuilder)localObject2).append(paramCMTime);
    Logger.v((String)???, ((StringBuilder)localObject2).toString());
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    synchronized (AudioDecoderTrack.DecoderThread.access$100(this.decoderThread))
    {
      if ((AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) != null) && (AudioDecoderTrack.CacheBuffer.access$300(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread)) == this.lastSampleState.getTime()))
      {
        paramCMTime = AudioDecoderTrack.CacheBuffer.access$400(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread));
        this.lastSampleState = new CMSampleState(AudioDecoderTrack.CacheBuffer.access$300(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread)));
        createNextDecoder(this.segmentIndex);
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readSample: [success] hit asyncRead - ");
        localStringBuilder.append(this.lastSampleState);
        Logger.v((String)localObject2, localStringBuilder.toString());
        return paramCMTime;
      }
      paramCMTime = doReadSample(paramCMTime);
      if (paramCMTime.getSampleByteBuffer() != null)
      {
        float f = this._speed;
        if ((f > 0.1F) && (f < 16.0F))
        {
          ??? = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("readSample: processFrame [volume ");
          ((StringBuilder)localObject2).append(this.volume);
          ((StringBuilder)localObject2).append("] [_speed ");
          ((StringBuilder)localObject2).append(this._speed);
          ((StringBuilder)localObject2).append("]");
          Logger.v((String)???, ((StringBuilder)localObject2).toString());
          paramCMTime.setSampleByteBuffer(processFrame(paramCMTime.getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
          ??? = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("readSample: processFrame finish [volume ");
          ((StringBuilder)localObject2).append(this.volume);
          ((StringBuilder)localObject2).append("] [_speed ");
          ((StringBuilder)localObject2).append(this._speed);
          ((StringBuilder)localObject2).append("]");
          Logger.v((String)???, ((StringBuilder)localObject2).toString());
        }
      }
      this.lastSampleState = paramCMTime.getState();
      createNextDecoder(this.segmentIndex);
      ??? = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readSample: [success]  - ");
      ((StringBuilder)localObject2).append(this.lastSampleState);
      Logger.v((String)???, ((StringBuilder)localObject2).toString());
      return paramCMTime;
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 174	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   5: ldc_w 670
    //   8: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 114	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   15: invokevirtual 671	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 107	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   23: aload_0
    //   24: getfield 149	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 149	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   34: invokevirtual 672	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 149	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   42: aload_0
    //   43: getfield 103	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   46: astore_1
    //   47: aload_1
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   53: ifnull +15 -> 68
    //   56: aload_0
    //   57: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   60: invokestatic 676	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   68: aload_1
    //   69: monitorexit
    //   70: getstatic 174	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   73: ldc_w 678
    //   76: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	AudioDecoderTrack
    //   87	4	1	localObject2	Object
    //   82	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	68	82	finally
    //   68	70	82	finally
    //   83	85	82	finally
    //   2	42	87	finally
    //   42	49	87	finally
    //   70	79	87	finally
    //   85	87	87	finally
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("seekTo:[time ");
    ((StringBuilder)localObject2).append(paramCMTime);
    ((StringBuilder)localObject2).append("] [needRead ");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append("] [quickSeek ");
    ((StringBuilder)localObject2).append(paramBoolean2);
    ((StringBuilder)localObject2).append("]");
    Logger.v((String)???, ((StringBuilder)localObject2).toString());
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    synchronized (AudioDecoderTrack.DecoderThread.access$100(this.decoderThread))
    {
      AudioDecoderTrack.DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.d(TAG, "seekTo: [failed] un started");
        return null;
      }
      int i = findSegmentIndexAt(paramCMTime, true);
      if (i == -1)
      {
        this.segmentIndex = -1;
        Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
        return null;
      }
      ??? = getSegmentStartTime(i);
      if ((this.segmentIndex != i) || (this.currentDecoder == null))
      {
        this.segmentIndex = (i - 1);
        nextSegment(false);
      }
      ??? = paramCMTime.sub((CMTime)???).multi(this._speed);
      localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
      AudioDecoder localAudioDecoder = this.currentDecoder;
      if (localAudioDecoder == null)
      {
        this.lastSampleState = new CMSampleState(paramCMTime);
        Logger.d(TAG, "seekTo: [failed] currentDecoder == null ");
        return null;
      }
      localAudioDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime().add((CMTime)???));
      if (paramCMTime.bigThan(this.frameDuration)) {
        this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));
      } else {
        this.lastSampleState = new CMSampleState(paramCMTime);
      }
      paramCMTime = TAG;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("seekTo: [success] [lastSampleState ");
      ((StringBuilder)???).append(this.lastSampleState);
      ((StringBuilder)???).append("]");
      Logger.v(paramCMTime, ((StringBuilder)???).toString());
      return null;
    }
  }
  
  public void setAudioInfo(@NonNull AudioInfo paramAudioInfo)
  {
    this.audioInfo = paramAudioInfo.clone();
    if (this.emptyAudioBuffer != null) {
      this.emptyAudioBuffer = null;
    }
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameDuration = this.frameDuration.divide(paramInt / this.frameRate);
    this.frameRate = paramInt;
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTrackIndex(int paramInt) {}
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public float speed()
  {
    return this._speed;
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
    if (this.segments.size() == 0)
    {
      release();
      return;
    }
    this.isReleased = false;
    this.decoderThread.start();
    this.started = true;
    this.segmentIndex = -1;
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */