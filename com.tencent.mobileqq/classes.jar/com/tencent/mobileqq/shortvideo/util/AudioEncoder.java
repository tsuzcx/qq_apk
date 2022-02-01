package com.tencent.mobileqq.shortvideo.util;

import bcjb;
import bckv;
import java.io.File;

public class AudioEncoder
{
  public static int a(bckv parambckv)
  {
    try
    {
      int i = encode(parambckv.jdField_a_of_type_JavaLangString, parambckv.jdField_b_of_type_JavaLangString, parambckv.jdField_a_of_type_Int, parambckv.jdField_b_of_type_Int, parambckv.c, parambckv.d, parambckv.e);
      return i;
    }
    catch (UnsatisfiedLinkError parambckv) {}
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
  
  public static bckv a(String paramString1, String paramString2, int paramInt)
  {
    bckv localbckv = new bckv();
    localbckv.jdField_a_of_type_JavaLangString = paramString1;
    localbckv.jdField_b_of_type_JavaLangString = paramString2;
    localbckv.jdField_a_of_type_Int = paramInt;
    localbckv.d = bcjb.q;
    localbckv.c = bcjb.n;
    if (bcjb.p == 2) {}
    for (localbckv.jdField_b_of_type_Int = 16; bcjb.o == 16; localbckv.jdField_b_of_type_Int = 8)
    {
      localbckv.e = 1;
      return localbckv;
    }
    localbckv.e = 2;
    return localbckv;
  }
  
  private static native int encode(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioEncoder
 * JD-Core Version:    0.7.0.1
 */