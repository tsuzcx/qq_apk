package com.tencent.mobileqq.weiyun.sdk.download.processor;

import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;

public class WeiyunNetEngine
{
  private static IHttpEngineService a;
  private static IHttpEngineService b;
  
  public static IHttpEngineService a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          HttpCommunicator localHttpCommunicator = new HttpCommunicator(128);
          localHttpCommunicator.start();
          a = new HttpEngineServiceImpl(localHttpCommunicator, true);
        }
      }
      finally {}
    }
    return a;
  }
  
  public static IHttpEngineService b()
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          HttpCommunicator localHttpCommunicator = new HttpCommunicator(128);
          localHttpCommunicator.start();
          b = new HttpEngineServiceImpl(localHttpCommunicator, true);
        }
      }
      finally {}
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.WeiyunNetEngine
 * JD-Core Version:    0.7.0.1
 */