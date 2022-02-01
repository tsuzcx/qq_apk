package com.tencent.mobileqq.service.message.remote;

public class MessageRecordInfo
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 32769: 
    case 32771: 
    default: 
      return "Default";
    case 32772: 
      return "Sending";
    case 32770: 
      return "Success";
    }
    return "Fail";
  }
  
  public static boolean a(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.remote.MessageRecordInfo
 * JD-Core Version:    0.7.0.1
 */