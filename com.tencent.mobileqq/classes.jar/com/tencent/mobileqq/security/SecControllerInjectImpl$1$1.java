package com.tencent.mobileqq.security;

import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;

class SecControllerInjectImpl$1$1
  implements Runnable
{
  SecControllerInjectImpl$1$1(SecControllerInjectImpl.1 param1) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1500L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).exitApp(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.security.SecControllerInjectImpl.1.1
 * JD-Core Version:    0.7.0.1
 */