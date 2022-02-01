package com.tencent.qqmini.miniapp.util.logmonitor;

import android.support.annotation.CheckResult;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
  
  /* Error */
  public java.lang.Process commit()
  {
    // Byte code:
    //   0: invokestatic 54	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: aload_0
    //   4: getfield 36	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:commandLine	Ljava/util/List;
    //   7: aload_0
    //   8: getfield 36	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:commandLine	Ljava/util/List;
    //   11: invokeinterface 58 1 0
    //   16: anewarray 60	java/lang/String
    //   19: invokeinterface 64 2 0
    //   24: checkcast 66	[Ljava/lang/String;
    //   27: invokevirtual 70	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   30: astore_1
    //   31: aload_0
    //   32: new 14	java/util/ArrayList
    //   35: dup
    //   36: getstatic 19	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:DEFAULT_COMMAND	Ljava/util/List;
    //   39: invokespecial 34	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   42: putfield 36	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:commandLine	Ljava/util/List;
    //   45: aload_1
    //   46: areturn
    //   47: astore_1
    //   48: goto +24 -> 72
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   56: aload_0
    //   57: new 14	java/util/ArrayList
    //   60: dup
    //   61: getstatic 19	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:DEFAULT_COMMAND	Ljava/util/List;
    //   64: invokespecial 34	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   67: putfield 36	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:commandLine	Ljava/util/List;
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: new 14	java/util/ArrayList
    //   76: dup
    //   77: getstatic 19	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:DEFAULT_COMMAND	Ljava/util/List;
    //   80: invokespecial 34	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   83: putfield 36	com/tencent/qqmini/miniapp/util/logmonitor/LogCatCmd:commandLine	Ljava/util/List;
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	LogCatCmd
    //   30	16	1	localProcess	java.lang.Process
    //   47	1	1	localObject	Object
    //   51	36	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	31	47	finally
    //   52	56	47	finally
    //   0	31	51	java/io/IOException
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
      localObject = this.commandLine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1.trim());
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      ((List)localObject).add(localStringBuilder.toString());
      this.commandLine.add("*:S");
      return this;
    }
    paramString1 = this.commandLine;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("*:");
    ((StringBuilder)localObject).append(paramString2);
    paramString1.add(((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogCatCmd
 * JD-Core Version:    0.7.0.1
 */