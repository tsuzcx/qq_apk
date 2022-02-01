package com.tencent.tavcut.operator;

import com.tencent.tavcut.composition.dataprocessor.RenderDataManager;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.rendermodel.RenderModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/operator/ClipSourceOperator;", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "dataManager", "Lcom/tencent/tavcut/composition/dataprocessor/RenderDataManager;", "(Lcom/tencent/tavcut/composition/dataprocessor/RenderDataManager;)V", "errorCallBack", "Lkotlin/Function1;", "Lcom/tencent/tavcut/operator/IClipSourceOperator$InvalidStatus;", "", "iStrategy", "Lcom/tencent/tavcut/operator/IClipSourceOperationStrategy;", "accessClipSourceIndex", "", "originSource", "Lcom/tencent/tavcut/model/ClipSource;", "addSource", "", "index", "clipSources", "", "adjustSourceSpeed", "speed", "", "(Lcom/tencent/tavcut/model/ClipSource;F)Ljava/lang/Boolean;", "adjustSourceTimeRange", "adjustSource", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "calculateCopiedInsertIndex", "strategy", "Lcom/tencent/tavcut/operator/SourceInsertStrategy;", "sizeOfList", "checkIndexValid", "checkInsertIndexValid", "copyCurrentClipSources", "", "copySource", "currentClipCount", "observeError", "callBack", "registerClipSourceOperationStrategy", "removeSource", "removeSourceAt", "removeSourceRange", "fromIndex", "toIndex", "reorderSource", "orderedSource", "targetIndex", "replaceSource", "srcSource", "destSource", "setClipAssets", "splitSource", "splitPositionUs", "", "updateSource", "updatedSource", "updatedSources", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ClipSourceOperator
  implements IClipSourceOperator
{
  private IClipSourceOperationStrategy a;
  private Function1<? super IClipSourceOperator.InvalidStatus, Unit> b;
  private final RenderDataManager c;
  
  public ClipSourceOperator(@NotNull RenderDataManager paramRenderDataManager)
  {
    this.c = paramRenderDataManager;
    this.a = ((IClipSourceOperationStrategy)new DefaultCopiedSourceInsertedStrategy());
    this.b = ((Function1)ClipSourceOperator.errorCallBack.1.INSTANCE);
  }
  
  private final List<ClipSource> a()
  {
    Object localObject = this.c.c();
    if (localObject != null)
    {
      localObject = ((RenderModel)localObject).getClipsAssets();
      if (localObject != null)
      {
        List localList = (List)new ArrayList();
        int i = 0;
        int j = ((Collection)localObject).size();
        while (i < j)
        {
          localList.add(ClipSource.copy$default((ClipSource)((List)localObject).get(i), null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
          i += 1;
        }
        return localList;
      }
    }
    return (List)new ArrayList();
  }
  
  private final boolean a(int paramInt)
  {
    int i = b();
    boolean bool2 = false;
    if (i == -1) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt <= b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final int b()
  {
    Object localObject = this.c.c();
    if (localObject != null)
    {
      localObject = ((RenderModel)localObject).getClipsAssets();
      if (localObject != null) {
        return ((List)localObject).size();
      }
    }
    return -1;
  }
  
  private final void b(List<ClipSource> paramList)
  {
    this.c.a(paramList, this.a.b(), this.a.a());
  }
  
  private final boolean b(int paramInt)
  {
    int i = b();
    boolean bool2 = false;
    if (i == -1) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((b(paramInt1)) && (paramInt2 > paramInt1))
    {
      if (paramInt2 > b()) {
        return;
      }
      if (b() <= this.a.c())
      {
        this.b.invoke(IClipSourceOperator.InvalidStatus.DELETE_LIMIT);
        return;
      }
      List localList = a();
      paramInt2 -= 1;
      if (paramInt2 >= paramInt1) {
        for (;;)
        {
          localList.remove(paramInt2);
          this.c.e(paramInt2);
          this.c.c(paramInt2);
          if (paramInt2 == paramInt1) {
            break;
          }
          paramInt2 -= 1;
        }
      }
      this.c.e(localList.size() - 1);
      b(localList);
    }
  }
  
  public void a(@NotNull IClipSourceOperationStrategy paramIClipSourceOperationStrategy)
  {
    Intrinsics.checkParameterIsNotNull(paramIClipSourceOperationStrategy, "iStrategy");
    this.a = paramIClipSourceOperationStrategy;
  }
  
  public boolean a(int paramInt, @NotNull List<ClipSource> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clipSources");
    boolean bool = a(paramInt);
    int i = 0;
    if (!bool)
    {
      this.b.invoke(IClipSourceOperator.InvalidStatus.ADD_INVALID_INDEX);
      return false;
    }
    List localList1 = a();
    List localList2 = (List)new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localList2.add(ClipSource.copy$default((ClipSource)localIterator.next(), null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
    }
    bool = localList1.addAll(paramInt, (Collection)localList2);
    if (this.c.b().isEmpty())
    {
      this.c.a(localList1.size() - 1);
    }
    else
    {
      int j = ((Collection)paramList).size();
      while (i < j)
      {
        this.c.b(paramInt + i);
        i += 1;
      }
    }
    this.c.a(paramInt, paramList.size());
    b(localList1);
    return bool;
  }
  
  public boolean a(@NotNull List<ClipSource> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clipSources");
    return a(b(), paramList);
  }
  
  @Nullable
  public ClipSource b(int paramInt1, int paramInt2)
  {
    if ((b(paramInt1)) && (b(paramInt2)))
    {
      List localList = a();
      ClipSource localClipSource = (ClipSource)localList.remove(paramInt1);
      localList.add(paramInt2, localClipSource);
      this.c.b(paramInt1, paramInt2);
      b(localList);
      return localClipSource;
    }
    this.b.invoke(IClipSourceOperator.InvalidStatus.REORDER_INVALID_INDEX);
    return null;
  }
  
  @Nullable
  public List<ClipSource> b(int paramInt, @NotNull List<ClipSource> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "updatedSources");
    if ((b(paramInt)) && (a(paramList.size() + paramInt)))
    {
      List localList1 = a();
      List localList2 = (List)new ArrayList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        ClipSource localClipSource1 = (ClipSource)paramList.next();
        ClipSource localClipSource2 = (ClipSource)localList1.get(paramInt);
        if ((Intrinsics.areEqual(localClipSource2, localClipSource1) ^ true))
        {
          localList1.set(paramInt, localClipSource1);
          localList2.add(localClipSource2);
        }
        paramInt += 1;
      }
      b(localList1);
      return localList2;
    }
    return CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.operator.ClipSourceOperator
 * JD-Core Version:    0.7.0.1
 */