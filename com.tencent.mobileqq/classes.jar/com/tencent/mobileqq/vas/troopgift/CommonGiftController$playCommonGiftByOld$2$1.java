package com.tencent.mobileqq.vas.troopgift;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/CommonGiftController$playCommonGiftByOld$2$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommonGiftController$playCommonGiftByOld$2$1
  implements PAGView.PAGViewListener
{
  public void onAnimationCancel(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationEnd(@Nullable PAGView paramPAGView)
  {
    this.a.this$0.l().invoke();
  }
  
  public void onAnimationRepeat(@Nullable PAGView paramPAGView)
  {
    if (CommonGiftController.a(this.a.this$0).getWholeState$AQQLiteApp_release() != PlayState.PLAYING)
    {
      if (paramPAGView != null) {
        paramPAGView.stop();
      }
      this.a.this$0.l().invoke();
    }
  }
  
  public void onAnimationStart(@Nullable PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.CommonGiftController.playCommonGiftByOld.2.1
 * JD-Core Version:    0.7.0.1
 */