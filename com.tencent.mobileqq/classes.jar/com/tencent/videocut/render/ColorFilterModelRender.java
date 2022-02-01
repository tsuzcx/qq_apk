package com.tencent.videocut.render;

import com.tencent.logger.Logger;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.ICutSession.DefaultImpls;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.extension.FilterModelExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/ColorFilterModelRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/FilterModel;", "Lcom/tencent/videocut/render/RenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "addEntity", "", "data", "getItemIdentity", "", "model", "prepareRenderData", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ColorFilterModelRender
  extends AbsListRender<FilterModel, RenderData>
{
  public static final ColorFilterModelRender.Companion a = new ColorFilterModelRender.Companion(null);
  private final ICutSession b;
  
  public ColorFilterModelRender(@NotNull ICutSession paramICutSession)
  {
    this.b = paramICutSession;
  }
  
  public int a(@NotNull RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    paramRenderData = ICutSession.DefaultImpls.a(this.b, paramRenderData.a(), 0, 2, null);
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add adjust ");
    localStringBuilder.append(paramRenderData.getId());
    localLogger.b("ColorFilterModelRender", localStringBuilder.toString());
    return paramRenderData.getId();
  }
  
  @NotNull
  public RenderData a(@NotNull FilterModel paramFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "model");
    return FilterModelExtKt.b(paramFilterModel, false);
  }
  
  @NotNull
  public List<FilterModel> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    Object localObject1 = (Iterable)paramMediaModel.filterModels.values();
    paramMediaModel = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int i;
      if (((FilterModel)localObject2).color != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramMediaModel.add(localObject2);
      }
    }
    return (List)paramMediaModel;
  }
  
  public void a(int paramInt)
  {
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remove adjust ");
    localStringBuilder.append(paramInt);
    localLogger.b("ColorFilterModelRender", localStringBuilder.toString());
    this.b.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable RenderData paramRenderData1, @NotNull RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    paramRenderData1 = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update adjust ");
    localStringBuilder.append(paramInt);
    paramRenderData1.b("ColorFilterModelRender", localStringBuilder.toString());
    paramRenderData1 = ((Iterable)paramRenderData2.a().getComponents()).iterator();
    while (paramRenderData1.hasNext())
    {
      paramRenderData2 = (IdentifyComponent)paramRenderData1.next();
      this.b.b(paramInt, paramRenderData2);
    }
  }
  
  @NotNull
  public String b(@NotNull FilterModel paramFilterModel)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "model");
    return paramFilterModel.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.ColorFilterModelRender
 * JD-Core Version:    0.7.0.1
 */