package com.tencent.qapmsdk.base.listener;

import com.tencent.qapmsdk.common.util.InspectUUID;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IInspectorListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onCheckingLeaked", "", "currentWaitSecond", "", "objInfo", "", "onFilter", "", "willCheckedObj", "", "onFinishDump", "isSuccess", "zipPath", "onLeaked", "uuid", "Lcom/tencent/qapmsdk/common/util/InspectUUID;", "onPrepareDump", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IInspectorListener
  extends IBaseListener
{
  public abstract void onCheckingLeaked(int paramInt, @NotNull String paramString);
  
  public abstract boolean onFilter(@NotNull Object paramObject);
  
  public abstract void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract boolean onLeaked(@NotNull InspectUUID paramInspectUUID);
  
  @NotNull
  public abstract List<String> onPrepareDump(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IInspectorListener
 * JD-Core Version:    0.7.0.1
 */