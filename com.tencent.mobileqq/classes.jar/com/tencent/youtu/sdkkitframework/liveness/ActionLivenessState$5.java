package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener;

class ActionLivenessState$5
  implements YTPoseDetectJNIInterface.IYtLoggerListener
{
  ActionLivenessState$5(ActionLivenessState paramActionLivenessState) {}
  
  public void log(String paramString1, String paramString2)
  {
    YtLogger.d(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.5
 * JD-Core Version:    0.7.0.1
 */