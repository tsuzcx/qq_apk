package com.tencent.mobileqq.vas.troopgift;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftPAGAnimationController$playStaffGift$3
  extends Lambda
  implements Function0<Unit>
{
  TroopGiftPAGAnimationController$playStaffGift$3(TroopGiftPAGAnimationController paramTroopGiftPAGAnimationController, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.a().start();
    TroopGiftPAGAnimationController localTroopGiftPAGAnimationController = this.this$0;
    String str = this.$orderId;
    Intrinsics.checkExpressionValueIsNotNull(str, "orderId");
    if (localTroopGiftPAGAnimationController.b(str)) {
      TroopGiftPAGAnimationController.a(this.this$0).postDelayed((Runnable)new TroopGiftPAGAnimationController.playStaffGift.3.1(this), 100L);
    }
    TroopGiftPAGAnimationController.a(this.this$0).removeView((View)TroopGiftPAGAnimationController.a(this.this$0));
    TroopGiftPAGAnimationController.a(this.this$0).addView((View)TroopGiftPAGAnimationController.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.playStaffGift.3
 * JD-Core Version:    0.7.0.1
 */