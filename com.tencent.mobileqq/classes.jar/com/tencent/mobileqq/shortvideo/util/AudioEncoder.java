package com.tencent.mobileqq.shortvideo.util;

import azib;
import azjw;
import java.io.File;

public class AudioEncoder
{
  public static int a(azjw paramazjw)
  {
    try
    {
      int i = encode(paramazjw.jdField_a_of_type_JavaLangString, paramazjw.jdField_b_of_type_JavaLangString, paramazjw.jdField_a_of_type_Int, paramazjw.jdField_b_of_type_Int, paramazjw.c, paramazjw.d, paramazjw.e);
      return i;
    }
    catch (UnsatisfiedLinkError paramazjw) {}
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
  
  public static azjw a(String paramString1, String paramString2, int paramInt)
  {
    azjw localazjw = new azjw();
    localazjw.jdField_a_of_type_JavaLangString = paramString1;
    localazjw.jdField_b_of_type_JavaLangString = paramString2;
    localazjw.jdField_a_of_type_Int = paramInt;
    localazjw.d = azib.q;
    localazjw.c = azib.n;
    if (azib.p == 2) {}
    for (localazjw.jdField_b_of_type_Int = 16; azib.o == 16; localazjw.jdField_b_of_type_Int = 8)
    {
      localazjw.e = 1;
      return localazjw;
    }
    localazjw.e = 2;
    return localazjw;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */