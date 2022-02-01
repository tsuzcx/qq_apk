package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CERenderService$ceOffscreenRenderView$2$apolloViewListener$1", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "onNotifyLongTouch", "", "name", "", "onNotifyStatusChanged", "clickPart", "", "apolloId", "onSurfaceReady", "w", "h", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CERenderService$ceOffscreenRenderView$2$apolloViewListener$1
  implements OnApolloViewListener
{
  public void onNotifyLongTouch(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    ITouchListener localITouchListener = CERenderService.a(this.a.this$0);
    if (localITouchListener != null) {
      localITouchListener.a(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "apolloId");
    ITouchListener localITouchListener = CERenderService.a(this.a.this$0);
    if (localITouchListener != null) {
      localITouchListener.a(paramInt, paramString);
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    CERenderService.a(this.a.this$0, true);
    if ((CERenderService.a(this.a.this$0) != paramInt1) || (CERenderService.b(this.a.this$0) != paramInt2))
    {
      CERenderService.a(this.a.this$0, paramInt1);
      CERenderService.b(this.a.this$0, paramInt2);
      if (!CERenderService.a(this.a.this$0)) {
        CERenderService.a(this.a.this$0);
      } else {
        this.a.this$0.d();
      }
    }
    ISurfaceStateListener localISurfaceStateListener = CERenderService.a(this.a.this$0);
    if (localISurfaceStateListener != null) {
      localISurfaceStateListener.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.ceOffscreenRenderView.2.apolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */