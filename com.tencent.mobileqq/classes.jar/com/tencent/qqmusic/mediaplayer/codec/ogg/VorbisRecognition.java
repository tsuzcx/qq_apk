package com.tencent.qqmusic.mediaplayer.codec.ogg;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class VorbisRecognition
  implements IAudioRecognition
{
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("OggS"))) {
      return AudioFormat.AudioType.OGG;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".ogg"))) {
      return AudioFormat.AudioType.OGG;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisRecognition
 * JD-Core Version:    0.7.0.1
 */