package com.tencent.youtu.ytcommon.auth;

import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.TimerTask;

final class YTAuthJNIInterface$2
  extends TimerTask
{
  public void run()
  {
    YTLogger.d("log_print_java", "flush in java ");
    YTAuthJNIInterface.access$100();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.2
 * JD-Core Version:    0.7.0.1
 */