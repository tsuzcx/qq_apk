package com.tencent.open.base;

import com.tencent.qphone.base.util.QLog;

public class LogUtility
{
  protected static String a = "";
  protected static boolean a = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".*[S|s][I|i][D|d].*");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|.*==.*");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|.*[U|u][I|i][N|n].*");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|.*%3d%3d.*");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|.*[V|v][K|k][E|e][Y|y]");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  protected static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder;
      if (paramInt == 1) {
        if (paramThrowable == null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append("::");
            localStringBuilder.append(paramString2);
            QLog.i(paramString1, 2, localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append("::");
          localStringBuilder.append(paramString2);
          QLog.i(paramString1, 2, localStringBuilder.toString(), paramThrowable);
        }
      }
      if ((paramInt == 2) || (paramInt == 0)) {
        if (paramThrowable == null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append("::");
            localStringBuilder.append(paramString2);
            QLog.d(paramString1, 2, localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append("::");
          localStringBuilder.append(paramString2);
          QLog.d(paramString1, 2, localStringBuilder.toString(), paramThrowable);
        }
      }
      if (paramInt == 3) {
        if (paramThrowable == null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append("::");
            localStringBuilder.append(paramString2);
            QLog.w(paramString1, 2, localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append("::");
          localStringBuilder.append(paramString2);
          QLog.w(paramString1, 2, localStringBuilder.toString(), paramThrowable);
        }
      }
      if (paramInt == 4) {
        if (paramThrowable == null)
        {
          if (QLog.isColorLevel())
          {
            paramThrowable = new StringBuilder();
            paramThrowable.append("");
            paramThrowable.append("::");
            paramThrowable.append(paramString2);
            QLog.e(paramString1, 2, paramThrowable.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append("::");
          localStringBuilder.append(paramString2);
          QLog.e(paramString1, 2, localStringBuilder.toString(), paramThrowable);
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(0, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(1, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.LogUtility
 * JD-Core Version:    0.7.0.1
 */