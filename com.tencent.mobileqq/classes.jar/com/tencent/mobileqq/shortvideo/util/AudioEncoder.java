package com.tencent.mobileqq.shortvideo.util;

import axik;
import axkf;
import java.io.File;

public class AudioEncoder
{
  public static int a(axkf paramaxkf)
  {
    try
    {
      int i = encode(paramaxkf.jdField_a_of_type_JavaLangString, paramaxkf.jdField_b_of_type_JavaLangString, paramaxkf.jdField_a_of_type_Int, paramaxkf.jdField_b_of_type_Int, paramaxkf.c, paramaxkf.d, paramaxkf.e);
      return i;
    }
    catch (UnsatisfiedLinkError paramaxkf) {}
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
  
  public static axkf a(String paramString1, String paramString2, int paramInt)
  {
    axkf localaxkf = new axkf();
    localaxkf.jdField_a_of_type_JavaLangString = paramString1;
    localaxkf.jdField_b_of_type_JavaLangString = paramString2;
    localaxkf.jdField_a_of_type_Int = paramInt;
    localaxkf.d = axik.q;
    localaxkf.c = axik.n;
    if (axik.p == 2) {}
    for (localaxkf.jdField_b_of_type_Int = 16; axik.o == 16; localaxkf.jdField_b_of_type_Int = 8)
    {
      localaxkf.e = 1;
      return localaxkf;
    }
    localaxkf.e = 2;
    return localaxkf;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */