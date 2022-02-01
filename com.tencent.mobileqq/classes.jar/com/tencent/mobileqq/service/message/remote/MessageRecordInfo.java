package com.tencent.mobileqq.service.message.remote;

public class MessageRecordInfo
{
  public static String a(int paramInt)
  {
    if (paramInt != 32768)
    {
      if (paramInt != 32770)
      {
        if (paramInt != 32772) {
          return "Default";
        }
        return "Sending";
      }
      return "Success";
    }
    return "Fail";
  }
  
  public static boolean a(int paramInt)
  {
    if (1 != paramInt) {
      return 2 == paramInt;
    }
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    return 1 == paramInt;
  }
  
  public static boolean c(int paramInt)
  {
    return 2 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.remote.MessageRecordInfo
 * JD-Core Version:    0.7.0.1
 */