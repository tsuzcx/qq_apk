package com.tencent.tavcut.render.player;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/player/IPlayer$PlayerListener;", "", "onPlayerSourceReady", "", "iPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "onPositionChanged", "currentDurationUs", "", "playerDurationUs", "onStatusChanged", "status", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayer$PlayerListener
{
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(@Nullable IPlayer.PlayerStatus paramPlayerStatus, @NotNull IPlayer paramIPlayer);
  
  public abstract void a(@NotNull IPlayer paramIPlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.IPlayer.PlayerListener
 * JD-Core Version:    0.7.0.1
 */