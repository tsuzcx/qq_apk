package com.tencent.mobileqq.shortvideo;

public class ShortVideoResourceManager$ConfigSession
{
  volatile int a = 0;
  int b;
  int c = 0;
  int d;
  
  String a()
  {
    switch (this.a)
    {
    default: 
      return "UNKNOWN_STATUS";
    case 0: 
      return "CONFIG_REQUEST_OK";
    case 1: 
      return "CONFIG_START_SERVLET";
    }
    return "CONFIG_SEND_REQ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.ConfigSession
 * JD-Core Version:    0.7.0.1
 */