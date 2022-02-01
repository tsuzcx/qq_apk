package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "invoke"}, k=3, mv={1, 1, 16})
final class BKRenderService$cmshowView$2
  extends Lambda
  implements Function0<ICMShowView>
{
  BKRenderService$cmshowView$2(BKRenderService paramBKRenderService)
  {
    super(0);
  }
  
  @NotNull
  public final ICMShowView invoke()
  {
    Object localObject1 = this.this$0;
    boolean bool = true;
    BKRenderService.a((BKRenderService)localObject1, true);
    localObject1 = BKRenderService.a(this.this$0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("init CMShowView renderConfig:");
    ((StringBuilder)localObject2).append(BKRenderService.a(this.this$0));
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = BKRenderService.a(this.this$0);
    if (localObject1 != null) {
      bool = ((RenderConfig)localObject1).a;
    }
    if (bool) {
      localObject1 = (ICMShowView)BKRenderService.a(this.this$0);
    } else {
      localObject1 = (ICMShowView)BKRenderService.a(this.this$0);
    }
    localObject2 = BKRenderService.a(this.this$0);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = BKRenderService.a(this.this$0, (ICMShowView)localObject1);
      if (localObject3 != null) {
        ((ApolloRender)localObject3).setRecordFrameListener((IRecordFrameListener)localObject2);
      }
    }
    localObject2 = BKRenderService.a(this.this$0);
    if ((localObject2 != null) && ((localObject2 instanceof IRenderCallback)))
    {
      localObject2 = BKRenderService.a(this.this$0, (ICMShowView)localObject1);
      if (localObject2 != null)
      {
        localObject3 = BKRenderService.a(this.this$0);
        if (localObject3 != null)
        {
          ((ApolloRender)localObject2).setRenderCallback((IRenderCallback)localObject3);
          return localObject1;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback");
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKRenderService.cmshowView.2
 * JD-Core Version:    0.7.0.1
 */