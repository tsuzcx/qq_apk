package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class WavRecognition
  implements IAudioRecognition
{
  public static boolean isWav(IDataSource paramIDataSource)
  {
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramIDataSource.readAt(0L, arrayOfByte, 0, arrayOfByte.length);
      if ((arrayOfByte[0] == 82) && (arrayOfByte[1] == 73) && (arrayOfByte[2] == 70) && (arrayOfByte[3] == 70)) {
        return true;
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        paramIDataSource.readAt(8L, arrayOfByte, 0, arrayOfByte.length);
        label64:
        return (arrayOfByte[0] == 87) && (arrayOfByte[1] == 65) && (arrayOfByte[2] == 86) && (arrayOfByte[3] == 69);
        localIOException = localIOException;
      }
      catch (IOException paramIDataSource)
      {
        break label64;
      }
    }
  }
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if (WaveReader.isWavFormat(paramString)) {
      return AudioFormat.AudioType.WAV;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wav"))) {
      return AudioFormat.AudioType.WAV;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition
 * JD-Core Version:    0.7.0.1
 */