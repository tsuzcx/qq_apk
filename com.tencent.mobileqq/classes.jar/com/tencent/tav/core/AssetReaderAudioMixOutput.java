package com.tencent.tav.core;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssetReaderAudioMixOutput
  extends AssetReaderOutput
{
  public static final String TAG = "AssetReaderAudioMixOutput";
  private IDecoderTrack audioCompositionDecoderTrack;
  @Nullable
  private Map<String, Object> audioSettings;
  private ArrayList<AssetTrack> audioTracks;
  private boolean decoderStarted = false;
  
  public AssetReaderAudioMixOutput(ArrayList<AssetTrack> paramArrayList, Map<String, Object> paramMap, boolean paramBoolean)
  {
    this.audioTracks = paramArrayList;
    this.audioSettings = paramMap;
    paramArrayList = new AudioCompositionDecoderTrack(paramArrayList, 2);
    if (paramBoolean)
    {
      this.audioCompositionDecoderTrack = new ReverseAudioDecoderTrack(paramArrayList);
      return;
    }
    this.audioCompositionDecoderTrack = paramArrayList;
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
    IDecoderTrack localIDecoderTrack = this.audioCompositionDecoderTrack;
    if (localIDecoderTrack != null) {
      localIDecoderTrack.release();
    }
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    IDecoderTrack localIDecoderTrack = this.audioCompositionDecoderTrack;
    if ((localIDecoderTrack instanceof AudioCompositionDecoderTrack))
    {
      ((AudioCompositionDecoderTrack)localIDecoderTrack).setAudioInfo(paramAudioInfo);
      return;
    }
    if ((localIDecoderTrack instanceof ReverseAudioDecoderTrack)) {
      ((ReverseAudioDecoderTrack)localIDecoderTrack).setAudioInfo(paramAudioInfo);
    }
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    IDecoderTrack localIDecoderTrack = this.audioCompositionDecoderTrack;
    if ((localIDecoderTrack instanceof AudioCompositionDecoderTrack))
    {
      ((AudioCompositionDecoderTrack)localIDecoderTrack).setAudioMix(paramAudioMix);
      return;
    }
    if ((localIDecoderTrack instanceof ReverseAudioDecoderTrack)) {
      ((ReverseAudioDecoderTrack)localIDecoderTrack).setAudioMix(paramAudioMix);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderAudioMixOutput
 * JD-Core Version:    0.7.0.1
 */