package com.tencent.tav.core;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssetReaderAudioMixOutput
  extends AssetReaderOutput
{
  public static final String TAG = "AssetReaderAudioMixOutput";
  private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
  @Nullable
  private Map<String, Object> audioSettings;
  private ArrayList<AssetTrack> audioTracks;
  private boolean decoderStarted = false;
  
  public AssetReaderAudioMixOutput(ArrayList<AssetTrack> paramArrayList, Map<String, Object> paramMap)
  {
    this.audioTracks = paramArrayList;
    this.audioSettings = paramMap;
    this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(paramArrayList, 2);
  }
  
  @Nullable
  public Map<String, Object> getAudioSettings()
  {
    return this.audioSettings;
  }
  
  public ArrayList<AssetTrack> getAudioTracks()
  {
    return this.audioTracks;
  }
  
  public void markConfigurationAsFinal() {}
  
  public CMSampleBuffer nextSampleBuffer()
  {
    return this.audioCompositionDecoderTrack.readSample();
  }
  
  void release()
  {
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
    if (localAudioCompositionDecoderTrack != null) {
      localAudioCompositionDecoderTrack.release();
    }
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    this.audioCompositionDecoderTrack.setAudioInfo(paramAudioInfo);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
    if (localAudioCompositionDecoderTrack != null) {
      localAudioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
  }
  
  void start(@Nullable IContextCreate paramIContextCreate, AssetReader paramAssetReader)
  {
    if ((this.audioCompositionDecoderTrack != null) && (!this.decoderStarted))
    {
      if (paramAssetReader.getTimeRange() != null)
      {
        paramIContextCreate = paramAssetReader.getTimeRange().getStart();
        if (paramIContextCreate.equals(CMTime.CMTimeZero))
        {
          this.audioCompositionDecoderTrack.start(null, paramAssetReader.getTimeRange());
        }
        else
        {
          this.audioCompositionDecoderTrack.start(null);
          this.audioCompositionDecoderTrack.seekTo(paramIContextCreate, false, false);
        }
      }
      else
      {
        this.audioCompositionDecoderTrack.start(null);
      }
      this.decoderStarted = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderAudioMixOutput
 * JD-Core Version:    0.7.0.1
 */