package com.tencent.timi.game.api.live;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/api/live/ILiveReportUtil;", "", "bindElementInfo", "", "view", "Landroid/view/View;", "isAsync", "", "identifier", "", "elementID", "businessParams", "", "bindElementInfoOnlyClick", "bindPageInfo", "fragment", "target", "pageID", "reportEvent", "eventID", "obj", "Ljava/lang/Object;", "timi-game-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILiveReportUtil
{
  public abstract void a(@NotNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap);
  
  public abstract void a(@NotNull Object paramObject1, @NotNull Object paramObject2, @NotNull String paramString, @Nullable Map<String, String> paramMap);
  
  public abstract void a(@NotNull Object paramObject, @NotNull String paramString, @Nullable Map<String, String> paramMap);
  
  public abstract void a(@NotNull String paramString, @NotNull Object paramObject, @NotNull Map<String, String> paramMap);
  
  public abstract void a(@NotNull String paramString, @NotNull Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.live.ILiveReportUtil
 * JD-Core Version:    0.7.0.1
 */