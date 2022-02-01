package com.tencent.youtu.sdkkitframework.common;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

public class LogWriter
{
  public static final String LOGFILE_TAG_NAME = "logfile";
  public static final String LOG_CONFIGFILE_NAME = "log.properties";
  public static LogWriter logWriter;
  private final String DEFAULT_LOG_FILE_NAME = Environment.getExternalStorageDirectory() + File.separator + "NativeLog" + File.separator + "default.log";
  private String logDirName;
  private String logFileName;
  private PrintWriter writer;
  
  private LogWriter()
  {
    init();
  }
  
  private LogWriter(String paramString1, String paramString2)
  {
    this.logDirName = paramString2;
    this.logFileName = paramString1;
    init();
  }
  
  private String getLogFileNameFromConfigFile()
  {
    try
    {
      Properties localProperties = new Properties();
      InputStream localInputStream = getClass().getResourceAsStream("log.properties");
      if (localInputStream != null)
      {
        localProperties.load(localInputStream);
        localInputStream.close();
        return localProperties.getProperty("logfile");
      }
      System.err.println("无法打开属性配置文件: log.properties");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        System.err.println("无法打开属性配置文件: log.properties");
      }
    }
    return null;
  }
  
  public static LogWriter getLogWriter()
  {
    try
    {
      if (logWriter == null) {
        logWriter = new LogWriter();
      }
      LogWriter localLogWriter = logWriter;
      return localLogWriter;
    }
    finally {}
  }
  
  public static LogWriter getLogWriter(String paramString1, String paramString2)
  {
    try
    {
      if (logWriter == null) {
        logWriter = new LogWriter(paramString1, paramString2);
      }
      paramString1 = logWriter;
      return paramString1;
    }
    finally {}
  }
  
  private void init()
  {
    YtLogger.d("LogWriter", "init()");
    File localFile = new File(this.logDirName);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    if (this.logFileName == null)
    {
      this.logFileName = getLogFileNameFromConfigFile();
      if (this.logFileName == null) {
        this.logFileName = this.DEFAULT_LOG_FILE_NAME;
      }
    }
    YtLogger.d("LogWriter", "logFileName: " + this.logFileName);
    localFile = new File(this.logFileName);
    try
    {
      this.writer = new PrintWriter(new FileWriter(localFile, false), true);
      System.out.println("日志文件的位置：" + localFile.getAbsolutePath());
      return;
    }
    catch (IOException localIOException)
    {
      throw new Exception("无法打开日志文件:" + localFile.getAbsolutePath(), localIOException);
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = getLogWriter("./workspace/temp/logger.log", "./workspace");
      paramArrayOfString.log("First log!");
      paramArrayOfString.log("第二个日志信息");
      paramArrayOfString.log("Third log");
      paramArrayOfString.log("第四个日志信息");
      Object localObject = new StringBuffer();
      int i = 0;
      while (i < 1000000)
      {
        ((StringBuffer)localObject).append("tableaA|device_number|13701010").append(i).append(";\n");
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      long l1 = System.currentTimeMillis();
      paramArrayOfString.log((String)localObject);
      long l2 = System.currentTimeMillis();
      System.out.println("总消耗时间：" + (l2 - l1));
      paramArrayOfString.close();
      return;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
  
  public void close()
  {
    logWriter = null;
    if (this.writer != null) {
      this.writer.close();
    }
  }
  
  public void log(Exception paramException)
  {
    try
    {
      this.writer.println(new Date() + ": ");
      paramException.printStackTrace(this.writer);
      return;
    }
    finally
    {
      paramException = finally;
      throw paramException;
    }
  }
  
  public void log(String paramString)
  {
    try
    {
      this.writer.println(new Date() + ": " + paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.LogWriter
 * JD-Core Version:    0.7.0.1
 */