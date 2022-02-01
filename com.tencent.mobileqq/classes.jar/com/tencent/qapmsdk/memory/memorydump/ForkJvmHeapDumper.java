package com.tencent.qapmsdk.memory.memorydump;

import android.os.Debug;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.IOException;

public class ForkJvmHeapDumper
  implements IHeapDumper
{
  private static final String TAG = "QAPM_memory_ForkJvmHeapDumper";
  private static volatile ForkJvmHeapDumper instance;
  private boolean dumperValid = false;
  private boolean soLoaded;
  
  private ForkJvmHeapDumper()
  {
    if (this.soLoaded) {
      return;
    }
    if (!DumpEnableCheck.checkVersion()) {
      return;
    }
    this.soLoaded = FileUtil.loadLibrary("qapmMemoryDump");
    if (this.soLoaded) {
      this.dumperValid = initForkDump();
    }
  }
  
  private native void exitProcess();
  
  public static ForkJvmHeapDumper getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new ForkJvmHeapDumper();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private native boolean initForkDump();
  
  private native void resumeVM();
  
  private native int trySuspendVmThenFork();
  
  private boolean waitDumping(int paramInt)
  {
    waitPid(paramInt);
    return true;
  }
  
  private native void waitPid(int paramInt);
  
  public boolean dump(String paramString)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_memory_ForkJvmHeapDumper", "dump ", paramString });
    if (!this.soLoaded)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ForkJvmHeapDumper", "dump failed caused by so not loaded!" });
      return false;
    }
    if (!DumpEnableCheck.checkDisk())
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ForkJvmHeapDumper", "dump failed caused by disk space not enough!" });
      return false;
    }
    if (!DumpEnableCheck.checkVersion())
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_ForkJvmHeapDumper", "dump failed caused by version net permitted!" });
      return false;
    }
    boolean bool;
    try
    {
      int i = trySuspendVmThenFork();
      Object localObject;
      if (i == 0)
      {
        Debug.dumpHprofData(paramString);
        paramString = Logger.INSTANCE;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyDumped:");
        ((StringBuilder)localObject).append(false);
        paramString.i(new String[] { "QAPM_memory_ForkJvmHeapDumper", ((StringBuilder)localObject).toString() });
        exitProcess();
        return false;
      }
      resumeVM();
      bool = waitDumping(i);
      try
      {
        localObject = Logger.INSTANCE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hprof pid:");
        localStringBuilder.append(i);
        localStringBuilder.append(" dumped: ");
        ((Logger)localObject).i(new String[] { "QAPM_memory_ForkJvmHeapDumper", localStringBuilder.toString(), paramString });
        return bool;
      }
      catch (IOException paramString) {}
      Logger.INSTANCE.exception("QAPM_memory_ForkJvmHeapDumper", "dump failed caused by IOException!", paramString);
    }
    catch (IOException paramString)
    {
      bool = false;
    }
    return bool;
  }
  
  public boolean isValid()
  {
    return this.dumperValid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.memorydump.ForkJvmHeapDumper
 * JD-Core Version:    0.7.0.1
 */