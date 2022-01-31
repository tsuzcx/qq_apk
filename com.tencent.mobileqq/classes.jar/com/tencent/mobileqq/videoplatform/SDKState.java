package com.tencent.mobileqq.videoplatform;

public class SDKState
{
  public static final int STATE_INITED_ERR = 3;
  public static final int STATE_INITED_SUC = 2;
  public static final int STATE_INITING = 1;
  public static final int STATE_NEVER_INITED = 0;
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "STATE_UNKNOW";
    case 0: 
      return "STATE_NEVER_INITED";
    case 1: 
      return "STATE_INITING";
    case 2: 
      return "STATE_INITED_SUC";
    }
    return "STATE_INITED_ERR";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.SDKState
 * JD-Core Version:    0.7.0.1
 */