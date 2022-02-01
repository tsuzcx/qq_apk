package com.tencent.youtu.ytcommon.auth;

import com.tencent.youtu.ytcommon.tools.YTLogger;

final class YTAuthJNIInterface$3
  implements HttpUtil.HttpResponseListener
{
  public void onFail(int paramInt)
  {
    try
    {
      YTLogger.d("log_print_java", "http request error : " + paramInt);
      YTLogger.d("log_print_java", "handle: " + YTAuthJNIInterface.access$200());
      YTAuthJNIInterface.access$300(YTAuthJNIInterface.access$200(), null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onSuccess(String paramString)
  {
    try
    {
      YTLogger.d("log_print_java", "response: " + paramString);
      YTLogger.d("log_print_java", "handle: " + YTAuthJNIInterface.access$200());
      YTAuthJNIInterface.access$300(YTAuthJNIInterface.access$200(), paramString);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.3
 * JD-Core Version:    0.7.0.1
 */