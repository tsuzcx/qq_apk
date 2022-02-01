package com.tencent.tavcut.render;

import android.widget.FrameLayout;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.MoviePlayer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/RenderPlayerFactory;", "", "()V", "TAV_PLAYER", "", "createPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "playerContainer", "Landroid/widget/FrameLayout;", "type", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class RenderPlayerFactory
{
  public static final RenderPlayerFactory a = new RenderPlayerFactory();
  
  @NotNull
  public final IPlayer a(@Nullable FrameLayout paramFrameLayout, int paramInt)
  {
    if (paramInt != 1) {
      return (IPlayer)new MoviePlayer(paramFrameLayout);
    }
    return (IPlayer)new MoviePlayer(paramFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.RenderPlayerFactory
 * JD-Core Version:    0.7.0.1
 */