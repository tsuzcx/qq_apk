package com.tencent.tavcut.operator;

import com.tencent.tavcut.model.ClipSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/operator/IClipSourceOperator;", "", "addSource", "", "index", "", "clipSources", "", "Lcom/tencent/tavcut/model/ClipSource;", "adjustSourceSpeed", "originSource", "speed", "", "(Lcom/tencent/tavcut/model/ClipSource;F)Ljava/lang/Boolean;", "adjustSourceTimeRange", "adjustSource", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "copySource", "observeError", "", "callBack", "Lkotlin/Function1;", "Lcom/tencent/tavcut/operator/IClipSourceOperator$InvalidStatus;", "registerClipSourceOperationStrategy", "iStrategy", "Lcom/tencent/tavcut/operator/IClipSourceOperationStrategy;", "removeSource", "removeSourceAt", "removeSourceRange", "fromIndex", "toIndex", "reorderSource", "orderedSource", "targetIndex", "replaceSource", "srcSource", "destSource", "splitSource", "splitPositionUs", "", "updateSource", "updateSources", "InvalidStatus", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IClipSourceOperator
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(@NotNull IClipSourceOperationStrategy paramIClipSourceOperationStrategy);
  
  public abstract boolean a(int paramInt, @NotNull List<ClipSource> paramList);
  
  public abstract boolean a(@NotNull List<ClipSource> paramList);
  
  @Nullable
  public abstract ClipSource b(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract List<ClipSource> b(int paramInt, @NotNull List<ClipSource> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.operator.IClipSourceOperator
 * JD-Core Version:    0.7.0.1
 */