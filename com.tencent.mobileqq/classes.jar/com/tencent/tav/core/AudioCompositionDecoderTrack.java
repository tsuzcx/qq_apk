package com.tencent.tav.core;

import android.text.TextUtils;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
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
    if (!paramAssetTrackSegment.isEmpty())
    {
      localObject = new DecoderAssetTrack();
      ((DecoderAssetTrack)localObject).assetPath = paramAssetTrack.getSourcePath();
      ((DecoderAssetTrack)localObject).trackId = paramAssetTrack.getTrackID();
      ((DecoderAssetTrack)localObject).mediaType = paramAssetTrack.getMediaType();
      ((DecoderAssetTrack)localObject).extraInfo = paramAssetTrack.getExtraInfo();
      ((DecoderAssetTrack)localObject).size = paramAssetTrack.getNaturalSize();
      ((DecoderAssetTrack)localObject).preferredTransform = paramAssetTrack.getPreferredTransform();
      ((DecoderAssetTrack)localObject).preferredVolume = paramAssetTrack.getPreferredVolume();
      ((DecoderAssetTrack)localObject).frameRate = ((int)paramAssetTrack.getNominalFrameRate());
      paramAssetTrack = (AssetTrack)localObject;
    }
    else
    {
      paramAssetTrack = null;
    }
    Object localObject = paramAssetTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(((CMTimeRange)localObject).getStart(), ((CMTimeRange)localObject).getDuration()), paramAssetTrack);
    paramAssetTrack.setScaledDuration(paramAssetTrackSegment.getScaleDuration());
    return paramAssetTrack;
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    if (!paramCompositionTrackSegment.isEmpty())
    {
      localObject = new DecoderAssetTrack();
      ((DecoderAssetTrack)localObject).trackId = paramCompositionTrackSegment.getSourceTrackID();
      ((DecoderAssetTrack)localObject).mediaType = paramAssetTrack.getMediaType();
      ((DecoderAssetTrack)localObject).assetPath = paramCompositionTrackSegment.getSourcePath();
      ((DecoderAssetTrack)localObject).extraInfo = paramCompositionTrackSegment.getExtraInfo();
      ((DecoderAssetTrack)localObject).preferredTransform = paramAssetTrack.getPreferredTransform();
      ((DecoderAssetTrack)localObject).size = paramAssetTrack.getNaturalSize();
      ((DecoderAssetTrack)localObject).frameRate = ((int)paramAssetTrack.getNominalFrameRate());
      ((DecoderAssetTrack)localObject).preferredVolume = paramAssetTrack.getPreferredVolume();
      paramAssetTrack = (AssetTrack)localObject;
      if (!TextUtils.isEmpty(((DecoderAssetTrack)localObject).assetPath))
      {
        ((DecoderAssetTrack)localObject).sourceType = paramCompositionTrackSegment.getSourceType();
        paramAssetTrack = (AssetTrack)localObject;
      }
    }
    else
    {
      paramAssetTrack = null;
    }
    Object localObject = paramCompositionTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(((CMTimeRange)localObject).getStart(), ((CMTimeRange)localObject).getDuration()), paramAssetTrack);
    paramAssetTrack.setScaledDuration(paramCompositionTrackSegment.getScaleDuration());
    return paramAssetTrack;
  }
  
  private CMSampleBuffer doReadSample()
  {
    try
    {
      Logger.v("AudioCompositionDecoder", "doReadSample: start ");
      if (this.decoderTrackList.isEmpty())
      {
        Logger.e("AudioCompositionDecoder", "doReadSample:[finish] decoderTrackList.isEmpty ");
        localObject1 = new CMSampleBuffer(CMSampleState.fromError(-100L));
        return localObject1;
      }
      localObject3 = (AudioDecoderTrack)this.decoderTrackList.get(0);
      localObject1 = ((AudioDecoderTrack)localObject3).readSample();
      if (((CMSampleBuffer)localObject1).getState().getStateCode() < -1L)
      {
        Logger.e("AudioCompositionDecoder", "doReadSample:[failed]");
        return localObject1;
      }
      this._lastReadAudioBuffer = ((CMSampleBuffer)localObject1);
      localObject1 = this._lastReadAudioBuffer.getSampleByteBuffer();
      if (this._lastReadAudioBuffer.getSampleByteBuffer() == null) {
        localObject1 = ((AudioDecoderTrack)localObject3).getEmptyAudioBuffer();
      }
      if (localObject1 != null) {
        ((ByteBuffer)localObject1).position(0);
      }
      localObject1 = new CMSampleBuffer(this._lastReadAudioBuffer.getTime(), (ByteBuffer)localObject1);
      i = this.decoderTrackList.size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject4;
        Object localObject5;
        AudioCompositor localAudioCompositor;
        for (;;)
        {
          throw localObject2;
        }
        label394:
        Object localObject3 = null;
        continue;
        label399:
        i -= 1;
      }
    }
    localObject4 = null;
    localObject3 = localObject1;
    if (i > 0)
    {
      localObject5 = (AudioDecoderTrack)this.decoderTrackList.get(i);
      localAudioCompositor = (AudioCompositor)this.audioCompositorMap.get(Integer.valueOf(((AudioDecoderTrack)localObject5).getTrackID()));
      if (localAudioCompositor == null)
      {
        Logger.e("AudioCompositionDecoder", "doReadSample: audioCompositorMap.get(decoderTrack.getTrackID(), return null!");
        break label399;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("doReadSample: readMergeSample ");
      ((StringBuilder)localObject3).append(i);
      Logger.v("AudioCompositionDecoder", ((StringBuilder)localObject3).toString());
      if (this.audioMix == null) {
        break label394;
      }
      localObject3 = this.audioMix.getInputParametersWithTrackID(((AudioDecoderTrack)localObject5).getTrackID());
      localObject3 = localAudioCompositor.readMergeSample((AudioDecoderTrack)localObject5, (AudioMixInputParameters)localObject3, (CMSampleBuffer)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doReadSample: readMergeSample finish ");
      ((StringBuilder)localObject1).append(i);
      Logger.v("AudioCompositionDecoder", ((StringBuilder)localObject1).toString());
      localObject1 = localObject3;
      if (localObject3 == null) {
        break label399;
      }
      localObject1 = localObject3;
      if (((CMSampleBuffer)localObject3).getState().getStateCode() >= -1L) {
        break label399;
      }
    }
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("doReadSample:[success]  ");
    if (localObject3 == null) {
      localObject1 = localObject4;
    } else {
      localObject1 = ((CMSampleBuffer)localObject3).getTime();
    }
    ((StringBuilder)localObject5).append(localObject1);
    Logger.v("AudioCompositionDecoder", ((StringBuilder)localObject5).toString());
    return localObject3;
  }
  
  private void initAudioDecodeTracks(CMTimeRange paramCMTimeRange)
  {
    if (this.audioTracks == null) {
      return;
    }
    try
    {
      this.decoderTrackList.clear();
      Object localObject1 = new AudioDecoderTrack();
      Object localObject2 = new ArrayList();
      Object localObject3 = CMTime.CMTimeZero;
      if (paramCMTimeRange == null) {
        paramCMTimeRange = getDuration();
      } else {
        paramCMTimeRange = paramCMTimeRange.getDuration();
      }
      ((List)localObject2).add(createDecoderTrackSegment(null, new CompositionTrackSegment(new CMTimeRange((CMTime)localObject3, paramCMTimeRange))));
      ((AudioDecoderTrack)localObject1).setTrackID(0);
      ((AudioDecoderTrack)localObject1).setTrackSegments((List)localObject2);
      ((AudioDecoderTrack)localObject1).setVolume(0.0F);
      ((AudioDecoderTrack)localObject1).setDecodeType(IDecoder.DecodeType.Audio);
      ((AudioDecoderTrack)localObject1).setAudioInfo(this.audioInfo);
      this.decoderTrackList.add(localObject1);
      paramCMTimeRange = this.audioTracks.iterator();
      while (paramCMTimeRange.hasNext())
      {
        localObject1 = (AssetTrack)paramCMTimeRange.next();
        if (((AssetTrack)localObject1).getMediaType() == 2)
        {
          localObject2 = new AudioDecoderTrack();
          localObject3 = new AudioCompositor(this.audioInfo);
          Object localObject4 = ((AssetTrack)localObject1).getSegments();
          ArrayList localArrayList = new ArrayList();
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject4).next();
            if ((localAssetTrackSegment instanceof CompositionTrackSegment)) {
              localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, (CompositionTrackSegment)localAssetTrackSegment));
            } else {
              localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, localAssetTrackSegment));
            }
          }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw paramCMTimeRange;
    }
  }
  
  private void initAudioMix()
  {
    Object localObject = this.audioTracks;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.audioTracks.iterator();
      while (localIterator.hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
        if (localAssetTrack != null)
        {
          MutableAudioMixInputParameters localMutableAudioMixInputParameters = new MutableAudioMixInputParameters(localAssetTrack, null);
          localMutableAudioMixInputParameters.setVolumeForTimeRange(localAssetTrack.getPreferredVolume(), localAssetTrack.getTimeRange());
          ((List)localObject).add(localMutableAudioMixInputParameters);
        }
      }
      this.audioMix = new AudioMix((List)localObject);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asyncReadNextSample: ");
    localStringBuilder.append(???);
    Logger.v("AudioCompositionDecoder", localStringBuilder.toString());
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
    while (localIterator.hasNext())
    {
      CMTime localCMTime = ((AssetTrack)localIterator.next()).getDuration();
      if (localCMTime.bigThan((CMTime)localObject)) {
        localObject = localCMTime;
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
  
  public CMSampleBuffer readCurrentSample()
  {
    return null;
  }
  
  public CMSampleBuffer readSample()
  {
    if (this.decoderTrackList.size() == 0) {
      return new CMSampleBuffer(CMSampleState.fromError(-100L));
    }
    synchronized (AudioCompositionDecoderTrack.DecoderThread.access$000(this.decoderThread))
    {
      if (AudioCompositionDecoderTrack.DecoderThread.access$100(this.decoderThread) != null)
      {
        CMSampleBuffer localCMSampleBuffer = AudioCompositionDecoderTrack.DecoderThread.access$100(this.decoderThread);
        AudioCompositionDecoderTrack.DecoderThread.access$102(this.decoderThread, null);
        return localCMSampleBuffer;
      }
      ??? = doReadSample();
      if ((??? != null) && (((CMSampleBuffer)???).getSampleByteBuffer() != null)) {
        ((CMSampleBuffer)???).setSampleByteBuffer(processFrame(((CMSampleBuffer)???).getSampleByteBuffer(), this.volume, this.rate, this.audioInfo));
      }
      return ???;
    }
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    return readSample();
  }
  
  public void release()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("release: ");
      ((StringBuilder)localObject1).append(this);
      Logger.d("AudioCompositionDecoder", ((StringBuilder)localObject1).toString());
      localObject1 = this.decoderTrackList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((AudioDecoderTrack)((Iterator)localObject1).next()).release();
      }
      this.decoderTrackList.clear();
      this.audioTracks.clear();
      this.decoderThread.release();
      localObject1 = this.audioCompositorMap.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((AudioCompositor)((Iterator)localObject1).next()).release();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("release: finish");
      ((StringBuilder)localObject1).append(this);
      Logger.d("AudioCompositionDecoder", ((StringBuilder)localObject1).toString());
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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
    ??? = new StringBuilder();
    ((StringBuilder)???).append("seekTo:[timeUs ");
    ((StringBuilder)???).append(paramCMTime);
    ((StringBuilder)???).append("] [needRead ");
    ((StringBuilder)???).append(paramBoolean1);
    ((StringBuilder)???).append("] [quickSeek ");
    ((StringBuilder)???).append(paramBoolean2);
    ((StringBuilder)???).append("]");
    Logger.v("AudioCompositionDecoder", ((StringBuilder)???).toString());
    synchronized (AudioCompositionDecoderTrack.DecoderThread.access$000(this.decoderThread))
    {
      AudioCompositionDecoderTrack.DecoderThread.access$102(this.decoderThread, null);
      ??? = this.decoderTrackList.iterator();
      while (((Iterator)???).hasNext())
      {
        AudioDecoderTrack localAudioDecoderTrack = (AudioDecoderTrack)((Iterator)???).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seekTo: ");
        localStringBuilder.append(localAudioDecoderTrack);
        Logger.v("AudioCompositionDecoder", localStringBuilder.toString());
        localAudioDecoderTrack.seekTo(paramCMTime, false, paramBoolean2);
      }
      try
      {
        this._lastReadAudioBuffer = null;
        paramCMTime = this.audioCompositorMap.values().iterator();
        while (paramCMTime.hasNext()) {
          ((AudioCompositor)paramCMTime.next()).clear();
        }
        return null;
      }
      finally {}
    }
    for (;;)
    {
      throw paramCMTime;
    }
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
  
  public void setTrackIndex(int paramInt) {}
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVolume(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVolume: ");
    ((StringBuilder)localObject).append(paramFloat);
    Logger.i("AudioCompositionDecoder", ((StringBuilder)localObject).toString());
    localObject = this.audioMix;
    if (localObject != null)
    {
      localObject = ((AudioMix)localObject).getInputParameters();
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
    paramSurfaceCreator = new StringBuilder();
    paramSurfaceCreator.append("start: ");
    paramSurfaceCreator.append(paramCMTimeRange);
    Logger.d("AudioCompositionDecoder", paramSurfaceCreator.toString());
    if (!this.decoderStarted)
    {
      paramSurfaceCreator = new StringBuilder();
      paramSurfaceCreator.append("start: ");
      paramSurfaceCreator.append(this);
      Logger.d("AudioCompositionDecoder", paramSurfaceCreator.toString());
      this.decoderThread.start();
      initAudioDecodeTracks(paramCMTimeRange);
      this.decoderStarted = true;
      int i = 0;
      for (paramCMTimeRange = null; i < this.decoderTrackList.size(); paramCMTimeRange = paramSurfaceCreator)
      {
        if (i > 0)
        {
          int j = i - 1;
          if (j < this.audioTracks.size())
          {
            AssetTrack localAssetTrack = (AssetTrack)this.audioTracks.get(j);
            paramSurfaceCreator = paramCMTimeRange;
            if (localAssetTrack == null) {
              break label199;
            }
            paramSurfaceCreator = paramCMTimeRange;
            if (localAssetTrack.getTimeRange() == null) {
              break label199;
            }
            paramSurfaceCreator = new CMTimeRange(localAssetTrack.getTimeRange().getStart(), localAssetTrack.getTimeRange().getDuration());
            break label199;
          }
        }
        paramSurfaceCreator = new CMTimeRange(CMTime.CMTimeZero, getDuration());
        label199:
        ((AudioDecoderTrack)this.decoderTrackList.get(i)).start(null, paramSurfaceCreator);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */