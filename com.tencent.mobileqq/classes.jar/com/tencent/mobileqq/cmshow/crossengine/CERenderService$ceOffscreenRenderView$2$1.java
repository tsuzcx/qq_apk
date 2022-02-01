package com.tencent.mobileqq.cmshow.crossengine;

import android.util.Pair;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CERenderService$ceOffscreenRenderView$2$1
  implements Runnable
{
  CERenderService$ceOffscreenRenderView$2$1(CERenderService.ceOffscreenRenderView.2 param2) {}
  
  public final void run()
  {
    Object localObject1 = CERenderService.a(this.this$0.this$0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("view.post, scene: ");
    ((StringBuilder)localObject2).append(CERenderService.a(this.this$0.this$0).a());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    CERenderService.a(this.this$0.this$0, true);
    localObject1 = this.this$0.this$0;
    localObject2 = CERenderService.a(this.this$0.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((RenderConfig)localObject2).a.first;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "renderConfig!!.offScreenSize.first");
    CERenderService.a((CERenderService)localObject1, ((Number)localObject2).intValue());
    localObject1 = this.this$0.this$0;
    localObject2 = CERenderService.a(this.this$0.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((RenderConfig)localObject2).a.second;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "renderConfig!!.offScreenSize.second");
    CERenderService.b((CERenderService)localObject1, ((Number)localObject2).intValue());
    if (!CERenderService.a(this.this$0.this$0)) {
      CERenderService.a(this.this$0.this$0);
    }
    CERenderService.a(this.this$0.this$0).a().setTimeScaleForWorld((String)new CERenderService.ceOffscreenRenderView.2.1.1(CERenderService.a(this.this$0.this$0).a()).get(), 1000, 0.0666667F);
    localObject1 = CERenderService.a(this.this$0.this$0);
    if (localObject1 != null) {
      ((ISurfaceStateListener)localObject1).a(CERenderService.a(this.this$0.this$0), CERenderService.b(this.this$0.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.ceOffscreenRenderView.2.1
 * JD-Core Version:    0.7.0.1
 */