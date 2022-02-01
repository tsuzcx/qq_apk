package com.tencent.qqmusic.mediaplayer;

public class AudioFormat
{
  private static final String EXTENSION_AAC = "aac";
  private static final String EXTENSION_AMR = "amr";
  private static final String EXTENSION_APE = "ape";
  private static final String EXTENSION_FLAC = "flac";
  private static final String EXTENSION_M4A = "m4a";
  private static final String EXTENSION_MP3 = "mp3";
  private static final String EXTENSION_MP4 = "mp4";
  private static final String EXTENSION_OGG = "ogg";
  private static final String EXTENSION_WAV = "wav";
  private static final String EXTENSION_WMA = "wma";
  private static final int VALUE_AAC = 11;
  private static final int VALUE_AMR = 6;
  private static final int VALUE_APE = 5;
  private static final int VALUE_FLAC = 2;
  private static final int VALUE_M4A = 3;
  private static final int VALUE_MP3 = 9;
  private static final int VALUE_MP4 = 10;
  private static final int VALUE_OGG = 4;
  private static final int VALUE_UNSUPPORT = 1;
  private static final int VALUE_WAV = 8;
  private static final int VALUE_WMA = 7;
  
  public static AudioFormat.AudioType getAudioType(int paramInt)
  {
    AudioFormat.AudioType[] arrayOfAudioType = AudioFormat.AudioType.values();
    int j = arrayOfAudioType.length;
    int i = 0;
    while (i < j)
    {
      AudioFormat.AudioType localAudioType = arrayOfAudioType[i];
      if (AudioFormat.AudioType.access$000(localAudioType) == paramInt) {
        return localAudioType;
      }
      i += 1;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public static boolean isAudioType(AudioFormat.AudioType paramAudioType)
  {
    return (paramAudioType != null) && (!AudioFormat.AudioType.UNSUPPORT.equals(paramAudioType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioFormat
 * JD-Core Version:    0.7.0.1
 */