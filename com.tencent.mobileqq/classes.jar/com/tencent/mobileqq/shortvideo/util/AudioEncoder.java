package com.tencent.mobileqq.shortvideo.util;

import awje;
import awkz;
import java.io.File;

public class AudioEncoder
{
  public static int a(awkz paramawkz)
  {
    try
    {
      int i = encode(paramawkz.jdField_a_of_type_JavaLangString, paramawkz.jdField_b_of_type_JavaLangString, paramawkz.jdField_a_of_type_Int, paramawkz.jdField_b_of_type_Int, paramawkz.c, paramawkz.d, paramawkz.e);
      return i;
    }
    catch (UnsatisfiedLinkError paramawkz) {}
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
  
  public static awkz a(String paramString1, String paramString2, int paramInt)
  {
    awkz localawkz = new awkz();
    localawkz.jdField_a_of_type_JavaLangString = paramString1;
    localawkz.jdField_b_of_type_JavaLangString = paramString2;
    localawkz.jdField_a_of_type_Int = paramInt;
    localawkz.d = awje.q;
    localawkz.c = awje.n;
    if (awje.p == 2) {}
    for (localawkz.jdField_b_of_type_Int = 16; awje.o == 16; localawkz.jdField_b_of_type_Int = 8)
    {
      localawkz.e = 1;
      return localawkz;
    }
    localawkz.e = 2;
    return localawkz;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */