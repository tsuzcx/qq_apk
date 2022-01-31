package com.tencent.mobileqq.shortvideo.dancemachine;

public class BadcaseReportUtils$BadDataItem
{
  public int a;
  public String a;
  public int b;
  
  public BadcaseReportUtils$BadDataItem(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnow";
    case 1: 
      return "USER_PROBLEM";
    case 2: 
      return "MODEL_PROBLEM";
    }
    return "MATCH_PROBLEM";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataItem
 * JD-Core Version:    0.7.0.1
 */