package com.tencent.videocut.render;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/RenderLayer;", "V", "Lcom/tencent/videocut/render/IRender;", "addEntity", "", "data", "(Ljava/lang/Object;)I", "getEntityIdByModelId", "modelId", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getModelByEntityId", "", "entityId", "removeEntity", "", "updateEntity", "originalEntityId", "oldData", "newData", "(ILjava/lang/Object;Ljava/lang/Object;)V", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface RenderLayer<V>
  extends IRender
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, @Nullable V paramV1, V paramV2);
  
  public abstract int c(V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.RenderLayer
 * JD-Core Version:    0.7.0.1
 */