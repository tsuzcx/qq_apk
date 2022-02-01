package com.tencent.qqmini.miniapp.util.logmonitor;

import android.support.annotation.CheckResult;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogCatCmd
{
  private static final List<String> DEFAULT_COMMAND = new ArrayList();
  private static LogCatCmd mInstance = null;
  private List<String> commandLine = new ArrayList(DEFAULT_COMMAND);
  
  static
  {
    DEFAULT_COMMAND.add("logcat");
  }
  
  public static LogCatCmd getInstance()
  {
    if (mInstance == null) {
      mInstance = new LogCatCmd();
    }
    return mInstance;
  }
  
  @CheckResult
  public LogCatCmd clear()
  {
    this.commandLine.add("-c");
    return this;
  }
  
  public Process commit()
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec((String[])this.commandLine.toArray(new String[this.commandLine.size()]));
      return localProcess;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    finally
    {
      this.commandLine = new ArrayList(DEFAULT_COMMAND);
    }
  }
  
  @CheckResult
  public LogCatCmd filter(@NonNull String paramString)
  {
    return filter(paramString, "V");
  }
  
  @CheckResult
  public LogCatCmd filter(@Nullable String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.commandLine.add(paramString1.trim() + ":" + paramString2);
      this.commandLine.add("*:S");
      return this;
    }
    this.commandLine.add("*:" + paramString2);
    return this;
  }
  
  public LogCatCmd options(String paramString)
  {
    this.commandLine.add(paramString);
    return this;
  }
  
  public LogCatCmd recentLines(@IntRange(from=0L) int paramInt)
  {
    this.commandLine.add("-t");
    this.commandLine.add(String.valueOf(paramInt));
    return this;
  }
  
  @CheckResult
  public LogCatCmd withTime()
  {
    this.commandLine.add("-v");
    this.commandLine.add("time");
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogCatCmd
 * JD-Core Version:    0.7.0.1
 */