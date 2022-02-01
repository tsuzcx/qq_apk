package com.tencent.mobileqq.dinifly.utils;

import android.util.Log;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger
  implements LottieLogger
{
  private static final Set<String> loggedMessages = new HashSet();
  
  public void debug(String paramString)
  {
    debug(paramString, null);
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    if (L.DBG) {
      Log.d("LOTTIE", paramString, paramThrowable);
    }
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    if (L.DBG) {
      Log.d("LOTTIE", paramString, paramThrowable);
    }
  }
  
  public void warning(String paramString)
  {
    warning(paramString, null);
  }
  
  public void warning(String paramString, Throwable paramThrowable)
  {
    if (loggedMessages.contains(paramString)) {
      return;
    }
    Log.w("LOTTIE", paramString, paramThrowable);
    loggedMessages.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.LogcatLogger
 * JD-Core Version:    0.7.0.1
 */