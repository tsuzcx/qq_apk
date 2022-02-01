package com.tencent.rmonitor.heapdump;

import android.os.Handler;
import android.util.Log;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.fd.report.FdLeakAttaReporter;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

public class ForkJvmHeapDumper
  extends StripHeapDumper
{
  private static boolean b = false;
  
  public ForkJvmHeapDumper()
  {
    if (!DumpEnableChecker.b()) {
      return;
    }
    if ((a) && (!b)) {
      b = nInitForkDump();
    }
  }
  
  private int a(String paramString, @NotNull HeapDumpConfig paramHeapDumpConfig, boolean paramBoolean)
  {
    nSuspendVM();
    int i = nFork();
    if (i == 0)
    {
      Log.i("ForkJvmHeapDumper", "sub process dump start.");
      paramString = b(paramString, paramHeapDumpConfig);
      if (!paramString.a) {
        i = -101;
      } else {
        i = 0;
      }
      paramHeapDumpConfig = new StringBuilder();
      paramHeapDumpConfig.append("sub process dump result:");
      paramHeapDumpConfig.append(paramString);
      Log.i("ForkJvmHeapDumper", paramHeapDumpConfig.toString());
      nExitProcess(i);
      return 0;
    }
    nResumeVM();
    Log.i("ForkJvmHeapDumper", "main process waiting dump result.");
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new ForkJvmHeapDumper.1(this, localAtomicBoolean, i);
    b().postDelayed((Runnable)localObject, 50000L);
    i = nWaitProcessExit(i);
    b().removeCallbacks((Runnable)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("main process wait result: ");
    ((StringBuilder)localObject).append(i);
    Log.i("ForkJvmHeapDumper", ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      if (localAtomicBoolean.get()) {
        i = 106;
      } else {
        i = 105;
      }
      FdLeakAttaReporter.a(i, true, "");
      if (paramBoolean)
      {
        a(paramHeapDumpConfig, new RuntimeException());
        return i;
      }
      Log.i("ForkJvmHeapDumper", "fork dump failed, retry again.");
      return a(paramString, paramHeapDumpConfig, true);
    }
    return 0;
  }
  
  private static native void nExitProcess(int paramInt);
  
  private static native int nFork();
  
  private static native boolean nInitForkDump();
  
  private static native void nResumeVM();
  
  private static native void nSuspendVM();
  
  private static native int nWaitProcessExit(int paramInt);
  
  public int a(String paramString, @NotNull HeapDumpConfig paramHeapDumpConfig)
  {
    Logger.b.i(new String[] { "ForkJvmHeapDumper", "dump ", paramString });
    if (!a)
    {
      Logger.b.e(new String[] { "ForkJvmHeapDumper", "dump failed caused by so not loaded!" });
      return 101;
    }
    if (!b)
    {
      Logger.b.e(new String[] { "ForkJvmHeapDumper", "dump failed caused by Symbol is not resolved!" });
      return 102;
    }
    if (!DumpEnableChecker.a())
    {
      Logger.b.e(new String[] { "ForkJvmHeapDumper", "dump failed caused by disk space not enough!" });
      return 103;
    }
    if (!DumpEnableChecker.b())
    {
      Logger.b.e(new String[] { "ForkJvmHeapDumper", "dump failed caused by version net permitted!" });
      return 104;
    }
    return a(paramString, paramHeapDumpConfig, false);
  }
  
  public boolean a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.ForkJvmHeapDumper
 * JD-Core Version:    0.7.0.1
 */