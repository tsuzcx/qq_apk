package com.tencent.timi.game.datareport.impl;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.timi.game.datareport.api.IReportService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/datareport/impl/ReportServiceImpl;", "Lcom/tencent/timi/game/datareport/api/IReportService;", "sourceId", "", "(I)V", "reporter", "Lcom/tencent/timi/game/datareport/impl/TimiGameDataReportImpl;", "getSourceId", "()I", "setSourceId", "bindElementInfo", "", "view", "Landroid/view/View;", "isAsync", "", "identifier", "", "elementID", "businessParams", "", "bindElementInfoExcludeClick", "bindElementInfoOnlyClick", "bindPageInfo", "fragment", "Landroidx/fragment/app/Fragment;", "target", "", "pageID", "getAppKey", "init", "context", "Landroid/content/Context;", "reportEvent", "eventID", "obj", "Ljava/lang/Object;", "serviceDestroy", "updateSource", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReportServiceImpl
  implements IReportService
{
  public static final ReportServiceImpl.Companion a = new ReportServiceImpl.Companion(null);
  private TimiGameDataReportImpl b;
  private int c;
  
  public ReportServiceImpl()
  {
    this(0, 1, null);
  }
  
  public ReportServiceImpl(int paramInt)
  {
    this.c = paramInt;
    this.b = new TimiGameDataReportImpl(false);
  }
  
  private final String a()
  {
    return "0S200MNJT807V3GE";
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    this.b.a(a());
  }
  
  public void a(@Nullable Context paramContext)
  {
    this.b.a(a());
  }
  
  public void a(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString2, "elementID");
    Intrinsics.checkParameterIsNotNull(paramMap, "businessParams");
    this.b.a(paramView, paramBoolean, paramString1, paramString2, paramMap, false);
  }
  
  public void a(@NotNull Fragment paramFragment, @NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    Intrinsics.checkParameterIsNotNull(paramObject, "target");
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    this.b.a(paramFragment, paramObject, paramString, null);
  }
  
  public void a(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "target");
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    this.b.a(paramObject, paramString, null);
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
 * Qualified Name:     com.tencent.timi.game.datareport.impl.ReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */