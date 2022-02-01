package com.tencent.mobileqq.search.base.util;

import java.util.HashMap;
import java.util.Map;

public class SearchStatisticsConstants
{
  private static int jdField_a_of_type_Int = 0;
  private static String jdField_a_of_type_JavaLangString = "";
  private static Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
    default: 
      break;
    }
    try
    {
      jdField_a_of_type_Int += 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Integer.valueOf(jdField_a_of_type_Int));
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.SearchStatisticsConstants
 * JD-Core Version:    0.7.0.1
 */