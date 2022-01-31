package com.tencent.mobileqq.shortvideo.util;

import azds;
import azfn;
import java.io.File;

public class AudioEncoder
{
  public static int a(azfn paramazfn)
  {
    try
    {
      int i = encode(paramazfn.jdField_a_of_type_JavaLangString, paramazfn.jdField_b_of_type_JavaLangString, paramazfn.jdField_a_of_type_Int, paramazfn.jdField_b_of_type_Int, paramazfn.c, paramazfn.d, paramazfn.e);
      return i;
    }
    catch (UnsatisfiedLinkError paramazfn) {}
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
  
  public static azfn a(String paramString1, String paramString2, int paramInt)
  {
    azfn localazfn = new azfn();
    localazfn.jdField_a_of_type_JavaLangString = paramString1;
    localazfn.jdField_b_of_type_JavaLangString = paramString2;
    localazfn.jdField_a_of_type_Int = paramInt;
    localazfn.d = azds.q;
    localazfn.c = azds.n;
    if (azds.p == 2) {}
    for (localazfn.jdField_b_of_type_Int = 16; azds.o == 16; localazfn.jdField_b_of_type_Int = 8)
    {
      localazfn.e = 1;
      return localazfn;
    }
    localazfn.e = 2;
    return localazfn;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */