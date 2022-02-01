package com.tencent.timi.game.datareport.api;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.timi.game.router.IService;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/datareport/api/IReportService;", "Lcom/tencent/timi/game/router/IService;", "bindElementInfo", "", "view", "Landroid/view/View;", "isAsync", "", "identifier", "", "elementID", "businessParams", "", "bindElementInfoExcludeClick", "bindElementInfoOnlyClick", "bindPageInfo", "fragment", "Landroidx/fragment/app/Fragment;", "target", "", "pageID", "reportEvent", "eventID", "obj", "Ljava/lang/Object;", "updateSource", "sourceId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IReportService
  extends IService
{
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap);
  
  public abstract void a(@NotNull Fragment paramFragment, @NotNull Object paramObject, @NotNull String paramString);
  
  public abstract void a(@NotNull Object paramObject, @NotNull String paramString);
  
  public abstract void a(@NotNull String paramString, @NotNull Object paramObject, @NotNull Map<String, String> paramMap);
  
  public abstract void a(@NotNull String paramString, @NotNull Map<String, String> paramMap);
  
  public abstract void b(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap);
  
  public abstract void c(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.datareport.api.IReportService
 * JD-Core Version:    0.7.0.1
 */