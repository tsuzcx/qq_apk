package com.tencent.mobileqq.videoplatform;

public class SDKState
{
  public static final int STATE_INITED_DONE = 2;
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
    }
    return "STATE_INITED_DONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.SDKState
 * JD-Core Version:    0.7.0.1
 */