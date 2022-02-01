package com.tencent.tav.core.audio;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;

public class AudioExportSession
{
  public static int MAX_THREAD_COUNT = 10;
  public static int SEGMENT_DURATION_US = 5000000;
  
  public static IAudioExportTask generateAudioAssetExportTask(Asset paramAsset, String paramString)
  {
    return new AudioExportTask(new AudioSourceComposition(paramAsset), paramString);
  }
  
  public static IAudioExportTask generateAudioTrackExportTask(AssetTrack paramAssetTrack, String paramString)
  {
    return new AudioExportTask(new AudioSourceTrack(paramAssetTrack), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportSession
 * JD-Core Version:    0.7.0.1
 */