package com.tencent.superplayer.utils;

import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public class HDRUtil
{
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static String a()
  {
    try
    {
      if (jdField_a_of_type_Boolean) {
        break label113;
      }
      jdField_a_of_type_Boolean = true;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int i;
        label113:
        String str;
        for (;;)
        {
          throw localObject;
        }
        i += 1;
      }
    }
    if (i <= 3)
    {
      if (TPThumbplayerCapabilityHelper.isHDRsupport(i, 0, 0))
      {
        jdField_a_of_type_JavaLangStringBuilder.append(i);
        jdField_a_of_type_JavaLangStringBuilder.append(",");
      }
    }
    else
    {
      if ((jdField_a_of_type_JavaLangStringBuilder.length() > 0) && (jdField_a_of_type_JavaLangStringBuilder.lastIndexOf(",") == jdField_a_of_type_JavaLangStringBuilder.length() - 1)) {
        jdField_a_of_type_JavaLangStringBuilder.deleteCharAt(jdField_a_of_type_JavaLangStringBuilder.length() - 1);
      } else if (jdField_a_of_type_JavaLangStringBuilder.length() == 0) {
        jdField_a_of_type_JavaLangStringBuilder.append("notSupport");
      }
      str = jdField_a_of_type_JavaLangStringBuilder.toString();
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.utils.HDRUtil
 * JD-Core Version:    0.7.0.1
 */