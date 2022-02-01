package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.base.meta.InspectUUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/IMemoryLeakListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryDumpListener;", "onCheckingLeaked", "", "currentWaitSecond", "", "objInfo", "", "onFilter", "", "willCheckedObj", "", "onLeaked", "uuid", "Lcom/tencent/rmonitor/base/meta/InspectUUID;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IMemoryLeakListener
  extends IMemoryDumpListener
{
  public abstract void onCheckingLeaked(int paramInt, @NotNull String paramString);
  
  public abstract boolean onFilter(@NotNull Object paramObject);
  
  public abstract boolean onLeaked(@NotNull InspectUUID paramInspectUUID);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
 * JD-Core Version:    0.7.0.1
 */