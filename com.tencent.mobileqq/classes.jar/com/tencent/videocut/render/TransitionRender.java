package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.videocut.render.extension.TransitionModelExtKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/TransitionRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/TransitionModel;", "Lcom/tencent/videocut/render/TransitionRenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "addEntity", "", "data", "getItemIdentity", "", "model", "prepareRenderData", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TransitionRender
  extends AbsListRender<TransitionModel, TransitionRenderData>
{
  private final ICutSession a;
  
  public TransitionRender(@NotNull ICutSession paramICutSession)
  {
    this.a = paramICutSession;
  }
  
  public int a(@NotNull TransitionRenderData paramTransitionRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionRenderData, "data");
    this.a.a(paramTransitionRenderData.b().b());
    return this.a.c(paramTransitionRenderData.b().a(), paramTransitionRenderData.a()).getId();
  }
  
  @NotNull
  public TransitionRenderData a(@NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "model");
    return TransitionModelExtKt.a(paramTransitionModel);
  }
  
  @NotNull
  public List<TransitionModel> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    return CollectionsKt.toList((Iterable)paramMediaModel.transitions.values());
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable TransitionRenderData paramTransitionRenderData1, @NotNull TransitionRenderData paramTransitionRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionRenderData2, "newData");
    if ((paramTransitionRenderData1 == null) || (paramTransitionRenderData1.a() != paramTransitionRenderData2.a())) {
      a(paramInt);
    }
    ICutSession localICutSession = this.a;
    paramTransitionRenderData1 = paramTransitionRenderData2.b().b().key;
    if (paramTransitionRenderData1 == null) {
      paramTransitionRenderData1 = "";
    }
    paramTransitionRenderData1 = localICutSession.a(paramTransitionRenderData1);
    if ((Intrinsics.areEqual(paramTransitionRenderData2.b().b(), paramTransitionRenderData1) ^ true)) {
      this.a.a(paramTransitionRenderData2.b().b());
    }
    this.a.c(paramTransitionRenderData2.b().a(), paramTransitionRenderData2.a());
  }
  
  @NotNull
  public String b(@NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "model");
    return paramTransitionModel.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.TransitionRender
 * JD-Core Version:    0.7.0.1
 */