package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class CrashVersionUtils
{
  public static void a()
  {
    QLog.e("LiteMonitorTag", 1, "initLiveSDK: setCrashVersion executeOnFileThread");
    ThreadManager.executeOnFileThread(new CrashVersionUtils.1());
    QLog.e("LiteMonitorTag", 1, "initLiveSDK: setCrashVersion executeOnFileThread end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash.CrashVersionUtils
 * JD-Core Version:    0.7.0.1
 */