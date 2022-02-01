package com.tencent.rmonitor.memory.leakdetect;

import com.tencent.rmonitor.base.meta.InspectUUID;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class EmptyMemoryLeakListener
  implements IMemoryLeakListener
{
  public void onCheckingLeaked(int paramInt, @NotNull String paramString) {}
  
  public boolean onFilter(@NotNull Object paramObject)
  {
    return false;
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onHprofDumped(@NotNull String paramString) {}
  
  public boolean onLeaked(@NotNull InspectUUID paramInspectUUID)
  {
    return true;
  }
  
  @Nullable
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.EmptyMemoryLeakListener
 * JD-Core Version:    0.7.0.1
 */