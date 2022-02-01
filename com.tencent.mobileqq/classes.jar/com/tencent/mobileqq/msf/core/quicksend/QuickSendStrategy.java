package com.tencent.mobileqq.msf.core.quicksend;

public class QuickSendStrategy
{
  public static final int STRATEGY_COMMON = 0;
  public static final int STRATEGY_MSG = 1;
  
  public static a getStragegyArgs(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return new a(5000L, 60000L, 12, true);
    }
    return new a(5000L, 0L, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy
 * JD-Core Version:    0.7.0.1
 */