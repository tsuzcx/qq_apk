package com.tencent.qapmsdk.memory;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import java.util.List;

final class MemoryCeilingMonitor$1
  implements IMemoryCellingListener
{
  public void onAfterDump() {}
  
  @NonNull
  public List<String> onBeforeDump(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = DumpMemInfoHandler.generateHprof(paramString);
    if ((((Boolean)paramString[0]).booleanValue()) && (paramString[1] != null))
    {
      localArrayList.add((String)paramString[1]);
      return localArrayList;
    }
    Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryMonitor", "failed dump memory" });
    return localArrayList;
  }
  
  public void onBeforeUploadJson() {}
  
  public boolean onCanDump(long paramLong)
  {
    return true;
  }
  
  public void onLowMemory(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryCeilingMonitor.1
 * JD-Core Version:    0.7.0.1
 */