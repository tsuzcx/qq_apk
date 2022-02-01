package com.tencent.videocut.render;

import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.PipModel;
import com.tencent.videocut.render.extension.PipModelExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/PipColorFilterModelRender;", "Lcom/tencent/videocut/render/AbsColorFilterModelRender;", "pipRender", "Lcom/tencent/videocut/render/PipRenderTargetRender;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/videocut/render/PipRenderTargetRender;Lcom/tencent/tavcut/session/ICutSession;)V", "addEntity", "", "data", "Lcom/tencent/videocut/render/RenderData;", "prepareRenderData", "model", "Lcom/tencent/videocut/render/FilterRenderData;", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipColorFilterModelRender
  extends AbsColorFilterModelRender
{
  private final PipRenderTargetRender a;
  
  public PipColorFilterModelRender(@NotNull PipRenderTargetRender paramPipRenderTargetRender, @NotNull ICutSession paramICutSession)
  {
    super(paramICutSession);
    this.a = paramPipRenderTargetRender;
  }
  
  public int a(@NotNull RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    Integer localInteger = this.a.a(paramRenderData.c());
    if (localInteger != null)
    {
      int i = ((Number)localInteger).intValue();
      return a().a(i, paramRenderData.a()).getId();
    }
    return 0;
  }
  
  @NotNull
  public List<FilterRenderData> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    paramMediaModel = (Iterable)paramMediaModel.pips.values();
    Object localObject2 = (Collection)new ArrayList();
    Iterator localIterator = paramMediaModel.iterator();
    while (localIterator.hasNext())
    {
      PipModel localPipModel = (PipModel)localIterator.next();
      Object localObject3 = localPipModel.mediaClip;
      localObject1 = null;
      paramMediaModel = (MediaModel)localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((MediaClip)localObject3).filter;
        paramMediaModel = (MediaModel)localObject1;
        if (localObject3 != null)
        {
          paramMediaModel = (MediaModel)localObject1;
          if (((FilterModel)localObject3).color != null) {
            paramMediaModel = new Pair(localObject3, PipModelExtKt.a(localPipModel));
          }
        }
      }
      if (paramMediaModel != null) {
        ((Collection)localObject2).add(paramMediaModel);
      }
    }
    Object localObject1 = (Iterable)localObject2;
    paramMediaModel = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      paramMediaModel.add(new FilterRenderData(0, (FilterModel)((Pair)localObject2).getFirst(), (String)((Pair)localObject2).getSecond(), 1, null));
    }
    return (List)paramMediaModel;
  }
  
  @NotNull
  public RenderData b(@NotNull FilterRenderData paramFilterRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterRenderData, "model");
    return RenderData.a(super.b(paramFilterRenderData), null, null, paramFilterRenderData.c(), 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.PipColorFilterModelRender
 * JD-Core Version:    0.7.0.1
 */