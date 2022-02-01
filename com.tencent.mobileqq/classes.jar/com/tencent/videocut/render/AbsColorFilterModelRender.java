package com.tencent.videocut.render;

import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.render.extension.FilterModelExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/AbsColorFilterModelRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/render/FilterRenderData;", "Lcom/tencent/videocut/render/RenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "getTavCutSession", "()Lcom/tencent/tavcut/session/ICutSession;", "getItemIdentity", "", "model", "isContentTheSame", "", "newModel", "oldModel", "prepareRenderData", "removeEntity", "", "entityId", "", "updateEntity", "originalEntityId", "oldData", "newData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsColorFilterModelRender
  extends AbsListRender<FilterRenderData, RenderData>
{
  @NotNull
  private final ICutSession a;
  
  public AbsColorFilterModelRender(@NotNull ICutSession paramICutSession)
  {
    this.a = paramICutSession;
  }
  
  @NotNull
  protected final ICutSession a()
  {
    return this.a;
  }
  
  @NotNull
  public String a(@NotNull FilterRenderData paramFilterRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterRenderData, "model");
    return paramFilterRenderData.b().id;
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable RenderData paramRenderData1, @NotNull RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    paramRenderData1 = ((Iterable)paramRenderData2.a().getComponents()).iterator();
    while (paramRenderData1.hasNext())
    {
      paramRenderData2 = (IdentifyComponent)paramRenderData1.next();
      this.a.b(paramInt, paramRenderData2);
    }
  }
  
  public boolean a(@NotNull FilterRenderData paramFilterRenderData1, @NotNull FilterRenderData paramFilterRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterRenderData1, "newModel");
    Intrinsics.checkParameterIsNotNull(paramFilterRenderData2, "oldModel");
    return (Intrinsics.areEqual(paramFilterRenderData1.b().color, paramFilterRenderData2.b().color)) && (Intrinsics.areEqual(paramFilterRenderData1.c(), paramFilterRenderData2.c())) && (paramFilterRenderData1.a() == paramFilterRenderData2.a());
  }
  
  @NotNull
  public RenderData b(@NotNull FilterRenderData paramFilterRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterRenderData, "model");
    return FilterModelExtKt.b(paramFilterRenderData.b(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.AbsColorFilterModelRender
 * JD-Core Version:    0.7.0.1
 */