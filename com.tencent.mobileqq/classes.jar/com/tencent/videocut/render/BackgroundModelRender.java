package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.BackgroundFillMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.utils.ColorUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/BackgroundModelRender;", "Lcom/tencent/videocut/render/AbsModelRender;", "Lcom/tencent/videocut/model/BackgroundModel;", "Lcom/tencent/videocut/render/RenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "addEntity", "", "data", "getModelIdentity", "", "model", "prepareRenderData", "removeEntity", "", "entityId", "selector", "Lcom/tencent/videocut/model/MediaModel;", "updateBackground", "updateEntity", "originalEntityId", "oldData", "newData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundModelRender
  extends AbsModelRender<BackgroundModel, RenderData>
{
  private final ICutSession a;
  
  public BackgroundModelRender(@NotNull ICutSession paramICutSession)
  {
    this.a = paramICutSession;
  }
  
  private final void c(BackgroundModel paramBackgroundModel)
  {
    Object localObject = paramBackgroundModel.renderSize;
    int i;
    if (localObject != null) {
      i = (int)((SizeF)localObject).width;
    } else {
      i = 720;
    }
    if (paramBackgroundModel != null)
    {
      localObject = paramBackgroundModel.renderSize;
      if (localObject != null)
      {
        j = (int)((SizeF)localObject).height;
        break label54;
      }
    }
    int j = 1280;
    label54:
    localObject = this.a;
    int k;
    if (paramBackgroundModel.bgFillMode != null) {
      k = paramBackgroundModel.bgFillMode.getValue();
    } else {
      k = 0;
    }
    ((ICutSession)localObject).a(k, ColorUtils.a.a(paramBackgroundModel.bgColor), paramBackgroundModel.bgPagPath);
    this.a.a(new Size(Integer.valueOf(i), Integer.valueOf(j), null, 4, null), paramBackgroundModel.fillScale);
  }
  
  public int a(@NotNull RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    paramRenderData = (IdentifyComponent)CollectionsKt.firstOrNull(paramRenderData.a().getComponents());
    if (paramRenderData != null) {
      paramRenderData = paramRenderData.getData();
    } else {
      paramRenderData = null;
    }
    if ((paramRenderData instanceof BackgroundModel)) {
      c((BackgroundModel)paramRenderData);
    }
    return -1;
  }
  
  @Nullable
  public String a(@Nullable BackgroundModel paramBackgroundModel)
  {
    if (paramBackgroundModel != null) {
      return paramBackgroundModel.id;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, @Nullable RenderData paramRenderData1, @NotNull RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    paramRenderData1 = (IdentifyComponent)CollectionsKt.firstOrNull(paramRenderData2.a().getComponents());
    if (paramRenderData1 != null) {
      paramRenderData1 = paramRenderData1.getData();
    } else {
      paramRenderData1 = null;
    }
    if ((paramRenderData1 instanceof BackgroundModel)) {
      c((BackgroundModel)paramRenderData1);
    }
  }
  
  @NotNull
  public RenderData b(@NotNull BackgroundModel paramBackgroundModel)
  {
    Intrinsics.checkParameterIsNotNull(paramBackgroundModel, "model");
    return new RenderData(new Entity(0, "background", null, CollectionsKt.listOf(new IdentifyComponent(paramBackgroundModel)), false, 0, 53, null), new InputSource(null, null, null, null, null, null, null, null, null, null, 1023, null), null, 4, null);
  }
  
  @Nullable
  public BackgroundModel c(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    return paramMediaModel.backgroundModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.BackgroundModelRender
 * JD-Core Version:    0.7.0.1
 */