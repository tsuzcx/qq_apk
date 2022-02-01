package com.tencent.timi.game.datareport.impl;

import android.content.Context;
import android.view.View;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.LiveReportUtilImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/datareport/impl/TGReportServiceImpl;", "Lcom/tencent/timi/game/datareport/api/ILiveReportService;", "appKey", "", "(Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "reporter", "Lcom/tencent/timi/game/datareport/impl/TimiGameDataReportImpl;", "bindElementInfo", "", "view", "Landroid/view/View;", "isAsync", "", "identifier", "elementID", "businessParams", "", "bindElementInfoExcludeClick", "bindElementInfoOnlyClick", "bindPageInfo", "fragmentOrActivity", "", "target", "pageID", "getILiveReportUtil", "Lcom/tencent/timi/game/api/live/ILiveReportUtil;", "init", "context", "Landroid/content/Context;", "reportEvent", "eventID", "obj", "Ljava/lang/Object;", "serviceDestroy", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGReportServiceImpl
  implements ILiveReportService
{
  public static final TGReportServiceImpl.Companion a = new TGReportServiceImpl.Companion(null);
  private TimiGameDataReportImpl b;
  @NotNull
  private final String c;
  
  public TGReportServiceImpl(@NotNull String paramString)
  {
    this.c = paramString;
    this.b = new TimiGameDataReportImpl(false);
    this.b.a(this.c);
    this.b.a(this.c);
  }
  
  @NotNull
  public ILiveReportUtil a()
  {
    return (ILiveReportUtil)LiveReportUtilImpl.a;
  }
  
  public void a(@Nullable Context paramContext)
  {
    this.b.a(this.c);
  }
  
  public void a(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString2, "elementID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    this.b.a(paramView, paramBoolean, paramString1, paramString2, paramMap, false);
  }
  
  public void a(@NotNull Object paramObject1, @NotNull Object paramObject2, @NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "fragmentOrActivity");
    Intrinsics.checkParameterIsNotNull(paramObject2, "target");
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    this.b.a(paramObject1, paramObject2, paramString, paramMap);
  }
  
  public void a(@NotNull Object paramObject, @NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "target");
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    this.b.a(paramObject, paramString, paramMap);
  }
  
  public void a(@NotNull String paramString, @NotNull Object paramObject, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventID");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    this.b.a(paramString, paramObject, paramMap);
  }
  
  public void a(@NotNull String paramString, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    this.b.a(paramString, paramMap);
  }
  
  public void b(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString2, "elementID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    this.b.a(paramView, paramBoolean, paramString1, paramString2, paramMap, true);
  }
  
  public void c(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString2, "elementID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    this.b.a(paramView, paramBoolean, paramString1, paramString2, paramMap);
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.datareport.impl.TGReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */