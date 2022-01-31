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
  
  /* Error */
  private final void swapQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue1	Ljava/util/concurrent/BlockingQueue;
    //   6: aload_0
    //   7: getfield 72	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:writerQueue	Ljava/util/concurrent/BlockingQueue;
    //   10: if_acmpne +26 -> 36
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 68	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue2	Ljava/util/concurrent/BlockingQueue;
    //   18: putfield 72	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:writerQueue	Ljava/util/concurrent/BlockingQueue;
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 66	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue1	Ljava/util/concurrent/BlockingQueue;
    //   26: putfield 70	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:readQueue	Ljava/util/concurrent/BlockingQueue;
    //   29: getstatic 103	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 66	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue1	Ljava/util/concurrent/BlockingQueue;
    //   41: putfield 72	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:writerQueue	Ljava/util/concurrent/BlockingQueue;
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 68	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue2	Ljava/util/concurrent/BlockingQueue;
    //   49: putfield 70	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:readQueue	Ljava/util/concurrent/BlockingQueue;
    //   52: goto -23 -> 29
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	DefaultLogProxy
    //   32	1	1	localUnit	Unit
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	55	finally
    //   29	33	55	finally
    //   36	52	55	finally
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
      if (paramVarArgs.length != 0) {
        break label40;
      }
      i = 1;
      if (i == 0) {
        break label45;
      }
    }
    label40:
    label45:
    String str1;
    do
    {
      return;
      i = 0;
      break;
      str1 = paramVarArgs[0];
    } while ((str1 == null) || (paramVarArgs.length <= 1));
    StringBuilder localStringBuilder = new StringBuilder(256);
    int j = paramVarArgs.length;
    int i = 1;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    String str2 = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(str2, "logS.toString()");
    paramVarArgs = "";
    switch (Logger.DefaultLogProxy.WhenMappings.$EnumSwitchMapping$0[paramLogState.ordinal()])
    {
    default: 
      paramLogState = paramVarArgs;
    }
    for (;;)
    {
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append(Logger.access$getLogTimeFormatter$p(Logger.INSTANCE).format(Long.valueOf(System.currentTimeMillis()))).append(paramLogState).append(str1).append(":    ").append(str2);
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
        return;
      }
      Log.v(str1, str2);
      paramLogState = "    VERBOS/";
      continue;
      Log.d(str1, str2);
      paramLogState = "    DEBUG/";
      continue;
      Log.i(str1, str2);
      paramLogState = "    INFO/";
      continue;
      Log.w(str1, str2);
      paramLogState = "    WARN/";
      continue;
      Log.e(str1, str2);
      paramLogState = "    ERROR/";
    }
  }
  
  public void flush(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "logInfo");
    if (!this.readQueue.offer(paramString))
    {
      swapQueue();
      this.readQueue.offer(paramString);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.Logger.DefaultLogProxy
 * JD-Core Version:    0.7.0.1
 */