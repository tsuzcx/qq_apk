package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.TuringFdConfig;
import com.tencent.turingfd.sdk.xq.TuringFdConfig.Builder;
import com.tencent.turingfd.sdk.xq.TuringFdService;

public class TuringSdkInitHelper
{
  private static boolean a = false;
  
  public static void a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (!a) {
      QLog.d("TuringSdkInitHelper", 1, "init TuringSDK");
    }
    try
    {
      TuringFdService.init(TuringFdConfig.newBuilder(localBaseApplication, "").appid("1109803375").build());
      a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TuringSdkInitHelper", 1, localThrowable, new Object[] { "Turing init crash fail" });
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.TuringSdkInitHelper
 * JD-Core Version:    0.7.0.1
 */