package com.tencent.qapmsdk.memory.memorydump;

import android.os.Debug;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.IOException;

public class ForkJvmHeapDumper
  implements IHeapDumper
{
  private static final String TAG = "QAPM_memory_ForkJvmHeapDumper";
  private static volatile ForkJvmHeapDumper instance = null;
  private boolean dumperValid = false;
  private boolean soLoaded;
  
  private ForkJvmHeapDumper()
  {
    if (this.soLoaded) {}
    do
    {
      do
      {
        return;
      } while (!DumpEnableCheck.checkVersion());
      this.soLoaded = FileUtil.loadLibrary("qapmMemoryDump");
    } while (!this.soLoaded);
    this.dumperValid = initForkDump();
  }
  
  private native void exitProcess();
  
  public static ForkJvmHeapDumper getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ForkJvmHeapDumper();
      }
      return instance;
    }
    finally {}
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
    boolean bool2 = false;
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
    boolean bool1 = bool2;
    int i;
    try
    {
      i = trySuspendVmThenFork();
      if (i == 0)
      {
        bool1 = bool2;
        Debug.dumpHprofData(paramString);
        bool1 = bool2;
        Logger.INSTANCE.i(new String[] { "QAPM_memory_ForkJvmHeapDumper", "notifyDumped:" + false });
        bool1 = bool2;
        exitProcess();
        return false;
      }
    }
    catch (IOException paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_ForkJvmHeapDumper", "dump failed caused by IOException!", paramString);
      return bool1;
    }
    bool1 = bool2;
    resumeVM();
    bool1 = bool2;
    bool2 = waitDumping(i);
    bool1 = bool2;
    Logger.INSTANCE.i(new String[] { "QAPM_memory_ForkJvmHeapDumper", "hprof pid:" + i + " dumped: ", paramString });
    return bool2;
  }
  
  public boolean isValid()
  {
    return this.dumperValid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.memorydump.ForkJvmHeapDumper
 * JD-Core Version:    0.7.0.1
 */