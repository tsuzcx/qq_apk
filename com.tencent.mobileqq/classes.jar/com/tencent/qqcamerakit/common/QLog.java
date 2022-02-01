package com.tencent.qqcamerakit.common;

public class QLog
{
  private static int jdField_a_of_type_Int = 2;
  private static Logger jdField_a_of_type_ComTencentQqcamerakitCommonLogger = new QLog.DefaultLogger(null);
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (jdField_a_of_type_Int >= paramInt)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable == null)
      {
        jdField_a_of_type_ComTencentQqcamerakitCommonLogger.a(paramString1, str);
        return;
      }
      jdField_a_of_type_ComTencentQqcamerakitCommonLogger.a(paramString1, str, paramThrowable);
    }
  }
  
  public static void a(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    if (paramThrowable == null) {
      i = 0;
    } else {
      i = 128;
    }
    StringBuilder localStringBuilder = new StringBuilder(k * 30 + i);
    k = paramVarArgs.length;
    int i = j;
    while (i < k)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject);
      }
      i += 1;
    }
    a(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void a(String paramString, int paramInt, Object... paramVarArgs)
  {
    a(paramString, paramInt, null, (Object[])paramVarArgs);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int > 1;
  }
  
  public static void b(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (jdField_a_of_type_Int >= paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
      int i = paramVarArgs.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = paramVarArgs[paramInt];
        if (localObject != null) {
          localStringBuilder.append(localObject);
        }
        paramInt += 1;
      }
      jdField_a_of_type_ComTencentQqcamerakitCommonLogger.b(paramString, localStringBuilder.toString());
    }
  }
  
  public static void c(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (jdField_a_of_type_Int >= paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
      int i = paramVarArgs.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = paramVarArgs[paramInt];
        if (localObject != null) {
          localStringBuilder.append(localObject);
        }
        paramInt += 1;
      }
      jdField_a_of_type_ComTencentQqcamerakitCommonLogger.c(paramString, localStringBuilder.toString());
    }
  }
  
  public static void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (jdField_a_of_type_Int >= paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
      int i = paramVarArgs.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = paramVarArgs[paramInt];
        if (localObject != null) {
          localStringBuilder.append(localObject);
        }
        paramInt += 1;
      }
      jdField_a_of_type_ComTencentQqcamerakitCommonLogger.d(paramString, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.common.QLog
 * JD-Core Version:    0.7.0.1
 */