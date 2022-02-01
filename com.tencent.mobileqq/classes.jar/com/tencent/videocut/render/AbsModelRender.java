package com.tencent.videocut.render;

import com.tencent.videocut.model.MediaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/AbsModelRender;", "T", "V", "Lcom/tencent/videocut/render/RenderLayer;", "()V", "currentModel", "Ljava/lang/Object;", "entityId", "", "Ljava/lang/Integer;", "getEntityIdByModelId", "modelId", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getModelByEntityId", "", "getModelIdentity", "model", "(Ljava/lang/Object;)Ljava/lang/String;", "isContentTheSame", "", "newModel", "oldModel", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "isItemTheSame", "prepareRenderData", "(Ljava/lang/Object;)Ljava/lang/Object;", "renderInternal", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "selector", "Lcom/tencent/videocut/model/MediaModel;", "(Lcom/tencent/videocut/model/MediaModel;)Ljava/lang/Object;", "update", "mediaModel", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsModelRender<T, V>
  implements RenderLayer<V>
{
  private T a;
  private Integer b;
  
  private final void c(T paramT1, T paramT2)
  {
    if (b(paramT1, paramT2)) {
      return;
    }
    if (paramT1 == null)
    {
      paramT1 = this.b;
      if (paramT1 != null) {
        a(((Number)paramT1).intValue());
      }
      this.b = ((Integer)null);
      return;
    }
    Object localObject1 = b(paramT1);
    if (paramT2 == null)
    {
      this.b = Integer.valueOf(c(localObject1));
      return;
    }
    Object localObject2 = b(paramT2);
    if (a(paramT1, paramT2))
    {
      paramT1 = this.b;
      if (paramT1 != null) {
        a(((Number)paramT1).intValue(), localObject2, localObject1);
      }
    }
    else
    {
      paramT1 = this.b;
      if (paramT1 != null) {
        a(((Number)paramT1).intValue());
      }
      this.b = Integer.valueOf(c(localObject1));
    }
  }
  
  @Nullable
  public abstract T a(@NotNull MediaModel paramMediaModel);
  
  @Nullable
  public abstract String a(@Nullable T paramT);
  
  public boolean a(@Nullable T paramT1, @Nullable T paramT2)
  {
    if ((paramT1 == null) && (paramT2 == null)) {
      return true;
    }
    if ((paramT1 != null) && (paramT2 != null)) {
      return Intrinsics.areEqual(a(paramT1), a(paramT2));
    }
    return false;
  }
  
  public abstract V b(T paramT);
  
  public void b(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    paramMediaModel = a(paramMediaModel);
    c(paramMediaModel, this.a);
    this.a = paramMediaModel;
  }
  
  public boolean b(@Nullable T paramT1, @Nullable T paramT2)
  {
    return Intrinsics.areEqual(paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.AbsModelRender
 * JD-Core Version:    0.7.0.1
 */