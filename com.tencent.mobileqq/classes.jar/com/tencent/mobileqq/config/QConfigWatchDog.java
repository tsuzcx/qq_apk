package com.tencent.mobileqq.config;

import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QConfigWatchDog
{
  public static QConfigWatchDog a()
  {
    return QConfigWatchDog.Holder.a;
  }
  
  private static void a(Exception paramException, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" Message: ");
    localStringBuilder.append(paramException.getMessage());
    CaughtExceptionReportProxy.e(new QConfigureException(paramException, localStringBuilder.toString()), paramString1);
  }
  
  private void b(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, int paramInt, Exception paramException) {}
  
  private void b(IQStorageIOProcessor paramIQStorageIOProcessor, File paramFile, Exception paramException) {}
  
  private void b(Class paramClass, Exception paramException) {}
  
  public void a(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, int paramInt, Exception paramException)
  {
    int i = paramIQConfigProcessor.type();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleParsedJsonOrXmlException, parsed type=");
      localStringBuilder.append(i);
      localStringBuilder.append(", version=");
      localStringBuilder.append(paramInt);
      QLog.d("QConfigWatchDog", 2, localStringBuilder.toString(), paramException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parsed config failed, type=");
    localStringBuilder.append(i);
    localStringBuilder.append(", version=");
    localStringBuilder.append(paramInt);
    a(paramException, localStringBuilder.toString(), "QConfigWatchDog_parsedConfig");
    b(paramIQConfigProcessor, paramArrayOfQConfItem, paramInt, paramException);
  }
  
  public void a(IQStorageIOProcessor paramIQStorageIOProcessor, File paramFile, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedIOException", paramException);
    }
    a(paramException, "write\\read IO failed", "QConfigWatchDog_parsedIO");
    b(paramIQStorageIOProcessor, paramFile, paramException);
  }
  
  public void a(Class paramClass, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException", paramException);
    }
    a(paramException, "parsed json\\Xml failed", "QConfigWatchDog_parsedIO");
    b(paramClass, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigWatchDog
 * JD-Core Version:    0.7.0.1
 */