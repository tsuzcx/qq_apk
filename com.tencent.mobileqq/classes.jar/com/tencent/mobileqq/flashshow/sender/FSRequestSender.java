package com.tencent.mobileqq.flashshow.sender;

import com.tencent.mobileqq.flashshow.data.call.FSRequestCall;

public class FSRequestSender
{
  private static volatile FSRequestSender a;
  
  public static FSRequestSender a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSRequestSender();
        }
      }
      finally {}
    }
    return a;
  }
  
  public FSRequestCall b()
  {
    return new FSRequestCall();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.sender.FSRequestSender
 * JD-Core Version:    0.7.0.1
 */