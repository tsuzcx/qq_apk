package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/brickengine/BKRenderService$apolloViewListener$1", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "onNotifyLongTouch", "", "name", "", "onNotifyStatusChanged", "clickPart", "", "apolloId", "onSurfaceReady", "w", "h", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKRenderService$apolloViewListener$1
  implements OnApolloViewListener
{
  public void a(int paramInt1, int paramInt2)
  {
    BKRenderService.b(this.a).a(EngineState.INITIALIZED);
    Object localObject = BKRenderService.c(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceReady set engine state to:");
    localStringBuilder.append(BKRenderService.b(this.a).e());
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = BKRenderService.d(this.a);
    if (localObject != null) {
      ((ISurfaceStateListener)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "apolloId");
    ITouchListener localITouchListener = BKRenderService.a(this.a);
    if (localITouchListener != null) {
      localITouchListener.a(paramInt, paramString);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    ITouchListener localITouchListener = BKRenderService.a(this.a);
    if (localITouchListener != null) {
      localITouchListener.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKRenderService.apolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */