package com.tencent.mobileqq.shortvideo.util;

import bddl;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import java.io.File;

public class AudioEncoder
{
  public static int a(bddl parambddl)
  {
    try
    {
      int i = encode(parambddl.jdField_a_of_type_JavaLangString, parambddl.jdField_b_of_type_JavaLangString, parambddl.jdField_a_of_type_Int, parambddl.jdField_b_of_type_Int, parambddl.c, parambddl.d, parambddl.e);
      return i;
    }
    catch (UnsatisfiedLinkError parambddl) {}
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
  
  public static bddl a(String paramString1, String paramString2, int paramInt)
  {
    bddl localbddl = new bddl();
    localbddl.jdField_a_of_type_JavaLangString = paramString1;
    localbddl.jdField_b_of_type_JavaLangString = paramString2;
    localbddl.jdField_a_of_type_Int = paramInt;
    localbddl.d = CodecParam.mAudioSampleRate;
    localbddl.c = CodecParam.mDstAudioEncBitrate;
    if (CodecParam.mAudioFormat == 2) {}
    for (localbddl.jdField_b_of_type_Int = 16; CodecParam.mAudioChannel == 16; localbddl.jdField_b_of_type_Int = 8)
    {
      localbddl.e = 1;
      return localbddl;
    }
    localbddl.e = 2;
    return localbddl;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */