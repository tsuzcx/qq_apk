package com.tencent.timi.game.profile.api;

import android.view.View;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/api/ProfileReportUtil;", "", "()V", "bindPage", "", "any", "page", "", "reportClick", "view", "Landroid/view/View;", "elementID", "businessParams", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileReportUtil
{
  public static final ProfileReportUtil a = new ProfileReportUtil();
  
  public final void a(@Nullable View paramView, @NotNull String paramString, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "elementID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    if (paramView != null) {
      ((IReportService)ServiceCenter.a(IReportService.class)).a(paramView, true, null, paramString, paramMap);
    }
  }
  
  public final void a(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "any");
    Intrinsics.checkParameterIsNotNull(paramString, "page");
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.api.ProfileReportUtil
 * JD-Core Version:    0.7.0.1
 */