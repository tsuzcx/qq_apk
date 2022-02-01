package com.tencent.qapmsdk.common.logger;

import android.os.Handler;
import android.util.Log;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;", "Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "()V", "flushing", "", "lastTimeMillis", "", "logFile", "Ljava/io/File;", "logQueueSize", "", "readQueue", "Ljava/util/concurrent/BlockingQueue;", "", "sb", "Ljava/lang/StringBuffer;", "workQueue1", "workQueue2", "writerQueue", "doLog", "", "state", "Lcom/tencent/qapmsdk/common/logger/LogState;", "args", "", "(Lcom/tencent/qapmsdk/common/logger/LogState;[Ljava/lang/String;)V", "flush", "logInfo", "swapQueue", "writeLogFile", "common_release"}, k=1, mv={1, 1, 15})
public final class Logger$DefaultLogProxy
  implements ILogProxy
{
  private volatile boolean flushing;
  private long lastTimeMillis;
  private File logFile;
  private final int logQueueSize = 1024;
  private BlockingQueue<String> readQueue = this.workQueue1;
  private final StringBuffer sb = new StringBuffer(2048);
  private final BlockingQueue<String> workQueue1 = (BlockingQueue)new LinkedBlockingQueue(this.logQueueSize);
  private final BlockingQueue<String> workQueue2 = (BlockingQueue)new LinkedBlockingQueue(this.logQueueSize);
  private BlockingQueue<String> writerQueue = this.workQueue2;
  
  private final void swapQueue()
  {
    try
    {
      if (this.workQueue1 == this.writerQueue)
      {
        this.writerQueue = this.workQueue2;
        this.readQueue = this.workQueue1;
      }
      else
      {
        this.writerQueue = this.workQueue1;
        this.readQueue = this.workQueue2;
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  private final void writeLogFile()
  {
    new Handler(ThreadManager.Companion.getLogThreadLooper()).post((Runnable)new Logger.DefaultLogProxy.writeLogFile.1(this));
  }
  
  public void doLog(@NotNull LogState paramLogState, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramLogState, "state");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (Logger.INSTANCE.getLogLevel().compareTo((Enum)paramLogState) >= 0)
    {
      int i;
      if (paramVarArgs.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      String str = paramVarArgs[0];
      if (str != null)
      {
        if (paramVarArgs.length <= 1) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder(256);
        int j = paramVarArgs.length;
        i = 1;
        while (i < j)
        {
          localStringBuilder.append(paramVarArgs[i]);
          i += 1;
        }
        paramVarArgs = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramVarArgs, "logS.toString()");
        i = Logger.DefaultLogProxy.WhenMappings.$EnumSwitchMapping$0[paramLogState.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5)
                {
                  paramLogState = "";
                }
                else
                {
                  Log.e(str, paramVarArgs);
                  paramLogState = "    ERROR/";
                }
              }
              else
              {
                Log.w(str, paramVarArgs);
                paramLogState = "    WARN/";
              }
            }
            else
            {
              Log.i(str, paramVarArgs);
              paramLogState = "    INFO/";
            }
          }
          else
          {
            Log.d(str, paramVarArgs);
            paramLogState = "    DEBUG/";
          }
        }
        else
        {
          Log.v(str, paramVarArgs);
          paramLogState = "    VERBOS/";
        }
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append(Logger.access$getLogTimeFormatter$p(Logger.INSTANCE).format(Long.valueOf(System.currentTimeMillis())));
        localStringBuilder.append(paramLogState);
        localStringBuilder.append(str);
        localStringBuilder.append(":    ");
        localStringBuilder.append(paramVarArgs);
        try
        {
          paramLogState = localStringBuilder.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramLogState, "logS.toString()");
          flush(paramLogState);
          return;
        }
        catch (Throwable paramLogState)
        {
          paramLogState.printStackTrace();
        }
      }
    }
  }
  
  public void flush(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "logInfo");
    if (!this.readQueue.offer(paramString))
    {
      swapQueue();
      this.readQueue.offer(paramString);
      try
      {
        writeLogFile();
        paramString = Unit.INSTANCE;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.Logger.DefaultLogProxy
 * JD-Core Version:    0.7.0.1
 */