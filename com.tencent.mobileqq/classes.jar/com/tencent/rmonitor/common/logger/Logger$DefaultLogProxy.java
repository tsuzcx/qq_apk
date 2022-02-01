package com.tencent.rmonitor.common.logger;

import android.os.Handler;
import android.util.Log;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.thread.ThreadManager.Companion;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logger/Logger$DefaultLogProxy;", "Lcom/tencent/rmonitor/common/logger/ILogProxy;", "()V", "flushing", "", "lastTimeMillis", "", "logFile", "Ljava/io/File;", "logQueueSize", "", "readQueue", "Ljava/util/concurrent/BlockingQueue;", "", "sb", "Ljava/lang/StringBuffer;", "workQueue1", "workQueue2", "writerQueue", "doLog", "", "state", "Lcom/tencent/rmonitor/common/logger/LogState;", "args", "", "(Lcom/tencent/rmonitor/common/logger/LogState;[Ljava/lang/String;)V", "flush", "logInfo", "swapQueue", "writeLogFile", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class Logger$DefaultLogProxy
  implements ILogProxy
{
  private final int a = 1024;
  private final StringBuffer b = new StringBuffer(2048);
  private final BlockingQueue<String> c = (BlockingQueue)new LinkedBlockingQueue(this.a);
  private final BlockingQueue<String> d = (BlockingQueue)new LinkedBlockingQueue(this.a);
  private long e;
  private BlockingQueue<String> f = this.c;
  private BlockingQueue<String> g = this.d;
  private File h;
  private volatile boolean i;
  
  private final void a()
  {
    try
    {
      if (this.c == this.g)
      {
        this.g = this.d;
        this.f = this.c;
      }
      else
      {
        this.g = this.c;
        this.f = this.d;
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  private final void b()
  {
    new Handler(ThreadManager.a.b()).post((Runnable)new Logger.DefaultLogProxy.writeLogFile.1(this));
  }
  
  public void a(@NotNull LogState paramLogState, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramLogState, "state");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (Logger.b.a().compareTo((Enum)paramLogState) >= 0)
    {
      int j;
      if (paramVarArgs.length == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return;
      }
      String str = paramVarArgs[0];
      if (str != null)
      {
        if (paramVarArgs.length <= 1) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder(256);
        int k = paramVarArgs.length;
        j = 1;
        while (j < k)
        {
          localStringBuilder.append(paramVarArgs[j]);
          j += 1;
        }
        paramVarArgs = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramVarArgs, "logS.toString()");
        j = Logger.DefaultLogProxy.WhenMappings.$EnumSwitchMapping$0[paramLogState.ordinal()];
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j != 5)
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
        localStringBuilder.append(Logger.a(Logger.b).format(Long.valueOf(System.currentTimeMillis())));
        localStringBuilder.append(paramLogState);
        localStringBuilder.append(str);
        localStringBuilder.append(":    ");
        localStringBuilder.append(paramVarArgs);
        try
        {
          paramLogState = localStringBuilder.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramLogState, "logS.toString()");
          a(paramLogState);
          return;
        }
        catch (Throwable paramLogState)
        {
          paramLogState.printStackTrace();
        }
      }
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "logInfo");
    if (!this.f.offer(paramString))
    {
      a();
      this.f.offer(paramString);
      try
      {
        b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logger.Logger.DefaultLogProxy
 * JD-Core Version:    0.7.0.1
 */