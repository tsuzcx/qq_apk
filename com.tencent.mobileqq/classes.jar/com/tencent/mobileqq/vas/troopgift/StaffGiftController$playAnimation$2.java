package com.tencent.mobileqq.vas.troopgift;

import android.widget.FrameLayout;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class StaffGiftController$playAnimation$2
  extends Lambda
  implements Function0<Unit>
{
  StaffGiftController$playAnimation$2(StaffGiftController paramStaffGiftController, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.f().start();
    StaffGiftController localStaffGiftController = this.this$0;
    String str = this.$orderId;
    Intrinsics.checkExpressionValueIsNotNull(str, "orderId");
    if (localStaffGiftController.a(str)) {
      this.this$0.c().postDelayed((Runnable)new StaffGiftController.playAnimation.2.1(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.StaffGiftController.playAnimation.2
 * JD-Core Version:    0.7.0.1
 */