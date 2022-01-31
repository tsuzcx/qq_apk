package com.tencent.mobileqq.shortvideo.util;

import axim;
import axkh;
import java.io.File;

public class AudioEncoder
{
  public static int a(axkh paramaxkh)
  {
    try
    {
      int i = encode(paramaxkh.jdField_a_of_type_JavaLangString, paramaxkh.jdField_b_of_type_JavaLangString, paramaxkh.jdField_a_of_type_Int, paramaxkh.jdField_b_of_type_Int, paramaxkh.c, paramaxkh.d, paramaxkh.e);
      return i;
    }
    catch (UnsatisfiedLinkError paramaxkh) {}
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
  
  public static axkh a(String paramString1, String paramString2, int paramInt)
  {
    axkh localaxkh = new axkh();
    localaxkh.jdField_a_of_type_JavaLangString = paramString1;
    localaxkh.jdField_b_of_type_JavaLangString = paramString2;
    localaxkh.jdField_a_of_type_Int = paramInt;
    localaxkh.d = axim.q;
    localaxkh.c = axim.n;
    if (axim.p == 2) {}
    for (localaxkh.jdField_b_of_type_Int = 16; axim.o == 16; localaxkh.jdField_b_of_type_Int = 8)
    {
      localaxkh.e = 1;
      return localaxkh;
    }
    localaxkh.e = 2;
    return localaxkh;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */