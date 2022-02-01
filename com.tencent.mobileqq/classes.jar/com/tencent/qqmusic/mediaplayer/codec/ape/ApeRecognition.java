package com.tencent.qqmusic.mediaplayer.codec.ape;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;

public class ApeRecognition
  implements IAudioRecognition
{
  public static final String TAG = "ApeRecognition";
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("MAC"))) {
      return AudioFormat.AudioType.APE;
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    NativeDecoder localNativeDecoder = new NativeDecoder();
    paramArrayOfByte = localAudioType;
    if (localNativeDecoder.init(new FileDataSource(paramString)) == 0)
    {
      paramString = localNativeDecoder.getAudioInformation();
      paramArrayOfByte = localAudioType;
      if (paramString != null)
      {
        paramArrayOfByte = localAudioType;
        if (paramString.getAudioType() == AudioFormat.AudioType.APE) {
          paramArrayOfByte = AudioFormat.AudioType.APE;
        }
      }
    }
    return paramArrayOfByte;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().contains(".ape")) || (paramString.toLowerCase().contains(".mac")))) {
      return AudioFormat.AudioType.APE;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ape.ApeRecognition
 * JD-Core Version:    0.7.0.1
 */