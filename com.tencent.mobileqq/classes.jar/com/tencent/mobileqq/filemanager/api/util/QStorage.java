package com.tencent.mobileqq.filemanager.api.util;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QStorage
{
  public static <T extends IQStorageSafable<Y>, Y> T a(Y paramY, Class<T> paramClass)
  {
    paramClass = (IQStorageSafable)QConfigManager.a(paramClass);
    try
    {
      paramClass.a(paramY);
      return paramClass;
    }
    catch (Exception paramY)
    {
      QLog.e("QStorage-File", 1, "error :" + paramY.getMessage());
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.util.QStorage
 * JD-Core Version:    0.7.0.1
 */