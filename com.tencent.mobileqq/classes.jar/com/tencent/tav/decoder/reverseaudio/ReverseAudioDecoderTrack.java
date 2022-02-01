package com.tencent.tav.decoder.reverseaudio;

import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ReverseAudioDecoderTrack
  implements IDecoderTrack
{
  private AudioCompositionDecoderTrack audioDecoderTrack;
  private CMTime currentSampleTime = new CMTime(0.0F);
  private CMTime reverseTime = new CMTime(0.0F);
  private CMTime seekDuration = new CMTime(0.09287982F);
  
  public ReverseAudioDecoderTrack(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
  }
  
  @NotNull
  private ByteBuffer revertByteBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    paramCMSampleBuffer = paramCMSampleBuffer.getSampleByteBuffer();
    Object localObject2 = paramCMSampleBuffer.asShortBuffer();
    Object localObject1 = new short[((ShortBuffer)localObject2).limit()];
    ((ShortBuffer)localObject2).get((short[])localObject1);
    int j = localObject1.length;
    localObject2 = new short[j];
    int i = 0;
    while (i < j)
    {
      localObject2[i] = localObject1[(j - i - 1)];
      i += 1;
    }
    i = j * 2;
    localObject1 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject1).order(paramCMSampleBuffer.order());
    ((ByteBuffer)localObject1).asShortBuffer().put((short[])localObject2);
    ((ByteBuffer)localObject1).position(0);
    ((ByteBuffer)localObject1).limit(i);
    return localObject1;
  }
  
  public void asyncReadNextSample(CMTime paramCMTime) {}
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    this.audioDecoderTrack.clipRangeAndClearRange(paramCMTimeRange);
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.currentSampleTime;
  }
  
  public CMTime getDuration()
  {
    return this.audioDecoderTrack.getDuration();
  }
  
  public CMTime getFrameDuration()
  {
    return this.audioDecoderTrack.getFrameDuration();
  }
  
  public int getFrameRate()
  {
    return this.audioDecoderTrack.getFrameRate();
  }
  
  public int getTrackId()
  {
    return this.audioDecoderTrack.getTrackId();
  }
  
  public CMSampleBuffer readCurrentSample()
  {
    return this.audioDecoderTrack.readCurrentSample();
  }
  
  public CMSampleBuffer readSample()
  {
    if (this.reverseTime.getTimeUs() == 0L) {
      this.reverseTime = this.audioDecoderTrack.getDuration().sub(this.seekDuration);
    } else {
      this.reverseTime = this.reverseTime.sub(this.seekDuration);
    }
    if (this.reverseTime.smallThan(CMTime.CMTimeZero)) {
      this.reverseTime = CMTime.CMTimeZero;
    }
    this.audioDecoderTrack.seekTo(this.reverseTime, false, true);
    CMSampleBuffer localCMSampleBuffer = this.audioDecoderTrack.readSample();
    if (localCMSampleBuffer.getState().getStateCode() == -1L) {
      this.currentSampleTime = CMTime.CMTimeZero;
    } else if (localCMSampleBuffer.getTime().bigThan(CMTime.CMTimeZero)) {
      this.currentSampleTime = this.audioDecoderTrack.getDuration().sub(localCMSampleBuffer.getTime());
    }
    CMSampleState localCMSampleState;
    if (this.reverseTime.equalsTo(CMTime.CMTimeZero)) {
      localCMSampleState = CMSampleState.fromError(-1L);
    } else {
      localCMSampleState = new CMSampleState(this.currentSampleTime);
    }
    return new CMSampleBuffer(localCMSampleState, revertByteBuffer(localCMSampleBuffer), true);
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    return readSample();
  }
  
  public void release()
  {
    this.reverseTime = CMTime.CMTimeZero;
    this.currentSampleTime = CMTime.CMTimeZero;
    this.audioDecoderTrack.release();
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCMTime.bigThan(CMTime.CMTimeZero)) {
      this.reverseTime = this.audioDecoderTrack.getDuration().sub(paramCMTime);
    } else {
      this.reverseTime = paramCMTime;
    }
    return this.audioDecoderTrack.seekTo(this.reverseTime, paramBoolean1, paramBoolean2);
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    this.audioDecoderTrack.setAudioInfo(paramAudioInfo);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioDecoderTrack.setAudioMix(paramAudioMix);
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.audioDecoderTrack.setDecodeType(paramDecodeType);
  }
  
  public void setFrameRate(int paramInt)
  {
    this.audioDecoderTrack.setFrameRate(paramInt);
  }
  
  public void setRate(float paramFloat)
  {
    this.audioDecoderTrack.setRate(paramFloat);
  }
  
  public void setTrackIndex(int paramInt)
  {
    this.audioDecoderTrack.setTrackIndex(paramInt);
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    this.audioDecoderTrack.setTrackSegments(paramList);
  }
  
  public void setVolume(float paramFloat)
  {
    this.audioDecoderTrack.setVolume(paramFloat);
  }
  
  public void start()
  {
    start(null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    this.audioDecoderTrack.start(paramSurfaceCreator, null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    this.audioDecoderTrack.start(paramSurfaceCreator, paramCMTimeRange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */