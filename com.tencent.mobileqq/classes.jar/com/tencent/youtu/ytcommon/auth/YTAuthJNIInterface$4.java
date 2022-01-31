package com.tencent.youtu.ytcommon.auth;

import java.io.IOException;

final class YTAuthJNIInterface$4
  implements Runnable
{
  YTAuthJNIInterface$4(String paramString) {}
  
  public void run()
  {
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", this.val$data, YTAuthJNIInterface.access$400());
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.4
 * JD-Core Version:    0.7.0.1
 */