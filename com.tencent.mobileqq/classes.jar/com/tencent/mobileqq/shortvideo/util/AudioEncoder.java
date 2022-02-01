package com.tencent.mobileqq.shortvideo.util;

import bbwq;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import java.io.File;

public class AudioEncoder
{
  public static int a(bbwq parambbwq)
  {
    try
    {
      int i = encode(parambbwq.jdField_a_of_type_JavaLangString, parambbwq.jdField_b_of_type_JavaLangString, parambbwq.jdField_a_of_type_Int, parambbwq.jdField_b_of_type_Int, parambbwq.c, parambbwq.d, parambbwq.e);
      return i;
    }
    catch (UnsatisfiedLinkError parambbwq) {}
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
  
  public static bbwq a(String paramString1, String paramString2, int paramInt)
  {
    bbwq localbbwq = new bbwq();
    localbbwq.jdField_a_of_type_JavaLangString = paramString1;
    localbbwq.jdField_b_of_type_JavaLangString = paramString2;
    localbbwq.jdField_a_of_type_Int = paramInt;
    localbbwq.d = CodecParam.mAudioSampleRate;
    localbbwq.c = CodecParam.mDstAudioEncBitrate;
    if (CodecParam.mAudioFormat == 2) {}
    for (localbbwq.jdField_b_of_type_Int = 16; CodecParam.mAudioChannel == 16; localbbwq.jdField_b_of_type_Int = 8)
    {
      localbbwq.e = 1;
      return localbbwq;
    }
    localbbwq.e = 2;
    return localbbwq;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */