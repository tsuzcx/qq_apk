package com.tencent.tavcut.session;

import com.tencent.tavcut.composition.dataprocessor.RenderDataManager;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class TavCutSession$reloadAssets$1
  extends Lambda
  implements Function0<Unit>
{
  TavCutSession$reloadAssets$1(TavCutSession paramTavCutSession)
  {
    super(0);
  }
  
  public final void invoke()
  {
    RenderModel localRenderModel = TavCutSession.b(this.this$0).c();
    if (localRenderModel != null)
    {
      IRenderChainManager localIRenderChainManager = TavCutSession.a(this.this$0);
      if (localIRenderChainManager != null) {
        localIRenderChainManager.a(TavCutSession.b(this.this$0).a(), localRenderModel, (Function2)new TavCutSession.reloadAssets.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession.reloadAssets.1
 * JD-Core Version:    0.7.0.1
 */