package com.tencent.qapmsdk.memory;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.common.util.InspectUUID;
import java.util.ArrayList;
import java.util.List;

class MemoryLeakMonitor$1
  implements IInspectorListener
{
  MemoryLeakMonitor$1(MemoryLeakMonitor paramMemoryLeakMonitor) {}
  
  public void onCheckingLeaked(int paramInt, String paramString) {}
  
  public boolean onFilter(Object paramObject)
  {
    return false;
  }
  
  public void onFinishDump(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onHprofDumped(@NonNull String paramString) {}
  
  public boolean onLeaked(InspectUUID paramInspectUUID)
  {
    return true;
  }
  
  @NonNull
  public List<String> onPrepareDump(String paramString)
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryLeakMonitor.1
 * JD-Core Version:    0.7.0.1
 */