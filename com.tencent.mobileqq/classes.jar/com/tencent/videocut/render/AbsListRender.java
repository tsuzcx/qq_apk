package com.tencent.videocut.render;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.Callback;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.tencent.videocut.model.MediaModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/AbsListRender;", "T", "V", "Lcom/tencent/videocut/render/RenderLayer;", "()V", "currentList", "", "entityIds", "", "", "", "detectMoves", "", "getEntityIdByModelId", "modelId", "(Ljava/lang/String;)Ljava/lang/Integer;", "getItemIdentity", "model", "(Ljava/lang/Object;)Ljava/lang/String;", "getModelByEntityId", "entityId", "(I)Ljava/lang/Object;", "isContentTheSame", "newModel", "oldModel", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "isItemTheSame", "onChanged", "", "newItem", "oldItem", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onInserted", "items", "onMoved", "item", "from", "to", "(Ljava/lang/Object;II)V", "onRemoved", "prepareRenderData", "(Ljava/lang/Object;)Ljava/lang/Object;", "renderAllItems", "newList", "oldList", "selector", "Lcom/tencent/videocut/model/MediaModel;", "update", "mediaModel", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsListRender<T, V>
  implements RenderLayer<V>
{
  private List<? extends T> a = CollectionsKt.emptyList();
  private final Map<String, Integer> b = (Map)new LinkedHashMap();
  
  private final void a(List<? extends T> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      int i = c(b(localObject));
      this.b.put(a(localObject), Integer.valueOf(i));
    }
  }
  
  private final void a(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    if (Intrinsics.areEqual(paramList1, paramList2)) {
      return;
    }
    DiffUtil.DiffResult localDiffResult = DiffUtil.calculateDiff((DiffUtil.Callback)new AbsListRender.renderAllItems.callback.1(this, paramList2, paramList1), b());
    Intrinsics.checkExpressionValueIsNotNull(localDiffResult, "DiffUtil.calculateDiff(callback, detectMoves())");
    localDiffResult.dispatchUpdatesTo((ListUpdateCallback)new AbsListRender.renderAllItems.1(this, paramList1, paramList2));
  }
  
  private final void b(List<? extends T> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = a(paramList.next());
      Integer localInteger = (Integer)this.b.get(str);
      if (localInteger != null)
      {
        ((Number)localInteger).intValue();
        a(localInteger.intValue());
      }
      this.b.remove(str);
    }
  }
  
  @Nullable
  public Integer a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "modelId");
    return (Integer)this.b.get(paramString);
  }
  
  @NotNull
  public abstract String a(T paramT);
  
  @NotNull
  public abstract List<T> a(@NotNull MediaModel paramMediaModel);
  
  public void a(T paramT, int paramInt1, int paramInt2) {}
  
  public boolean a(T paramT1, T paramT2)
  {
    return Intrinsics.areEqual(paramT1, paramT2);
  }
  
  public abstract V b(T paramT);
  
  public void b(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    paramMediaModel = a(paramMediaModel);
    a(paramMediaModel, this.a);
    this.a = paramMediaModel;
  }
  
  public void b(T paramT1, T paramT2)
  {
    Object localObject = a(paramT1);
    localObject = (Integer)this.b.get(localObject);
    if (localObject != null)
    {
      a(((Integer)localObject).intValue(), b(paramT2), b(paramT1));
      return;
    }
    throw ((Throwable)new IllegalStateException("couldn't find target entityId"));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c(T paramT1, T paramT2)
  {
    return Intrinsics.areEqual(a(paramT1), a(paramT2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.AbsListRender
 * JD-Core Version:    0.7.0.1
 */