package com.tencent.tbs.log;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class TBSLog$TBSLogger
  implements Logger
{
  private String mTagName = getClass().getName();
  
  private TBSLog$TBSLogger() {}
  
  private TBSLog$TBSLogger(String paramString)
  {
    this.mTagName = paramString;
  }
  
  private String format(String paramString, Object... paramVarArgs)
  {
    String str = formatMessage(paramString, paramVarArgs);
    Throwable localThrowable = getThrowableToLog(paramVarArgs);
    paramString = "";
    paramVarArgs = paramString;
    if (str != null)
    {
      if (str.length() == 0) {
        return "";
      }
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(str);
      if (localThrowable != null)
      {
        paramString = new StringBuilder();
        paramString.append("\n");
        paramString.append(Formatter.formatThrowable(localThrowable));
        paramString = paramString.toString();
      }
      paramVarArgs.append(paramString);
      paramVarArgs = paramVarArgs.toString();
    }
    return paramVarArgs;
  }
  
  private String formatMessage(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      try
      {
        paramVarArgs = String.format(Locale.US, paramString, paramVarArgs);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
    return paramString;
  }
  
  private Throwable getThrowableToLog(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return null;
      }
      paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
      if (!(paramArrayOfObject instanceof Throwable)) {
        return null;
      }
      return (Throwable)paramArrayOfObject;
    }
    return null;
  }
  
  private void printlnInternal(LogLevel paramLogLevel, String paramString1, String paramString2)
  {
    try
    {
      if (!TBSLog.access$300()) {
        return;
      }
      if (paramLogLevel.getValue() < TBSLog.access$400().getValue()) {
        return;
      }
      paramLogLevel = new LogItem(System.currentTimeMillis(), paramLogLevel, paramString1, paramString2);
      if (TBSLog.access$500())
      {
        paramString1 = TBSLog.access$600().iterator();
        while (paramString1.hasNext()) {
          ((LogPrinter)paramString1.next()).println(paramLogLevel);
        }
      }
      return;
    }
    catch (Exception paramLogLevel)
    {
      paramLogLevel.printStackTrace();
    }
  }
  
  private void setTagName(String paramString)
  {
    this.mTagName = paramString;
  }
  
  public void d(String paramString)
  {
    printlnInternal(LogLevel.DEBUG, this.mTagName, paramString);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    printlnInternal(LogLevel.DEBUG, this.mTagName, format(paramString, paramVarArgs));
  }
  
  public void e(String paramString)
  {
    printlnInternal(LogLevel.ERROR, this.mTagName, paramString);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    printlnInternal(LogLevel.ERROR, this.mTagName, format(paramString, paramVarArgs));
  }
  
  public void i(String paramString)
  {
    printlnInternal(LogLevel.INFO, this.mTagName, paramString);
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    printlnInternal(LogLevel.INFO, this.mTagName, format(paramString, paramVarArgs));
  }
  
  public void log(int paramInt, String paramString)
  {
    printlnInternal(LogLevel.valueOf(paramInt), this.mTagName, paramString);
  }
  
  public void log(int paramInt, String paramString, Object... paramVarArgs)
  {
    printlnInternal(LogLevel.valueOf(paramInt), this.mTagName, format(paramString, paramVarArgs));
  }
  
  public void v(String paramString)
  {
    printlnInternal(LogLevel.VERBOSE, this.mTagName, paramString);
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    printlnInternal(LogLevel.VERBOSE, this.mTagName, format(paramString, paramVarArgs));
  }
  
  public void w(String paramString)
  {
    printlnInternal(LogLevel.WARN, this.mTagName, paramString);
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    printlnInternal(LogLevel.WARN, this.mTagName, format(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.TBSLog.TBSLogger
 * JD-Core Version:    0.7.0.1
 */