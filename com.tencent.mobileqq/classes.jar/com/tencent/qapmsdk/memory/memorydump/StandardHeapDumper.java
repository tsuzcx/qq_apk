package com.tencent.qapmsdk.memory.memorydump;

import android.os.Debug;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;

public class StandardHeapDumper
  implements IHeapDumper
{
  private static final String TAG = "QAPM_memory_StandardHeapDumper";
  private static volatile StandardHeapDumper instance = null;
  
  public static StandardHeapDumper getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new StandardHeapDumper();
      }
      return instance;
    }
    finally {}
  }
  
  public boolean dump(String paramString)
  {
    try
    {
      Debug.dumpHprofData(paramString);
      return true;
    }
    catch (IOException paramString)
    {
      Logger.INSTANCE.exception("QAPM_memory_StandardHeapDumper", paramString);
    }
    return false;
  }
  
  public boolean isValid()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.memorydump.StandardHeapDumper
 * JD-Core Version:    0.7.0.1
 */