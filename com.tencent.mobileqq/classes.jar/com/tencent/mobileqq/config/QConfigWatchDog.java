package com.tencent.mobileqq.config;

import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class QConfigWatchDog
{
  private QConfigWatchDog.JSONConstructorHook jdField_a_of_type_ComTencentMobileqqConfigQConfigWatchDog$JSONConstructorHook = new QConfigWatchDog.JSONConstructorHook(null);
  private QConfigWatchDog.ThreadSwitchHook jdField_a_of_type_ComTencentMobileqqConfigQConfigWatchDog$ThreadSwitchHook = new QConfigWatchDog.ThreadSwitchHook(null);
  private QConfigWatchDog.XmlPullHook jdField_a_of_type_ComTencentMobileqqConfigQConfigWatchDog$XmlPullHook = new QConfigWatchDog.XmlPullHook(null);
  private Member jdField_a_of_type_JavaLangReflectMember = null;
  private List<Member> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static QConfigWatchDog a()
  {
    return QConfigWatchDog.Holder.a;
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("-----------------------------------------------\n");
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfStackTraceElement[i].toString();
        if ((!str.contains("com.tencent.mobileqq.config.QConfigWatchDog")) && (!str.contains("com.qq.android.dexposed.DexposedBridge")) && (!str.contains("me.weishu.epic.art")) && (!str.contains("java.lang.reflect.Method.invoke")) && (!str.contains("dalvik.system.VMStack.getThreadStackTrace")) && (!str.contains("java.lang.Thread.getStackTrace")) && (!str.contains("org.json.JSONTokener")) && (!str.contains("org.json.JSONObject.<init>")))
        {
          localStringBuilder.append(str);
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private void b(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, int paramInt, Exception paramException) {}
  
  private void b(IQStorageIOProcessor paramIQStorageIOProcessor, File paramFile, Exception paramException) {}
  
  private void b(Class paramClass, Exception paramException) {}
  
  private static void b(Exception paramException, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" Message: ");
    localStringBuilder.append(paramException.getMessage());
    CaughtExceptionReportProxy.e(new QConfigureException(paramException, localStringBuilder.toString()), paramString1);
  }
  
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
    b(paramException, localStringBuilder.toString(), "QConfigWatchDog_parsedConfig");
    b(paramIQConfigProcessor, paramArrayOfQConfItem, paramInt, paramException);
  }
  
  public void a(IQStorageIOProcessor paramIQStorageIOProcessor, File paramFile, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedIOException", paramException);
    }
    b(paramException, "write\\read IO failed", "QConfigWatchDog_parsedIO");
    b(paramIQStorageIOProcessor, paramFile, paramException);
  }
  
  public void a(Class paramClass, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException", paramException);
    }
    b(paramException, "parsed json\\Xml failed", "QConfigWatchDog_parsedIO");
    b(paramClass, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigWatchDog
 * JD-Core Version:    0.7.0.1
 */