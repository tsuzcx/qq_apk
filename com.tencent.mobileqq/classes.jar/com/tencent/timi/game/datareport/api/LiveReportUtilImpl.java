package com.tencent.timi.game.datareport.api;

import android.view.View;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/datareport/api/LiveReportUtilImpl;", "Lcom/tencent/timi/game/api/live/ILiveReportUtil;", "()V", "bindElementInfo", "", "view", "Landroid/view/View;", "isAsync", "", "identifier", "", "elementID", "businessParams", "", "bindElementInfoOnlyClick", "bindPageInfo", "fragment", "", "target", "pageID", "reportEvent", "eventID", "obj", "Ljava/lang/Object;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveReportUtilImpl
  implements ILiveReportUtil
{
  public static final LiveReportUtilImpl a = new LiveReportUtilImpl();
  
  public void a(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString2, "elementID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramView, paramBoolean, paramString1, paramString2, paramMap);
  }
  
  public void a(@NotNull Object paramObject1, @NotNull Object paramObject2, @NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "fragment");
    Intrinsics.checkParameterIsNotNull(paramObject2, "target");
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramObject1, paramObject2, paramString, paramMap);
  }
  
  public void a(@NotNull Object paramObject, @NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "target");
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramObject, paramString, paramMap);
  }
  
  public void a(@NotNull String paramString, @NotNull Object paramObject, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventID");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramString, paramObject, paramMap);
  }
  
  public void a(@NotNull String paramString, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(paramString, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.datareport.api.LiveReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */