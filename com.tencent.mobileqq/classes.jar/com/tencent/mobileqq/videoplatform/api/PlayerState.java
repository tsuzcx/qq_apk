package com.tencent.mobileqq.videoplatform.api;

public class PlayerState
{
  public static final int STATE_BUFFERING = 5;
  public static final int STATE_COMPLETE = 8;
  public static final int STATE_ERROR = 7;
  public static final int STATE_IDLE = 0;
  public static final int STATE_PAUSE = 6;
  public static final int STATE_PLAYING = 4;
  public static final int STATE_PREPARING = 3;
  public static final int STATE_RELEASED = 9;
  public static final int STATE_SDK_INITED = 2;
  public static final int STATE_SDK_INITING = 1;
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "STATE_UNKNOW";
    case 0: 
      return "STATE_IDLE";
    case 1: 
      return "STATE_SDK_INITING";
    case 2: 
      return "STATE_SDK_INITED";
    case 3: 
      return "STATE_PREPARING";
    case 4: 
      return "STATE_PLAYING";
    case 5: 
      return "STATE_BUFFERING";
    case 6: 
      return "STATE_PAUSE";
    case 7: 
      return "STATE_ERROR";
    case 8: 
      return "STATE_COMPLETE";
    }
    return "STATE_RELEASED";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.PlayerState
 * JD-Core Version:    0.7.0.1
 */