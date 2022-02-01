package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion$genOnScreenView$view$1", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "onNotifyLongTouch", "", "name", "", "onNotifyStatusChanged", "clickPart", "", "apolloId", "onSurfaceReady", "w", "h", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion$genOnScreenView$view$1
  implements OnApolloViewListener
{
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("[cmshow][CECMShowOffscreenEngine]", 1, "CEOffScreenEngine onScreenView onSurfaceReady");
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "apolloId");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.genOnScreenView.view.1
 * JD-Core Version:    0.7.0.1
 */