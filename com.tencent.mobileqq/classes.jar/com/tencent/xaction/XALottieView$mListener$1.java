package com.tencent.xaction;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.log.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "composition", "Lcom/tencent/mobileqq/dinifly/LottieComposition;", "onCompositionLoaded"}, k=3, mv={1, 1, 16})
final class XALottieView$mListener$1
  implements OnCompositionLoadedListener
{
  XALottieView$mListener$1(XALottieView paramXALottieView) {}
  
  public final void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCompositionLoaded: composition= ");
      ((StringBuilder)localObject).append(paramLottieComposition);
      QLog.a("XALottieView", 1, ((StringBuilder)localObject).toString());
    }
    if (paramLottieComposition == null) {
      return;
    }
    if (XALottieView.access$getMIsStop$p(this.a))
    {
      paramLottieComposition = new StringBuilder();
      paramLottieComposition.append("onCompositionLoaded: mIsStop ");
      paramLottieComposition.append(XALottieView.access$getMIsStop$p(this.a));
      QLog.a("XALottieView", 1, paramLottieComposition.toString());
      return;
    }
    this.a.cancelAnimation();
    this.a.setComposition(paramLottieComposition);
    this.a.setProgress(0.0F);
    paramLottieComposition = this.a;
    Object localObject = paramLottieComposition.getDecor().getStyle();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramLottieComposition.setRepeatCount(((ViewData)localObject).getTp().getRc());
    this.a.setVisibility(0);
    paramLottieComposition = this.a.getDecor().getStyle();
    if (paramLottieComposition == null) {
      Intrinsics.throwNpe();
    }
    if (paramLottieComposition.getTp().getAutoPlay()) {
      this.a.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XALottieView.mListener.1
 * JD-Core Version:    0.7.0.1
 */