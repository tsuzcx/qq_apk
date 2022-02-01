package com.tencent.mobileqq.shortvideo.util;

import bdbt;
import bddn;
import java.io.File;

public class AudioEncoder
{
  public static int a(bddn parambddn)
  {
    try
    {
      int i = encode(parambddn.jdField_a_of_type_JavaLangString, parambddn.jdField_b_of_type_JavaLangString, parambddn.jdField_a_of_type_Int, parambddn.jdField_b_of_type_Int, parambddn.c, parambddn.d, parambddn.e);
      return i;
    }
    catch (UnsatisfiedLinkError parambddn) {}
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
  
  public static bddn a(String paramString1, String paramString2, int paramInt)
  {
    bddn localbddn = new bddn();
    localbddn.jdField_a_of_type_JavaLangString = paramString1;
    localbddn.jdField_b_of_type_JavaLangString = paramString2;
    localbddn.jdField_a_of_type_Int = paramInt;
    localbddn.d = bdbt.q;
    localbddn.c = bdbt.n;
    if (bdbt.p == 2) {}
    for (localbddn.jdField_b_of_type_Int = 16; bdbt.o == 16; localbddn.jdField_b_of_type_Int = 8)
    {
      localbddn.e = 1;
      return localbddn;
    }
    localbddn.e = 2;
    return localbddn;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */