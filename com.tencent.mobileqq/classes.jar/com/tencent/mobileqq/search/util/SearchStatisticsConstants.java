package com.tencent.mobileqq.search.util;

import java.util.HashMap;
import java.util.Map;

public class SearchStatisticsConstants
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "";
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_JavaLangString = "";
      jdField_a_of_type_Int = 0;
      jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      try
      {
        jdField_a_of_type_Int += 1;
        jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaLangString + paramInt + "|";
        jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Integer.valueOf(jdField_a_of_type_Int));
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchStatisticsConstants
 * JD-Core Version:    0.7.0.1
 */