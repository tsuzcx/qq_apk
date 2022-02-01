package com.tencent.qapmsdk.base.listener;

import com.tencent.qapmsdk.common.util.InspectUUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IInspectorListener;", "Lcom/tencent/qapmsdk/base/listener/IMemoryDumpListener;", "onCheckingLeaked", "", "currentWaitSecond", "", "objInfo", "", "onFilter", "", "willCheckedObj", "", "onLeaked", "uuid", "Lcom/tencent/qapmsdk/common/util/InspectUUID;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IInspectorListener
  extends IMemoryDumpListener
{
  public abstract void onCheckingLeaked(int paramInt, @NotNull String paramString);
  
  public abstract boolean onFilter(@NotNull Object paramObject);
  
  public abstract boolean onLeaked(@NotNull InspectUUID paramInspectUUID);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IInspectorListener
 * JD-Core Version:    0.7.0.1
 */