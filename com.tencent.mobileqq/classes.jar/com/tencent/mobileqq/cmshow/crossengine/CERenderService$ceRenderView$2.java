package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.RenderContext;
import com.tencent.crossengine.TouchProcessor;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowView;", "invoke"}, k=3, mv={1, 1, 16})
final class CERenderService$ceRenderView$2
  extends Lambda
  implements Function0<CECMShowView>
{
  CERenderService$ceRenderView$2(CERenderService paramCERenderService)
  {
    super(0);
  }
  
  @NotNull
  public final CECMShowView invoke()
  {
    Object localObject1 = CERenderService.a(this.this$0).a();
    Object localObject2 = CERenderService.a(this.this$0).a().getRenderContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "engineContext.ceApplication.renderContext");
    Object localObject3 = CERenderService.a(this.this$0).a().getTouchProcessor();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "engineContext.ceApplication.touchProcessor");
    localObject1 = new CECMShowView((Context)localObject1, (RenderContext)localObject2, (TouchProcessor)localObject3, (OnApolloViewListener)new CERenderService.ceRenderView.2.view.1(this));
    localObject2 = CERenderService.a(this.this$0);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("init CECMShowView renderConfig:");
    ((StringBuilder)localObject3).append(CERenderService.a(this.this$0));
    ((StringBuilder)localObject3).append(", view:");
    ((StringBuilder)localObject3).append(localObject1);
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.ceRenderView.2
 * JD-Core Version:    0.7.0.1
 */