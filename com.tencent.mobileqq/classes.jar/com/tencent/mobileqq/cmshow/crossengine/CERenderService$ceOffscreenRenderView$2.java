package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenView;", "invoke"}, k=3, mv={1, 1, 16})
final class CERenderService$ceOffscreenRenderView$2
  extends Lambda
  implements Function0<CECMShowOffscreenView>
{
  CERenderService$ceOffscreenRenderView$2(CERenderService paramCERenderService)
  {
    super(0);
  }
  
  @NotNull
  public final CECMShowOffscreenView invoke()
  {
    Object localObject = new CERenderService.ceOffscreenRenderView.2.apolloViewListener.1(this);
    CECMShowOffscreenView localCECMShowOffscreenView = new CECMShowOffscreenView(CERenderService.a(this.this$0).a(), CERenderService.a(this.this$0).a(), CERenderService.a(this.this$0).a().name(), CERenderService.a(this.this$0), (OnApolloViewListener)localObject);
    localObject = CERenderService.a(this.this$0);
    if (localObject != null) {
      localObject = ((RenderConfig)localObject).a;
    } else {
      localObject = null;
    }
    if (localObject == RenderMode.OFF_SCREEN) {
      ThreadManager.getSubThreadHandler().post((Runnable)new CERenderService.ceOffscreenRenderView.2.1(this));
    }
    localObject = CERenderService.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init CECMShowOffscreenView renderConfig:");
    localStringBuilder.append(CERenderService.a(this.this$0));
    localStringBuilder.append(", view:");
    localStringBuilder.append(localCECMShowOffscreenView);
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    return localCECMShowOffscreenView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.ceOffscreenRenderView.2
 * JD-Core Version:    0.7.0.1
 */