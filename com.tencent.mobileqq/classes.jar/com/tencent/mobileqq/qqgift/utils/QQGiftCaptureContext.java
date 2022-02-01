package com.tencent.mobileqq.qqgift.utils;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGiftCaptureContext
{
  public static AppInterface a()
  {
    try
    {
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject instanceof AppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveCaptureContext", 2, "getAppInterface in main process");
        }
        return (AppInterface)localObject;
      }
      localObject = ((AppRuntime)localObject).getAppRuntime("qq_live_tool");
      if ((localObject instanceof AppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveCaptureContext", 2, "getAppInterface in tool process");
        }
        localObject = (AppInterface)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QQLiveCaptureContext", 1, "getAppInterface fail, ", localException);
    }
    return null;
  }
  
  @Nullable
  public static String b()
  {
    if (MobileQQ.sProcessId != 1) {
      return "qq_gift_tool";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftCaptureContext
 * JD-Core Version:    0.7.0.1
 */