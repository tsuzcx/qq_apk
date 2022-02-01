package com.tencent.mobileqq.filemanager.api.util;

import com.tencent.mobileqq.config.QConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class QStorage
{
  public static <T extends IQStorageSafable<Y>, Y> T a(Y paramY, Class<T> paramClass)
  {
    paramClass = (IQStorageSafable)QConfigHelper.a(paramClass);
    try
    {
      paramClass.onParse(paramY);
      return paramClass;
    }
    catch (Exception paramY)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error :");
      localStringBuilder.append(paramY.getMessage());
      QLog.e("QStorage-File", 1, localStringBuilder.toString());
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.util.QStorage
 * JD-Core Version:    0.7.0.1
 */