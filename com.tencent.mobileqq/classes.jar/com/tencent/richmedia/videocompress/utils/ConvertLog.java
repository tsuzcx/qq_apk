package com.tencent.richmedia.videocompress.utils;

public class ConvertLog
{
  public static final int CLR = 2;
  private static int LOG_LEVEL = 2;
  public static final int USR = 1;
  private static Logger logger = new ConvertLog.DefaultLogger(null);
  
  public static void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (LOG_LEVEL >= paramInt)
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
      logger.d(paramString, localStringBuilder.toString());
    }
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (LOG_LEVEL >= paramInt)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable == null)
      {
        logger.e(paramString1, str);
        return;
      }
      logger.e(paramString1, str, paramThrowable);
    }
  }
  
  public static void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
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
    e(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    e(paramString, paramInt, null, (Object[])paramVarArgs);
  }
  
  public static void i(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (LOG_LEVEL >= paramInt)
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
      logger.i(paramString, localStringBuilder.toString());
    }
  }
  
  public static boolean isColorLevel()
  {
    return LOG_LEVEL > 1;
  }
  
  public static void setLogLevel(int paramInt)
  {
    int i = 2;
    if (paramInt >= 2) {
      paramInt = i;
    } else {
      paramInt = 1;
    }
    LOG_LEVEL = paramInt;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    if (paramLogger != null) {
      logger = paramLogger;
    }
  }
  
  public static void w(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (LOG_LEVEL >= paramInt)
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
      logger.w(paramString, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.utils.ConvertLog
 * JD-Core Version:    0.7.0.1
 */