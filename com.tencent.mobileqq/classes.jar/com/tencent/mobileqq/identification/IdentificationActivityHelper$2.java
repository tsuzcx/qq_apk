package com.tencent.mobileqq.identification;

import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtLogger.IYtLoggerListener;

class IdentificationActivityHelper$2
  implements YtLogger.IYtLoggerListener
{
  IdentificationActivityHelper$2(IdentificationActivityHelper paramIdentificationActivityHelper) {}
  
  public void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("youtu.log_");
      localStringBuilder.append(paramString1);
      QLog.d(localStringBuilder.toString(), 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationActivityHelper.2
 * JD-Core Version:    0.7.0.1
 */