package com.tencent.timi.game.live.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.timi.game.live.api.IGameLiveService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/GameLiveServiceImpl;", "Lcom/tencent/timi/game/live/api/IGameLiveService;", "()V", "createLEBWebRTCLiveView", "Lcom/tencent/timi/game/live/api/IGameLiveView;", "context", "Landroid/content/Context;", "createView", "Landroid/view/View;", "viewName", "", "attrs", "Landroid/util/AttributeSet;", "getDanmakuChooserView", "Lcom/tencent/timi/game/live/api/DanmakuChooserView;", "ctx", "init", "", "launchDebugActivity", "Context", "provideViews", "", "serviceDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GameLiveServiceImpl
  implements IGameLiveService
{
  @Nullable
  public View a(@Nullable String paramString, @NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return null;
  }
  
  @NotNull
  public List<String> a()
  {
    return CollectionsKt.mutableListOf(new String[] { "com.yolo.esports.gamelive.api.DanmakuChooserView" });
  }
  
  public void a(@Nullable Context paramContext) {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.GameLiveServiceImpl
 * JD-Core Version:    0.7.0.1
 */