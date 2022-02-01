package com.tencent.tavcut.session;

import com.tencent.tavcut.composition.dataprocessor.RenderDataManager;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "renderManager", "Lcom/tencent/tavcut/render/IRenderChainManager;", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "invoke"}, k=3, mv={1, 1, 16})
final class TavCutSession$updatePlayer$1
  extends Lambda
  implements Function2<IRenderChainManager, RenderModel, Unit>
{
  TavCutSession$updatePlayer$1(TavCutSession paramTavCutSession)
  {
    super(2);
  }
  
  public final void invoke(@NotNull IRenderChainManager paramIRenderChainManager, @NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramIRenderChainManager, "renderManager");
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    TavCutSession.a(this.this$0, paramIRenderChainManager);
    TavCutSession.b(this.this$0).a(paramRenderModel.getTimeLines());
    TavCutSession.c(this.this$0);
    TavCutSession.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession.updatePlayer.1
 * JD-Core Version:    0.7.0.1
 */