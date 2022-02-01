package com.tencent.mobileqq.vas.troopgift;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/TroopGiftComboView$setPAGResource$1$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftComboView$setPAGResource$1$1
  implements PAGView.PAGViewListener
{
  public void onAnimationCancel(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationEnd(@Nullable PAGView paramPAGView)
  {
    TroopGiftComboView.a(this.a.this$0, TroopGiftPAGAnimationController.PlayState.PLAYED);
    if (TroopGiftComboView.b(this.a.this$0) == TroopGiftPAGAnimationController.PlayState.PLAYED) {
      TroopGiftComboView.b(this.a.this$0, TroopGiftPAGAnimationController.PlayState.PLAYED);
    }
  }
  
  public void onAnimationRepeat(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationStart(@Nullable PAGView paramPAGView)
  {
    TroopGiftComboView.a(this.a.this$0, TroopGiftPAGAnimationController.PlayState.PLAYING);
    TroopGiftComboView.b(this.a.this$0, TroopGiftPAGAnimationController.PlayState.PLAYING);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.setPAGResource.1.1
 * JD-Core Version:    0.7.0.1
 */