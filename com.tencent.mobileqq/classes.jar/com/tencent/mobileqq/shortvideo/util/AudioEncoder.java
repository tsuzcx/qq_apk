package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import java.io.File;

public class AudioEncoder
{
  public static int a(AudioEncoder.AudioData paramAudioData)
  {
    try
    {
      int i = encode(paramAudioData.jdField_a_of_type_JavaLangString, paramAudioData.jdField_b_of_type_JavaLangString, paramAudioData.jdField_a_of_type_Int, paramAudioData.jdField_b_of_type_Int, paramAudioData.c, paramAudioData.d, paramAudioData.e);
      return i;
    }
    catch (UnsatisfiedLinkError paramAudioData) {}
    return -200;
  }
  
  public static int a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return -201;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return -202;
    }
    if (paramString.length() <= 0L) {
      return -203;
    }
    return 0;
  }
  
  public static AudioEncoder.AudioData a(String paramString1, String paramString2, int paramInt)
  {
    AudioEncoder.AudioData localAudioData = new AudioEncoder.AudioData();
    localAudioData.jdField_a_of_type_JavaLangString = paramString1;
    localAudioData.jdField_b_of_type_JavaLangString = paramString2;
    localAudioData.jdField_a_of_type_Int = paramInt;
    localAudioData.d = CodecParam.mAudioSampleRate;
    localAudioData.c = CodecParam.mDstAudioEncBitrate;
    if (CodecParam.mAudioFormat == 2) {}
    for (localAudioData.jdField_b_of_type_Int = 16; CodecParam.mAudioChannel == 16; localAudioData.jdField_b_of_type_Int = 8)
    {
      localAudioData.e = 1;
      return localAudioData;
    }
    localAudioData.e = 2;
    return localAudioData;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */