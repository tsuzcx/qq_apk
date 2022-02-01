package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface.IYtLoggerListener;

class ReflectLivenessState$7
  implements YTAGReflectLiveCheckJNIInterface.IYtLoggerListener
{
  ReflectLivenessState$7(ReflectLivenessState paramReflectLivenessState) {}
  
  public void log(String paramString1, String paramString2)
  {
    YtLogger.d(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.7
 * JD-Core Version:    0.7.0.1
 */