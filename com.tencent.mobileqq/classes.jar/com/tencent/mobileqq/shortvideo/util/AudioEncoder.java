package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.editor.composite.CodecParam;
import java.io.File;

public class AudioEncoder
{
  public static int a(AudioEncoder.AudioData paramAudioData)
  {
    try
    {
      int i = encode(paramAudioData.a, paramAudioData.b, paramAudioData.c, paramAudioData.d, paramAudioData.e, paramAudioData.f, paramAudioData.g);
      return i;
    }
    catch (UnsatisfiedLinkError paramAudioData)
    {
      label34:
      break label34;
    }
    return -200;
  }
  
  public static int a(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return -202;
      }
      if (paramString.length() <= 0L) {
        return -203;
      }
      return 0;
    }
    return -201;
  }
  
  public static AudioEncoder.AudioData a(String paramString1, String paramString2, int paramInt)
  {
    AudioEncoder.AudioData localAudioData = new AudioEncoder.AudioData();
    localAudioData.a = paramString1;
    localAudioData.b = paramString2;
    localAudioData.c = paramInt;
    localAudioData.f = CodecParam.mAudioSampleRate;
    localAudioData.e = CodecParam.mDstAudioEncBitrate;
    if (CodecParam.mAudioFormat == 2) {
      localAudioData.d = 16;
    } else {
      localAudioData.d = 8;
    }
    if (CodecParam.mAudioChannel == 16)
    {
      localAudioData.g = 1;
      return localAudioData;
    }
    localAudioData.g = 2;
    return localAudioData;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */