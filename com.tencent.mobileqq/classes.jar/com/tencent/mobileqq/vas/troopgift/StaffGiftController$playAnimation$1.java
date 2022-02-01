package com.tencent.mobileqq.vas.troopgift;

import android.view.View;
import com.tencent.xaction.openapi.api.ISubscribeNotify;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/StaffGiftController$playAnimation$1", "Lcom/tencent/xaction/openapi/api/ISubscribeNotify;", "notify", "", "tag", "", "status", "view", "Landroid/view/View;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class StaffGiftController$playAnimation$1
  implements ISubscribeNotify
{
  public void notify(@NotNull String paramString1, @NotNull String paramString2, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "status");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if ((Intrinsics.areEqual(paramString2, "end")) && (StaffGiftController.a(this.a, paramString1))) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.StaffGiftController.playAnimation.1
 * JD-Core Version:    0.7.0.1
 */