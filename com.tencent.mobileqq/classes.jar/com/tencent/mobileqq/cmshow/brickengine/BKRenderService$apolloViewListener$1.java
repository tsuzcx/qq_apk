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
  public void onNotifyLongTouch(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    ITouchListener localITouchListener = BKRenderService.a(this.a);
    if (localITouchListener != null) {
      localITouchListener.a(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "apolloId");
    ITouchListener localITouchListener = BKRenderService.a(this.a);
    if (localITouchListener != null) {
      localITouchListener.a(paramInt, paramString);
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    BKRenderService.a(this.a).a(EngineState.INITIALIZED);
    Object localObject = BKRenderService.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceReady set engine state to:");
    localStringBuilder.append(BKRenderService.a(this.a).a());
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = BKRenderService.a(this.a);
    if (localObject != null) {
      ((ISurfaceStateListener)localObject).a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKRenderService.apolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */