package com.tencent.tbs.log;

import android.os.Process;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatter
{
  private static final DateFormat sLogDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
  
  public static String formatLog(LogItem paramLogItem)
  {
    if (paramLogItem == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(sLogDateFormat.format(new Date(paramLogItem.timeMillis)));
    localStringBuilder.append(" ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("-");
    localStringBuilder.append(Process.myTid());
    localStringBuilder.append(" ");
    localStringBuilder.append(LogLevel.getShortName(paramLogItem.level));
    localStringBuilder.append("/");
    localStringBuilder.append(paramLogItem.tag);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramLogItem.msg);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
  
  public static String formatThrowable(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.log.Formatter
 * JD-Core Version:    0.7.0.1
 */