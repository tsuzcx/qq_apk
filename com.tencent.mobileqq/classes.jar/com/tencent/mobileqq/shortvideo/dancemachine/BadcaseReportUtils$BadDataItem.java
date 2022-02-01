package com.tencent.mobileqq.shortvideo.dancemachine;

public class BadcaseReportUtils$BadDataItem
{
  public static final int MATCH_PROBLEM = 3;
  public static final int MODEL_PROBLEM = 2;
  public static final int USER_PROBLEM = 1;
  public String boyID;
  public int mIndex;
  public int problemKind;
  
  public BadcaseReportUtils$BadDataItem(int paramInt1, String paramString, int paramInt2)
  {
    this.problemKind = paramInt1;
    this.boyID = paramString;
    this.mIndex = paramInt2;
  }
  
  public static String getErrMsg(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataItem
 * JD-Core Version:    0.7.0.1
 */