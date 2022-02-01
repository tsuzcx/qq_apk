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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("disconnect error:");
      localStringBuilder.append(localThrowable.getMessage());
      SonicUtils.log("SonicSdk_SonicSessionConnection", 6, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl.2
 * JD-Core Version:    0.7.0.1
 */