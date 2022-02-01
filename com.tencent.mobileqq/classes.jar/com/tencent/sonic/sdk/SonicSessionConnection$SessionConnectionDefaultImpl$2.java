package com.tencent.sonic.sdk;

import java.net.HttpURLConnection;

class SonicSessionConnection$SessionConnectionDefaultImpl$2
  implements Runnable
{
  SonicSessionConnection$SessionConnectionDefaultImpl$2(SonicSessionConnection.SessionConnectionDefaultImpl paramSessionConnectionDefaultImpl, HttpURLConnection paramHttpURLConnection) {}
  
  public void run()
  {
    try
    {
      this.val$httpURLConnection.disconnect();
      return;
    }
    catch (Throwable localThrowable)
    {
      SonicUtils.log("SonicSdk_SonicSessionConnection", 6, "disconnect error:" + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl.2
 * JD-Core Version:    0.7.0.1
 */