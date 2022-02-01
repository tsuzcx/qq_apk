package com.tencent.mobileqq.danmaku.util;

import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig.ILogger;

public class Logger
{
  public static final int a;
  private static VideoDanmakuConfig.ILogger jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  static
  {
    int i;
    if (DanmakuDependImp.a().a().a()) {
      i = 4;
    } else {
      i = 3;
    }
    jdField_a_of_type_Int = i;
  }
  
  public static void a(VideoDanmakuConfig.ILogger paramILogger)
  {
    jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger = paramILogger;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Int >= 5)
    {
      VideoDanmakuConfig.ILogger localILogger = jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
      if (localILogger != null) {
        localILogger.a(paramString1, paramString2);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (jdField_a_of_type_Int >= 1)
    {
      VideoDanmakuConfig.ILogger localILogger = jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
      if (localILogger != null) {
        localILogger.a(paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if ((jdField_a_of_type_Int >= 5) && (jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger != null))
    {
      Object localObject = jdField_a_of_type_JavaLangStringBuilder;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        jdField_a_of_type_JavaLangStringBuilder.append(localObject);
        i += 1;
      }
      jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger.a(paramString, jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Int >= 4)
    {
      VideoDanmakuConfig.ILogger localILogger = jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
      if (localILogger != null) {
        localILogger.b(paramString1, paramString2);
      }
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if ((jdField_a_of_type_Int >= 4) && (jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger != null))
    {
      Object localObject = jdField_a_of_type_JavaLangStringBuilder;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        jdField_a_of_type_JavaLangStringBuilder.append(localObject);
        i += 1;
      }
      jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger.b(paramString, jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Int >= 3)
    {
      VideoDanmakuConfig.ILogger localILogger = jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
      if (localILogger != null) {
        localILogger.c(paramString1, paramString2);
      }
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if ((jdField_a_of_type_Int >= 3) && (jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger != null))
    {
      Object localObject = jdField_a_of_type_JavaLangStringBuilder;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        jdField_a_of_type_JavaLangStringBuilder.append(localObject);
        i += 1;
      }
      jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger.c(paramString, jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Int >= 2)
    {
      VideoDanmakuConfig.ILogger localILogger = jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
      if (localILogger != null) {
        localILogger.d(paramString1, paramString2);
      }
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((jdField_a_of_type_Int >= 1) && (jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger != null))
    {
      Object localObject = jdField_a_of_type_JavaLangStringBuilder;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        jdField_a_of_type_JavaLangStringBuilder.append(localObject);
        i += 1;
      }
      jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger.e(paramString, jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Int >= 1)
    {
      VideoDanmakuConfig.ILogger localILogger = jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger;
      if (localILogger != null) {
        localILogger.e(paramString1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.util.Logger
 * JD-Core Version:    0.7.0.1
 */