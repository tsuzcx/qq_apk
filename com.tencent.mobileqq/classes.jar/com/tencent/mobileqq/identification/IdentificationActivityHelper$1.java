package com.tencent.mobileqq.identification;

import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtLogger.IYtLoggerListener;

class IdentificationActivityHelper$1
  implements YtLogger.IYtLoggerListener
{
  IdentificationActivityHelper$1(IdentificationActivityHelper paramIdentificationActivityHelper) {}
  
  public void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("youtu.log_" + paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */