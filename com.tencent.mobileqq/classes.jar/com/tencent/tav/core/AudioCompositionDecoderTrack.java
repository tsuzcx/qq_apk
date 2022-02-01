package com.tencent.tav.core;

import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoder;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AudioCompositionDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "AudioCompositionDecoder";
  private CMSampleBuffer _lastReadAudioBuffer;
  private HashMap<Integer, AudioCompositor> audioCompositorMap = new HashMap();
  private AudioInfo audioInfo = new AudioInfo();
  private AudioMix audioMix;
  private List<AssetTrack> audioTracks = new ArrayList();
  private boolean decoderStarted = false;
  private final AudioCompositionDecoderTrack.DecoderThread decoderThread = new AudioCompositionDecoderTrack.DecoderThread(this);
  private ArrayList<AudioDecoderTrack> decoderTrackList = new ArrayList();
  private AudioMixer mAudioMixer = new AudioMixer();
  private float rate = 1.0F;
  private float volume = 1.0F;
  
  public AudioCompositionDecoderTrack(int paramInt)
  {
    initAudioDecodeTracks(null);
    initAudioMix();
  }
  
  public AudioCompositionDecoderTrack(List<AssetTrack> paramList, int paramInt)
  {
    this.audioTracks = paramList;
    initAudioDecodeTracks(null);
    initAudioMix();
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramAssetTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramAssetTrack.getSourcePath();
      localDecoderAssetTrack.trackId = paramAssetTrack.getTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
    }
    paramAssetTrack = paramAssetTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramAssetTrackSegment.getScaleDuration());
    return paramAssetTrack;
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramCompositionTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.trackId = paramCompositionTrackSegment.getSourceTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      localDecoderAssetTrack.assetPath = paramCompositionTrackSegment.getSourcePath();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
    }
    paramAssetTrack = paramCompositionTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramCompositionTrackSegment.getScaleDuration());
    return paramAssetTrack;
  }
  
  private CMSampleBuffer doReadSample()
  {
    for (;;)
    {
      int i;
      try
      {
        if (Logger.LOG_VERBOSE) {
          Logger.d("AudioCompositionDecoder", "doReadSample: start ");
        }
        if (this.decoderTrackList.isEmpty())
        {
          Logger.e("AudioCompositionDecoder", "doReadSample:[finish] decoderTrackList.isEmpty ");
          localObject3 = new CMSampleBuffer(AudioDecoder.SAMPLE_TIME_UNSTART);
          return localObject3;
        }
        Object localObject4 = (AudioDecoderTrack)this.decoderTrackList.get(0);
        localObject3 = ((AudioDecoderTrack)localObject4).readSample();
        if (((CMSampleBuffer)localObject3).getTime().smallThan(IDecoder.SAMPLE_TIME_FINISH))
        {
          Logger.e("AudioCompositionDecoder", "doReadSample:[failed]");
          continue;
        }
        this._lastReadAudioBuffer = ((CMSampleBuffer)localObject3);
        Object localObject1 = this._lastReadAudioBuffer.getSampleByteBuffer();
        if (this._lastReadAudioBuffer.getSampleByteBuffer() != null) {
          break label399;
        }
        localObject1 = ((AudioDecoderTrack)localObject4).getEmptyAudioBuffer();
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).position(0);
        }
        localObject1 = new CMSampleBuffer(this._lastReadAudioBuffer.getTime(), (ByteBuffer)localObject1);
        i = this.decoderTrackList.size() - 1;
        if (i <= 0) {
          break label396;
        }
        localObject4 = (AudioDecoderTrack)this.decoderTrackList.get(i);
        AudioCompositor localAudioCompositor = (AudioCompositor)this.audioCompositorMap.get(Integer.valueOf(((AudioDecoderTrack)localObject4).getTrackID()));
        if (localAudioCompositor == null)
        {
          Logger.e("AudioCompositionDecoder", "doReadSample: audioCompositorMap.get(decoderTrack.getTrackID(), return null!");
          break label402;
        }
        if (Logger.LOG_VERBOSE) {
          Logger.i("AudioCompositionDecoder", "doReadSample: readMergeSample " + i, new Object[0]);
        }
        if (this.audioMix != null)
        {
          localObject3 = this.audioMix.getInputParametersWithTrackID(((AudioDecoderTrack)localObject4).getTrackID());
          localObject3 = localAudioCompositor.readMergeSample((AudioDecoderTrack)localObject4, (AudioMixInputParameters)localObject3, (CMSampleBuffer)localObject1);
          if (Logger.LOG_VERBOSE) {
            Logger.i("AudioCompositionDecoder", "doReadSample: readMergeSample finish " + i, new Object[0]);
          }
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label402;
          }
          localObject1 = localObject3;
          if (!((CMSampleBuffer)localObject3).getTime().smallThan(IDecoder.SAMPLE_TIME_FINISH)) {
            break label402;
          }
          localObject1 = localObject3;
          localObject3 = localObject1;
          if (!Logger.LOG_VERBOSE) {
            continue;
          }
          localObject4 = new StringBuilder().append("doReadSample:[success]  ");
          if (localObject1 != null) {
            break label388;
          }
          localObject3 = null;
          Logger.d("AudioCompositionDecoder", localObject3);
          localObject3 = localObject1;
          continue;
        }
        localObject3 = null;
      }
      finally {}
      continue;
      label388:
      Object localObject3 = localObject2.getTime();
      continue;
      label396:
      continue;
      label399:
      continue;
      label402:
      i -= 1;
    }
  }
  
  private void initAudioDecodeTracks(CMTimeRange paramCMTimeRange)
  {
    if (this.audioTracks == null) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      ArrayList localArrayList;
      AssetTrackSegment localAssetTrackSegment;
      try
      {
        this.decoderTrackList.clear();
        localObject1 = new AudioDecoderTrack();
        localObject2 = new ArrayList();
        localObject3 = CMTime.CMTimeZero;
        if (paramCMTimeRange == null)
        {
          paramCMTimeRange = getDuration();
          ((List)localObject2).add(createDecoderTrackSegment(null, new CompositionTrackSegment(new CMTimeRange((CMTime)localObject3, paramCMTimeRange))));
          ((AudioDecoderTrack)localObject1).setTrackID(0);
          ((AudioDecoderTrack)localObject1).setTrackSegments((List)localObject2);
          ((AudioDecoderTrack)localObject1).setVolume(0.0F);
          ((AudioDecoderTrack)localObject1).setDecodeType(IDecoder.DecodeType.Audio);
          ((AudioDecoderTrack)localObject1).setAudioInfo(this.audioInfo);
          this.decoderTrackList.add(localObject1);
          paramCMTimeRange = this.audioTracks.iterator();
          if (!paramCMTimeRange.hasNext()) {
            break;
          }
          localObject1 = (AssetTrack)paramCMTimeRange.next();
          if (((AssetTrack)localObject1).getMediaType() != 2) {
            continue;
          }
          localObject2 = new AudioDecoderTrack();
          localObject3 = new AudioCompositor(this.audioInfo);
          Object localObject4 = ((AssetTrack)localObject1).getSegments();
          localArrayList = new ArrayList();
          localObject4 = ((List)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label281;
          }
          localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject4).next();
          if (!(localAssetTrackSegment instanceof CompositionTrackSegment)) {
            break label263;
          }
          localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, (CompositionTrackSegment)localAssetTrackSegment));
          continue;
        }
        paramCMTimeRange = paramCMTimeRange.getDuration();
      }
      finally {}
      continue;
      label263:
      localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, localAssetTrackSegment));
      continue;
      label281:
      ((AudioDecoderTrack)localObject2).setTrackID(((AssetTrack)localObject1).getTrackID());
      ((AudioDecoderTrack)localObject2).setTrackSegments(localArrayList);
      ((AudioDecoderTrack)localObject2).setFrameRate((int)((AssetTrack)localObject1).getNominalFrameRate());
      ((AudioDecoderTrack)localObject2).setVolume(((AssetTrack)localObject1).getPreferredVolume());
      ((AudioDecoderTrack)localObject2).setDecodeType(IDecoder.DecodeType.Audio);
      ((AudioDecoderTrack)localObject2).setAudioInfo(this.audioInfo);
      if (((AssetTrack)localObject1).getTimeRange() != null) {
        ((AudioDecoderTrack)localObject2).clipRangeAndClearRange(new CMTimeRange(((AssetTrack)localObject1).getTimeRange().getStart(), ((AssetTrack)localObject1).getTimeRange().getDuration()));
      }
      this.decoderTrackList.add(localObject2);
      this.audioCompositorMap.put(Integer.valueOf(((AssetTrack)localObject1).getTrackID()), localObject3);
    }
  }
  
  private void initAudioMix()
  {
    if ((this.audioTracks != null) && (this.audioTracks.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.audioTracks.iterator();
      while (localIterator.hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
        if (localAssetTrack != null)
        {
          MutableAudioMixInputParameters localMutableAudioMixInputParameters = new MutableAudioMixInputParameters(localAssetTrack, null);
          localMutableAudioMixInputParameters.setVolumeForTimeRange(localAssetTrack.getPreferredVolume(), localAssetTrack.getTimeRange());
          localArrayList.add(localMutableAudioMixInputParameters);
        }
      }
      this.audioMix = new AudioMix(localArrayList);
    }
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      this.audioTracks.add(paramAssetTrack);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d("AudioCompositionDecoder", "asyncReadNextSample: " + ???);
    }
    if (AudioCompositionDecoderTrack.DecoderThread.access$100(this.decoderThread) == null) {
      synchronized (AudioCompositionDecoderTrack.DecoderThread.access$000(this.decoderThread))
      {
        if (AudioCompositionDecoderTrack.DecoderThread.access$100(this.decoderThread) == null) {
          this.decoderThread.action();
        }
        return;
      }
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange) {}
  
  public CMTime getCurrentSampleTime()
  {
    return ((AudioDecoderTrack)this.decoderTrackList.get(0)).getCurrentSampleTime();
  }
  
  public CMTime getDuration()
  {
    Object localObject = CMTime.CMTimeZero;
    Iterator localIterator = this.audioTracks.iterator();
    if (localIterator.hasNext())
    {
      CMTime localCMTime = ((AssetTrack)localIterator.next()).getDuration();
      if (localCMTime.bigThan((CMTime)localObject)) {
        localObject = localCMTime;
      }
      for (;;)
      {
        break;
      }
    }
    return localObject;
  }
  
  public CMTime getFrameDuration()
  {
    return CMTime.CMTimeZero;
  }
  
  public int getFrameRate()
  {
    return 0;
  }
  
  public int getTrackId()
  {
    return 0;
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      this.mAudioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
      paramByteBuffer = this.mAudioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      return paramByteBuffer;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public CMSampleBuffer readSample()
  {
    if (this.decoderTrackList.size() == 0) {
      ??? = new CMSampleBuffer(AudioDecoder.SAMPLE_TIME_UNSTART);
    }
    CMSampleBuffer localCMSampleBuffer2;
    do
    {
      do
      {
        return ???;
        synchronized (AudioCompositionDecoderTrack.DecoderThread.access$000(this.decoderThread))
        {
          if (AudioCompositionDecoderTrack.DecoderThread.access$100(this.decoderThread) != null)
          {
            CMSampleBuffer localCMSampleBuffer1 = AudioCompositionDecoderTrack.DecoderThread.access$100(this.decoderThread);
            AudioCompositionDecoderTrack.DecoderThread.access$102(this.decoderThread, null);
            return localCMSampleBuffer1;
          }
        }
        localCMSampleBuffer2 = doReadSample();
        ??? = localCMSampleBuffer2;
      } while (localCMSampleBuffer2 == null);
      ??? = localCMSampleBuffer2;
    } while (localCMSampleBuffer2.getSampleByteBuffer() == null);
    localCMSampleBuffer2.setSampleByteBuffer(processFrame(localCMSampleBuffer2.getSampleByteBuffer(), this.volume, this.rate, this.audioInfo));
    return localCMSampleBuffer2;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    return readSample();
  }
  
  public void release()
  {
    try
    {
      Logger.e("AudioCompositionDecoder", "release: " + this);
      Iterator localIterator = this.decoderTrackList.iterator();
      while (localIterator.hasNext()) {
        ((AudioDecoderTrack)localIterator.next()).release();
      }
      this.decoderTrackList.clear();
    }
    finally {}
    this.audioTracks.clear();
    this.decoderThread.release();
    Logger.e("AudioCompositionDecoder", "release: finish" + this);
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      this.audioTracks.remove(paramAssetTrack);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d("AudioCompositionDecoder", "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    }
    synchronized (AudioCompositionDecoderTrack.DecoderThread.access$000(this.decoderThread))
    {
      AudioCompositionDecoderTrack.DecoderThread.access$102(this.decoderThread, null);
      ??? = this.decoderTrackList.iterator();
      if (((Iterator)???).hasNext())
      {
        AudioDecoderTrack localAudioDecoderTrack = (AudioDecoderTrack)((Iterator)???).next();
        if (Logger.LOG_VERBOSE) {
          Logger.i("AudioCompositionDecoder", "seekTo: " + localAudioDecoderTrack, new Object[0]);
        }
        localAudioDecoderTrack.seekTo(paramCMTime, false, paramBoolean2);
      }
    }
    try
    {
      this._lastReadAudioBuffer = null;
      paramCMTime = this.audioCompositorMap.values().iterator();
      while (paramCMTime.hasNext()) {
        ((AudioCompositor)paramCMTime.next()).clear();
      }
    }
    finally {}
    return null;
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    this.audioInfo = paramAudioInfo.clone();
    this.mAudioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((AudioDecoderTrack)localIterator.next()).setAudioInfo(paramAudioInfo);
    }
    localIterator = this.audioCompositorMap.values().iterator();
    while (localIterator.hasNext()) {
      ((AudioCompositor)localIterator.next()).setAudioInfo(paramAudioInfo);
    }
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameRate(int paramInt)
  {
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((AudioDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
  }
  
  public void setRate(float paramFloat)
  {
    this.rate = paramFloat;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVolume(float paramFloat)
  {
    Logger.d("AudioCompositionDecoder", "setVolume: " + paramFloat);
    if (this.audioMix != null)
    {
      Object localObject = this.audioMix.getInputParameters();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)((Iterator)localObject).next();
          if ((localAudioMixInputParameters != null) && ((localAudioMixInputParameters instanceof MutableAudioMixInputParameters))) {
            ((MutableAudioMixInputParameters)localAudioMixInputParameters).setVolumeForTimeRange(paramFloat);
          }
        }
      }
    }
    this.volume = paramFloat;
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
    Logger.d("AudioCompositionDecoder", "start: " + paramCMTimeRange);
    int i;
    if (!this.decoderStarted)
    {
      Logger.e("AudioCompositionDecoder", "start: " + this);
      this.decoderThread.start();
      initAudioDecodeTracks(paramCMTimeRange);
      this.decoderStarted = true;
      i = 0;
      paramSurfaceCreator = null;
      if (i < this.decoderTrackList.size()) {
        if ((i > 0) && (i - 1 < this.audioTracks.size()))
        {
          paramCMTimeRange = (AssetTrack)this.audioTracks.get(i - 1);
          if ((paramCMTimeRange == null) || (paramCMTimeRange.getTimeRange() == null)) {
            break label199;
          }
          paramSurfaceCreator = new CMTimeRange(paramCMTimeRange.getTimeRange().getStart(), paramCMTimeRange.getTimeRange().getDuration());
        }
      }
    }
    label199:
    for (;;)
    {
      ((AudioDecoderTrack)this.decoderTrackList.get(i)).start(null, paramSurfaceCreator);
      i += 1;
      break;
      paramSurfaceCreator = new CMTimeRange(CMTime.CMTimeZero, getDuration());
      continue;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */