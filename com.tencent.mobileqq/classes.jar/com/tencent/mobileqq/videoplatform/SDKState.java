package com.tencent.mobileqq.videoplatform;

public class SDKState
{
  public static final int STATE_INITED_DONE = 2;
  public static final int STATE_INITING = 1;
  public static final int STATE_NEVER_INITED = 0;
  
  public static String getStateStr(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "STATE_UNKNOW";
        }
        return "STATE_INITED_DONE";
      }
      return "STATE_INITING";
    }
    return "STATE_NEVER_INITED";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.SDKState
 * JD-Core Version:    0.7.0.1
 */