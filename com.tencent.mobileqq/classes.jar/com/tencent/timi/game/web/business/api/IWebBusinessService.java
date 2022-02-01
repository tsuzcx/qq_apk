package com.tencent.timi.game.web.business.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.timi.game.IViewCreator;
import com.tencent.timi.game.router.IService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/web/business/api/IWebBusinessService;", "Lcom/tencent/timi/game/router/IService;", "Lcom/tencent/timi/game/IViewCreator;", "launchInscriptionBrowserActivity", "", "activity", "Landroid/app/Activity;", "url", "", "anchorBusniessId", "gameId", "", "isAnchor", "", "loadUrl", "context", "Landroid/content/Context;", "preLoadUrl", "preStartWebProcess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IWebBusinessService
  extends IViewCreator, IService
{
  public abstract void a(@NotNull Activity paramActivity, @NotNull String paramString1, @NotNull String paramString2, int paramInt, boolean paramBoolean);
  
  public abstract void a(@NotNull Context paramContext, @NotNull String paramString);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.api.IWebBusinessService
 * JD-Core Version:    0.7.0.1
 */